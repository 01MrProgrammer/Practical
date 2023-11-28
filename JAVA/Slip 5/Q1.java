import java.util.*;


class continent
{
   String continent_name;
   
   void get()
   {
   Scanner sc= new Scanner(System.in);
   
   System.out.println("Enter continent name: ");
   continent_name=sc.nextLine();
   }
   
   void display()
   {
      System.out.println("\nContinent Name:" + continent_name);
   }
}


class country extends continent
{
  String country_name;
  
  void get()
  {
      super.get();
      Scanner sc=new Scanner(System.in);
      
      System.out.println("Enter country name: ");
      country_name =sc.nextLine();
  }
  
  void display()
  {
   super.display();
   System.out.println("Country Name: " + country_name);
  }
}


class state extends country
{
  String state_name;
  
  void get()
  {
     super.get();
     Scanner sc= new Scanner(System.in);
     
     System.out.println("Enter state name: ");
     state_name=sc.nextLine();
  }
   
  void display()
  {
     super.display();
     System.out.println("State Name: " + state_name);
  }
}
 
class place extends state
{
  String place_name;
  
  void get()
  {
     super.get();
     Scanner sc= new Scanner(System.in);
     
     System.out.println("Enter place name: ");
     place_name=sc.nextLine();
  }
   
  void display()
  {
     super.display();
     System.out.println("Place Name: " + place_name);
  }
} 

public class Q1
{
 public static void main(String args[])
 {
   place st= new place();
   st.get();
   st.display();
 }
}
     
    
       
   
   
