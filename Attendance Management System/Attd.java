import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Attd extends JFrame {
    private JPanel panel;
    private JTextField textField1;
    private JButton button1;

    public Attd(){
        setContentPane(panel);
        setSize(400,40);
        setVisible(true);
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("button click");
            }
        });
    }

    public static void main(String[] args) {
        new Attd();
    }
}
