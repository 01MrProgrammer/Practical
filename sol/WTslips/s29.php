<?php
/*error_reporting(E_ALL);
ini_set('display_errors', 1);*/

$host = "host=127.0.0.1";
$port = "port=5432";
$dbname = "dbname=FileDB";
$credentials = "user=postgres password=shubham@123";

$db = pg_connect("$host $port $dbname $credentials");

if (!$db) {
    die("Connection failed: " . pg_last_error());
}

function displayCommitteeStatus($db) {
    $result = pg_query($db, "SELECT name, status FROM Committee");
    if (pg_num_rows($result) > 0) {
        echo "<table border='1'>
                <tr>
                    <th>Committee Name</th>
                    <th>Status</th>
                </tr>";
        while ($row = pg_fetch_assoc($result)) {
            echo "<tr>
                    <td>" . $row["name"] . "</td>
                    <td>" . $row["status"] . "</td>
                  </tr>";
        }
        echo "</table>";
    } else {
        echo "No committees found!";
    }
    echo "<br>";
}

echo "Committee Status Before Update: <br>";
displayCommitteeStatus($db);

if ($_SERVER["REQUEST_METHOD"] == "POST" && isset($_POST['title'])) {
    $title = $_POST['title'];
    $checkEvent = pg_prepare($db, "check_event", "SELECT eno FROM Event WHERE title = $1");
    $eventResult = pg_execute($db, "check_event", array($title));
    
    if (pg_num_rows($eventResult) == 0) {
        die("No matching event found for the title: $title");
    }

    $sql = "
        UPDATE Committee
        SET status = 'working'
        WHERE cno IN (
            SELECT cno FROM EventCommittee WHERE eno = (
                SELECT eno FROM Event WHERE title = $1
            )
        )
    ";

    $result = pg_prepare($db, "update_status", $sql);
    $execResult = pg_execute($db, "update_status", array($title));
    
    if ($execResult) {
        echo "Committee status updated successfully!<br>";
    } else {
        echo "Error updating status: " . pg_last_error($db) . "<br>";
    }

    echo "<br>Committee Status After Update: <br>";
    displayCommitteeStatus($db);
} else {
    echo '
    <form action="" method="post">
        Event Title: <input type="text" name="title">
        <input type="submit" value="Update Committee Status">
    </form>
    ';
}

pg_close($db);
?>

