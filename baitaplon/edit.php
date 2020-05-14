<?php
require"connect.php";
$id = $_POST['id'];
$username = $_POST['username'];
$password = $_POST['password'];

$query = " UPDATE login SET username = '$username', password = '$password' WHERE id = '$id'";
if (mysqli_query($connect, $query)) {

	echo "success";
}
else{
echo "error";
}
?>