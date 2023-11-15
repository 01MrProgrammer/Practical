<html>

<body>

<form method="post">


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









