<html>
<body>
<form method="post">
<pre>
Enter 1st string<input type="text" name="str1" ><br>
Enter 2nd string<input type="text" name="str2" ><br>
<input type="radio" name="ch" value="1">Occurence<br>
<input type="radio" name="ch" value="2">Position<br>
<input type="radio" name="ch" value="3">Compare<br>
<input type="submit" name="btnshow" value="ok"><br>
<input type="reset" value="cancel"><br>
</pre>
</form>
</body>

<?php
	if(isset($_POST["btnshow"]))
	{
		$str1=$_POST['str1'];
		$str2=$_POST['str2'];
		$ch=$_POST['ch'];
		echo"First string is:$str1<br>";
		echo"Second string is:$str2<br>";
		switch($ch)
		{
			case 1:if(strcmp($str2,substr($str1,0,strlen($str2)))==0)
				{
					echo"yes 2nd string appears at the start of 1st string.";
				}
				else
				{
					echo"No ,string doesn't appears at the start of 1st string";
				}
				break;
			case 2:$z=0;
			       $flag=0;
			       while($z<=strlen($str1))
			       {
			       		if(strcmp($str2,substr($str1,$z,strlen($str2)))==0)
			       		{
			       			$flag=1;
			       			$pos=$z+1;
			       			$z++;
			       		}
			       		else
			       		{
			       			$z++;
			       		}
			       	}
			       	if($flag==1)
			       	{
			       		echo"string found at $pos";
			       	}
			       	else
			       	{
			       		echo"string not found";
			       	}
			       	break;
			case 3:if(strnatcasecmp($str1,$str2)==0)
				{
					echo"Strings are equal";
				}
				else
				{
					echo"strings are not same";
				}
				break;
			}
		}
	?>
	
</html>
		
