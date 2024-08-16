import static javafx.application.Platform.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Starter extends Application {
    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Homepage");
        stage.setOnCloseRequest(windowEvent -> exit());
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/homepage.fxml"))));
        stage.show();
    }
}
