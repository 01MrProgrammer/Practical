<?php
// Define the associative array
$ageArray = array( "kanchan" => "31","Ram" => "41","shubham" => "39", "shubhangi" => "40");

// a) Ascending order sort by value
asort($ageArray);
echo "Ascending order sort by value:<br>";
print_r($ageArray);

// b) Ascending order sort by key
ksort($ageArray);
echo "<br><br>Ascending order sort by key:<br>";
print_r($ageArray);

// c) Descending order sort by value
arsort($ageArray);
echo "<br><br>Descending order sort by value:<br>";
print_r($ageArray);

// d) Descending order sort by key
krsort($ageArray);
echo "<br><br>Descending order sort by key:<br>";
print_r($ageArray);
?>

