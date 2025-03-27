import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainApp extends Application {

    private TableView<Student> table;
    private StudentDAO studentDAO = new StudentDAO();

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("IDLS Management");

        // Création de la TableView et des colonnes
        table = new TableView<>();
        
        TableColumn<Student, String> colLastName = new TableColumn<>("Last Name");
colLastName.setCellValueFactory(data -> 
    new javafx.beans.property.SimpleStringProperty(data.getValue().getlastName())
);

TableColumn<Student, String> colFirstName = new TableColumn<>("First Name");
colFirstName.setCellValueFactory(data -> 
    new javafx.beans.property.SimpleStringProperty(data.getValue().getfirstName())
);

        
        TableColumn<Student, String> colBirthdate = new TableColumn<>("Birthdate");
        colBirthdate.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().getBirthdate()));

        TableColumn<Student, String> colCourse = new TableColumn<>("Course");
        colCourse.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().getCourse()));

        TableColumn<Student, String> colPromotion = new TableColumn<>("Promotion");
        colPromotion.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().getPromotion()));

        table.getColumns().addAll(colLastName, colFirstName, colBirthdate, colCourse, colPromotion);

        // Création du formulaire d'ajout
        TextField txtLastName = new TextField();
        txtLastName.setPromptText("Last Name");

        TextField txtFirstName = new TextField();
        txtFirstName.setPromptText("First Name");

        TextField txtBirthdate = new TextField();
        txtBirthdate.setPromptText("Birthdate (yyyy-mm-dd)");

        TextField txtCourse = new TextField();
        txtCourse.setPromptText("Course (GPHY, GCELL, ECMPS)");

        TextField txtPromotion = new TextField();
        txtPromotion.setPromptText("Promotion (M1 ou M2)");

        Button btnAdd = new Button("Add Student");
        btnAdd.setOnAction(e -> {
            String lastName = txtLastName.getText().trim();
            String firstName = txtFirstName.getText().trim();
            String birthdate = txtBirthdate.getText().trim();
            String course = txtCourse.getText().trim();
            String promotion = txtPromotion.getText().trim();

            Student student = new Student(lastName, firstName, birthdate, course, promotion);
            studentDAO.addStudent(student);
            refreshTable();
        });

        VBox formBox = new VBox(10);
        formBox.setPadding(new Insets(10));
        formBox.getChildren().addAll(
            new Label("Add a new student"),
            txtLastName, txtFirstName, txtBirthdate, txtCourse, txtPromotion, btnAdd
        );

        // Bouton pour rafraîchir l'affichage
        Button btnRefresh = new Button("Refresh");
        btnRefresh.setOnAction(e -> refreshTable());

        VBox vboxRight = new VBox(10);
        vboxRight.setPadding(new Insets(10));
        vboxRight.getChildren().addAll(btnRefresh, table);

        BorderPane root = new BorderPane();
        root.setLeft(formBox);
        root.setCenter(vboxRight);

        Scene scene = new Scene(root, 800, 400);
        primaryStage.setScene(scene);
        primaryStage.show();

        refreshTable();
    }

    private void refreshTable() {
        ObservableList<Student> data = FXCollections.observableArrayList(studentDAO.getAllStudents());
        table.setItems(data);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
