<!DOCTYPE html>
<html>
<head>
    <title>String Operations</title>
</head>
<body>
    <form method="post" action="">
        <label for="inputString">Enter a string:</label>
        <input type="text" name="inputString" id="inputString" required><br><br>
        
        <label for="separator">Choose a separator:</label>
        <select name="separator" id="separator">
            <option value="#">#</option>
            <option value="|">|</option>
            <option value="%">%</option>
            <option value="@">@</option>
            <option value="!">!</option>
            <option value=",">,</option>
        </select><br><br>
        
        <input type="submit" name="btnProcess" value="Process">
    </form>

    <?php
    if (isset($_POST["btnProcess"])) {
        $inputString = $_POST['inputString'];
        $selectedSeparator = $_POST['separator'];

        echo "Original String: $inputString<br>";
        echo "Selected Separator: $selectedSeparator<br><br>";

        $words = explode($selectedSeparator, $inputString);
        echo "Split Words: " . implode(', ', $words) . "<br><br>";
        $newSeparator = '-';
        $newString = str_replace($selectedSeparator, $newSeparator, $inputString);
        echo "String with Replaced Separator: $newString<br><br>";
        $lastWord = strrchr($inputString, $selectedSeparator);
        if ($lastWord === false) {
            echo "No occurrence of the separator found.";
        } else {
            echo "Last Word: $lastWord";
        }
    }
    ?>
</body>
</html>