import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.geometry.Insets;
import javafx.scene.layout.GridPane;
import java.lang.Math;

public class Question2 extends Application {
    @Override
    // Override the start method in the Application class
    public void start(Stage primaryStage) {
        GridPane pane = new GridPane();
        TextField tfNumber1 = new TextField();
        TextField tfNumber2 = new TextField();
        TextField tfNumber3 = new TextField();
        TextField tfResult = new TextField();
        Button btCalculate = new Button("Calculate");

        tfNumber1.setAlignment(Pos.BOTTOM_RIGHT);
        tfNumber2.setAlignment(Pos.BOTTOM_RIGHT);
        tfNumber3.setAlignment(Pos.BOTTOM_RIGHT);
        tfResult.setAlignment(Pos.BOTTOM_RIGHT);
        tfResult.setEditable(false);
        tfResult.setStyle("-fx-control-inner-background: grey");

        Label lbl1 = new Label("Investment Amount: ");
        Label lbl2 = new Label("Years: ");
        Label lbl3 = new Label("Annual Interest Rate: ");
        Label lblResult = new Label("Future value: ");

        /*
        lbl1.setContentDisplay(ContentDisplay.RIGHT);
        lbl2.setContentDisplay(ContentDisplay.RIGHT);
        lbl3.setContentDisplay(ContentDisplay.RIGHT);
        lblResult.setContentDisplay(ContentDisplay.RIGHT);
        */

        pane.setPadding(new Insets(5, 5, 5, 5));
        pane.add(lbl1, 0, 0);
        pane.add(tfNumber1, 1, 0);
        pane.add(lbl2, 0, 1);
        pane.add(tfNumber2, 1, 1);
        pane.add(lbl3, 0, 2);
        pane.add(tfNumber3, 1, 2);
        pane.add(lblResult, 0, 3);
        pane.add(tfResult, 1, 3);
        pane.add(btCalculate, 1, 4);

        // Create a scene and place it in the stage
        Scene scene = new Scene(pane, 350, 175);
        primaryStage.setTitle("Question 2"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage
        btCalculate.setOnAction(e -> {
            tfResult.setText(Math.round(Double.parseDouble(tfNumber1.getText()) *
                    Math.pow((1 + (Double.parseDouble(tfNumber3.getText()) / 1200)),
                            ((Double.parseDouble(tfNumber2.getText())) * 12)) * 100.0) / 100.0 + "");
        });
    }


    public static void main(String[] args) {
        launch(args);
    }
}
