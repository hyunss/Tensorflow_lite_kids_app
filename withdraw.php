<?php
//회원탈퇴php
$con = mysqli_connect("localhost", "jyyu7777", "Hansol206", "jyyu7777");


$userID = $_POST["userID"];


$statement = mysqli_query($con, "DELETE FROM USER_BABY WHERE userID = '$userID'");
mysqli_stmt_execute($statement);



$response = array();
$response["success"] = true;

echo json_encode($response);

?>