import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Mevent
{
    public static void main(String[] args) 
    {
        new MyFrame("Mouse Events");
    }
}

class MyFrame extends JFrame
{
    TextField click_text_field, mouse_move_field;
    Label click_text_label, mouse_move_label;
    int x,y;
    Panel panel;
    MyFrame(String title)
    {
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        panel =new Panel();
        panel.setLayout(new GridLayout(2,2,5,5));
        click_text_label = new Label("Co-ordinates of clicking");
        mouse_move_label = new Label("Co-ordinates of movement");
        click_text_field=new TextField(20);
        mouse_move_field =new TextField(20);
        panel.add(click_text_label);
        panel.add(click_text_field);
        panel.add(mouse_move_label);
        panel.add(mouse_move_field);
        add(panel);
        addMouseListener(new MyClick());
        addMouseMotionListener(new MyMove());
        setSize(500,500);
        setVisible(true);
    }
    class MyClick extends MouseAdapter 
    {
        public void mouseClicked(MouseEvent me)
        {
            x=me.getX();
            y=me.getY();
            click_text_field.setText("X="+x+" Y="+y);
        }
    }
    class MyMove extends MouseMotionAdapter
    {
        public void mouseMoved(MouseEvent me)
        {
            x=me.getX();
            y=me.getY();
            mouse_move_field.setText("X="+ x +" Y="+y);
        }
    }
}