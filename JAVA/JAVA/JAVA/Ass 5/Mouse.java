
import javax.swing.*; 
import java.awt.*; 
import java.awt.event.*; 
class Mouse extends JFrame{ 
JPanel p1; 
JTextField t; 
Mouse(){ 
p1=new JPanel(); 
t=new JTextField(20); 
p1.add(t,BorderLayout.CENTER); 
addMouseListener(new MouseAdapter() 
{ 
public void mouseClicked(MouseEvent e) 
{ 
t.setText("Clicked at: ("+e.getX()+","+e.getY()+")"); 
repaint(); 
} 
}); 
addWindowListener(new WindowAdapter() 
{ 
public void windowClosing(WindowEvent e) 
{ 
System.exit(0); 
} 
}); 
addMouseMotionListener(new MouseAdapter() 
{ 
public void mouseMoved(MouseEvent me) 
{ 
int x=me.getX(); 
int y=me.getY(); 
t.setText("X= "+x+" Y="+y); 
} 
}); 
add(p1); 
setSize(500,500); 
setVisible(true); 
} 
public static void main(String[] args) 
{ 
new Mouse(); 
} 
} 


