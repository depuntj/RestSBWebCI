<?php
class Location_model extends CI_Model {
    public function get_location($id) {
    $this->db->where('id_pk', $id);
    $query = $this->db->get('lokasi');
    return $query->row();
}
    public function __construct() {
        $this->load->database();
    }
    public function insert($data)
    {
        $this->db->insert('lokasi', $data);
    }
    public function insert_location($data) {
        $this->db->insert('lokasi', $data);
    }

    public function get_all_locations() {
        $query = $this->db->get('lokasi');
        return $query->result();
    }
    public function get_location_by_id($id)
    {
        $query = $this->db->get_where('lokasi', ['id_pk' => $id]);
        return $query->row();
    }

    public function update($id, $data)
    {
        $this->db->where('id_pk', $id);
        $this->db->update('lokasi', $data);
    }
    public function update_location($id, $data) {
        $this->db->where('id_pk', $id);
        $this->db->update('lokasi', $data);
    }

    public function delete_location($id) {
        $this->db->where('id_pk', $id);
        $this->db->delete('lokasi');
    }
}
