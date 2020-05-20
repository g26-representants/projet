package projet.view.application;

import javax.inject.Inject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import jfox.javafx.view.IManagerGui;
import projet.view.EnumView;


public class ControllerAdmin2 {

	
	// Composants de la vue
	
	@FXML
	private TextField		textFieldId;
	@FXML
	private TextField		textFieldNom;
	@FXML
	private TextField		textFieldAnneeCreation;
	@FXML
	private CheckBox		checkBoxSiege;

	
	// Autres champs
	
	@Inject
	private IManagerGui		managerGui;
	

	
	
	// Actions
	
	@FXML
	private void Retour() {
		managerGui.showView( EnumView.Accueil );
	}
	
	@FXML
	private void Sauvegarder(ActionEvent event) {
		managerGui.showView( EnumView.Vue3 );
	}
	

	
}
