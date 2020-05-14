<?php
require "connect.php";
$id = $_POST['id'];
$query =  "DELETE FROM `login` WHERE id = '$id' ";
if (mysqli_query($connect, $query)) {

	echo "success";
}
else{
echo "error";
}
?>