import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class count extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Word Counter");

        Label textLabel = new Label("Enter Text:");
        TextField textField = new TextField();
        Button countButton = new Button("Number Of Words:");

        countButton.setOnAction(e -> {
            String text = textField.getText();
            int wordCount = countWords(text);
            displayResult(wordCount);
        });

        VBox vbox = new VBox(10);
        vbox.setPadding(new Insets(10));
        vbox.getChildren().addAll(textLabel, textField, countButton);

        Scene scene = new Scene(vbox, 300, 150);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private int countWords(String text) {
        if (text == null || text.trim().isEmpty()) {
            return 0;
        }
        String[] words = text.split("\\s+");
        return words.length;
    }

    private void displayResult(int wordCount) {
        Stage dialogStage = new Stage();
        dialogStage.setTitle("Word Count Result");
        VBox vbox = new VBox(10);
        vbox.setPadding(new Insets(10));
        Label label = new Label("Number of words: " + wordCount);
        vbox.getChildren().add(label);
        Scene scene = new Scene(vbox, 250, 100);
        dialogStage.setScene(scene);
        dialogStage.show();
    }
}
