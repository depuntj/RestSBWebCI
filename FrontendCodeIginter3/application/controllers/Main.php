<?php
defined('BASEPATH') OR exit('No direct script access allowed');

class Main extends CI_Controller {

    public function __construct() {
        parent::__construct();
        $this->load->model('Project_model');
        $this->load->model('Location_model');
        $this->load->helper('url');
    }

    public function index() {
    $projects = $this->Project_model->get_all_projects();
    $locations = $this->Location_model->get_all_locations();

    // Ensure $projects and $locations are always arrays
    $data['projects'] = is_array($projects) ? $projects : [$projects];
    $data['locations'] = is_array($locations) ? $locations : [$locations];

    $this->load->view('main_page', $data);
}

    public function input_data() {
        $data['projects'] = $this->Project_model->get_all_projects();
        $data['locations'] = $this->Location_model->get_all_locations();

        $this->load->view('input_data', $data);
    }

     public function add_project()
    {
        $this->load->model('Project_model');
        
        // Get form data
        $data = [
            'id_pk'            => $this->input->post('id_pk'),
            'nama_proyek'      => $this->input->post('nama_proyek'),
            'client'           => $this->input->post('client'),
            'tgl_mulai'        => $this->input->post('tgl_mulai'),
            'tgl_selesai'      => $this->input->post('tgl_selesai'),
            'pimpinan_proyek'  => $this->input->post('pimpinan_proyek'),
            'keterangan'       => $this->input->post('keterangan')
        ];
        
        // Insert project data
        $this->Project_model->insert($data);
        
        // Get location data
        $locations = $this->input->post('lokasi');
        if ($locations) {
            foreach ($locations as $location_id) {
                $this->Project_model->add_location($data['id_pk'], $location_id);
            }
        }
        
        // Redirect or load a view
        $this->load->view('success');
    }

    public function add_location()
    {
        $this->load->model('Location_model');
        
        // Get form data
        $data = [
            'id_pk'        => $this->input->post('id_pk'),
            'nama_lokasi'  => $this->input->post('nama_lokasi'),
            'negara'       => $this->input->post('negara'),
            'provinsi'     => $this->input->post('provinsi'),
            'kota'         => $this->input->post('kota'),
            'created_at'   => date('Y-m-d H:i:s') // Set current timestamp
        ];
        
        // Insert location data
        $this->Location_model->insert($data);
        
        // Redirect or load a view
        $this->load->view('success');
    }

    public function edit_project($id)
    {
        $this->load->model('Project_model');
        $this->load->model('Location_model');

        // Fetch existing project data
        $data['project'] = $this->Project_model->get_project_by_id($id);

        // Fetch all locations
        $data['locations'] = $this->Location_model->get_all_locations();

        // Fetch project locations
        $data['project_locations'] = $this->Project_model->get_project_locations($id);

        $this->load->view('edit_data', $data);
    }

    public function edit_location($id)
    {
        $this->load->model('Location_model');

        // Fetch existing location data
        $data['location'] = $this->Location_model->get_location_by_id($id);

        $this->load->view('edit_data', $data);
    }

    public function update_project($id)
    {
        $this->load->model('Project_model');
        
        $data = [
            'nama_proyek'       => $this->input->post('nama_proyek'),
            'client'            => $this->input->post('client'),
            'tgl_mulai'         => $this->input->post('tgl_mulai'),
            'tgl_selesai'       => $this->input->post('tgl_selesai'),
            'pimpinan_proyek'   => $this->input->post('pimpinan_proyek'),
            'keterangan'        => $this->input->post('keterangan'),
        ];

        // Update project data
        $this->Project_model->update($id, $data);

        // Update project locations
        $locations = $this->input->post('lokasi');
        $this->Project_model->update_project_locations($id, $locations);

        // Redirect or load a view
        $this->load->view('success');
    }

     public function update_location($id)
    {
        $this->load->model('Location_model');
        
        $data = [
            'nama_lokasi' => $this->input->post('nama_lokasi'),
            'negara'      => $this->input->post('negara'),
            'provinsi'    => $this->input->post('provinsi'),
            'kota'        => $this->input->post('kota'),
            'updated_at'  => date('Y-m-d H:i:s'), // Update timestamp
        ];

        // Update location data
        $this->Location_model->update($id, $data);

        // Redirect or load a view
        $this->load->view('success');
    }

    public function delete_project($id) {
        $this->Project_model->delete_project($id);
        redirect('main');
    }

    public function delete_location($id) {
        $this->Location_model->delete_location($id);
        redirect('main');
    }
}