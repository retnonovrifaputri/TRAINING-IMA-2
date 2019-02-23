<?php
// Include File koneksi
require 'koneksi.php';
// Buat Query Perintah Untuk Menampilkan Semua Data
// Secara Descending Berdasarkan ID
$sql_get_berita = "SELECT * FROM tb_berita ORDER BY id DESC";
$query = $conn->query($sql_get_berita);

// Variable Penampung Array Sementara
$response_data = null;

while ($data = $query->fetch_assoc()) {
	// Tambahkan Data Yg Di Seleksi Ke Dalam Array
	$response_data[] = $data;
}

// Cek Apakah Datanya Null ?
if (is_null($response_data)) {
	// jika ya, Buat Status Untuk Response Jadi False
	$status = false;
} else {
	// Jika Tidak, Buat Status Untuk Response Jadi True
	$status = true;
}
// Set Type Header Response Ke Json
header('Content-Type: application/json');
// Bungkus Data Dalam Array
$response = ['status' => $status, 'berita' => $response_data];
// Tampilkan Dan convert Ke Format Json
echo json_encode($response);
