import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Enumeration;

public class A5_SBQ1 {

    private JFrame frame;
    private JTextField nameField;
    private JTextArea resultArea;
    private ButtonGroup classGroup;
    private JCheckBox musicBox, sportsBox, travelBox;
    private JRadioButton boldButton, italicButton, underlineButton;
    private JComboBox<Integer> fontSizeBox;

    public A5_SBQ1() {
        frame = new JFrame("User Info");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 10, 10);

        // Your Name Label and TextField
        addComponent(new JLabel("Your Name:"), 0, 0);
        nameField = new JTextField(15);
        addComponent(nameField, 1, 0, 3, 1);

        // Your Class
        addComponent(new JLabel("Your Class:"), 0, 1);
        classGroup = new ButtonGroup();
        JRadioButton fyButton = new JRadioButton("FY");
        JRadioButton syButton = new JRadioButton("SY");
        JRadioButton tyButton = new JRadioButton("TY");
        classGroup.add(fyButton);
        classGroup.add(syButton);
        classGroup.add(tyButton);
        addComponent(fyButton, 1, 1);
        addComponent(syButton, 2, 1);
        addComponent(tyButton, 3, 1);

        // Hobbies
        addComponent(new JLabel("Your Hobbies:"), 0, 2);
        musicBox = new JCheckBox("Music");
        sportsBox = new JCheckBox("Sports");
        travelBox = new JCheckBox("Travelling");
        addComponent(musicBox, 1, 2);
        addComponent(sportsBox, 2, 2);
        addComponent(travelBox, 3, 2);

        // Font Style
        addComponent(new JLabel("Font Style:"), 0, 3);
        boldButton = new JRadioButton("Bold");
        italicButton = new JRadioButton("Italic");
        underlineButton = new JRadioButton("Underline");
        ButtonGroup styleGroup = new ButtonGroup();
        styleGroup.add(boldButton);
        styleGroup.add(italicButton);
        styleGroup.add(underlineButton);
        addComponent(boldButton, 1, 3);
        addComponent(italicButton, 2, 3);
        addComponent(underlineButton, 3, 3);

        // Font Size
        addComponent(new JLabel("Size:"), 0, 4);
        Integer[] sizes = {8, 10, 12, 14, 16, 18, 20};
        fontSizeBox = new JComboBox<>(sizes);
        addComponent(fontSizeBox, 1, 4, 3, 1);

        // Button to Apply Changes
        JButton applyButton = new JButton("Apply Changes");
        applyButton.addActionListener(this::applyChanges);
        addComponent(applyButton, 0, 5, 4, 1);

        // Text Area for Result
        resultArea = new JTextArea(5, 20);
        resultArea.setEditable(false);
        addComponent(resultArea, 0, 6, 4, 1);

        frame.pack();
        frame.setVisible(true);
    }

    private void applyChanges(ActionEvent e) {
        String name = nameField.getText();
        String userClass = null;
        for (Enumeration<AbstractButton> buttons = classGroup.getElements(); buttons.hasMoreElements();) {
            AbstractButton button = buttons.nextElement();
            if (button.isSelected()) {
                userClass = button.getText();
            }
        }
        StringBuilder hobbies = new StringBuilder();
        if (musicBox.isSelected()) hobbies.append("Music ");
        if (sportsBox.isSelected()) hobbies.append("Sports ");
        if (travelBox.isSelected()) hobbies.append("Travelling ");

        resultArea.setText(String.format("Name: %s\nClass: %s\nHobbies: %s", name, userClass, hobbies.toString().trim()));
    }

    private void addComponent(Component component, int x, int y) {
        addComponent(component, x, y, 1, 1);
    }

    private void addComponent(Component component, int x, int y, int width, int height) {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = x;
        gbc.gridy = y;
        gbc.gridwidth = width;
        gbc.gridheight = height;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 10, 10);
        frame.add(component, gbc);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(A5_SBQ1::new);
        
    }
}

