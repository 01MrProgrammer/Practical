<!--Assignment-3 Set-B Q2-->

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>String Operations with Separator</title>
</head>
<body>
    <form action="" method="post">
        <label for="inputString">Enter String:</label>
        <input type="text" name="inputString" id="inputString" required>
        <br>
        <label for="separator">Choose a Separator:</label>
        <select name="separator" id="separator">
            <option value="#">#</option>
            <option value="|">|</option>
            <option value="%">%</option>
            <option value="@">@</option>
            <option value="!">!</option>
            <option value=",">,</option>
        </select>
        <br>
        <input type="submit" value="Submit">
    </form>
</body>
</html>

<?php
if ($_SERVER["REQUEST_METHOD"] == "POST") {
    $inputString = $_POST['inputString'];
    $separator = $_POST['separator'];

    // a. Split the string into separate words using the given separator.
    $words = explode($separator, $inputString);
    echo "Words after splitting with '$separator': <br>" . implode(", ", $words) . "<br><br>";

    // b. Replace all the occurrences of the separator with a fixed separator (e.g., "*").
    $replacedString = str_replace($separator, "*", $inputString);
    echo "String after replacing '$separator' with '*': <br>$replacedString<br><br>";

    // c. Find the last word in the given string using strrpos() and substr() functions.
    $lastSeparatorPos = strrpos($inputString, $separator);
    $lastWord = ($lastSeparatorPos !== false) ? substr($inputString, $lastSeparatorPos + 1) : $inputString;
    echo "Last word in the string: <br>$lastWord<br><br>";
}
?>

