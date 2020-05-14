<?php
require"connect.php";
$tenkh = $_POST['tenkh'];
$diachikh = $_POST['diachikh'];
$sdtkh = $_POST['sdtkh'];
$ghichu = $_POST['ghichu'];
$makhuyenmai = $_POST['makhuyenmai'];
$query = "SELECT * FROM `khachhang` WHERE tenkh = '".$tenkh."' AND diachikh = '".$diachikh."' AND sdtkh = '".$sdtkh."'AND ghichu = '".$ghichu."' AND makhuyenmai = '".$makhuyenmai."'";
if (mysqli_num_rows(mysqli_query($connect,$query)) > 0){
        echo "success";
    }
else{
echo "error";
}
?>