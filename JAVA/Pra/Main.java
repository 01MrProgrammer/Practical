import java.util.Scanner;

abstract class staff{
    protected int id;
    protected String name;
    
    public staff(int id, String name)
    {
        this.id=id;
        this.name=name;
    }
    abstract void displayDetails();
}