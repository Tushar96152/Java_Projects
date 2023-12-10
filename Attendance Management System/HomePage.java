import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class HomePage extends JFrame{
    private JPanel panel1;
    private JRadioButton logInRadioButton;
    private JRadioButton absetntRadioButton;
    private JRadioButton logOutRadioButton;
    private JButton submitButton;

    JFrame base = new JFrame();

    public HomePage()
    {
        base.setBounds(300,200,500,400);


        panel1.setBounds(0,0,900,400);
        base.add(panel1);
        panel1.setVisible(true);
        submitButton.addActionListener(new ActionListener() {

            String data;
            @Override
            public void actionPerformed(ActionEvent e) {
                if (logInRadioButton.isSelected())
                {
                    data ="present";
                    JOptionPane.showMessageDialog(HomePage.this,data);
                }
                else if(logOutRadioButton.isSelected())
                {
                    data="out";
                    JOptionPane.showMessageDialog(HomePage.this,data);
                }
            }
        });
    }

    public static void main(String[] args) {
        new HomePage();
    }

}
