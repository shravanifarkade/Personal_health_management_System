
import java.sql.Connection;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            Connection conn = DBConnection.getConnection();
            UserDAO userDAO = new UserDAO(conn);
            DoctorDAO doctorDAO = new DoctorDAO(conn);
            CheckupDAO checkupDAO = new CheckupDAO(conn);
            PrescriptionDAO prescriptionDAO = new PrescriptionDAO(conn);
            AlertDAO alertDAO = new AlertDAO(conn);
            HealthDataDAO healthDataDAO = new HealthDataDAO(conn);
            ActivityLogDAO activityLogDAO = new ActivityLogDAO(conn);
            MedicalHistoryDAO medicalHistoryDAO = new MedicalHistoryDAO(conn);
            Scanner sc = new Scanner(System.in);
            int choice;

            do {
                // Main Menu
                System.out.println("\n====== HealthDBMS Menu ======");
                System.out.println("1. Manage Users");
                System.out.println("2. Manage Doctors");
                System.out.println("3. Manage Checkups");
                System.out.println("4. Manage Prescriptions");
                System.out.println("5. Manage Alerts");
                System.out.println("6. Manage Health Data");
                System.out.println("7. Manage Activity Log");
                System.out.println("8. Manage Medical History");
                System.out.println("9. Exit");
                System.out.print("Enter your choice: ");
                choice = sc.nextInt();
                sc.nextLine(); // consume the newline

                switch (choice) {
                    case 1 -> userMenu(userDAO, sc);
                    case 2 -> doctorMenu(doctorDAO, sc);
                    case 3 -> checkupMenu(checkupDAO, sc);
                    case 4 -> prescriptionMenu(prescriptionDAO, sc);
                    case 5 -> alertMenu(alertDAO, sc);
                    case 6 -> healthDataMenu(healthDataDAO, sc);
                    case 7 -> activityLogMenu(activityLogDAO, sc);
                    case 8 -> medicalHistoryMenu(medicalHistoryDAO, sc);
                    case 9 -> System.out.println("Exiting...");
                    default -> System.out.println("Invalid choice. Please try again.");
                }
            } while (choice != 9);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // User Management Menu
    private static void userMenu(UserDAO userDAO, Scanner sc) {
        int choice;
        do {
            System.out.println("\n-- User Management Menu --");
            System.out.println("1. Add User");
            System.out.println("2. View All Users");
            System.out.println("3. Update User Email");
            System.out.println("4. Delete User");
            System.out.println("5. Back to Main Menu");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // consume the newline

            switch (choice) {
                case 1 -> addUser(userDAO, sc);
                case 2 -> viewUsers(userDAO);
                case 3 -> updateUserEmail(userDAO, sc);
                case 4 -> deleteUser(userDAO, sc);
                case 5 -> System.out.println("Returning to main menu...");
                default -> System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 5);
    }

    private static void addUser(UserDAO userDAO, Scanner sc) {
        System.out.print("First name: ");
        String firstName = sc.nextLine();
        System.out.print("Last name: ");
        String lastName = sc.nextLine();
        System.out.print("Email: ");
        String email = sc.nextLine();
        System.out.print("Gender: ");
        String gender = sc.nextLine();

        try {
            userDAO.insert(new User(0, firstName, lastName, email, gender));
            System.out.println("✅ User added successfully.");
        } catch (Exception e) {
            System.out.println("❌ Error adding user: " + e.getMessage());
        }
    }

    private static void viewUsers(UserDAO userDAO) {
        try {
            System.out.println("\n--- Users ---");
            for (User user : userDAO.getAllUsers()) {
                System.out.println(user);
            }
        } catch (Exception e) {
            System.out.println("❌ Error retrieving users: " + e.getMessage());
        }
    }

    private static void updateUserEmail(UserDAO userDAO, Scanner sc) {
        System.out.print("User ID to update: ");
        int userId = sc.nextInt();
        sc.nextLine(); // consume the newline
        System.out.print("New Email: ");
        String newEmail = sc.nextLine();

        try {
            userDAO.updateUserEmail(userId, newEmail);
            System.out.println("✅ User email updated successfully.");
        } catch (Exception e) {
            System.out.println("❌ Error updating user email: " + e.getMessage());
        }
    }

    private static void deleteUser(UserDAO userDAO, Scanner sc) {
        System.out.print("User ID to delete: ");
        int userId = sc.nextInt();

        try {
            userDAO.deleteUser(userId);
            System.out.println("🗑 User deleted successfully.");
        } catch (Exception e) {
            System.out.println("❌ Error deleting user: " + e.getMessage());
        }
    }

    // Doctor Management Menu
    private static void doctorMenu(DoctorDAO doctorDAO, Scanner sc) {
        int choice;
        do {
            System.out.println("\n-- Doctor Management Menu --");
            System.out.println("1. Add Doctor");
            System.out.println("2. View All Doctors");
            System.out.println("3. Update Doctor");
            System.out.println("4. Delete Doctor");
            System.out.println("5. Back to Main Menu");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // consume the newline

            switch (choice) {
                case 1 -> addDoctor(doctorDAO, sc);
                case 2 -> viewDoctors(doctorDAO);
                case 3 -> updateDoctor(doctorDAO, sc);
                case 4 -> deleteDoctor(doctorDAO, sc);
                case 5 -> System.out.println("Returning to main menu...");
                default -> System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 5);
    }

    private static void addDoctor(DoctorDAO doctorDAO, Scanner sc) {
        System.out.print("Name: ");
        String name = sc.nextLine();
        System.out.print("Specialization: ");
        String specialization = sc.nextLine();
        System.out.print("Phone: ");
        String phone = sc.nextLine();
        System.out.print("Email: ");
        String email = sc.nextLine();

        try {
            doctorDAO.insert(new Doctor(0, name, specialization, phone, email));
            System.out.println("✅ Doctor added successfully.");
        } catch (Exception e) {
            System.out.println("❌ Error adding doctor: " + e.getMessage());
        }
    }

    private static void viewDoctors(DoctorDAO doctorDAO) {
        try {
            System.out.println("\n--- Doctors ---");
            for (Doctor doctor : doctorDAO.getAllDoctors()) {
                System.out.println(doctor);
            }
        } catch (Exception e) {
            System.out.println("❌ Error retrieving doctors: " + e.getMessage());
        }
    }

    private static void updateDoctor(DoctorDAO doctorDAO, Scanner sc) {
        System.out.print("Doctor ID to update: ");
        int doctorId = sc.nextInt();
        sc.nextLine(); // consume the newline
        System.out.print("New Name: ");
        String newName = sc.nextLine();
        System.out.print("New Specialization: ");
        String newSpecialization = sc.nextLine();

        try {
            doctorDAO.update(doctorId, newName, newSpecialization);
            System.out.println("✅ Doctor updated successfully.");
        } catch (Exception e) {
            System.out.println("❌ Error updating doctor: " + e.getMessage());
        }
    }

    private static void deleteDoctor(DoctorDAO doctorDAO, Scanner sc) {
        System.out.print("Doctor ID to delete: ");
        int doctorId = sc.nextInt();

        try {
            doctorDAO.delete(doctorId);
            System.out.println("🗑 Doctor deleted successfully.");
        } catch (Exception e) {
            System.out.println("❌ Error deleting doctor: " + e.getMessage());
        }
    }

    // Checkup Management Menu
    private static void checkupMenu(CheckupDAO checkupDAO, Scanner sc) {
        int choice;
        do {
            System.out.println("\n-- Checkup Management Menu --");
            System.out.println("1. Add Checkup");
            System.out.println("2. View All Checkups");
            System.out.println("3. Update Checkup");
            System.out.println("4. Delete Checkup");
            System.out.println("5. Back to Main Menu");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // consume the newline

            switch (choice) {
                case 1 -> addCheckup(checkupDAO, sc);
                case 2 -> viewCheckups(checkupDAO);
                case 3 -> updateCheckup(checkupDAO, sc);
                case 4 -> deleteCheckup(checkupDAO, sc);
                case 5 -> System.out.println("Returning to main menu...");
                default -> System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 5);
    }

    private static void addCheckup(CheckupDAO checkupDAO, Scanner sc) {
        System.out.print("User ID: ");
        int userId = sc.nextInt();
        System.out.print("Doctor ID: ");
        int doctorId = sc.nextInt();
        System.out.print("Date (YYYY-MM-DD): ");
        String date = sc.next();
        System.out.print("Notes: ");
        String notes = sc.next();

        try {
            checkupDAO.insert(new Checkup(0, userId, doctorId, Date.valueOf(date), notes));
            System.out.println("✅ Checkup added successfully.");
        } catch (Exception e) {
            System.out.println("❌ Error adding checkup: " + e.getMessage());
        }
    }

    private static void viewCheckups(CheckupDAO checkupDAO) {
        try {
            System.out.println("\n--- Checkups ---");
            for (Checkup checkup : checkupDAO.getAllCheckups()) {
                System.out.println(checkup);
            }
        } catch (Exception e) {
            System.out.println("❌ Error retrieving checkups: " + e.getMessage());
        }
    }

    private static void updateCheckup(CheckupDAO checkupDAO, Scanner sc) {
        System.out.print("Checkup ID to update: ");
        int checkupId = sc.nextInt();
        System.out.print("New Doctor ID: ");
        int doctorId = sc.nextInt();
        System.out.print("New Notes: ");
        String notes = sc.next();

        try {
            checkupDAO.update(checkupId, doctorId, notes);
            System.out.println("✅ Checkup updated successfully.");
        } catch (Exception e) {
            System.out.println("❌ Error updating checkup: " + e.getMessage());
        }
    }

    private static void deleteCheckup(CheckupDAO checkupDAO, Scanner sc) {
        System.out.print("Checkup ID to delete: ");
        int checkupId = sc.nextInt();

        try {
            checkupDAO.delete(checkupId);
            System.out.println("🗑 Checkup deleted successfully.");
        } catch (Exception e) {
            System.out.println("❌ Error deleting checkup: " + e.getMessage());
        }
    }

    // Prescription Management Menu
    private static void prescriptionMenu(PrescriptionDAO prescriptionDAO, Scanner sc) {
        int choice;
        do {
            System.out.println("\n-- Prescription Management Menu --");
            System.out.println("1. Add Prescription");
            System.out.println("2. View All Prescriptions");
            System.out.println("3. Update Prescription");
            System.out.println("4. Delete Prescription");
            System.out.println("5. Back to Main Menu");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // consume the newline

            switch (choice) {
                case 1 -> addPrescription(prescriptionDAO, sc);
                case 2 -> viewPrescriptions(prescriptionDAO);
                case 3 -> updatePrescription(prescriptionDAO, sc);
                case 4 -> deletePrescription(prescriptionDAO, sc);
                case 5 -> System.out.println("Returning to main menu...");
                default -> System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 5);
    }

    private static void addPrescription(PrescriptionDAO prescriptionDAO, Scanner sc) {
        System.out.print("Checkup ID: ");
        int checkupId = sc.nextInt();
        System.out.print("Medicine Name: ");
        String medicineName = sc.next();
        System.out.print("Dosage: ");
        String dosage = sc.next();
        System.out.print("Duration: ");
        String duration = sc.next();

        try {
            prescriptionDAO.insert(new Prescription(0, checkupId, medicineName, dosage, duration));
            System.out.println("✅ Prescription added successfully.");
        } catch (Exception e) {
            System.out.println("❌ Error adding prescription: " + e.getMessage());
        }
    }

    private static void viewPrescriptions(PrescriptionDAO prescriptionDAO) {
        try {
            System.out.println("\n--- Prescriptions ---");
            for (Prescription prescription : prescriptionDAO.getAllPrescriptions()) {
                System.out.println(prescription);
            }
        } catch (Exception e) {
            System.out.println("❌ Error retrieving prescriptions: " + e.getMessage());
        }
    }

    private static void updatePrescription(PrescriptionDAO prescriptionDAO, Scanner sc) {
        System.out.print("Prescription ID to update: ");
        int prescriptionId = sc.nextInt();
        sc.nextLine(); // consume the newline
        System.out.print("New Medicine Name: ");
        String medicineName = sc.next();
        System.out.print("New Dosage: ");
        String dosage = sc.next();

        try {
            prescriptionDAO.update(prescriptionId, medicineName, dosage);
            System.out.println("✅ Prescription updated successfully.");
        } catch (Exception e) {
            System.out.println("❌ Error updating prescription: " + e.getMessage());
        }
    }

    private static void deletePrescription(PrescriptionDAO prescriptionDAO, Scanner sc) {
        System.out.print("Prescription ID to delete: ");
        int prescriptionId = sc.nextInt();

        try {
            prescriptionDAO.delete(prescriptionId);
            System.out.println("🗑 Prescription deleted successfully.");
        } catch (Exception e) {
            System.out.println("❌ Error deleting prescription: " + e.getMessage());
        }
    }

    // Alert Management Menu
    private static void alertMenu(AlertDAO alertDAO, Scanner sc) {
        int choice;
        do {
            System.out.println("\n-- Alert Management Menu --");
            System.out.println("1. Add Alert");
            System.out.println("2. View All Alerts");
            System.out.println("3. Update Alert");
            System.out.println("4. Delete Alert");
            System.out.println("5. Back to Main Menu");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // consume the newline

            switch (choice) {
                case 1 -> addAlert(alertDAO, sc);
                case 2 -> viewAlerts(alertDAO);
                case 3 -> updateAlert(alertDAO, sc);
                case 4 -> deleteAlert(alertDAO, sc);
                case 5 -> System.out.println("Returning to main menu...");
                default -> System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 5);
    }

    private static void addAlert(AlertDAO alertDAO, Scanner sc) {
        System.out.print("User ID: ");
        int userId = sc.nextInt();
        sc.nextLine(); // consume the newline
        System.out.print("Alert Message: ");
        String alertMessage = sc.nextLine();
        System.out.print("Alert Date (YYYY-MM-DD HH:MM:SS): ");
        String alertDateStr = sc.nextLine();
        Timestamp alertDate = Timestamp.valueOf(alertDateStr);

        try {
            alertDAO.insert(new Alert(0, userId, alertMessage, alertDate));
            System.out.println("✅ Alert added successfully.");
        } catch (Exception e) {
            System.out.println("❌ Error adding alert: " + e.getMessage());
        }
    }

    private static void viewAlerts(AlertDAO alertDAO) {
        try {
            System.out.println("\n--- Alerts ---");
            for (Alert alert : alertDAO.getAllAlerts()) {
                System.out.println(alert);
            }
        } catch (Exception e) {
            System.out.println("❌ Error retrieving alerts: " + e.getMessage());
        }
    }

    private static void updateAlert(AlertDAO alertDAO, Scanner sc) {
        System.out.print("Alert ID to update: ");
        int alertId = sc.nextInt();
        sc.nextLine(); // consume the newline
        System.out.print("New Alert Message: ");
        String alertMessage = sc.nextLine();

        try {
            alertDAO.update(alertId, alertMessage);
            System.out.println("✅ Alert updated successfully.");
        } catch (Exception e) {
            System.out.println("❌ Error updating alert: " + e.getMessage());
        }
    }

    private static void deleteAlert(AlertDAO alertDAO, Scanner sc) {
        System.out.print("Alert ID to delete: ");
        int alertId = sc.nextInt();

        try {
            alertDAO.delete(alertId);
            System.out.println("🗑 Alert deleted successfully.");
        } catch (Exception e) {
            System.out.println("❌ Error deleting alert: " + e.getMessage());
        }
    }

    // Health Data Management Menu
    private static void healthDataMenu(HealthDataDAO healthDataDAO, Scanner sc) {
        int choice;
        do {
            System.out.println("\n-- Health Data Management Menu --");
            System.out.println("1. Add Health Data");
            System.out.println("2. View All Health Data");
            System.out.println("3. Update Health Data");
            System.out.println("4. Delete Health Data");
            System.out.println("5. Back to Main Menu");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // consume the newline

            switch (choice) {
                case 1 -> addHealthData(healthDataDAO, sc);
                case 2 -> viewHealthData(healthDataDAO);
                case 3 -> updateHealthData(healthDataDAO, sc);
                case 4 -> deleteHealthData(healthDataDAO, sc);
                case 5 -> System.out.println("Returning to main menu...");
                default -> System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 5);
    }

    private static void addHealthData(HealthDataDAO healthDataDAO, Scanner sc) {
        System.out.print("User ID: ");
        int userId = sc.nextInt();
        System.out.print("Date Recorded (YYYY-MM-DD): ");
        String dateRecorded = sc.next();
        System.out.print("Weight: ");
        double weight = sc.nextDouble();
        sc.nextLine(); // consume the newline
        System.out.print("Blood Pressure: ");
        String bloodPressure = sc.nextLine();
        System.out.print("Heart Rate: ");
        int heartRate = sc.nextInt();

        try {
            healthDataDAO.insert(new HealthData(0, userId, Date.valueOf(dateRecorded), weight, bloodPressure, heartRate));
            System.out.println("✅ Health Data added successfully.");
        } catch (Exception e) {
            System.out.println("❌ Error adding health data: " + e.getMessage());
        }
    }

    private static void viewHealthData(HealthDataDAO healthDataDAO) {
        try {
            System.out.println("\n--- Health Data ---");
            for (HealthData healthData : healthDataDAO.getAllHealthData()) {
                System.out.println(healthData);
            }
        } catch (Exception e) {
            System.out.println("❌ Error retrieving health data: " + e.getMessage());
        }
    }

    private static void updateHealthData(HealthDataDAO healthDataDAO, Scanner sc) {
        System.out.print("Health Data ID to update: ");
        int dataId = sc.nextInt();
        System.out.print("New Weight: ");
        double weight = sc.nextDouble();

        try {
            healthDataDAO.update(dataId, weight);
            System.out.println("✅ Health Data updated successfully.");
        } catch (Exception e) {
            System.out.println("❌ Error updating health data: " + e.getMessage());
        }
    }

    private static void deleteHealthData(HealthDataDAO healthDataDAO, Scanner sc) {
        System.out.print("Health Data ID to delete: ");
        int dataId = sc.nextInt();

        try {
            healthDataDAO.delete(dataId);
            System.out.println("🗑 Health Data deleted successfully.");
        } catch (Exception e) {
            System.out.println("❌ Error deleting health data: " + e.getMessage());
        }
    }

    // Activity Log Management Menu
    private static void activityLogMenu(ActivityLogDAO activityLogDAO, Scanner sc) {
        int choice;
        do {
            System.out.println("\n-- Activity Log Management Menu --");
            System.out.println("1. Add Activity Log");
            System.out.println("2. View All Activity Logs");
            System.out.println("3. Update Activity Log");
            System.out.println("4. Delete Activity Log");
            System.out.println("5. Back to Main Menu");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // consume the newline

            switch (choice) {
                case 1 -> addActivityLog(activityLogDAO, sc);
                case 2 -> viewActivityLogs(activityLogDAO);
                case 3 -> updateActivityLog(activityLogDAO, sc);
                case 4 -> deleteActivityLog(activityLogDAO, sc);
                case 5 -> System.out.println("Returning to main menu...");
                default -> System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 5);
    }

    private static void addActivityLog(ActivityLogDAO activityLogDAO, Scanner sc) {
        System.out.print("User ID: ");
        int userId = sc.nextInt();
        sc.nextLine(); // consume the newline
        System.out.print("Activity: ");
        String activity = sc.nextLine();
        System.out.print("Activity Date (YYYY-MM-DD HH:MM:SS): ");
        String activityDateStr = sc.nextLine();
        Timestamp activityDate = Timestamp.valueOf(activityDateStr);

        try {
            activityLogDAO.insert(new ActivityLog(0, userId, activity, activityDate));
            System.out.println("✅ Activity Log added successfully.");
        } catch (Exception e) {
            System.out.println("❌ Error adding Activity Log: " + e.getMessage());
        }
    }

    private static void viewActivityLogs(ActivityLogDAO activityLogDAO) {
        try {
            System.out.println("\n--- Activity Logs ---");
            for (ActivityLog activityLog : activityLogDAO.getAllActivityLogs()) {
                System.out.println(activityLog);
            }
        } catch (Exception e) {
            System.out.println("❌ Error retrieving Activity Logs: " + e.getMessage());
        }
    }

    private static void updateActivityLog(ActivityLogDAO activityLogDAO, Scanner sc) {
        System.out.print("Activity Log ID to update: ");
        int logId = sc.nextInt();
        sc.nextLine(); // consume the newline
        System.out.print("New Activity: ");
        String activity = sc.nextLine();

        try {
            activityLogDAO.update(logId, activity);
            System.out.println("✅ Activity Log updated successfully.");
        } catch (Exception e) {
            System.out.println("❌ Error updating Activity Log: " + e.getMessage());
        }
    }

    private static void deleteActivityLog(ActivityLogDAO activityLogDAO, Scanner sc) {
        System.out.print("Activity Log ID to delete: ");
        int logId = sc.nextInt();

        try {
            activityLogDAO.delete(logId);
            System.out.println("🗑 Activity Log deleted successfully.");
        } catch (Exception e) {
            System.out.println("❌ Error deleting Activity Log: " + e.getMessage());
        }
    }

    // Medical History Management Menu
    private static void medicalHistoryMenu(MedicalHistoryDAO medicalHistoryDAO, Scanner sc) {
        int choice;
        do {
            System.out.println("\n-- Medical History Management Menu --");
            System.out.println("1. Add Medical History");
            System.out.println("2. View All Medical Histories");
            System.out.println("3. Update Medical History");
            System.out.println("4. Delete Medical History");
            System.out.println("5. Back to Main Menu");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // consume the newline

            switch (choice) {
                case 1 -> addMedicalHistory(medicalHistoryDAO, sc);
                case 2 -> viewMedicalHistories(medicalHistoryDAO);
                case 3 -> updateMedicalHistory(medicalHistoryDAO, sc);
                case 4 -> deleteMedicalHistory(medicalHistoryDAO, sc);
                case 5 -> System.out.println("Returning to main menu...");
                default -> System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 5);
    }

    private static void addMedicalHistory(MedicalHistoryDAO medicalHistoryDAO, Scanner sc) {
        System.out.print("User ID: ");
        int userId = sc.nextInt();
        sc.nextLine(); // consume the newline
        System.out.print("Condition Name: ");
        String conditionName = sc.nextLine();
        System.out.print("Diagnosis Date (YYYY-MM-DD): ");
        String diagnosisDateStr = sc.nextLine();
        Date diagnosisDate = Date.valueOf(diagnosisDateStr);
        System.out.print("Treatment: ");
        String treatment = sc.nextLine();

        try {
            medicalHistoryDAO.insert(new MedicalHistory(0, userId, conditionName, diagnosisDate, treatment));
            System.out.println("✅ Medical History added successfully.");
        } catch (Exception e) {
            System.out.println("❌ Error adding Medical History: " + e.getMessage());
        }
    }

    private static void viewMedicalHistories(MedicalHistoryDAO medicalHistoryDAO) {
        try {
            System.out.println("\n--- Medical Histories ---");
            for (MedicalHistory medicalHistory : medicalHistoryDAO.getAllMedicalHistories()) {
                System.out.println(medicalHistory);
            }
        } catch (Exception e) {
            System.out.println("❌ Error retrieving Medical Histories: " + e.getMessage());
        }
    }

    private static void updateMedicalHistory(MedicalHistoryDAO medicalHistoryDAO, Scanner sc) {
        System.out.print("Medical History ID to update: ");
        int historyId = sc.nextInt();
        sc.nextLine(); // consume the newline
        System.out.print("New Treatment: ");
        String treatment = sc.nextLine();

        try {
            medicalHistoryDAO.update(historyId, treatment);
            System.out.println("✅ Medical History updated successfully.");
        } catch (Exception e) {
            System.out.println("❌ Error updating Medical History: " + e.getMessage());
        }
    }

    private static void deleteMedicalHistory(MedicalHistoryDAO medicalHistoryDAO, Scanner sc) {
        System.out.print("Medical History ID to delete: ");
        int historyId = sc.nextInt();

        try {
            medicalHistoryDAO.delete(historyId);
            System.out.println("🗑 Medical History deleted successfully.");
        } catch (Exception e) {
            System.out.println("❌ Error deleting Medical History: " + e.getMessage());
        }
    }
}
