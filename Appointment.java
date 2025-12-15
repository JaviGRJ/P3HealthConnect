import java.time.LocalDate;


public class Appointment {
private Patient patient;
private Doctor doctor;
private LocalDate date;


public Appointment(Patient patient, Doctor doctor, LocalDate date) {
this.patient = patient;
this.doctor = doctor;
this.date = date;
}


public Patient getPatient() {
return patient;
}


public Doctor getDoctor() {
return doctor;
}


public LocalDate getDate() {
return date;
}


@Override
public String toString() {
return "Appointment{" +
"patient=" + patient.getName() +
", doctor=" + doctor.getName() +
", date=" + date +
'}';
}
}