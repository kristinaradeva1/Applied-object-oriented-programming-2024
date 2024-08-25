package problem1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextInputDialog;
import javafx.scene.effect.Light;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.stage.Stage;




    public class Geometry extends Application {

        public static void main(java.lang.String[] args) {
            launch(args);
        }

        @java.lang.Override
        public void start(Stage stage) {
            Group group = new Group();

            Scene scene = new Scene(group, 300,300);
            double height = scene.getHeight();
            double width = scene.getWidth();

            double centerX = height / 2;
            double centerY = width / 2;
            double radius = Math.min(width, height) / 3;

            Circle circle = new Circle(centerX, centerY, radius);
            circle.setFill(null);
            circle.setStroke(Color.BLACK);
            group.getChildren().add(circle);

            int x;
            TextInputDialog dialog = new TextInputDialog();
            dialog.setTitle("Input dialog");
            dialog.setHeaderText("Enter x between 0 and width");
            dialog.setContentText("x = ");
            String xString = dialog.showAndWait().get();
            x = Integer.parseInt(xString);

            if(x < 0) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("x invalid");
                alert.setContentText("Enter new x! ");
                alert.showAndWait();
            }

            Line line = new Line(x, 0, x, height );
            line.setStroke(Color.RED);
            group.getChildren().add(line);

            Text text = new Text(centerX, centerY, "center");
            group.getChildren().add(text);

            Light.Point firstIntersectionPoint;
            Light.Point secondIntersectionPoint;
            // Set the Window title
            stage.setTitle("Drawing scene");
            stage.sizeToScene();
            stage.resizableProperty().setValue(java.lang.Boolean.FALSE);
            stage.setScene(scene);
            stage.show();
        }

    }