package problem1;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class CalculatorController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtInputOutput;

    @FXML
    private Button bntOff;

    @FXML
    void btnOffOnClick(ActionEvent event) {
//        txtInputOutput.setText("0");
//        String fieldInfo = txtInputOutput.getText();
//        txtInputOutput.setText(fieldInfo + "0");
        Platform.exit();
    }

    @FXML
    void initialize() {
        assert txtInputOutput != null : "fx:id=\"txtInputOutput\" was not injected: check your FXML file 'view-calculator.fxml'.";
        assert bntOff != null : "fx:id=\"bntOff\" was not injected: check your FXML file 'view-calculator.fxml'.";

    }
}

