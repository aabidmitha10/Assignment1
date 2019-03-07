import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.Arrays;
import java.util.Random;

public class Question1 extends Application {

    @Override // Override the start method in the Application class
    public void start(Stage primaryStage) {

        // Create a pane and set its properties
        GridPane pane = new GridPane();
        pane.setAlignment(Pos.CENTER);
        pane.setPadding(new Insets(5, 5, 5, 5));
        pane.setHgap(5.5);
        pane.setVgap(5.5);

        Random rand = new Random();
        int rand_num;
        int rand_num_list[] = new int[54];
        String addresses[] = new String [54];
        for (int i = 0; i < addresses.length; i++){
            rand_num = rand.nextInt((54 - 1) + 1) + 1;
            for (int j = 0; j < rand_num_list.length; j++){
                while (rand_num == rand_num_list[j]) {
                    rand_num = rand.nextInt((54 - 1) + 1) + 1;
                }
            }

            rand_num_list[i] = rand_num;
            addresses[i] = "file:///C:/Users/Aabid Mitha/OneDrive/Uni/Year 2/Semester 2/Systems Development and Integration/Assignments/Assignment 1/image/card/" + rand_num_list[i] + ".png";
            System.out.println(rand_num_list[i]);
            System.out.println(addresses[i]);
        }
        // Place nodes in the pane
        ImageView imageView1 = new ImageView(new Image(addresses[0]));
        ImageView imageView2 = new ImageView(new Image(addresses[1]));
        ImageView imageView3 = new ImageView(new Image(addresses[2]));

        Label lbl1 = new Label("", imageView1);
        Label lbl2 = new Label("", imageView2);
        Label lbl3 = new Label("", imageView3);

        pane.add(lbl1, 0, 0);
        pane.add(lbl2, 1, 0);
        pane.add(lbl3, 2, 0);


        // Create a scene and place it in the stage
        Scene scene = new Scene(pane);
        primaryStage.setTitle("Question 1"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage
    }

    public static void main(String[] args) {
        launch(args);
    }
}