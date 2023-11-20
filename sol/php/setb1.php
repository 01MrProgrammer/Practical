<?php
$s1=$_POST['str1'];
$s2=$_POST['str2'];
if(strpos($s2,$s1))
{
echo "$s1 is present at begining at $s2<br>";
}
else
{
echo "$s1 is no present at the begining of $s2<br>";
}
$z=strpos($s2,$s1);
echo "position of $1 in $s2 is $z<br>";
$z=strncmp($s1,$s2,3);
if($z==0)
{
echo "both string matches 3 char";
}
else
{
echo "string not match";
}
?>
