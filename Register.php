<?php

$con = mysqli_connect("localhost", "jyyu7777", "Hansol206", "jyyu7777");

$userID = $_POST["userID"];
$userPassword = $_POST["userPassword"];
$userName = $_POST["userName"];
$userPhone = $_POST["userPhone"];
$userEmail = $_POST["userEmail"];


$statement = mysqli_prepare($con, "INSERT INTO USER_BABY VALUES(?,?,?,?,?)");



mysqli_stmt_bind_param($statement, "sssss", $userID, $userPassword, $userName, $userPhone, $userEmail);
mysqli_stmt_execute($statement);



$response = array();
$response["success"] = true;

echo json_encode($response);
?>
