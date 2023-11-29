

class continent
{
String name;
continent(String name)
{
	this.name=name;
}


void display()
{
	System.out.println("continent="+name);
}
}
class country extends continent
{
	String name;
	country(String coname,String cuname)
	{
	 super(coname);
 	 name=cuname;
	}

	void display()
	{
	  super.display();
	  System.out.println("country="+name);
	}
}


class state extends country
{
	String name;
	state(String coname,String cuname,String stname)

	{
	 super(coname,cuname);
	 name=stname;
	}
	void display()
	{
		  super.display();
		  System.out.println("state="+name);
	}
}


class place extends state
{
	String name;
	place(String coname,String cuname,String stname,String planame)
	{
 		super(coname,cuname,stname);
 		name=planame;
	}
	void display()
	{
	  super.display();
	  System.out.println("place="+name);
	}
}


class setAa
{
	public static void main(String args[])
	{
	 place p=new place("Asia","India","Maharashtra","Pune");
	 p.display();
	}
}















