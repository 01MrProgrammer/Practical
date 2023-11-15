<!DOCTYPE html>
<html>
<head>
    <title>Array Operations</title>
</head>
<body >
<form action="<?php echo $_SERVER['PHP_SELF']; ?>" method="post">
<h2>Enter choice :</h2>
<input type="radio" name="ch" value=1> split an array into chunks<br>
<input type="radio" name="ch" value=2> Sort array by values without changing key values <br>
<input type="radio" name="ch" value=3> Filter odd elements from array <br>

<br>

<input type="submit" value="SUBMIT">  <input type="reset" value="CLEAR">
</form>
</body>
</html>

<html>
<body >
<?php
function is_odd($var)
{
    if ($var % 2 == 1)
        return $var;
}

$choice = isset($_POST['ch']) ? $_POST['ch'] : '';

$arr = array('a' => 1, 'b' => 2, 'c' => 3, 'd' => 4, 'e' => 5, 'f' => 6, 'g' => 7, 'h' => 8);
$arr1 = array('l' => 11, 'm' => 2, 'n' => 33, 'o' => 44, 'p' => 5, 'q' => 66, 'r' => 77, 's' => 8);

if ($_SERVER["REQUEST_METHOD"] == "POST") {
    switch ($choice) {
        case 1:
            

            // Split the array into chunks of size 3
            $chunks = array_chunk($arr, 4);
            echo "<br>Array split into chunks:<br>";
            print_r($chunks);
            break;
        case 2:
            asort($arr);
            echo "Array in ascending order:<br>";
            print_r($arr);
            arsort($arr);
            echo "<br>Array in descending order:<br>";
            print_r($arr);
            break;
        case 3:
            print_r(array_filter($arr, 'is_odd'));
            break;
       
    }
    echo "<br><a href='".$_SERVER['PHP_SELF']."'>RETURN</a>";
}
?>
</font>
</body>
</html>

