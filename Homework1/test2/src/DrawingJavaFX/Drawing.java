package DrawingJavaFX;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

public class Drawing extends Application {

    @Override
    public void start(Stage primaryStage) {
        Group group = new Group(); // Create a layout Panel
        Scene scene = new Scene(group, 300, 250);// Create the Scene

        // add content to the Layout panel
        double width = scene.getWidth(); // total width of the scene
        double height = scene.getHeight(); // total width of the scene

        double widthCopy = width;
        double heightCopy = height;

        for(int i = 290; i >= 0; i-=10) {
            Line line = new Line(0, i, widthCopy, height);
            widthCopy -= 10;
            line.setStroke(Color.BLUE);
            line.setStrokeWidth(1);
            group.getChildren().add(line);
        }

        widthCopy = width;

        for(int i = 290; i >= 0; i-=10)   {
            Line line = new Line(i, 0, width, heightCopy);
            heightCopy -= 10;
            line.setStroke(Color.BLUE);
            line.setStrokeWidth(1);
            group.getChildren().add(line);
        }
         //draw a line from the upper-left to the lower-right


        heightCopy = height;
// novoto
        for(int i = 290; i >= 0; i-=10) {
            Line line = new Line(width, height - heightCopy, i, height);
            heightCopy -= 10;
            line.setStroke(Color.BLUE);
            line.setStrokeWidth(1);
            group.getChildren().add(line);
        }

        

        // Set the title of the Stage(the application window)
        primaryStage.setTitle("Drawing shapes");
        // Add the Scene to the Stage
        primaryStage.setScene(scene);
        // Show the Stage (the application window)
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
