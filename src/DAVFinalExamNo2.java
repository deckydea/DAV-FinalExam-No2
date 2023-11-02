import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class DAVFinalExamNo2 extends JFrame {
    private final JTextField usernameTextField;
    private final JPasswordField passwordField;
    private final JPasswordField confirmPasswordField;
    private final JRadioButton maleRadioButton;
    private final JRadioButton femaleRadioButton;
    private final ButtonGroup genderButtonGroup;
    private final JComboBox<String> memberLevelComboBox;

    public DAVFinalExamNo2() {
        setTitle("Form Registrasi");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel(new BorderLayout());
        
        //Title
        JLabel titleLabel = new JLabel("Form Registrasi");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        mainPanel.add(titleLabel, BorderLayout.NORTH);

        JPanel inputPanel = new JPanel(new GridLayout(6, 2, 10, 10));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JLabel usernameLabel = new JLabel("Username");
        usernameTextField = new JTextField(20);

        JLabel passwordLabel = new JLabel("Password");
        passwordField = new JPasswordField(20);

        JLabel confirmPasswordLabel = new JLabel("Password Confirmation");
        confirmPasswordField = new JPasswordField(20);

        JLabel genderLabel = new JLabel("Gender");
        maleRadioButton = new JRadioButton("Male");
        femaleRadioButton = new JRadioButton("Female");
        genderButtonGroup = new ButtonGroup();
        genderButtonGroup.add(maleRadioButton);
        genderButtonGroup.add(femaleRadioButton);
        JPanel genderPanel = new JPanel(new FlowLayout());
        genderPanel.add(maleRadioButton);
        genderPanel.add(femaleRadioButton);

        JLabel memberLevelLabel = new JLabel("Member Level");
        String[] memberLevels = {"Basic", "Gold", "Platinum"};
        memberLevelComboBox = new JComboBox<>(memberLevels);

        inputPanel.add(usernameLabel);
        inputPanel.add(usernameTextField);
        inputPanel.add(passwordLabel);
        inputPanel.add(passwordField);
        inputPanel.add(confirmPasswordLabel);
        inputPanel.add(confirmPasswordField);
        inputPanel.add(genderLabel);
        inputPanel.add(genderPanel);
        inputPanel.add(memberLevelLabel);
        inputPanel.add(memberLevelComboBox);

        JPanel buttonPanel = new JPanel(new FlowLayout());
        JButton submitButton = new JButton("Submit");
        JButton cancelButton = new JButton("Cancel");

        submitButton.addActionListener((ActionEvent e) -> {
            if (validateFields()) {
                JOptionPane.showMessageDialog(DAVFinalExamNo2.this, "Registrasi berhasil!");
            }
        });
        buttonPanel.add(submitButton);
        
        
        cancelButton.addActionListener((ActionEvent e) -> {
            System.exit(0); // Keluar dari aplikasi
        });
        buttonPanel.add(cancelButton);

        mainPanel.add(inputPanel, BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        add(mainPanel);
    }

    private boolean validateFields() {
        String username = usernameTextField.getText();
        String password = new String(passwordField.getPassword());
        String confirmPassword = new String(confirmPasswordField.getPassword());

        if (username.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Semua field harus diisi.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if (!password.equals(confirmPassword)) {
            JOptionPane.showMessageDialog(this, "Password dan konfirmasi password tidak cocok.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            DAVFinalExamNo2 registrationForm = new DAVFinalExamNo2();
            registrationForm.setVisible(true);
        });
    }
}
