<html>
<head>
    <title>String Operations</title>
</head>
<body>
    <form method="post" action="">
        <label for="sentence">Enter a sentence:</label>
        <input type="text" name="sentence" id="sentence" required><br><br>

        <label for="word">Enter a word:</label>
        <input type="text" name="word" id="word" required><br><br>

        <label for="position">Enter position:</label>
        <input type="number" name="position" id="position" required><br><br>

        <label for="remove_chars">Number of characters to remove:</label>
        <input type="number" name="remove_chars" id="remove_chars" required><br><br>

        <input type="submit" name="btnSubmit" value="Submit">
    </form>

    <?php
    if (isset($_POST["btnSubmit"])) {
        $sentence = $_POST['sentence'];
        $word = $_POST['word'];
        $position = $_POST['position'];
        $remove_chars = $_POST['remove_chars'];
        $new_sentence_a = substr_replace($sentence, '', $position, $remove_chars);
        $new_sentence_b = substr_replace($sentence, $word, $position, 0);
        $new_sentence_c = str_replace('some characters', $word, $sentence);
        $new_sentence_d = substr_replace($sentence, $word, $position);

        echo "<h3>Original Sentence:</h3><p>$sentence</p>";
        echo "<h3>Modified Sentences:</h3>";
        echo "<p>After deleting: $new_sentence_a</p>";
        echo "<p>After inserting: $new_sentence_b</p>";
        echo "<p>After replacing: $new_sentence_c</p>";
        echo "<p>After replacing all: $new_sentence_d</p>";
    }
    ?>
</body>
</html>