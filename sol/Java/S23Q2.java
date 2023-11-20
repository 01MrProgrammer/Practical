import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

public class S23Q2 extends JFrame {
    private JTextField amountField, resultField;
    private JComboBox<String> fromCurrencyComboBox, toCurrencyComboBox;
    private JButton convertButton;

    public S23Q2() {
        setTitle("Currency Converter");
        setLayout(new FlowLayout());

        JLabel amountLabel = new JLabel("Enter Amount:");
        amountField = new JTextField(10);

        JLabel fromCurrencyLabel = new JLabel("From Currency:");
        fromCurrencyComboBox = new JComboBox<>(new String[]{"SGD", "USD", "Euro"});

        JLabel toCurrencyLabel = new JLabel("To Currency:");
        toCurrencyComboBox = new JComboBox<>(new String[]{"SGD", "USD", "Euro"});

        convertButton = new JButton("Convert");
        resultField = new JTextField(15);
        resultField.setEditable(false);

        convertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                convertCurrency();
            }
        });

        add(amountLabel);
        add(amountField);
        add(fromCurrencyLabel);
        add(fromCurrencyComboBox);
        add(toCurrencyLabel);
        add(toCurrencyComboBox);
        add(convertButton);
        add(resultField);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void convertCurrency() {
        try {
            double amount = Double.parseDouble(amountField.getText());
            String fromCurrency = (String) fromCurrencyComboBox.getSelectedItem();
            String toCurrency = (String) toCurrencyComboBox.getSelectedItem();

            double convertedAmount = convert(amount, fromCurrency, toCurrency);

            DecimalFormat df = new DecimalFormat("0.00");
            resultField.setText(df.format(convertedAmount));
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Invalid amount", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private double convert(double amount, String fromCurrency, String toCurrency) {
        double conversionRate = 0.0;

        if (fromCurrency.equals("SGD") && toCurrency.equals("USD")) {
            conversionRate = 1.41;
        } else if (fromCurrency.equals("USD") && toCurrency.equals("SGD")) {
            conversionRate = 1.0 / 1.41;
        } else if (fromCurrency.equals("USD") && toCurrency.equals("Euro")) {
            conversionRate = 0.92;
        } else if (fromCurrency.equals("Euro") && toCurrency.equals("USD")) {
            conversionRate = 1.0 / 0.92;
        } else if (fromCurrency.equals("SGD") && toCurrency.equals("Euro")) {
            conversionRate = 0.65;
        } else if (fromCurrency.equals("Euro") && toCurrency.equals("SGD")) {
            conversionRate = 1.0 / 0.65;
        }

        return amount * conversionRate;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new S23Q2());
    }
}
