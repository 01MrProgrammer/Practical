<!DOCTYPE html>
<html>
<head>
    <title>Student Result</title>
</head>
<body>
    <form method="post" action="">
        <?php
        $subjects = array("Subject 1", "Subject 2", "Subject 3", "Subject 4", "Subject 5");

        for ($i = 0; $i < count($subjects); $i++) {
            echo "<label for='marks[$i]'>" . $subjects[$i] . ":</label>";
            echo "<input type='number' name='marks[$i]' id='marks[$i]' min='0' max='100' required><br><br>";
        }
        ?>

        <input type="submit" name="btnCalculate" value="Calculate Result">
    </form>

    <?php
    function calculateResult($marks, $subjects) {
        $totalMarks = 0;

        foreach ($marks as $mark) {
            $totalMarks += $mark;
        }

        $totalSubjects = count($marks);
        $percentage = ($totalMarks / ($totalSubjects * 100)) * 100;

        if ($percentage >= 90) {
            $grade = 'A';
        } elseif ($percentage >= 80) {
            $grade = 'B';
        } elseif ($percentage >= 70) {
            $grade = 'C';
        } elseif ($percentage >= 60) {
            $grade = 'D';
        } else {
            $grade = 'F';
        }

        echo "<h2>Result:</h2>";
        echo "<table border='1'>
                <tr>
                    <th>Subject</th>
                    <th>Marks</th>
                </tr>";

        for ($i = 0; $i < count($marks); $i++) {
            echo "<tr>
                    <td>$subjects[$i]</td>
                    <td>$marks[$i]</td>
                </tr>";
        }

        echo "</table>";
        echo "<p>Total Marks: $totalMarks / " . ($totalSubjects * 100) . "</p>";
        echo "<p>Percentage: $percentage%</p>";
        echo "<p>Grade: $grade</p>";
    }

    if (isset($_POST["btnCalculate"])) {
        $marks = $_POST['marks'];
        calculateResult($marks, $subjects);
    }
    ?>
</body>
</html>