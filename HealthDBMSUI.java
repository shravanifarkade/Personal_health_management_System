import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HealthDBMSUI {
    private JFrame frame;

    public HealthDBMSUI() {
        frame = new JFrame("Health Management DBMS");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new GridLayout(0, 2)); // 2 columns

        // Add buttons for each action
        addButton("Add User", e -> openAddUserForm());
        addButton("View All Users", e -> viewAllUsers());
        addButton("Update User", e -> openUpdateUserForm());
        addButton("Delete User", e -> openDeleteUserForm());
        addButton("Add Doctor", e -> openAddDoctorForm());
        addButton("View All Doctors", e -> viewAllDoctors());
        addButton("Update Doctor", e -> openUpdateDoctorForm());
        addButton("Delete Doctor", e -> openDeleteDoctorForm());

        frame.setVisible(true);
    }

    private void addButton(String title, ActionListener action) {
        JButton button = new JButton(title);
        button.addActionListener(action);
        frame.add(button);
    }

    // Placeholder methods for actions
    private void openAddUserForm() {
        // Open the Add User form here
        JOptionPane.showMessageDialog(frame, "Open Add User Form");
    }

    private void viewAllUsers() {
        // Display all users here
        JOptionPane.showMessageDialog(frame, "Display All Users");
    }

    private void openUpdateUserForm() {
        // Open the Update User form here
        JOptionPane.showMessageDialog(frame, "Open Update User Form");
    }

    private void openDeleteUserForm() {
        // Open the Delete User form here
        JOptionPane.showMessageDialog(frame, "Open Delete User Form");
    }

    private void openAddDoctorForm() {
        // Open the Add Doctor form here
        JOptionPane.showMessageDialog(frame, "Open Add Doctor Form");
    }

    private void viewAllDoctors() {
        // Display all doctors here
        JOptionPane.showMessageDialog(frame, "Display All Doctors");
    }

    private void openUpdateDoctorForm() {
        // Open the Update Doctor form here
        JOptionPane.showMessageDialog(frame, "Open Update Doctor Form");
    }

    private void openDeleteDoctorForm() {
        // Open the Delete Doctor form here
        JOptionPane.showMessageDialog(frame, "Open Delete Doctor Form");
    }

    public static void main(String[] args) {
        new HealthDBMSUI();
    }
}
