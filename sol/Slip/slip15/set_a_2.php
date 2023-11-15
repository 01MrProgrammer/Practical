<html>
<body>
<form method="post">
<pre>
Enter string<input type="text" name="str1" ><br>
<input type="radio" name="ch" value="1">Length<br>
<input type="radio" name="ch" value="2">count vowels<br>
<input type="radio" name="ch" value="3">convert lowercase and title case<br>
<input type="radio" name="ch" value="4">padding the string by *<br>
<input type="radio" name="ch" value="5">Remove the leading white spaces<br>
<input type="radio" name="ch" value="6">reverse string<br>

<input type="submit" name="btnshow" value="ok"><br>
<input type="reset" value="cancel"><br>
</pre>
</form>
</body>

<?php
	if(isset($_POST["btnshow"]))
	{
		$str1=$_POST['str1'];
		$ch=$_POST['ch'];
		echo"String is:$str1<br>";
		switch($ch)
		{
			case 1:
				$len=0;
				for($i=0;isset($str1[$i]);$i++)
				{
					$len++;
				}
				echo $len;
				break;
			case 2:$len=strlen($str1);
				$v=0;
				for($i=0;$i<$len;$i++)
				if($str1[$i]=='a' || $str1[$i]=='e'|| $str1[$i]=='i'||$str1[$i]=='o'||$str1[$i]=='u')
				{
					$v++;
				}
				echo $v;
				break;
			case 3:$str=strtolower($str1);
				echo "Lower case:".$str."<br>";
				echo"title case:".ucwords($str);
				break;
			case 4:echo str_pad($str1,30,"*",STR_PAD_BOTH);
				break;
			case 5:echo " String after removing whitespaces: ".str_replace(" ","",$str1);
				break;
			case 6:echo"Reversed string is".strrev($str1);
				break;
		}
	}
?>
</html>
		

