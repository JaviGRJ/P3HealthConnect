/**
 * Main application class for HealthConnect.
 */


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class HealthConnectApp {


private static List<Patient> patients = new ArrayList<>();
private static List<Doctor> doctors = new ArrayList<>();
private static List<Appointment> appointments = new ArrayList<>();


/**
 * Application entry point.
 */

public static void main(String[] args) {
Scanner scanner = new Scanner(System.in);
boolean running = true;


while (running) {
System.out.println("\\n=== HealthConnect CLI ===");
System.out.println("1. Register patient");
System.out.println("2. Register doctor");
System.out.println("3. Create appointment");
System.out.println("4. Show appointments");
System.out.println("5. Show appointments by patient");
System.out.println("6. Cancel appointment");
System.out.println("0. Exit");
System.out.print("Choose an option: ");


int option = scanner.nextInt();
scanner.nextLine();


switch (option) {
    case 1:
        registerPatient(scanner);
        break;
    case 2:
        registerDoctor(scanner);
        break;
    case 3:
        createAppointment(scanner);
        break;
    case 4:
        showAppointments();
        break;
    case 5:
        showAppointmentsByPatient(scanner);
        break;
    case 6:
        cancelAppointment(scanner);
        break;
    case 0:
        running = false;
        break;
    default:
        System.out.println("Invalid option");
}

}
scanner.close();
}

private static void showAppointmentsByPatient(Scanner scanner) {
    if (appointments.isEmpty()) {
        System.out.println("No appointments registered.");
        return;
    }

    Patient patient = selectPatient(scanner);

    System.out.println("Appointments for " + patient.getName() + ":");

    boolean found = false;
    for (Appointment a : appointments) {
        if (a.getPatient().equals(patient)) {
            System.out.println(a);
            found = true;
        }
    }

    if (!found) {
        System.out.println("No appointments for this patient.");
    }
}


private static void registerPatient(Scanner scanner) {
System.out.print("Patient ID: ");
String id = scanner.nextLine();
System.out.print("Name: ");
String name = scanner.nextLine();
System.out.print("Email: ");
String email = scanner.nextLine();
System.out.print("Age: ");
int age = scanner.nextInt();
scanner.nextLine();


patients.add(new Patient(id, name, email, age));
System.out.println("Patient registered successfully.");
}


private static void registerDoctor(Scanner scanner) {
System.out.print("Doctor ID: ");
String id = scanner.nextLine();
System.out.print("Name: ");
String name = scanner.nextLine();
System.out.print("Email: ");
String email = scanner.nextLine();
System.out.print("Specialty: ");
String specialty = scanner.nextLine();


doctors.add(new Doctor(id, name, email, specialty));
System.out.println("Doctor registered successfully.");
}


private static void createAppointment(Scanner scanner) {
    if (patients.isEmpty() || doctors.isEmpty()) {
        System.out.println("You must register at least one patient and one doctor first.");
        return;
    }

    Patient patient = selectPatient(scanner);
    Doctor doctor = selectDoctor(scanner);

    System.out.print("Appointment date (YYYY-MM-DD): ");
    String dateInput = scanner.nextLine();
    LocalDate date = LocalDate.parse(dateInput);

    appointments.add(new Appointment(patient, doctor, date));
    System.out.println("Appointment created successfully.");
}


private static void showAppointments() {
if (appointments.isEmpty()) {
System.out.println("No appointments registered.");
} else {
appointments.forEach(System.out::println);
}
}
private static Patient selectPatient(Scanner scanner) {
    System.out.println("Select a patient:");

    for (int i = 0; i < patients.size(); i++) {
        System.out.println(i + " - " + patients.get(i).getName());
    }

    System.out.print("Patient number: ");
    int index = scanner.nextInt();
    scanner.nextLine();

    return patients.get(index);
}

private static Doctor selectDoctor(Scanner scanner) {
    System.out.println("Select a doctor:");

    for (int i = 0; i < doctors.size(); i++) {
        System.out.println(i + " - " + doctors.get(i).getName()
                + " (" + doctors.get(i).getSpecialty() + ")");
    }

    System.out.print("Doctor number: ");
    int index = scanner.nextInt();
    scanner.nextLine();

    return doctors.get(index);
}

private static void cancelAppointment(Scanner scanner) {
    if (appointments.isEmpty()) {
        System.out.println("No appointments to cancel.");
        return;
    }

    System.out.println("Select appointment to cancel:");

    for (int i = 0; i < appointments.size(); i++) {
        System.out.println(i + " - " + appointments.get(i));
    }

    System.out.print("Appointment number: ");
    int index = scanner.nextInt();
    scanner.nextLine();

    appointments.remove(index);
    System.out.println("Appointment cancelled.");
}

}