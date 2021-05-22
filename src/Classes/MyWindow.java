package Classes;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class MyWindow {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btn_start;

    @FXML
    private TextField textBox_Binary;

    @FXML
    private TextField textBox_Decimal;

    private String binaryToDecimal(String number){
        return binaryToDecimal(Integer.parseInt(number));
    }

    private String binaryToDecimal(int number){
        double result = 0;
        int[] myNumber = new int[String.valueOf(number).length()];
        for (int i = 0; i < String.valueOf(number).length(); i++)
            myNumber[i] = Integer.parseInt(String.valueOf(String.valueOf(number).toCharArray()[i]));
        for (int i = 0; i < String.valueOf(number).length(); i++){
            result += (Math.pow(2,i)) * myNumber[i];
        }
        return String.valueOf(result);
    }

    private String decimalToBinary(String number){
        return decimalToBinary(Integer.parseInt(number));
    }

    private String decimalToBinary(int number){
        StringBuilder result = new StringBuilder();

        do{
            result.append(number % 2);
            if(number/2==0) break;
            number /= 2;
        } while(true);
        result.reverse();
        return result.toString();
    }

    @FXML
    void initialize() {
        assert btn_start != null : "fx:id=\"btn_start\" was not injected: check your FXML file 'MyWindow.fxml'.";
        assert textBox_Binary != null : "fx:id=\"textBox_Binary\" was not injected: check your FXML file 'MyWindow.fxml'.";
        assert textBox_Decimal != null : "fx:id=\"textBox_Decimal\" was not injected: check your FXML file 'MyWindow.fxml'.";

    }

    public void Start(ActionEvent actionEvent) {
        String[] numbers = {"",""};
        //numbers[0] = binaryToDecimal(textBox_Binary.getText());
        numbers[1] = decimalToBinary(textBox_Decimal.getText());

        //textBox_Decimal.setText(numbers[0]);
        textBox_Binary.setText(numbers[1]);
    }
}
