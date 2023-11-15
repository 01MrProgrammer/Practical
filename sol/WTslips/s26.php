<?php

$host = "host=127.0.0.1";
$port = "port=5432";
$dbname = "dbname=postgres";
$credentials = "user=postgres password=shubham@123";

$db = pg_connect("$host $port $credentials");

if (!$db) {
    die("Connection failed: " . pg_last_error());
}

if ($_SERVER["REQUEST_METHOD"] == "POST" && isset($_POST['hospitalName'])) {
    $hospitalName = $_POST['hospitalName'];

    // Use prepared statements to prevent SQL injection
    $sql = "
        SELECT Doctor.dname
        FROM Doctor
        JOIN Hospital ON Doctor.hosp_no = Hospital.hosp_no
        WHERE Hospital.hname = $1
    ";

    $result = pg_query_params($db, $sql, array($hospitalName));

    if (pg_num_rows($result) > 0) {
        echo '<h2>Doctors at ' . $hospitalName . '</h2>';
        echo '<ul>';

        while ($row = pg_fetch_assoc($result)) {
            echo '<li>' . $row["dname"] . '</li>';
        }

        echo '</ul>';
    } else {
        echo 'No doctors found for the specified hospital.';
    }
}

pg_close($db);

?>

<!DOCTYPE html>
<html>
<head>
    <title>Find Doctors by Hospital</title>
</head>
<body>
    <h1>Find Doctors by Hospital</h1>
    <form action="" method="post">
        Hospital Name: <input type="text" name="hospitalName">
        <input type="submit" value="Find Doctors">
    </form>
</body>
</html>

