<!--Assignment-5 Set-A Q1-->

<?php

$servername = "localhost";
$username = "root";
$password = "";
$database = "FileDB";
$file_directory = "uploads";
$file_name = "sample.txt";
$file_path = "$file_directory/$file_name";

// Ensure the directory exists
if (!file_exists($file_directory)) {
    mkdir($file_directory, 0777, true);
}

// Create a sample file
file_put_contents($file_path, "This is sample content for our file.");

// Create connection
$conn = new mysqli($servername, $username, $password);

// Check connection
if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
}

// Create database and table, and insert file information
$conn->query("CREATE DATABASE IF NOT EXISTS FileDB");
$conn->query("USE FileDB");
$conn->query("CREATE TABLE IF NOT EXISTS files (
    id INT PRIMARY KEY AUTO_INCREMENT,
    file_name VARCHAR(255) NOT NULL,
    file_path VARCHAR(255) NOT NULL
)");
$conn->query("INSERT INTO files (file_name, file_path) VALUES ('$file_name', '$file_path')");

// Fetch the file information from the database
$sql = "SELECT file_name, file_path FROM files WHERE id = 1";
$result = $conn->query($sql);

if ($result->num_rows > 0) {
    while ($row = $result->fetch_assoc()) {
        $f_path = $row["file_path"];
        
        if (file_exists($f_path)) {
            $file_contents = file_get_contents($f_path);
            $file_size = filesize($f_path);
            
            echo "File Contents:<br>";
            echo "<pre>$file_contents</pre><br>";
            echo "File Size: $file_size bytes";
        } else {
            echo "File not found!";
        }
    }
} else {
    echo "No files found in the database.";
}

$conn->close();

?>
