<!DOCTYPE html>
<html>
<head>
    <style>
        body{
            align: center;
        }
        .chessboard {
            border-collapse: collapse;
            border:2px solid black;
            width: 320px;
            height: 320px;
            align: center;
        }
        
        .chessboard td {
            width: 40px;
            height: 40px;
            text-align: center;
            vertical-align: middle;
        }
        
        .white {
            background-color: #ffffff;
        }
        
        .black {
            background-color: #000000;
        }
    </style>
</head>
<body>
    <table class="chessboard">
        <?php
        for ($row = 1; $row <= 8; $row++) {
            echo "<tr>";
            for ($col = 1; $col <= 8; $col++) {
                $class = ($row + $col) % 2 === 0 ? "white" : "black";
                echo "<td class=\"$class\"></td>";
            }
            echo "</tr>";
        }
        ?>
    </table>
</body>
</html>