import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {
    public static void main(String[] args) throws Exception {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("tela_inicial.fxml"));

        primaryStage.setTitle("Crescimento populacional");
        primaryStage.setScene(new Scene(root, 618, 250));
        primaryStage.show();
    }

}