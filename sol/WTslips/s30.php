<?php

$host = "host=127.0.0.1";
$port = "port=5432";
$dbname = "dbname=competition_db";
$credentials = "user=postgres password=shubham@123";

$db = pg_connect("$host $port $credentials");

if (!$db) {
    die("Connection failed: " . pg_last_error());
}

// Create the database if it doesn't exist
// Note: The database creation part is removed because it's non-trivial to check and create databases in PostgreSQL within the same connection. It's recommended to create the database manually or through an admin interface.

// Check and create tables if they don't exist
$result = pg_query($db, "SELECT 1 FROM pg_tables WHERE tablename = 'student'");
if (pg_num_rows($result) == 0) {
    pg_query($db, "CREATE TABLE Student (Stud_id INT PRIMARY KEY, name VARCHAR(255), class VARCHAR(255))");
    pg_query($db, "INSERT INTO Student VALUES (1, 'Alice', '10A'), (2, 'Bob', '10B'), (3, 'Charlie', '10C')");
}

$result = pg_query($db, "SELECT 1 FROM pg_tables WHERE tablename = 'competition'");
if (pg_num_rows($result) == 0) {
    pg_query($db, "CREATE TABLE Competition (c_no INT PRIMARY KEY, c_name VARCHAR(255), type VARCHAR(255))");
    pg_query($db, "INSERT INTO Competition VALUES (1, 'Math Challenge', 'Academic'), (2, 'Coding Challenge', 'Technical'), (3, 'Art Contest', 'Creative')");
}

$result = pg_query($db, "SELECT 1 FROM pg_tables WHERE tablename = 'studentcompetition'");
if (pg_num_rows($result) == 0) {
    pg_query($db, "CREATE TABLE StudentCompetition (Stud_id INT, c_no INT, rank INT, year INT, PRIMARY KEY(Stud_id, c_no))");
    pg_query($db, "INSERT INTO StudentCompetition VALUES (1, 1, 1, 2023), (2, 2, 1, 2023), (3, 3, 1, 2023)");
}

if ($_SERVER["REQUEST_METHOD"] == "POST" && isset($_POST['c_name'])) {
    $c_name = $_POST['c_name'];

    $sql = "
        SELECT Student.name, Student.class
        FROM Student
        JOIN StudentCompetition ON Student.Stud_id = StudentCompetition.Stud_id
        JOIN Competition ON StudentCompetition.c_no = Competition.c_no
        WHERE Competition.c_name = $1 AND StudentCompetition.rank = 1
    ";

    $result = pg_query_params($db, $sql, array($c_name));
    if (pg_num_rows($result) > 0) {
        while ($row = pg_fetch_assoc($result)) {
            echo "Student Name: " . $row["name"] . "<br>";
            echo "Class: " . $row["class"] . "<br>";
        }
    } else {
        echo "No student secured 1st rank in the given competition.";
    }
} else {
    echo '
    <form action="" method="post">
        Competition Name: <input type="text" name="c_name">
        <input type="submit" value="Find 1st Rank">
    </form>
    ';
}

pg_close($db);

?>


