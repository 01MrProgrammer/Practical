import java.awt.*;
import java.awt.event.*;

public class LoginScreen extends Frame implements ActionListener {
    TextField name, pass;
    Button b1, b2;
    Label l1, l2, l3;
    int counter = 3;

    LoginScreen() {
        setLayout(new FlowLayout());

        this.l1 = new Label("Username: ");
        this.l2 = new Label("Password: ");
        this.name = new TextField(20);
        this.pass = new TextField(20);
        this.pass.setEchoChar('*');
        this.b1 = new Button("Submit");
        this.b2 = new Button("Clear");

        this.b1.addActionListener(this);
        this.b2.addActionListener(this);

        add(this.l1);
        add(this.name);
        add(this.l2);
        add(this.pass);
        add(this.b1);
        add(this.b2);

        setTitle("Login Screen");
        setSize(300, 300);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        try {
            if (ae.getSource() == this.b1) {
                String username = this.name.getText();
                String password = this.pass.getText();

                if (username.equals(password)) {
                    setVisible(false);
                    new Welcome();
                } else {
                    throw new Exception("Incorrect login. " + (--this.counter) + " attempts remaining.");
                }
            } else if (ae.getSource() == this.b2) {
                this.name.setText("");
                this.pass.setText("");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            if (this.counter == 0) {
                System.exit(0);
            }
        }
    }

    public static void main(String[] args) {
        new LoginScreen();
    }
}

class Welcome extends Frame {
    Welcome() {
        setTitle("Welcome");
        setSize(300, 300);
        setVisible(true);
    }
}
