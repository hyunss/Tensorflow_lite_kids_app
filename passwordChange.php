<?php

$con = mysqli_connect("localhost", "jyyu7777", "Hansol206", "jyyu7777");


$userID = $_POST["userID"];
$userPassword = $_POST["userPassword"];



$statement = mysqli_query($con, "UPDATE USER_BABY SET userPassword= '$userPassword' WHERE userID = '$userID'  ");

mysqli_stmt_execute($statement);

$statement = mysqli_query($con, "DELETE FROM Id WHERE ID='$userID'");
mysqli_stmt_execute($statement);


$response = array();
$response["success"] = true;

echo json_encode($response);

?>

