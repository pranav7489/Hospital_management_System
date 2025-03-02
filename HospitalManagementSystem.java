//package project in java;

import java.util.ArrayList;
import java.util.Scanner;

class Patient {
    private static int idCounter = 1; // property of Patient class
    private int id;
    private int age;
    private String name;
    private String gender;

    // constructor
    Patient(String name, int age, String gender) {
        this.id = idCounter++;
        this.age = age;
        this.name = name;
        this.gender = gender;
    }

    // getter
    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Patient Id: " + id + ", Name: " + name + ", Age: " + age + ", Gender: " + gender;
    }
}

class Doctor {
    private static int idCounter = 1;
    private int id;
    private String name;
    private String speciality;

    // constructor
    Doctor(String name, String speciality) {
        this.id = idCounter++;
        this.name = name;
        this.speciality = speciality;
    }

    // getter
    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Doctor Id: " + id + ", Name: " + name + ", Speciality: " + speciality;
    }
}

class Appointment {
    private Patient patient;
    private Doctor doctor;
    private String date;

    // constructor
    Appointment(Patient patient, Doctor doctor, String date) {
        this.patient = patient;
        this.doctor = doctor;
        this.date = date;
    }

    @Override
    public String toString() {
        return "Appointment: [Patient: " + patient + ", Doctor: " + doctor + ", Date: " + date + "]";
    }
}

public class HospitalManagementSystem {
    private static ArrayList<Patient> patients = new ArrayList<>();
    private static ArrayList<Doctor> doctors = new ArrayList<>();
    private static ArrayList<Appointment> appointments = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("Welcome to Hospital Management System");
            System.out.println("1. Add Patient");
            System.out.println("2. Add Doctor");
            System.out.println("3. Schedule Appointment");
            System.out.println("4. View Patient");
            System.out.println("5. View Doctor");
            System.out.println("6. View Appointments");
            System.out.println("0. Exit");
            System.out.println("Enter your choice:");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    addPatient(sc);
                    break;
                case 2:
                    addDoctor(sc);
                    break;
                case 3:
                    scheduleAppointment(sc);
                    break;
                case 4:
                    viewPatient();
                    break;
                case 5:
                    viewDoctor();
                    break;
                case 6:
                    viewAppointment();
                    break;
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        } while (choice != 0);
    }

    private static void addPatient(Scanner sc) {
        System.out.println("Enter Patient Name:");
        String name = sc.next();
        System.out.println("Enter Patient Age:");
        int age = sc.nextInt();
        System.out.println("Enter Patient Gender:");
        String gender = sc.next();
        Patient patient = new Patient(name, age, gender);
        patients.add(patient);
        System.out.println("Patient added successfully!");
    }

    private static void addDoctor(Scanner sc) {
        System.out.println("Enter Doctor Name:");
        String name = sc.next();
        System.out.println("Enter Speciality:");
        String speciality = sc.next();
        Doctor doctor = new Doctor(name, speciality);
        doctors.add(doctor);
        System.out.println("Doctor added successfully!");
    }

    private static void scheduleAppointment(Scanner sc) {
        System.out.println("Enter Patient ID:");
        int p_id = sc.nextInt();
        System.out.println("Enter Doctor ID:");
        int d_id = sc.nextInt();
        System.out.println("Enter Appointment Date (YYYY-MM-DD):");
        String date = sc.next();

        Patient patient = findPatientById(p_id);
        Doctor doctor = findDoctorById(d_id);

        if (patient != null && doctor != null) {
            Appointment appointment = new Appointment(patient, doctor, date);
            appointments.add(appointment);
            System.out.println("Appointment added successfully!");
        } else {
            System.out.println("Invalid Patient ID or Doctor ID.");
        }
    }

    private static void viewPatient() {
        System.out.println("Patients list:");
        for (Patient patient : patients) {
            System.out.println(patient);
        }
    }

    private static void viewDoctor() {
        System.out.println("List of Doctors:");
        for (Doctor doctor : doctors) {
            System.out.println(doctor);
        }
    }

    private static void viewAppointment() {
        System.out.println("Appointments list:");
        for (Appointment appointment : appointments) {
            System.out.println(appointment);
        }
    }

    private static Patient findPatientById(int id) {
        for (Patient patient : patients) {
            if (patient.getId() == id) {
                return patient;
            }
        }
        return null;
    }

    private static Doctor findDoctorById(int id) {
        for (Doctor doctor : doctors) {
            if (doctor.getId() == id) {
                return doctor;
            }
        }
        return null;
    }
}
