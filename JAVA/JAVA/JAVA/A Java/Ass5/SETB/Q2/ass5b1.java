import java.awt.*; 
import javax.swing.*; 
import java.awt.event.*; 
class ass5b1 extends JFrame implements ActionListener{ 
static int n; 
Panel p1,p2; 
JLabel l1,l2; 
JPasswordField p; 
JTextField t; 
Button b1,b2; 
ass5b1() 
{ 
p1=new Panel(); 
l1=new JLabel("User name"); 
l2=new JLabel("Password"); 
t=new JTextField(20); 
p=new JPasswordField(10); 
b1=new Button("Submit"); 
b2=new Button("Clear"); 
p1.setLayout(new GridLayout(2,1)); 
p1.add(l1); 
p1.add(t); 
p1.add(l2); 
p1.add(p); 
p2=new Panel(); 
p2.setLayout(new GridLayout(2,1)); 
p2.add(b1); 
p2.add(b2); 
b1.addActionListener(this); 
b2.addActionListener(this); 
setLayout(new GridLayout(2,1)); 
add(p1); 
add(p2); 
setSize(500,500); 
setVisible(true); 
} 
public void actionPerformed(ActionEvent e) 
{ 
if(e.getSource()==b1) 
{ 
String s1=t.getText(); 
char c[]=new char[50]; 
c=p.getPassword(); 
String s2=new String(c); 
if(s1.equals("Hemu@2003") && s2.equals("Pass@123")) 
{ 
JOptionPane.showMessageDialog(null,"Login Succesfull"); 
n=0; 
} 
else 
{ 
JOptionPane.showMessageDialog(null,"Login Failed");
t.setText(""); 
p.setText(""); 
n++; 
if(n==3) 
System.exit(0); 
} 
} 
else if(e.getSource()==b2) 
{ 
t.setText(""); 
p.setText(""); 
} 
} 
public static void main(String[] args) 
{ 
new ass5b1(); 
} 
}
