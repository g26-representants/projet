package projet.view.application;

import javax.inject.Inject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import jfox.javafx.view.IManagerGui;
import jfox.start.ManagerGui;
import projet.view.EnumView;


public class ControllerAdmin1 {

	
	// Composants de la vue
	
	@FXML
	private Button  Ouvrir;
	
	// Autres champs
	
	@Inject
	private ManagerGui managerGui;
	
	// Actions
	
	@FXML
	private void Supprimer() {
		managerGui.exit();
	}
	
	@FXML
	private void Ouvrir(ActionEvent event) {
		managerGui.showView( EnumView.Vue2 );
	}
	
}
