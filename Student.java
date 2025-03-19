public class Student {
    private String nom;
    private String prenom;
    private String birthdate; // vous pouvez utiliser LocalDate pour une meilleure gestion des dates
    private String course;   // ECMPS, GCell, GPhy
    private String promotion; // M1 ou M2

    public Student(String nom, String prenom, String birthdate, String course, String promotion) {
        this.nom = nom;
        this.prenom = prenom;
        this.birthdate = birthdate;
        this.course = course;
        this.promotion = promotion;
    }

    // Getters et setters
    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

    public String getPrenom() { return prenom; }
    public void setPrenom(String prenom) { this.prenom = prenom; }

    public String getBirthdate() { return birthdate; }
    public void setBirthdate(String birthdate) { this.birthdate = birthdate; }

    public String getCourse() { return course; }
    public void setCourse(String course) { this.course = course; }

    public String getPromotion() { return promotion; }
    public void setPromotion(String promotion) { this.promotion = promotion; }
}
