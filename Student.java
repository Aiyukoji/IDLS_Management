public class Student {
    private String lastName;
    private String firstName;
    private String birthdate; 
    private String course;   // GPHY, GCELL, ECMPS
    private String promotion; // M1 ou M2

    public Student(String lastName, String firstName, String birthdate, String course, String promotion) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.birthdate = birthdate;
        this.course = course;
        this.promotion = promotion;
    }

    // Getters et setters
    public String getlastName() { return lastName; }
    public void setlastName(String lastName) { this.lastName = lastName; }

    public String getfirstName() { return firstName; }
    public void setfirstName(String firstName) { this.firstName = firstName; }

    public String getBirthdate() { return birthdate; }
    public void setBirthdate(String birthdate) { this.birthdate = birthdate; }

    public String getCourse() { return course; }
    public void setCourse(String course) { this.course = course; }

    public String getPromotion() { return promotion; }
    public void setPromotion(String promotion) { this.promotion = promotion; }
}
