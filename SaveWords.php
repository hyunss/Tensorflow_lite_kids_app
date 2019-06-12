<?php
	$con = mysqli_connect("localhost", "jyyu7777", "Hansol206", "jyyu7777");


	$userID = $_POST["userID"];
	$userWORDS = $_POST["userWORDS"];

	$statement = mysqli_prepare($con, "INSERT INTO USER_WORD VALUES(?,?)");


	mysqli_stmt_bind_param($statement, "ss", $userID, $userWORDS);
	mysqli_stmt_execute($statement);

	$response["success"] = true;

	echo json_encode($response);
?>