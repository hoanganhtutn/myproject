<?php 
require"connect.php";

	$mang = array();
	$query = "SELECT * FROM login ";
	$data = mysqli_query($connect,$query);
	while ($row = mysqli_fetch_assoc($data)) {
		array_push($mang, new login(
		$row['id'],
		$row['username'],
		$row['password']));

	}
	echo json_encode($mang);
	class login
	{
		
		function login($id,$username,$password){
		$this->id = $id;
		$this->username = $username;
		$this->password = $password;
	}
}
 ?>