package application;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.input.DragEvent;

public class BMICalculatorController {

    @FXML
    private JFXTextField weightInput;

    @FXML
    private JFXTextField heightInput;

    @FXML
    private JFXButton buttonCalculate;

    @FXML
    private JFXTextField bmiOutput;

    @FXML
    private JFXTextField statusOutput;

    @FXML
    void calculate(ActionEvent event) {
    	
    	try {
    		Double weightValue = Double.parseDouble(weightInput.getText());
    		Double heightValue = Double.parseDouble(heightInput.getText());
    		
    		Double weightMetric = weightValue * 0.45;
    		Double heightMetric = (heightValue * 0.025)*(heightValue * 0.025);
    		Double bmiValue = weightMetric / heightMetric;
    		weightInput.setText("Weight (pounds)");
    		heightInput.setText("Height (inches)");
    		setResult(bmiValue);
    	} catch(Exception e) {
    		
    	}

    }
    
    @FXML
    void clearWeightText(DragEvent event) {
    	weightInput.clear();
    }
    
    @FXML
    void clearHeightText(DragEvent event) {
    	heightInput.clear();
    }


	private void setResult(Double bmiValue) {
		// TODO Auto-generated method stub
		
		bmiOutput.setText(bmiValue.toString());
		if(bmiValue <= 18.5) {
			statusOutput.setText("Underweight");
		} else if(18.6 <= bmiValue && bmiValue <= 24.9) {
			statusOutput.setText("Normal weight");
		} else if(25 <= bmiValue && bmiValue <= 29.9) {
			statusOutput.setText("Overweight");
		} else {
			statusOutput.setText("Obese");
		}
		
	}

}
