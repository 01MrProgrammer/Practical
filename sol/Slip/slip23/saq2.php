<html>

<body>

<form method="post">
    <input type="radio" name="rbchoice" Value='1'>Insert Element in Stack <br>

<input type="radio" name="rbchoice" value='2'> Remove Element from Stack<br>
 <input type="radio" name="rbchoice" value='3'> Display contents of Stack <br>

<input type="radio" name="rbchoice"  value='4'> Insert element in Queue<br>

 <input type="radio" name="rbchoice" value='5'> Remove element in Queue<br>

<input type="radio" name="rbchoice" value='6'> Display Content of Queue <br >
<input type="submit" name="btnshow" value="show">

<?php 
 if(isset($_POST["btnshow"]))
   {
    extract($_POST);

     $a=array("orange", "apple");
     Switch ($rbchoice)
      {   
           case 1: array_push($a, "mango");
                    print_r($a);
                    break;
           case 2: array_pop($a); 
                    print_r($a);
                    break;
         case 3 : print_r($a);
         break;

         case 4 :array_push($a, "mango");
                    print_r($a);
                    break;
         case 5 : array_shift($a);
                    print_r($a);
                        break;
         case 6 : print_r($a);
                    break;
      }
    }
    ?>
    </form>
</body>

</html>









