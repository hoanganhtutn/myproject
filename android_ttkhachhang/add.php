<?php
require"connect.php";
$tenkh = $_POST['tenkh'];
$diachikh = $_POST['diachikh'];
$sdtkh = $_POST['sdtkh'];
$email = $_POST['email'];
$ghichu = $_POST['ghichu'];
$makhuyenmai = $_POST['makhuyenmai'];
$query = " INSERT INTO khachhang (idkh, tenkh, diachikh,sdtkh,email, ghichu,makhuyenmai) VALUES (null, '$tenkh','$diachikh','$sdtkh','$email','$ghichu','$makhuyenmai')";
	if (mysqli_query($connect, $query)) {

	echo "success";
}
else{
echo "error";
}
?>