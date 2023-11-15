<?php
if ($_SERVER["REQUEST_METHOD"] == "POST") {
    // Retrieve user input from the form
    $smallString = $_POST["smallString"];
    $largeString = $_POST["largeString"];

    // a. Find whether the small string appears at the start of the large string
    $startsWith = strpos($largeString, $smallString) === 0;

    // b. Find the position of the small string in the big string
    $position = strpos($largeString, $smallString);

    // c. Compare both strings for the first n characters (case-insensitive)
    $n = 3; // You can change this value as needed
    $comparison = strncasecmp($smallString, $largeString, $n);

    // Display results
    echo "<p>Does the small string appear at the start of the large string? " . ($startsWith ? 'Yes' : 'No') . "</p>";
    echo "<p>Position of the small string in the large string: " . ($position !== false ? $position : 'Not found') . "</p>";
    echo "<p>Comparison of the first $n characters (case-insensitive): " . ($comparison === 0 ? 'Equal' : 'Not equal') . "</p>";
}
?>
