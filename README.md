# Personal_health_management_System
A console-based Health Management System built using Java and MySQL. This project allows users to manage patients, doctors, checkups, prescriptions, medical history, and health data with full CRUD (Create, Read, Update, Delete) functionality through a menu-driven interface.
# Health DBMS

## Description
A console-based **Health Management System** built using **Java** and **MySQL**.  
This project allows users to manage patients, doctors, checkups, prescriptions, medical history, and health data with full **CRUD (Create, Read, Update, Delete) functionality** through a **menu-driven interface**.

---

## Features
- Add, update, delete, and view **users/patients**.
- Add, update, delete, and view **doctors**.
- Track **checkups** and **prescriptions**.
- Maintain **medical history** and **health alerts**.
- Console-based **menu-driven interface** for easy navigation.

---

## Technologies
- **Java** (JDBC)
- **MySQL**
- Console Interface

---

## Setup Instructions

1. **Clone the repository**
```bash
git clone https://github.com/yourusername/Health-DBMS.git
cd Health-DBMS

Set up the database

Open MySQL and run the SQL script healthdb_schema.sql to create the database and insert sample data:

source path/to/healthdb_schema.sql;


Compile and run the Java program

javac *.java
java Main

Project Structure
Health-DBMS/
├── Main.java             # Menu-driven interface
├── User.java             # Model class for User
├── Doctor.java           # Model class for Doctor
├── Checkup.java          # Model class for Checkup
├── Prescription.java     # Model class for Prescription
├── DAOUser.java          # DAO class for User CRUD
├── DAODoctor.java        # DAO class for Doctor CRUD
├── ...                   # Other DAO/model classes
├── healthdb_schema.sql   # Database creation & sample data
├── README.md             # Project overview
└── .gitignore            # Ignore .class files, IDE configs

Usage

Run the program.

Use the console menu to perform operations like:

Add new patients or doctors

View or update existing records

Delete records

Manage prescriptions and checkups

Author

Shravani Amol Farkade
