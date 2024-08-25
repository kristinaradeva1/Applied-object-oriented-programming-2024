package problem1;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class RouteCipherController {
    private RouteCipher routeCipher;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Text txtRouteCipher;

    @FXML
    private Label lblCipherKey;

    @FXML
    private TextArea txaDecrypt;

    @FXML
    private TextArea txaEncrypt;

    @FXML
    private Button btnEncrypt;

    @FXML
    private Button btnDecrypt;

    @FXML
    private Button btnQuit;

    @FXML
    private TextField txtFKey;

    @FXML
    void btnDecryptOnClick(ActionEvent event) {
        // Get the text from txaDecrypt
        String ciphertext = txaDecrypt.getText();

        // Decrypt the text
        String decryptedText = routeCipher.decrypt(ciphertext);

        // Set the decrypted text to txaResults
        txaDecrypt.setText(decryptedText);
    }

    @FXML
    void btnEncryptOnClick(ActionEvent event) {
        // Get the text from txaEncrypt
        String plaintext = txaEncrypt.getText();

        // Encrypt the text
        String encryptedText = routeCipher.encrypt(plaintext);

        // Set the encrypted text to txaResults
        txaDecrypt.setText(encryptedText);
    }

    @FXML
    void btnQuitOnClick(ActionEvent event) {
        Platform.exit();
    }

    @FXML
    void initialize() {
        assert txtRouteCipher != null : "fx:id=\"txtRouteCipher\" was not injected: check your FXML file 'view-routecipher.fxml'.";
        assert lblCipherKey != null : "fx:id=\"lblCipherKey\" was not injected: check your FXML file 'view-routecipher.fxml'.";
        assert txaDecrypt != null : "fx:id=\"txaDecrypt\" was not injected: check your FXML file 'view-routecipher.fxml'.";
        assert txaEncrypt != null : "fx:id=\"txaEncrypt\" was not injected: check your FXML file 'view-routecipher.fxml'.";
        assert btnEncrypt != null : "fx:id=\"btnEncrypt\" was not injected: check your FXML file 'view-routecipher.fxml'.";
        assert btnDecrypt != null : "fx:id=\"btnDecrypt\" was not injected: check your FXML file 'view-routecipher.fxml'.";
        assert btnQuit != null : "fx:id=\"btnQuit\" was not injected: check your FXML file 'view-routecipher.fxml'.";
        assert txtFKey != null : "fx:id=\"txtFKey\" was not injected: check your FXML file 'view-routecipher.fxml'.";

        routeCipher = new RouteCipher(5);
    }
}