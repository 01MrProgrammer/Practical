<?php

$message = '';

if ($_SERVER["REQUEST_METHOD"] == "POST") {
    if (isset($_POST['operation'])) {
        $operation = $_POST['operation'];
        $filename = isset($_POST['filename']) ? $_POST['filename'] : '';

        if ($operation !== 'd' && empty($filename)) {
            $message = "Please enter a filename.";
        } else {
            switch ($operation) {
                case 'a':
                    $message = displayFileType($filename);
                    break;
                case 'b':
                    $message = displayLastAccessTime($filename);
                    break;
                case 'c':
                    $message = displayFileSize($filename);
                    break;
                case 'd':
                    $message = deleteFile($filename);
                    break;
                default:
                    $message = "Invalid operation!";
            }
        }
    }
}

function displayFileType($filename) {
    return "File Type: " . mime_content_type($filename);
}

function displayLastAccessTime($filename) {
    return "Last Access Time: " . date("F d Y H:i:s.", fileatime($filename));
}

function displayFileSize($filename) {
    return "File Size: " . filesize($filename) . " bytes";
}

function deleteFile($filename) {
    if (!file_exists($filename)) {
        return "File does not exist!";
    }

    if (!is_writable($filename)) {
        return "File is not writable!";
    }

    if (unlink($filename)) {
        return "File deleted successfully!";
    } else {
        return "Error deleting the file: " . error_get_last()['message'];
    }
}

?>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>File Operations</title>
</head>
<body>

<h1>File Operations</h1>

<form action="" method="post">
    Enter Filename: <input type="text" name="filename" required>
    <br><br>
    <div>
        <h2>Choose Operation:</h2>
        <ul>
            <li>
                <input type="radio" name="operation" value="a" id="operation_a">
                <label for="operation_a">Display type of file</label>
            </li>
            <li>
                <input type="radio" name="operation" value="b" id="operation_b">
                <label for="operation_b">Display last access time of file</label>
            </li>
            <li>
                <input type="radio" name="operation" value="c" id="operation_c">
                <label for="operation_c">Display the size of file</label>
            </li>
            <li>
                <input type="radio" name="operation" value="d" id="operation_d">
                <label for="operation_d">Delete the file</label>
            </li>
        </ul>
    </div>
    <br>
    <input type="submit" value="Execute">
</form>

<?php
if (!empty($message)) {
    echo "<p>$message</p>";
}
?>

</body>
</html>


