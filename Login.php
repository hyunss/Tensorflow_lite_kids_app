<?php
	$con = mysqli_connect("localhost", "jyyu7777", "Hansol206", "jyyu7777");


	$userID = $_POST["userID"];
	$userPassword = $_POST["userPassword"];

	$statement = mysqli_prepare($con, "SELECT * FROM USER_BABY WHERE userID = ? AND userPassword = ?");

	mysqli_stmt_bind_param($statement, "ss", $userID, $userPassword);
	mysqli_stmt_execute($statement);


	mysqli_stmt_store_result($statement);
	mysqli_stmt_bind_param($statement, $userID, $userPassword, $userName, $userPhone, $userEmail);


	$response = array();
	$response["success"] = false;

	while(mysqli_stmt_fetch($statement)){
		$response["success"] = true;
		$response["userID"] = $userID;
		$response["userPassword"] = $userPassword;
		$response["userName"] = $userName;
		$response["userPhone"] = $userPhoneNumber;
		$response["userEmail"] = $userEmail;
	}

	echo json_encode($response);
?>