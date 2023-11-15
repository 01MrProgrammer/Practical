<html>
<head>
	<title></title>
</head>
<body>
<form method="post">
Enter 1st number<input type="text" name="txtno1" ><br>
Enter 2nd number<input type="text" name="txtno2" ><br>
<input type="radio" name="rbchoice" value="1">Mod<br>
<input type="radio" name="rbchoice" value="2">Power<br>
<input type="radio" name="rbchoice" value="3">Sum<br>
<input type="radio" name="rbchoice" value="4">Factorial<br>
<input type="submit" name="btnshow" value="show"><br>
</form>
</body>
</html>
<?php
	if(isset($_POST["btnshow"]))
	{
		extract($_POST);
?>
<br/>
Ans:-
<?php
	switch($rbchoice)
	{
		case 1:echo $txtno1 % $txtno2;
			break;
		case 2:echo pow($txtno1,$txtno2);
			break;
		case 3:$ans=0;
			$ans=$txtno1+$txtno2;
			echo $ans;
			break;
		case 4:	$ans=1;
			for($i=1;$i<=$txtno2;$i++)
			{
				$ans*=$i;
			}
			echo $ans;
			break;
	}
	}
?>
		
