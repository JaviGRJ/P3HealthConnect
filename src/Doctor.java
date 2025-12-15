public class Doctor extends User {
private String specialty;


public Doctor(String id, String name, String email, String specialty) {
super(id, name, email);
this.specialty = specialty;
}


public String getSpecialty() {
return specialty;
}
}