import java.util.Scanner;
class continent
{
	String cont_name;
	continent()
	{}
 	void accept()
	{
	  System.out.println("Enter the Name of Continent: ");
		Scanner sc=new Scanner(System.in);
		cont_name=sc.nextLine();
	
	}
	void display()
	{
		System.out.println("the Continent is:"+cont_name);
		

	}
	
}

class country extends continent
{
	String country_name;
		void accept()
		{Scanner sc=new Scanner(System.in);
		super.accept();
		System.out.println("Enter the country name: ");	
		country_name=sc.nextLine();
		}
           void display()
		{    
		  super.display();
		  System.out.println("the country name:"+country_name);
         	}

}


class state extends country
{
	String state_name;
	void accept()
		{
			super.accept();
			System.out.println("Enter the State name: ");
			Scanner sc=new Scanner(System.in);
			state_name=sc.nextLine();

		}
            	void display()
		{     
		 	super.display();
			System.out.println("the state name:"+state_name);
         	 }
			
		
}


class seta_1
{
 public static void main(String args[])
   	{
		state s=new state();
		s.accept();
       	  	s.display();
	}
}
