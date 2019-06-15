package application;

import javafx.scene.control.Alert;

public class Alertas {
	 public void alertas(){
	        Alert alert = new Alert(Alert.AlertType.ERROR);
	        alert.setTitle("Error:)");
	        alert.setHeaderText(null);
	        alert.setContentText("Dejaste campos sin rellenar");

	        alert.showAndWait();
	    }
}
