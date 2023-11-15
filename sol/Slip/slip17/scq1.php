<?php
$age = array("Sophia"=>"31","Jacob"=>"41","William"=>"39","Ramesh"=>"40");
asort($age);

echo "\n\nAscending order sort by value:\n";
echo "\n\n";
foreach($age as $key => $value)
{
    echo "Key=" . $key . ", Value=" . $value;
    
}
ksort($age);
echo "\n\n\nAscending order sort by key:\n";
foreach($age as $key => $value)
{   
    echo "\n\n";
    echo "Key=" . $key . ", Value=" . $value;
    echo "\n\n";
}
arsort($age);
echo "\n\nDescending order sorting by value:\n";
foreach($age as $key => $value)
{
    echo "Key=" . $key . ", Value=" . $value;
    echo "\n";
}
krsort($age);
echo "\nDescending order sorting by key:\n";
foreach($age as $key => $value)
{
    echo "Key=" . $key . ", Value=" . $value;
    echo "\n";
}
?>