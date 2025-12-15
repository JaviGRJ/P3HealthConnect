public class Patient extends User {
private int age;


public Patient(String id, String name, String email, int age) {
super(id, name, email);
this.age = age;
}


public int getAge() {
return age;
}
}
