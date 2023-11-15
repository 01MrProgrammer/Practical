<html>
<body>
<form method="post">
    <input type="radio" name="rbchoice" value='1'>Split an array into chunks
    <input type="text" name="chunkSize" placeholder="Enter chunk size"><br>
    <input type="radio" name="rbchoice" value='2'>Sort the array by values without changing the keys <br>
    <input type="radio" name="rbchoice" value='3'> Filter the odd elements from an array<br>

    <input type="submit" name="btnshow" value="show">
    <?php 
    if(isset($_POST["btnshow"])) {
        extract($_POST);
        $assocArray = array("a" => 5, "b" => 3, "c" => 7, "d" => 2);
        $assocArray2 = array("e" => 6, "f" => 1, "g" => 4,"h" => 2);
        switch ($rbchoice) {
            case '1':
                if (isset($_POST['chunkSize'])) 
                {
                    $chunkSize = (int)$_POST['chunkSize']; 
                    if ($chunkSize > 0) {
                        $chunks = array_chunk($assocArray, $chunkSize, true);
                        print_r($chunks);
                    } else {
                        echo "Invalid chunk size. Please enter a positive integer greater than 0.\n";
                    }
                } 
                else
                 {
                    echo "Chunk size not provided.\n";
                }
                break;
            case '2':
                asort($assocArray);
                print_r($assocArray);
                break;
            case '3':
                $filteredArray = array_filter($assocArray, function ($value, $key) {
                    return $value % 2 == 0;
                }, ARRAY_FILTER_USE_BOTH);
                print_r($filteredArray);
                break;
            
            
            default:
                echo "Invalid choice. Please select a valid option.\n";
                break;
        }
    }
    ?>
</form>
</body>

</html>