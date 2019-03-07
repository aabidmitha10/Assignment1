import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import javafx.scene.shape.Circle;
import java.util.Arrays;
import java.util.Random;
import javafx.scene.control.Label;

public class Question3 extends Application {
    @Override // Override the start method in the Application class
    public void start(Stage primaryStage) {
        // Create a pane and set its properties
        Pane pane = new Pane();
        Circle circle = new Circle(100);
        circle.setCenterX(250);
        circle.setCenterY(250);
        circle.setFill(Color.WHITE);
        circle.setStroke(Color.BLACK);

        Random rand = new Random();
        int abs = -1;
        double initial_x_points[] = new double[3];
        double initial_y_points[] = new double[3];
        for(int i = 0; i < initial_x_points.length; i++) {
            initial_x_points[i] = rand.nextInt((350 - 150) + 1) + 150;
            abs = rand.nextInt((1 - 0) + 1) + 0;
            System.out.println(abs);
            if (abs == 0) {
                initial_y_points[i] = 250 - Math.sqrt(10000 - (initial_x_points[i] - 250) * (initial_x_points[i] - 250));
            }
            else{
                initial_y_points[i] = 250 + Math.sqrt(10000 - (initial_x_points[i] - 250) * (initial_x_points[i] - 250));
            }
        }

        for (int i = 0; i < initial_x_points.length; i++){
            System.out.println(initial_x_points[i] + ", " + initial_y_points[i]);
        }

        //Make 3 random points
        Circle pointA = new Circle(5);
        pointA.setCenterX(initial_x_points[0]);
        pointA.setCenterY(initial_y_points[0]);
        pointA.setFill(Color.RED);
        pointA.setStroke(Color.BLACK);

        Circle pointB = new Circle(5);
        pointB.setCenterX(initial_x_points[1]);
        pointB.setCenterY(initial_y_points[1]);
        pointB.setFill(Color.RED);
        pointB.setStroke(Color.BLACK);

        Circle pointC = new Circle(5);
        pointC.setCenterX(initial_x_points[2]);
        pointC.setCenterY(initial_y_points[2]);
        pointC.setFill(Color.RED);
        pointC.setStroke(Color.BLACK);

        //Lengths of points
        double a = Math.sqrt(Math.pow((pointC.getCenterX() - pointB.getCenterX()), 2) +  Math.pow((pointC.getCenterY() - pointB.getCenterY()), 2));
        double b = Math.sqrt(Math.pow((pointC.getCenterX() - pointA.getCenterX()), 2) +  Math.pow((pointC.getCenterY() - pointA.getCenterY()), 2));
        double c = Math.sqrt(Math.pow((pointB.getCenterX() - pointA.getCenterX()), 2) +  Math.pow((pointB.getCenterY() - pointA.getCenterY()), 2));
        //System.out.println(a + " " + b + " " + " " + c);

        //Angles
        double init_angles[] = test(pointA, pointB, pointC);
        Label lblA = new Label(Double.toString(init_angles[0]));
        Label lblB = new Label(Double.toString(init_angles[1]));
        Label lblC = new Label(Double.toString(init_angles[2]));
        lblA.relocate(pointA.getCenterX(), pointA.getCenterY());
        lblB.relocate(pointB.getCenterX(), pointB.getCenterY());
        lblC.relocate(pointC.getCenterX(), pointC.getCenterY());


        //Connect 3 points
        Line line1 = new Line(initial_x_points[0], initial_y_points[0], initial_x_points[1], initial_y_points[1]); //2 coordinate points
        Line line2 = new Line(initial_x_points[1], initial_y_points[1], initial_x_points[2], initial_y_points[2]); //2 coordinate points
        Line line3 = new Line(initial_x_points[2], initial_y_points[2], initial_x_points[0], initial_y_points[0]); //2 coordinate points

        //Add objects to pane
        pane.getChildren().addAll(circle, pointA, pointB, pointC, line1, line2, line3, lblA, lblB, lblC);

        //Move points
        pointA.setOnMouseDragged(e -> {
            pointA.setCenterX(e.getX());
            if(pointA.getCenterX() > 350){
                pointA.setCenterX(350);
            }
            if(pointA.getCenterX() < 150){
                pointA.setCenterX(150);
            }

            if (e.getY() < 250) {
                pointA.setCenterY(250 - Math.sqrt(10000 - (pointA.getCenterX() - 250) * (pointA.getCenterX() - 250)));
            }
            else {
                pointA.setCenterY(250 + Math.sqrt(10000 - (pointA.getCenterX() - 250) * (pointA.getCenterX() - 250)));
            }
            line1.setStartX(pointA.getCenterX());
            line1.setStartY(pointA.getCenterY());
            line3.setEndX(pointA.getCenterX());
            line3.setEndY(pointA.getCenterY());
            double angles[] = test(pointA, pointB, pointC);
            lblA.setText(Double.toString(angles[0]));
            lblA.relocate(pointA.getCenterX(), pointA.getCenterY());
            lblB.setText(Double.toString(angles[1]));
            lblC.setText(Double.toString(angles[2]));
        });

        pointB.setOnMouseDragged(e -> {
            pointB.setCenterX(e.getX());
            if(pointB.getCenterX() > 350){
                pointB.setCenterX(350);
            }
            if(pointB.getCenterX() < 150){
                pointB.setCenterX(150);
            }

            if (e.getY() < 250) {
                pointB.setCenterY(250 - Math.sqrt(10000 - (pointB.getCenterX() - 250) * (pointB.getCenterX() - 250)));
            }
            else {
                pointB.setCenterY(250 + Math.sqrt(10000 - (pointB.getCenterX() - 250) * (pointB.getCenterX() - 250)));
            }
            line1.setEndX(pointB.getCenterX());
            line1.setEndY(pointB.getCenterY());
            line2.setStartX(pointB.getCenterX());
            line2.setStartY(pointB.getCenterY());
            double angles[] = test(pointA, pointB, pointC);
            lblB.setText(Double.toString(angles[1]));
            lblB.relocate(pointB.getCenterX(), pointB.getCenterY());
            lblA.setText(Double.toString(angles[0]));
            lblC.setText(Double.toString(angles[2]));

        });

        pointC.setOnMouseDragged(e -> {
            pointC.setCenterX(e.getX());
            if(pointC.getCenterX() > 350){
                pointC.setCenterX(350);
            }
            if(pointC.getCenterX() < 150){
                pointC.setCenterX(150);
            }

            if (e.getY() < 250) {
                pointC.setCenterY(250 - Math.sqrt(10000 - (pointC.getCenterX() - 250) * (pointC.getCenterX() - 250)));
            }
            else {
                pointC.setCenterY(250 + Math.sqrt(10000 - (pointC.getCenterX() - 250) * (pointC.getCenterX() - 250)));
            }
            line2.setEndX(pointC.getCenterX());
            line2.setEndY(pointC.getCenterY());
            line3.setStartX(pointC.getCenterX());
            line3.setStartY(pointC.getCenterY());
            double angles[] = test(pointA, pointB, pointC);
            lblC.setText(Double.toString(angles[2]));
            lblC.relocate(pointC.getCenterX(), pointC.getCenterY());
            lblA.setText(Double.toString(angles[0]));
            lblB.setText(Double.toString(angles[1]));
        });


        // Create a scene and place it in the stage
        Scene scene = new Scene(pane, 500, 500);
        primaryStage.setTitle("Question 3"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage
    }

    /**
     * The main method is only needed for the IDE with limited
     * JavaFX support. Not needed for running from the command line.
     */
    public static void main(String[] args) {
        launch(args);
    }

    public double[] test(Circle pointA, Circle pointB, Circle pointC){
        double a = Math.sqrt(Math.pow((pointC.getCenterX() - pointB.getCenterX()), 2) +  Math.pow((pointC.getCenterY() - pointB.getCenterY()), 2));
        double b = Math.sqrt(Math.pow((pointC.getCenterX() - pointA.getCenterX()), 2) +  Math.pow((pointC.getCenterY() - pointA.getCenterY()), 2));
        double c = Math.sqrt(Math.pow((pointB.getCenterX() - pointA.getCenterX()), 2) +  Math.pow((pointB.getCenterY() - pointA.getCenterY()), 2));
        double angleA = Math.round(Math.acos((a * a - b * b - c * c) / (-2 * b * c)) * (180 / Math.PI));
        double angleB = Math.round(Math.acos((b * b - a * a - c * c) / (-2 * a * c)) * (180 / Math.PI));
        double angleC = Math.round(Math.acos((c * c - b * b - a * a) / (-2 * a * b)) * (180 / Math.PI));
        double angles[] = {angleA, angleB, angleC};
        return angles;
    }
}

