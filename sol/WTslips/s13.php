<!DOCTYPE html>
<html>
<head>
    <style>
        /* Define CSS styles for the chessboard */
        table {
            border-collapse: collapse;
            margin-left:250px;
            border:2px solid black;
        }
        
        td {
            width: 50px;
            height: 50px;
            text-align: center;
        }

        /* Define alternate cell colors for the chessboard */
        .white {
            background-color: #ffffff;
        }

        .black {
            background-color: #000000;
        }
    </style>
</head>
<body>
    <table>
        <?php
        // Loop to generate the chessboard pattern
        for ($row = 1; $row <= 8; $row++) {
            echo '<tr>';
            for ($col = 1; $col <= 8; $col++) {
                // Use CSS classes to style alternate cells
                $class = ($row + $col) % 2 == 0 ? 'white' : 'black';
                echo '<td class="' . $class . '"></td>';
            }
            echo '</tr>';
        }
        ?>
    </table>
</body>
</html>

/*alternate code*/
<!DOCTYPE html>
<html>
<head>
    <style>
       
        table {
            border-collapse: collapse;
            margin-left: 250px;
            border: 2px solid black;
        }
        td {
            width: 50px;
            height: 50px;
            text-align: center;
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
    <table>
        <tr>
            <td class="black"></td>
            <td class="white"></td>
            <td class="black"></td>
            <td class="white"></td>
            <td class="black"></td>
            <td class="white"></td>
            <td class="black"></td>
            <td class="white"></td>
        </tr>
        <tr>
            <td class="white"></td>
            <td class="black"></td>
            <td class="white"></td>
            <td class="black"></td>
            <td class="white"></td>
            <td class="black"></td>
            <td class="white"></td>
            <td class="black"></td>
        </tr>
        <tr>
            <td class="black"></td>
            <td class="white"></td>
            <td class="black"></td>
            <td class="white"></td>
            <td class="black"></td>
            <td class="white"></td>
            <td class="black"></td>
            <td class="white"></td>
        </tr>
        <tr>
            <td class="white"></td>
            <td class="black"></td>
            <td class="white"></td>
            <td class="black"></td>
            <td class="white"></td>
            <td class="black"></td>
            <td class="white"></td>
            <td class="black"></td>
        </tr>
        <tr>
            <td class="black"></td>
            <td class="white"></td>
            <td class="black"></td>
            <td class="white"></td>
            <td class="black"></td>
            <td class="white"></td>
            <td class="black"></td>
            <td class="white"></td>
        </tr>
        <tr>
            <td class="white"></td>
            <td class="black"></td>
            <td class "white"></td>
            <td class="black"></td>
            <td class="white"></td>
            <td class="black"></td>
            <td class="white"></td>
            <td class="black"></td>
        </tr>
        <tr>
            <td class="black"></td>
            <td class="white"></td>
            <td class="black"></td>
            <td class="white"></td>
            <td class="black"></td>
            <td class="white"></td>
            <td class="black"></td>
            <td class="white"></td>
        </tr>
        <tr>
            <td class="white"></td>
            <td class="black"></td>
            <td class="white"></td>
            <td class="black"></td>
            <td class="white"></td>
            <td class="black"></td>
            <td class="white"></td>
            <td class="black"></td>
        </tr>
    </table>
</body>
</html>
