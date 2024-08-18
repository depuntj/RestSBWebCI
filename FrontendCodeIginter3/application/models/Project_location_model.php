<?php
defined('BASEPATH') OR exit('No direct script access allowed');

class Project_location_model extends CI_Model {

    public function __construct() {
        parent::__construct();
        $this->load->database();
    }

    public function insert_proyek_lokasi($data) {
        return $this->db->insert('proyek_lokasi', $data);
    }
}
?>
