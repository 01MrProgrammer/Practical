<!DOCTYPE html>
<html>
<head>
    <title>String Operations</title>
</head>
<body>
    <h1>String Operations</h1>
    <form action="<?php echo $_SERVER['PHP_SELF']; ?>" method="post">
        <label for="inputString">Enter a string:</label>
        <input type="text" id="inputString" name="inputString" value="<?php if (isset($_POST['inputString'])) echo $_POST['inputString']; ?>"><br><br>
        
        <input type="radio" name="operation" value="length"> Find Length<br>
        <input type="radio" name="operation" value="vowels"> Count Vowels<br>
        <input type="radio" name="operation" value="titlecase"> Convert to Title Case<br>
        <input type="radio" name="operation" value="pad"> Pad with '*'<br>
        <input type="radio" name="operation" value="whitespace"> Remove Leading Whitespaces<br>
        <input type="radio" name="operation" value="reverse"> Reverse String<br><br>
        
        <input type="submit" value="Submit">
    </form>
    
    <?php
    function findStringLength($str) {
        $length = 0;
        while (isset($str[$length])) {
            $length++;
        }
        return $length;
    }
    
    function countVowels($str) {
        $vowels = ['a', 'e', 'i', 'o', 'u'];
        $count = 0;
        foreach ($vowels as $vowel) {
            $count += substr_count($str, $vowel);
        }
        return $count;
    }
    
    function convertToTitleCase($str) {
        return ucwords($str);
    }
    
    function padStringWithAsterisk($str) {
        return '*' . $str . '*';
    }
    
    function removeLeadingWhitespaces($str) {
        return ltrim($str);
    }
    
    function reverseString($str) {
        return strrev($str);
    }
    
    if ($_SERVER["REQUEST_METHOD"] == "POST") {
        $inputString = $_POST["inputString"];
        $operation = $_POST["operation"];
        
        echo "<h2>Results:</h2>";
        
        switch ($operation) {
            case "length":
                echo "Length of the string: " . findStringLength($inputString);
                break;
            case "vowels":
                echo "Number of vowels: " . countVowels($inputString);
                break;
            case "titlecase":
                $lowercase = strtolower($inputString);
                echo "Lowercase: " . $lowercase . "<br>";
                echo "Lowercase to Title case: " . convertToTitleCase($lowercase);
                break;
            case "pad":
                echo "String padded with '*': " . padStringWithAsterisk($inputString);
                break;
            case "whitespace":
                echo "String with leading whitespaces removed: " . removeLeadingWhitespaces($inputString);
                break;
            case "reverse":
                echo "Reversed string: " . reverseString($inputString);
                break;
            default:
                echo "Please select an operation.";
        }
    }
    ?>
</body>
</html>

