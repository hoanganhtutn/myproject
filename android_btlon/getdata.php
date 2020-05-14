<?php 
require"connect.php";

	$mang = array();
	$query = "SELECT * FROM item ";
	$data = mysqli_query($connect,$query);
	while ($row = mysqli_fetch_assoc($data)) {
		array_push($mang, new login(
		$row['id'],
		$row['gia'],
		$row['time'],
		$row['thongtin']));

	}
	echo json_encode($mang);
	class login
	{
		
		function login($id,$gia,$time,$thongtin){
		$this->id = $id;
		$this->gia = $gia;
		$this->time = $time;
		$this->thongtin = $thongtin;
	}
}
 ?>