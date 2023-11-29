		
public interface Department{
		public void getDetpName();
		public void getDetpHead();
	}
	
	class Hostel{
		protected String hname,hlocation;
		int noofroom;
		void getHostelName()
		{
			System.out.println("Name Of the Hostel : " + hname);
		}
		void getHostelLocation()
		{
			System.out.println("Hostel Location : " + hlocation);
		}
		void getNoOfRoom()
		{
			System.out.println("Total Room : " + noofroom);
		}
	}
	
      
	class Student extends Hostel implements Department
	{
		String sname,regno,elesub;
		String deptName,deptHead;
		int avgMarks;
		void getStudentName()
		{
			System.out.println("Student : " + sname);
		}
		String getStudentRegNo()
		{
			return regno;
		}
		void getElectiveSubject()
		{
			System.out.println("Elective Subject : " + elesub);
		}
		void getAvgMarks()
		{
			System.out.println("Average Marks : " + avgMarks);
		}
		public void getDetpName()
		{
			System.out.println("Department Name : " + deptName);
		}
		public void getDetpHead()
		{
			System.out.println("Department Head : " + deptHead);
		}
		void addStudent(){
			Scanner sc=new Scanner(System.in);
			System.out.print("Enter Student name : ");
			sname=sc.nextLine();
			System.out.print("Enter Registration Number : ");
			regno=sc.nextLine();
			System.out.print("Enter Elective Subject : ");
			elesub=sc.nextLine();
			System.out.print("Enter Hostel Name : ");
			hname=sc.nextLine();
			System.out.print("Enter Hostel Location : ");
			hlocation=sc.nextLine();
			System.out.print("Enter Department Name : ");
			deptName=sc.nextLine();
			System.out.print("Enter Department Head : ");
			deptHead=sc.nextLine();
			System.out.print("Enter No of room : ");
			noofroom=sc.nextInt();
			System.out.print("Enter Avg Marks : ");
			avgMarks=sc.nextInt();
		}
		void migrate()
		{
			Scanner sc=new Scanner(System.in);
			System.out.print("Enter new Department Name : ");
			deptName=sc.nextLine();
			System.out.print("Enter new Department Head : ");
			deptHead=sc.nextLine();
		}
		void display()
		{
			getStudentName();
			System.out.println(" Student Registration No is : " + getStudentRegNo());
			getElectiveSubject();
			getAvgMarks();
			getDetpName();
			getDetpHead();
		}
	}
	
	import java.util.*;
	class StudentMaster
	{
		public static void main(String []args){
			Scanner sc=new Scanner(System.in);
			Student []st=new Student[100];
			int sno=0;
			String rno;
			int ch;
			boolean b;
			while(true)
			{
				System.out.println("\n 1. Admit a student");
				System.out.println(" 2. Migrate a student");
				System.out.println(" 3. Display");
				System.out.println(" 4. Exit");
				System.out.println(" 5. Enter Your Choice");
				ch=sc.nextInt();
				switch(ch)
				{
					case 1:
						st[sno]=new Student();
						st[sno++].addStudent();
						break;
					case 2:
						System.out.println("Enter Registration no : ");
						rno=sc.next();
						b=false;
						for(int i=0;i<sno;i++)
						{
							if(st[i].getStudentRegNo().equals(rno))
							{
								b=true;
								st[0].migrate();
								break;
							}
						}
						if(b==false)
						{
							System.out.println("Student Not Found");
						}
						break;
					case 3:
						System.out.println("Enter Registration no : ");
						rno=sc.next();
						b=false;
						for(int i=0;i<sno;i++){
							if(st[i].getStudentRegNo().equals(rno)){
							b=true;
							st[0].display();
							break;
							}
						}
						if(b==false){
							System.out.println("Student Not Found");
						}
						break;
					case 4:
						System.exit(0);
					default:
						System.out.println("--Invalid Entry--");
				}
			}
		}
	}
