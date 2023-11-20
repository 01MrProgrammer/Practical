<?php
$string1=$_POST['string1'];
$separater=$_POST['separator'];
$choice=$_POST['choice'];
$new_separater=$_POST['newsep'];//only for second case
echo"originonal String is=$string1.<br>";
switch($choice)
{
case 1:
$sep_string=explode($separater,$string1);
echo"separated string is=>";
print_r($sep_string);
break;
case 2:
$z=str_replace($separater,$new_separater,$string1);
echo "replaced string is".$z;
break;
case 3:
$lws=strrpos($string1,' ')+1;
$last=substr($string1,$lws);
echo $last;
}
?>
