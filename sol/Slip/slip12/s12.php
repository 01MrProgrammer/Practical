<!DOCTYPE html>
<html>
<head>
    <title>Calculator</title>
</head>
<body>
    <h2>Simple Calculator</h2>
    <?php
    function calculate($num1, $num2, $operation = 'add') {
        switch ($operation) {
            case 'add':
                return $num1 + $num2;
            case 'subtract':
                return $num1 - $num2;
            case 'multiply':
                return $num1 * $num2;
            case 'divide':
                if ($num2 != 0) {
                    return $num1 / $num2;
                } else {
                    return "Cannot divide by zero.";
                }
            default:
                return "Invalid operation.";
        }
    }

    if ($_SERVER['REQUEST_METHOD'] === 'POST') {
        $num1 = $_POST['num1'];
        $num2 = $_POST['num2'];
        $operation = $_POST['operation'];
        $result = calculate($num1, $num2, $operation);
        echo "Result: $result";
    }
    ?>

    <form action="<?php echo $_SERVER['PHP_SELF']; ?>" method="post">
        Enter first number: <input type="number" name="num1" required><br><br>
        Enter second number: <input type="number" name="num2" required><br><br>
        Choose an operation:
        <input type="radio" name="operation" value="add" checked> Addition
        <input type="radio" name="operation" value="subtract"> Subtraction
        <input type="radio" name="operation" value="multiply"> Multiplication
        <input type="radio" name="operation" value="divide"> Division<br><br>
        <input type="submit" value="Calculate">
    </form>
</body>
</html>