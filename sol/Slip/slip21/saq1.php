<?php
$highTemps = array( '81', '52', '63', '74', '95','80','71','72','73',
'74','76','78','89','81', '52', '63', '74', '95','80','71','72','73',
'74','76','78','89','81', '52', '63', '74', '95','80','71','72','73','74','76','78','89' );
echo"array = ";
foreach ($highTemps as $x)
{
    echo "$x ,";
}
$averageTemp = array_sum($highTemps) / count($highTemps);
rsort($highTemps);
$warmestTemps = array_slice($highTemps, 0, 5);
$coolestTemps = array_slice($highTemps, -5);
echo"\n\n <br>";
echo "\nAverage High Temperature: " . round($averageTemp, 2) . "&deg;F<br>";
echo "Five Warmest High Temperatures: " . implode(", ", $warmestTemps) . "&deg;F<br>";
echo "Five Coolest High Temperatures: " . implode(", ", $coolestTemps) . "&deg;F";
?>