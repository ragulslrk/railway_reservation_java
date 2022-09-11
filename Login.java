import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;


public class Login  extends JFrame{

    private static final long serialVersionUID = 1L;
    private JTextField textField;
    private JPasswordField passwordField;
    private JButton btnNewButton;
    private JLabel label;
    private JPanel contentPane;

    public static void main(String[] args) throws Exception  {
        Login lg= new Login();
        lg.setVisible(true);
        

    
}
public Login(){
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setBounds(450, 190, 1014, 597);
    setResizable(false);
    setSize(800,700);
    contentPane = new JPanel();
    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
    setContentPane(contentPane);
    contentPane.setLayout(null);

    JLabel lblNewLabel = new JLabel("Login");
    lblNewLabel.setForeground(Color.BLACK);
    lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 46));
    lblNewLabel.setBounds(323, 13, 273, 93);
    contentPane.add(lblNewLabel);

    textField = new JTextField();
    textField.setFont(new Font("Tahoma", Font.PLAIN, 32));
    textField.setBounds(320, 170, 281, 58);
    contentPane.add(textField);
    textField.setColumns(10);

    passwordField = new JPasswordField();
    passwordField.setFont(new Font("Tahoma", Font.PLAIN, 32));
    passwordField.setBounds(320, 286, 281, 58);
    contentPane.add(passwordField);

    JLabel lblUsername = new JLabel("Username");
    lblUsername.setBackground(Color.BLACK);
    lblUsername.setForeground(Color.BLACK);
    lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 31));
    lblUsername.setBounds(150, 166, 193, 52);
    contentPane.add(lblUsername);

    JLabel lblPassword = new JLabel("Password");
    lblPassword.setForeground(Color.BLACK);
    lblPassword.setBackground(Color.CYAN);
    lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 31));
    lblPassword.setBounds(150, 286, 193, 52);
    contentPane.add(lblPassword);

    btnNewButton = new JButton("Login");
    btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 26));
    btnNewButton.setBounds(320, 370, 273, 93);
    contentPane.add(btnNewButton);  
    btnNewButton.addActionListener(new ActionListener() {

        public void actionPerformed(ActionEvent e) {
            String userName = textField.getText();
            String password =new String( passwordField.getPassword());
            try {
                String url = "jdbc:mysql://localhost:3306/railway";
                String uname = "root";
                String pass = "Ragul5656";
                String query = "select EmpName, EmpId from employee";

             Connection con = DriverManager.getConnection(url, uname, pass);
                Statement st = con.createStatement();
                st.executeUpdate("Select * from user where username="+userName+" and password="+password);
                ResultSet rs = st.executeQuery(query);
                System.out.println(rs);
            } catch (SQLException sqlException) {
                sqlException.printStackTrace();
            }
        }
    });

}

}

