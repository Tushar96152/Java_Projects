import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class LogInPage extends JFrame {
    int id;

    JTextField emailLogin;
    JTextField passwordLogin;
    JLabel emailLogin1,passwordLogin1;
    JFrame base = new JFrame("ATTENDANCE MANAGEMENT SYSTEM");
    JPanel panel1 = new JPanel();
    JPanel panel2 = new JPanel();


    JTextField name,address,gmail,phonNum,userId,rollNum,branch,password;
    JLabel name1,gmail1,address1,phonNum1,userId1,brach1,rollNum1,password1;

    public void logInPage(){

        /********************* ICON ***************************/

        base.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("logo.png")));





        base.setBounds(300,200,900,400);



        panel1.setBounds(300,200,900,400);

        ImageIcon icon = new ImageIcon(getClass().getResource("loginlogoutpage.jpg"));
        JLabel   img    = new JLabel(icon);
        /************************ Email box for login page******************************/

        emailLogin1 = new JLabel("Email");
        emailLogin1.setBounds(480,150,120,30);
        emailLogin1.setFont(new Font("Serif", Font.PLAIN, 21));
        emailLogin1.setForeground(Color.WHITE);
        img.add(emailLogin1);
        emailLogin = new JTextField();
        emailLogin.setBounds(610,150,200,30);
        emailLogin.setFont(new Font("Serif", Font.PLAIN, 21));
        emailLogin.setForeground(Color.WHITE);
        emailLogin.setOpaque(false);
        img.add(emailLogin);

        /**************************password box for login page****************************/

        passwordLogin1 = new JLabel("PASSWORD");
        passwordLogin1.setBounds(480,200,120,30);
        passwordLogin1.setFont(new Font("Serif", Font.PLAIN, 21));
        passwordLogin1.setForeground(Color.WHITE);
        img.add(passwordLogin1);
        passwordLogin = new JTextField();
        passwordLogin.setBounds(610,200,200,30);
        passwordLogin.setFont(new Font("Serif", Font.PLAIN, 21));
        passwordLogin.setForeground(Color.WHITE);
        passwordLogin.setOpaque(false);
        img.add(passwordLogin);

        /**********************Login button********************************/

        JButton button = new JButton("LOGIN");
        button.setBounds(610,250,200,30);
        img.add(button);
        try {

        }
        catch (Exception a)
        {
            a.printStackTrace();
        }

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/attendence", "root", "tusharkapoor00");
                    System.out.println("connection successfull");
                    String emailInput = emailLogin.getText();
                    String passwordInput = passwordLogin.getText();

                    String emailData = "";
                    String passwordData = "";
                    String query = "select * from reg_details where gmail = '"+emailInput+"' and password = '"+passwordInput+"';";
                    System.out.println(query);

                    Statement st = con.createStatement();
                    ResultSet rs = st.executeQuery(query);
                    while (rs.next())
                    {
                        emailData = rs.getString("gmail");
                        passwordData = rs.getString("password");
                    }
                    if (emailInput.equals(emailData) && passwordInput.equals(passwordData))
                    {


                        panel1.setVisible(false);
                        attPage(emailInput,passwordInput);



                        JOptionPane.showMessageDialog(panel1,"LOGIN SUCCESSFUL");

                    }
                    else
                    {
                        JOptionPane.showMessageDialog(panel1,"check your details");
                    }
                }
                catch (Exception b)
                {
                    b.printStackTrace();
                    System.out.println("login button error");
                }
            }
        });

        /************************ registeration button ******************************/

        JButton button1 = new JButton("REGISTER");
        button1.setBounds(610,300,200,30);
        button1.setBorderPainted(false);
        button1.setContentAreaFilled(false);
        button1.setFocusPainted(false);
        button1.setOpaque(false);
        button1.setForeground(Color.WHITE);
        button1.setFont(new Font("Serif", Font.PLAIN, 21));

        img.add(button1);





        base.setVisible(true);

        base.add(panel1);
        panel1.add(img);

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registrationPage();
                img.setVisible(false);
            }
        });
    }
    /***********************************Registeration page***********************/

    public void  registrationPage()
    {
        ImageIcon icon = new ImageIcon(getClass().getResource("registrationPage.jpg"));
        JLabel   regImg    = new JLabel(icon);

       // panel.setLayout(null);

        /******      page opening   ***********/
        base.add(panel2);
        panel2.add(regImg);
        panel1.setVisible(false);
        panel2.setVisible(true);




        /*******************************  User id ********************************************/

        userId = new JTextField();
        userId.setBounds(130,50,200,30);
        userId.setForeground(Color.WHITE);
        userId.setFont(new Font("Serif", Font.PLAIN, 21));
        userId.setOpaque(false);
        regImg.add(userId);

        userId1 = new JLabel("USER ID");
        userId1.setBounds(20,50,100,30);
        userId1.setFont(new Font("Serif", Font.PLAIN, 21));
        userId1.setForeground(Color.WHITE);
        regImg.add(userId1);

        /******************************** Name  ****************************************************/

        name = new JTextField();
        name.setBounds(130,100,200,30);
        name.setForeground(Color.WHITE);
        name.setFont(new Font("Serif", Font.PLAIN, 21));
        name.setOpaque(false);
        regImg.add(name);

        name1 = new JLabel("NAME");
        name1.setBounds(20,100,100,30);
        name1.setForeground(Color.WHITE);
        name1.setFont(new Font("Serif", Font.PLAIN, 21));
        regImg.add(name1);

        /**************************************************/

         JRadioButton male = new JRadioButton("MALE");
         male.setBounds(60,150,100,50);
         male.setOpaque(false);
         male.setForeground(Color.WHITE);
         male.setFont(new Font("Serif", Font.PLAIN, 21));
         regImg.add(male);

        JRadioButton female = new JRadioButton("FEMALE");
        female.setBounds(150,150,140,50);
        female.setOpaque(false);
        female.setForeground(Color.WHITE);
        female.setFont(new Font("Serif", Font.PLAIN, 21));
        regImg.add(female);

        JRadioButton other = new JRadioButton("OTHER");
        other.setBounds(260,150,100,50);
        other.setOpaque(false);
        other.setForeground(Color.WHITE);
        other.setFont(new Font("Serif", Font.PLAIN, 21));
        regImg.add(other);

        /*******************  Gmail    ******************/

        gmail = new JTextField();
        gmail.setBounds(120,220,200,30);
        gmail.setForeground(Color.WHITE);
        gmail.setFont(new Font("Serif", Font.PLAIN, 21));
        gmail.setOpaque(false);
        regImg.add(gmail);

        gmail1 = new JLabel("GMAIL");
        gmail1.setBounds(20,220,100,30);
        gmail1.setForeground(Color.WHITE);
        gmail1.setFont(new Font("Serif", Font.PLAIN, 21));
        regImg.add(gmail1);

        /*********************   branch     ******************************/
        branch = new JTextField();
        branch.setBounds(130,270,200,30);
        branch.setForeground(Color.WHITE);
        branch.setFont(new Font("Serif", Font.PLAIN, 21));
        branch.setOpaque(false);
        regImg.add(branch);

        brach1 = new JLabel("BRANCH");
        brach1.setBounds(20,270,100,30);
        brach1.setForeground(Color.WHITE);
        brach1.setFont(new Font("Serif", Font.PLAIN, 21));
        regImg.add(brach1);

        /*********************** password   *********************************/

        password = new JTextField();
        password.setBounds(630,50,200,30);
        password.setForeground(Color.WHITE);
        password.setFont(new Font("Serif", Font.PLAIN, 21));
        password.setOpaque(false);
        regImg.add(password);

        password1 = new JLabel("PASSWORD");
        password1.setBounds(500,50,120,30);
        password1.setForeground(Color.WHITE);
        password1.setFont(new Font("Serif", Font.PLAIN, 21));
        regImg.add(password1);

        /**************************************************************/
        phonNum = new JTextField();
        phonNum.setBounds(630,100,200,30);
        phonNum.setForeground(Color.WHITE);
        phonNum.setFont(new Font("Serif", Font.PLAIN, 21));
        phonNum.setOpaque(false);
        regImg.add(phonNum);

        phonNum1 = new JLabel("PHON NO.");
        phonNum1.setBounds(500,100,100,30);
        phonNum1.setForeground(Color.WHITE);
        phonNum1.setFont(new Font("Serif", Font.PLAIN, 21));
        regImg.add(phonNum1);

        /************************    Roll No.*********************************************/
        rollNum = new JTextField();
        rollNum.setBounds(630,150,200,30);
        rollNum.setForeground(Color.WHITE);
        rollNum.setFont(new Font("Serif", Font.PLAIN, 21));
        rollNum.setOpaque(false);
        regImg.add(rollNum);

        rollNum1 = new JLabel("ROLL NO.");
        rollNum1.setBounds(500,150,100,30);
        rollNum1.setForeground(Color.WHITE);
        rollNum1.setFont(new Font("Serif", Font.PLAIN, 21));
        regImg.add(rollNum1);

        /**************************** address *****************************************/
        address = new JTextField();
        address.setBounds(630,200,200,30);
        address.setForeground(Color.WHITE);
        address.setFont(new Font("Serif", Font.PLAIN, 21));
        address.setOpaque(false);
        regImg.add(address);

        address1 = new JLabel("ADDRESS");
        address1.setBounds(500,200,100,30);
        address1.setForeground(Color.WHITE);
        address1.setFont(new Font("Serif", Font.PLAIN, 21));
        regImg.add(address1);

        /*************************   submit button ***********************************/

        JButton submit = new JButton("SUBMIT");
        submit.setBounds(630,250,90,30);
        regImg.add(submit);





        /*********************************>>  JDBC << ***********************************/
        try {


            Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/attendence", "root", "tusharkapoor00");
            System.out.println("connection successfull");






            submit.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int idInput = Integer.parseInt(userId.getText());
                    System.out.println(idInput);
                    String nameInput = name.getText();
                    String sex = "male" ;
                    if (male.isSelected())
                    {
                        sex = "male";
                    } else if (female.isSelected()) {
                        sex = "female";

                    }
                    else if (other.isSelected()){
                        sex = "other";
                    }
                    String gmailInput = gmail.getText();
                    String branchInput = branch.getText();
                    String passwordInput = password.getText();

                    String phonInput = phonNum.getText();
                    String rollInput = rollNum.getText();
                    String addInput = address.getText();
                    String qr = "insert into  reg_details values('"+idInput+"','"+nameInput+"','"+sex+"','"+gmailInput+"','"+branchInput+"','"+passwordInput+"','"+rollInput+"','"+phonInput+"','"+addInput+"');";


                    System.out.println(qr);
                    System.out.println(idInput);
                    System.out.println(nameInput);
                    System.out.println(gmail);
                    System.out.println(passwordInput);

                    new SendingEmail("tushar96152",gmailInput," Confirmation of Sign-In in Attendance Management system","Dear "+nameInput+",\n" +
                            "\n" +
                            "I hope this message finds you well. We are writing to confirm your recent sign-in to our Attendance Management Software. Your successful sign-in indicates that your account has been accessed and is ready for use.If you did not perform this sign-in or suspect any unauthorized access to your account, please contact our IT support team immediately at [IT Support Contact Information]. We take the security of your account and your personal information seriously, and we will take the necessary steps to investigate and secure your account if any issues are identified.\n" +
                            "\n" +
                            "We would like to remind you to keep your login credentials confidential and change your password regularly to ensure the security of your account.\n" +
                            "\n" +
                            "Thank you for your cooperation in using our Attendance Management Software. If you encounter any difficulties or have any questions about using the software, please don't hesitate to reach out to our support team. We are here to assist you.\n" +
                            "\n" +
                            "Best regards,");

                    try {
                        Statement st = con.createStatement();
                        st.executeUpdate(qr);
                        con.close();
                    } catch (Exception t) {
                        t.printStackTrace();
                    }

                }
            });


        } catch (Exception e) {
            e.printStackTrace();
        }
        /****************** back to login page button **************/
        JButton backLogin = new JButton("back");
        backLogin.setBounds(730,250,90,30);
        regImg.add(backLogin);

        backLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel2.setVisible(false);
                logInPage();
                panel1.setVisible(true);

            }
        });





    }

    public  void attPage(String gmail, String password)
    {


        JPanel panel3 = new JPanel();
        panel3.setBounds(300,200,900,400);
        base.add(panel3);

        panel3.setVisible(true);


        base.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);



        ImageIcon icon = new ImageIcon(getClass().getResource("attImage.jpg"));
        JLabel   img    = new JLabel(icon);
        img.setBounds(0,0,900,400);
        panel3.add(img);
        // base.setVisible(true);

        /************************** showing user details by fatching **********************************/
        try{
            Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/attendence", "root", "tusharkapoor00");
            System.out.println("connection successfull");
            String query1 = "select * from reg_details where gmail = '"+gmail+"' and password = '"+password+"';";
            System.out.println(query1);

            Statement st1 = con.createStatement();
            ResultSet rs = st1.executeQuery(query1);
            while (rs.next())
            {
                String userName = rs.getString("name");
                String userNameUpperCase = userName.toUpperCase();
                JLabel welcomLine = new JLabel("WELCOME   "+userNameUpperCase);
                welcomLine.setForeground(Color.white);
                welcomLine.setFont(new Font("Serif", Font.PLAIN, 30));
                welcomLine.setBounds(310,51,400,30);
                img.add(welcomLine);

                ImageIcon manLogo = new ImageIcon(getClass().getResource("manLogoAttdPage.png"));
                JLabel manlogo = new JLabel(manLogo);
                manlogo.setBounds(250,50,60,60);
                img.add(manlogo);





                String timeStamp = new SimpleDateFormat("yyyy / MM /dd     ").format(Calendar.getInstance().getTime());
                JLabel time  = new JLabel(timeStamp);
                time.setBounds(710,50,200,30);
                time.setForeground(Color.white);
                time.setFont(new Font("Serif", Font.PLAIN, 24));
                img.add(time);

                System.out.println(id);
            }

        }
        catch (Exception q)
        {
            q.printStackTrace();
        }


        /********************************************************************/
        JRadioButton login = new JRadioButton("LOGIN");
        login.setBounds(100,200,100,30);;
        login.setFont(new Font("Serif", Font.PLAIN, 24));
        login.setForeground(Color.WHITE);
        login.setOpaque(false);
        img.add(login);

        JRadioButton logout = new JRadioButton("LOGOUT");
        logout.setBounds(350,200,200,30);
        logout.setFont(new Font("Serif", Font.PLAIN, 24));
        logout.setForeground(Color.WHITE);
        logout.setOpaque(false);
        img.add(logout);

        JRadioButton absent = new JRadioButton("ABSENT");
        absent.setBounds(650,200,200,30);
        absent.setFont(new Font("Serif", Font.PLAIN, 24));
        absent.setForeground(Color.WHITE);
        absent.setOpaque(false);
        img.add(absent);

        JButton submit = new JButton("SUBMIT");
        submit.setBounds(250,300,200,30);
        img.add(submit);
        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String data = " ";
                try {
                    System.out.println(emailLogin.getText());
                    Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/attendence", "root", "tusharkapoor00");
                    System.out.println("connection successfull");
                    String query1 = "select * from reg_details where gmail = '"+gmail+"' and password = '"+password+"';";
                    System.out.println(query1);

                    Statement st1 = con.createStatement();
                    ResultSet rs = st1.executeQuery(query1);
                    while (rs.next())
                    {
                        id = Integer.parseInt(rs.getString("user_id"));
                        System.out.println(id);
                    }

                    if (login.isSelected())
                    {
                        String query = "Insert into attendenceData values("+id+",current_date(),current_time(),'Present',null);";
                        System.out.println(query);
                        Statement st = con.createStatement();
                        st.executeUpdate(query);

                        data = "Welcome";
                        JOptionPane.showMessageDialog(panel3, data);

                    } else if (logout.isSelected()) {
                        String query = "update attendenceData  set  logout_time = current_time() where id ="+id+" and logout_time is null;";
                        System.out.println(query);
                        Statement st = con.createStatement();
                        st.executeUpdate(query);
                        data = "Good-Bye";
                        JOptionPane.showMessageDialog(panel3, data);

                    } else if (absent.isSelected()) {
                        String query = "Insert into attendenceData values("+id+",'-------------','--------------','Absent','---------------','------------');";
                        System.out.println(query);
                        Statement st = con.createStatement();
                        st.executeUpdate(query);
                        data = "Absent";
                        JOptionPane.showMessageDialog(panel3, data);

                    }
                }
                catch (Exception p)
                {
                    p.printStackTrace();
                    System.out.println("attendence page error");
                }

            }
        });






    }





}
