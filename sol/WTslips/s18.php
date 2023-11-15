<!DOCTYPE html>
<html>
<head>
    <title>Associative Array Operations</title>
</head>
<body>
    <h1>Menu-Driven Program for Associative Array Operations</h1>
    <form action="<?php echo $_SERVER['PHP_SELF']; ?>" method="post">
        <p>Select an operation:</p>
        <input type="radio" name="operation" value="reverse"> Reverse key-value pairs<br>
        <input type="radio" name="operation" value="traverse"> Traverse in random order<br>
        <input type="radio" name="operation" value="convert"> Convert to variables<br>
        <input type="radio" name="operation" value="display"> Display with keys<br>
        <input type="submit" value="Submit">
    </form>

    <?php
    $ageArray = array("kanchan" => "31", "Ram" => "41", "shubham" => "39", "shubhangi" => "40");

    if ($_SERVER["REQUEST_METHOD"] == "POST") {
        $selectedOperation = $_POST["operation"];

        switch ($selectedOperation) {
            case "reverse":
                $reversedArray = array_flip($ageArray);
                print_r($reversedArray);
                break;
            case "traverse":
                shuffle($ageArray);
                print_r($ageArray);
                break;
            case "convert":
                extract($ageArray);
                echo "kanchan: $kanchan, Ram: $Ram, shubham: $shubham, shubhangi: $shubhangi";
                break;
            case "display":
                foreach ($ageArray as $key => $value) {
                    echo "$key: $value<br>";
                }
                break;
            default:
                echo "Invalid choice. Please select a valid option.";
                break;
        }
    }
    ?>
</body>
</html>

