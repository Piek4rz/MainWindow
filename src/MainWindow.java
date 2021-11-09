import java.util.HashMap;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class MainWindow extends JFrame{

    private final JPanel panel;
    private final HashMap<String,String> data;

    public static void main(String[] args) {
        MainWindow main = new MainWindow();
    }


    public MainWindow(){

        panel = new JPanel();
        panel.setBounds(10,10,10,10);
        panel.setLayout(null);
        panel.setBackground(new Color(213, 206, 206));


        JTextField ID = new JTextField();
        ID.setBounds(100,50,500,50);
        panel.add(ID);

        JLabel textID = new JLabel("ID:");
        textID.setBounds(20,50,50,50);
        panel.add(textID);

        JPasswordField pass = new JPasswordField();
        pass.setBounds(100,150,500,50);
        panel.add(pass);

        JLabel textPass = new JLabel("Password:");
        textPass.setBounds(20,150,100,50);
        panel.add(textPass);

        data = new HashMap<>();
        data.put("admin","admin");
        data.put("student","student");
        data.put("gosc","gosc");
        data.put("login","haslo");

        JButton loginBtn = new JButton("Login");
        loginBtn.setBounds(130, 300, 120, 35);
        panel.add(loginBtn);

        class Login implements ActionListener{
            public void actionPerformed(ActionEvent e) {
                String log = ID.getText();
                String password = String.valueOf(pass.getPassword());
                if (data.containsKey(log) && password.equals(data.get(log)))
                {
                    panel.setBackground(Color.green);
                }
                else
                {
                    panel.setBackground(Color.red);
                }
            }
        }
        loginBtn.addActionListener(new Login());

        JButton cancelBtn = new JButton("Cancel");
        cancelBtn.setBounds(400, 300, 120, 35);
        panel.add(cancelBtn);

        class Cancel implements ActionListener {
            public void actionPerformed(ActionEvent e) {
                ID.setText("");
                pass.setText("");
                panel.setBackground(new Color(213, 206, 206));
            }

        }
        cancelBtn.addActionListener(new Cancel());

        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(650, 400);
        getContentPane().add(panel);
    }
}