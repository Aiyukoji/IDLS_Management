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
        TableColumn<Student, String> colNom = new TableColumn<>("Nom");
        colNom.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().getNom()));

        TableColumn<Student, String> colPrenom = new TableColumn<>("Prénom");
        colPrenom.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().getPrenom()));

        TableColumn<Student, String> colBirthdate = new TableColumn<>("Date de Naissance");
        colBirthdate.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().getBirthdate()));

        TableColumn<Student, String> colCourse = new TableColumn<>("Parcours");
        colCourse.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().getCourse()));

        TableColumn<Student, String> colPromotion = new TableColumn<>("Promotion");
        colPromotion.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().getPromotion()));

        table.getColumns().addAll(colNom, colPrenom, colBirthdate, colCourse, colPromotion);

        // Bouton pour rafraîchir l'affichage
        Button btnRefresh = new Button("Afficher");
        btnRefresh.setOnAction(e -> refreshTable());

        VBox vbox = new VBox();
        vbox.setPadding(new Insets(10));
        vbox.setSpacing(10);
        vbox.getChildren().addAll(btnRefresh, table);

        BorderPane root = new BorderPane();
        root.setCenter(vbox);

        Scene scene = new Scene(root, 600, 400);
        primaryStage.setScene(scene);
        primaryStage.show();

        // Chargement initial
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
