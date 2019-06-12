<?php

$con = mysqli_connect("localhost", "jyyu7777", "Hansol206", "jyyu7777");
mysqli_set_charset("set names utf8");
$userID = $_POST["userID"];
$response = array();
$response["success"] = false;


$result = mysqli_query($con,"select * from USER_BABY where userID = '$userID'"); 
	
$response["success"] = true;
$response["userID"] = "";
$response["userPassword"] = "";
$response["userName"] = "";
$response["userPhone"] = "";
$response["userEmail"] = "";
while($row = mysqli_fetch_array($result))
{
		#$ID = $row[0];
	 //한개라도 값이 검색되었다면 (즉, 유저가 존재한다면)
	$response["success"] = true;
	$response["userID"] = $row[0];
	$response["userPassword"] = $row[1];
	$response["userName"] = $row[2];
	$response["userPhone"] = $row[3];
	$response["userEmail"] = $row[4];
}
echo json_encode($response);		

$to = $response["userEmail"];

$subject = "비밀번호 찾기";

$random = mt_rand(10000,99999); #랜덤한 숫자 5자리

$contents = "인증번호는 ".$random."입니다";

$headers = "From: Manager @naver.com\r\n";

mail($to, $subject, $contents, $headers);
# ID란 테이블을 생성해놈
#ID랑 랜덤한 숫자를 넣어노셈
#ID는 $userID 랑 $random
#############################################################
$result = mysqli_query($con,"Insert into Id values('$userID','$random')");
mysqli_fetch_array($result);
#############################################################
?>