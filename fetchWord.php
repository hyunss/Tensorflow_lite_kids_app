<?php
define('HOST','localhost');
define('USER','jyyu7777');
define('PASS','Hansol206');
define('DB','jyyu7777');

 

$con = mysqli_connect(HOST,USER,PASS,DB);
 
$userID = $_GET["userID"];
 
$sql = "select userWORDS from USER_WORD where userID like '$userID'";
 
$res = mysqli_query($con,$sql);
 
$result = array();
 
while($row = mysqli_fetch_array($res)){
array_push($result,array(
'userWORDS'=>$row[0]
));
}
 
echo json_encode(array("result"=>$result));
 
mysqli_close($con);
 
?>