<?php
define('HOST','localhost');
define('USER','jyyu7777');
define('PASS','Hansol206');
define('DB','jyyu7777');

 
$con = mysqli_connect(HOST,USER,PASS,DB);
$userID  = $_GET['userID'];
 
$sql = "SELECT userName, userEmail FROM USER_BABY WHERE userID like '%$userID%'";
 
$res = mysqli_query($con, $sql);
 
$result = array();
 
while($row = mysqli_fetch_array($res)){
array_push($result,array('userName'=>$row[0],
'userEmail'=>$row[1]
));
}
 
echo json_encode(array("result"=>$result));
 
mysqli_close($con);
 
?>