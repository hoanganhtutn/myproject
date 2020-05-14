<?php
require"connect.php";
$username = $_POST['username'];
$password = $_POST['password'];

$query = "SELECT * FROM login WHERE  username = '".$username."' AND password = '".$password."'";
if (mysqli_num_rows(mysqli_query($connect,$query)) > 0){
        echo "success";
    }
else{
echo "error";
}
?>