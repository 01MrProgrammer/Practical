<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>String Manipulation Form</title>
</head>
<body>

<?php
// Function to split string, replace separator, and find the last word
function manipulateString($inputString, $selectedSeparator, $replaceSeparator) {
    // Split the string into separate words using the given separator
    $words = explode($selectedSeparator, $inputString);

    // Replace all occurrences of the separator in the given string with another separator
    $modifiedString = str_replace($selectedSeparator, $replaceSeparator, $inputString);

    // Find the last word in the given string
    $lastWord = end($words);

    // Display the results
    echo "Original String: $inputString <br>";
    echo "Separated Words: " . implode(', ', $words) . "<br>";
    echo "Modified String: $modifiedString <br>";
    echo "Last Word: $lastWord <br>";
}

// Check if form is submitted
if ($_SERVER["REQUEST_METHOD"] == "POST") {
    // Retrieve user input
    $userInput = $_POST["userInput"];
    $selectedSeparator = $_POST["separator"];
    $replaceSeparator = $_POST["replaceSeparator"];

    // Perform string manipulation
    manipulateString($userInput, $selectedSeparator, $replaceSeparator);
}
?>

<form method="post" action="<?php echo htmlspecialchars($_SERVER["PHP_SELF"]); ?>">
    <label for="userInput">Enter a String:</label>
    <input type="text" name="userInput" required><br>

    <label for="separator">Choose a Separator:</label>
    <select name="separator">
        <option value="#">#</option>
        <option value="|">|</option>
        <option value="%">%</option>
        <!-- Add more separator options as needed -->
    </select><br>

    <label for="replaceSeparator">Replace Separator with:</label>
    <input type="text" name="replaceSeparator" required><br>

    <input type="submit" value="Submit">
</form>

</body>
</html>
