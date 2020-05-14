<?php 
require"connect.php";

	$mang = array();
	$query = "SELECT * FROM khachhang ";
	$data = mysqli_query($connect,$query);
	while ($row = mysqli_fetch_assoc($data)) {
		array_push($mang, new khachhang(
		$row['idkh'],
		$row['tenkh'],
		$row['diachikh'],
		$row['sdtkh'],
		$row['email'],
		$row['ghichu'],
		$row['makhuyenmai']));

	}
	echo json_encode($mang);
	class khachhang
	{
		
		function khachhang($idkh,$tenkh,$diachikh,$sdtkh,$email,$ghichu,$makhuyenmai){
		$this->idkh = $idkh;
		$this->tenkh = $tenkh;
		$this->diachikh = $diachikh;
		$this->sdtkh = $sdtkh;
		$this->email = $email;
		$this->ghichu = $ghichu;
		$this->makhuyenmai = $makhuyenmai;
	}
}
 ?>