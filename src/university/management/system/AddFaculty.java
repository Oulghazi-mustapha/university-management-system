package university.management.system;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class AddFaculty extends JFrame implements ActionListener {

    JTextField textName, Textuni, textAddress, textPhone, textemail;
    JLabel empText;
    JDateChooser cdob;
    JComboBox<String> courseBox, departmentBox, genderbox;
    JButton submit, cancel;

    Random ran = new Random();
    long f4 = Math.abs((ran.nextLong() % 9000L) + 1000L);

    AddFaculty() {
        // Frame setup
        setTitle("Add Faculty");
        setSize(900, 700);
        setLocation(350, 50);
        setLayout(null);

        getContentPane().setBackground(new Color(100, 179, 239));

        // Background image
        ImageIcon imageIcon = new ImageIcon(getClass().getResource("/icon/addstagaire.jpg"));
        Image image = imageIcon.getImage().getScaledInstance(900, 700, Image.SCALE_DEFAULT);
        JLabel background = new JLabel(new ImageIcon(image));
        background.setBounds(0, 0, 900, 700);
        add(background);

        // Heading
        JLabel heading = new JLabel("New Stagaire Details");
        heading.setBounds(310, 30, 500, 50);
        heading.setFont(new Font("serif", Font.BOLD, 30));
        background.add(heading);

        // Form fields
        JLabel name = new JLabel("Full Name:");
        name.setBounds(50, 150, 100, 30);
        name.setFont(new Font("serif", Font.BOLD, 20));
        background.add(name);

        textName = new JTextField();
        textName.setBounds(200, 150, 150, 30);
        background.add(textName);

        JLabel fname = new JLabel("University:");
        fname.setBounds(400, 150, 200, 30);
        fname.setFont(new Font("serif", Font.BOLD, 20));
        background.add(fname);

        Textuni = new JTextField();
        Textuni.setBounds(600, 150, 150, 30);
        background.add(Textuni);

        JLabel empID = new JLabel("Employee ID:");
        empID.setBounds(50, 200, 200, 30);
        empID.setFont(new Font("serif", Font.BOLD, 20));
        background.add(empID);

        empText = new JLabel("1409" + f4);
        empText.setBounds(200, 200, 150, 30);
        empText.setFont(new Font("serif", Font.BOLD, 20));
        background.add(empText);

        JLabel dob = new JLabel("Date of Birth:");
        dob.setBounds(400, 200, 200, 30);
        dob.setFont(new Font("serif", Font.BOLD, 20));
        background.add(dob);

        cdob = new JDateChooser();
        cdob.setBounds(600, 200, 150, 30);
        background.add(cdob);

        JLabel address = new JLabel("Address:");
        address.setBounds(50, 250, 200, 30);
        address.setFont(new Font("serif", Font.BOLD, 20));
        background.add(address);

        textAddress = new JTextField();
        textAddress.setBounds(200, 250, 150, 30);
        background.add(textAddress);

        JLabel phone = new JLabel("Phone:");
        phone.setBounds(400, 250, 200, 30);
        phone.setFont(new Font("serif", Font.BOLD, 20));
        background.add(phone);

        textPhone = new JTextField();
        textPhone.setBounds(600, 250, 150, 30);
        background.add(textPhone);

        JLabel email = new JLabel("Email:");
        email.setBounds(50, 320, 200, 30);
        email.setFont(new Font("serif", Font.BOLD, 20));
        background.add(email);

        textemail = new JTextField();
        textemail.setBounds(200, 320, 150, 30);
        background.add(textemail);

        JLabel gender = new JLabel("Gender:");
        gender.setBounds(400, 320, 200, 30);
        gender.setFont(new Font("serif", Font.BOLD, 20));
        background.add(gender);

        String[] genderOptions = {"", "Male", "Female"};
        genderbox = new JComboBox<>(genderOptions);
        genderbox.setBounds(600, 320, 150, 30);
        background.add(genderbox);

        JLabel qualification = new JLabel("Qualification:");
        qualification.setBounds(50, 400, 200, 30);
        qualification.setFont(new Font("serif", Font.BOLD, 20));
        background.add(qualification);

        String[] courses = {"", "BAC+1", "BAC+2", "BAC+3", "BAC+4", "BAC+5", "BAC+6", "BAC+7", "BAC+8"};
        courseBox = new JComboBox<>(courses);
        courseBox.setBounds(200, 400, 150, 30);
        courseBox.setBackground(Color.WHITE);
        background.add(courseBox);

        JLabel department = new JLabel("Department:");
        department.setBounds(400, 400, 200, 30);
        department.setFont(new Font("serif", Font.BOLD, 20));
        background.add(department);

        String[] departments = {"", "Data Science", "Cyber Security", "Full Stack", "AI", "Robotics"};
        departmentBox = new JComboBox<>(departments);
        departmentBox.setBounds(600, 400, 150, 30);
        departmentBox.setBackground(Color.WHITE);
        background.add(departmentBox);

        // Buttons
        submit = new JButton("Submit");
        submit.setBounds(250, 550, 120, 30);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        background.add(submit);

        cancel = new JButton("Cancel");
        cancel.setBounds(450, 550, 120, 30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        background.add(cancel);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submit) {
            String name = textName.getText();
            String university = Textuni.getText();
            String empid = empText.getText();
            String dob = ((JTextField) cdob.getDateEditor().getUiComponent()).getText();
            String address = textAddress.getText();
            String phone = textPhone.getText();
            String email = textemail.getText();
            String gender = (String) genderbox.getSelectedItem();
            String course = (String) courseBox.getSelectedItem();
            String department = (String) departmentBox.getSelectedItem();

            try {
                String q = "INSERT INTO Stagaire (name, university, empid, dob, address, phone, email, gender, course, department) " +
                        "VALUES ('" + name + "', '" + university + "', '" + empid + "', '" + dob + "', '" + address + "', '" + phone + "', '" + email + "', '" + gender + "', '" + course + "', '" + department + "')";

                Conn c = new Conn();
                c.statement.executeUpdate(q);
                JOptionPane.showMessageDialog(null, "Details Inserted Successfully!");
                setVisible(false);
            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error while inserting data. Please check your inputs and database configuration.");
            }
        } else if (e.getSource() == cancel) {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new AddFaculty();
    }
}
