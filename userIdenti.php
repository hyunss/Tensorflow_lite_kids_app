<?php

$con = mysqli_connect("localhost", "jyyu7777", "Hansol206", "jyyu7777");
mysqli_set_charset("set names utf8");
$result = mysqli_query($con,"select * from Id where userID = '$userID'"); 

$response["success"] = true;
$response["ID"] = "";
$response["identi"] = "";

while($row = mysqli_fetch_array($result))
{
		#$ID = $row[0];
	 //한개라도 값이 검색되었다면 (즉, 유저가 존재한다면)
	$response["success"] = true;
	$response["ID"] = $row[0];
	$response["identi"] = $row[1];
}


 echo json_encode($response);


###############################################
# Id 테이블에 있는 값과 받아온 값이 맞으면 비밀번호를 보여주거나 리턴해줌

?>