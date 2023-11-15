<!DOCTYPE html>
<html>
<head>
    <title>String Comparison</title>
</head>
<body>
    <h1>String Comparison</h1>
    <form action="<?php echo $_SERVER['PHP_SELF']; ?>" method="post">
        <label for="string1">Enter the first string:</label>
        <input type="text" id="string1" name="string1" value="<?php echo isset($_POST['string1']) ? $_POST['string1'] : ''; ?>"><br><br>

        <label for="string2">Enter the second string:</label>
        <input type="text" id="string2" name="string2" value="<?php echo isset($_POST['string2']) ? $_POST['string2'] : ''; ?>"><br><br>

        <label>Select Comparison Operation:</label>
        <input type="radio" name="operation" value="startsWith" <?php echo (isset($_POST['operation']) && $_POST['operation'] === 'startsWith') ? 'checked' : ''; ?>> Starts With
        <input type="radio" name="operation" value="position" <?php echo (isset($_POST['operation']) && $_POST['operation'] === 'position') ? 'checked' : ''; ?>> Position
        <input type="radio" name="operation" value="firstNChars" <?php echo (isset($_POST['operation']) && $_POST['operation'] === 'firstNChars') ? 'checked' : ''; ?>> First N Characters

        <label for="n">Number of characters to compare (only for 'First N Characters' operation):</label>
        <input type="text" id="n" name="n" value="<?php echo isset($_POST['n']) ? $_POST['n'] : ''; ?>"><br><br>

        <input type="submit" value="Submit">
    </form>

    <?php
    if ($_SERVER["REQUEST_METHOD"] == "POST") {
        $string1 = $_POST["string1"];
        $string2 = $_POST["string2"];
        $operation = $_POST["operation"];
        
        echo "<h2>Results:</h2>";

        switch ($operation) {
            case "startsWith":
                if (strpos($string1, $string2) === 0) {
                    echo "The small string appears at the start of the large string.<br><br>";
                } else {
                    echo "The small string does not appear at the start of the large string.<br><br>";
                }
                break;

            case "position":
                $position = strpos($string1, $string2);
                if ($position !== false) {
                    echo "Position of the small string in the big string: $position<br><br>";
                } else {
                    echo "The small string was not found in the big string.<br><br>";
                }
                break;

            case "firstNChars":
                $n = isset($_POST['n']) ? (int)$_POST['n'] : 0; // Get the value of 'n' from the form
                $substring1 = substr($string1, 0, $n);
                $substring2 = substr($string2, 0, $n);
                if (strcasecmp($substring1, $substring2) === 0) {
                    echo "First $n characters are the same (case-insensitive) in both strings.<br><br>";
                } else {
                    echo "First $n characters are different in the two strings.<br><br>";
                }
                break;
        }
    }
    ?>
</body>
</html>

