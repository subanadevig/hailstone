import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class HailstoneFX extends Application {

    private int c;

    // function to print hailstone numbers
    // and to calculate the number of steps required
    private int HailstoneNumbers(int N) {
        if (N == 1 && c == 0) {
            return c;
        } else if (N == 1 && c != 0) {
            c++;
            return c;
        } else if (N % 2 == 0) {
            c++;
            System.out.println(N + " is even,so I take half:" + N / 2);
            HailstoneNumbers(N / 2);
        } else if (N % 2 != 0) {
            c++;
            System.out.println(N + "is odd,so I take 3n+1:" + (3 * N + 1));
            HailstoneNumbers(3 * N + 1);
        }
        return c;
    }

    @Override
    public void start(Stage primaryStage) {

        // Create a label to prompt the user to enter a number
        Label promptLabel = new Label("Enter a number:");

        // Create a text field to let the user enter a number
        TextField numberField = new TextField();

        // Create a button to generate the hailstone numbers
        Button generateButton = new Button("Generate Hailstone Numbers");
        generateButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                c = 0;
                int N = Integer.parseInt(numberField.getText());
                int x = HailstoneNumbers(N);
                System.out.println("Number of Steps: " + x);
            }
        });

        // Create a layout to hold the prompt, text field, and button
        HBox inputLayout = new HBox();
        inputLayout.getChildren().addAll(promptLabel, numberField, generateButton);

        // Create a layout to hold the input layout
        VBox root = new VBox();
        root.getChildren().add(inputLayout);

        // Create a scene and add it to the stage
        Scene scene = new Scene(root, 600, 100);
        primaryStage.setTitle("Hailstone Numbers");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
