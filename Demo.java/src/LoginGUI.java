import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class LoginGUI extends JFrame implements ActionListener {

    JLabel titleLabel, userLabel, passLabel, iconLabel;
    JTextField userTextField;
    JPasswordField passTextField;
    JButton loginButton;
    Connection conn;

    public LoginGUI() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/newdatabase", "root", "absandass44@");
        } catch (Exception ex) {
            System.out.println("Exception caught: " + ex);
        }

        titleLabel = new JLabel("Login Form");
        titleLabel.setBounds(90, 20, 250, 40);
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 32));
        titleLabel.setForeground(new Color(63, 81, 181));

        iconLabel = new JLabel(new ImageIcon("logo.png"));
        iconLabel.setBounds(320, 20, 70, 70);

        userLabel = new JLabel("Username:");
        userLabel.setBounds(50, 100, 100, 30);
        userLabel.setFont(new Font("Segoe UI", Font.BOLD, 16));
        userLabel.setForeground(new Color(63, 81, 181));

        passLabel = new JLabel("Password:");
        passLabel.setBounds(50, 150, 100, 30);
        passLabel.setFont(new Font("Segoe UI", Font.BOLD, 16));
        passLabel.setForeground(new Color(63, 81, 181));

        userTextField = new JTextField();
        userTextField.setBounds(160, 100, 200, 30);
        userTextField.setFont(new Font("Segoe UI", Font.PLAIN, 16));

        passTextField = new JPasswordField();
        passTextField.setBounds(160, 150, 200, 30);
        passTextField.setFont(new Font("Segoe UI", Font.PLAIN, 16));

        loginButton = new JButton("Login");
        loginButton.setBounds(180, 220, 100, 40);
        loginButton.setFont(new Font("Segoe UI", Font.BOLD, 16));
        loginButton.setForeground(Color.WHITE);
        loginButton.setBackground(new Color(63, 81, 181));
        loginButton.addActionListener(this);

        add(titleLabel);
        add(iconLabel);
        add(userLabel);
        add(userTextField);
        add(passLabel);
        add(passTextField);
        add(loginButton);

        getContentPane().setBackground(Color.WHITE);

        setSize(450, 320);
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent ae) {
        try {
            String query = "SELECT * FROM users WHERE username=? AND password=?";
            PreparedStatement pst = conn.prepareStatement(query);
            pst.setString(1, userTextField.getText());
            pst.setString(2, new String(passTextField.getPassword()));
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");
                JOptionPane.showMessageDialog(null, "Welcome " + firstName + " " + lastName);
            } else {
                JOptionPane.showMessageDialog(null, "Sorry, you are not registered");
            }
        } catch (Exception ex) {
            System.out.println("Exception caught: " + ex);
        }
    }

    public static void main(String[] args) {
        new LoginGUI();
    }
}

