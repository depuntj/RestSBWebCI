<?php
class Project_model extends CI_Model {
    public function __construct() {
        $this->load->database();
    }
    public function insert($data)
    {
        // Insert data with 'id_pk'
        $this->db->insert('proyek', $data);
        return $this->db->affected_rows(); // Return number of affected rows
    }

    public function add_location($project_id, $location_id)
    {
        $data = [
            'proyek_id_pk' => $project_id,
            'lokasi_id_pk' => $location_id
        ];
        $this->db->insert('proyek_lokasi', $data);
    }
    public function get_project($id) {
    $this->db->where('id_pk', $id);
    $query = $this->db->get('proyek');
    return $query->row();
}
    public function get_project_locations($id)
    {
        $this->db->select('lokasi_id_pk');
        $this->db->from('proyek_lokasi');
        $this->db->where('proyek_id_pk', $id);
        $query = $this->db->get();
        return array_column($query->result(), 'lokasi_id_pk');
    }
    public function insert_project($data) {
        $this->db->insert('proyek', $data);
        return $this->db->insert_id();
    }

    public function get_all_projects() {
    $query = $this->db->get('proyek');
    $result = $query->result();
    
    if (empty($result)) {
        log_message('debug', 'No projects found in the database.');
    } else {
        log_message('debug', 'Found ' . count($result) . ' projects.');
    }
    
    return $result;
}
public function get_project_by_id($id)
    {
        $query = $this->db->get_where('proyek', ['id_pk' => $id]);
        return $query->row();
    }

    

    public function update($id, $data)
    {
        $this->db->where('id_pk', $id);
        $this->db->update('proyek', $data);
    }

    public function update_project_locations($id, $locations)
    {
        $this->db->delete('proyek_lokasi', ['proyek_id_pk' => $id]);

        foreach ($locations as $location_id) {
            $this->db->insert('proyek_lokasi', [
                'proyek_id_pk' => $id,
                'lokasi_id_pk' => $location_id
            ]);
        }
    }
    public function update_project($id, $data) {
        $this->db->where('id_pk', $id);
        $this->db->update('proyek', $data);
    }

    public function delete_project($id) {
        $this->db->where('id_pk', $id);
        $this->db->delete('proyek');
    }

    public function associate_project_location($project_id, $location_id) {
        $data = array(
            'proyek_id_pk' => $project_id,
            'lokasi_id_pk' => $location_id
        );
        $this->db->insert('proyek_lokasi', $data);
    }
}
