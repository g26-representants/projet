package projet.view.boldair;

import javax.inject.Inject;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.util.converter.IntegerStringConverter;
import jfox.javafx.util.ConverterStringInteger;
import jfox.javafx.util.ListenerFocusValidation;
import jfox.javafx.view.IManagerGui;
import projet.data.Boldair;
import projet.view.EnumView;


public class ControllerBoldairForm {

	
	// Composants de la vue
	
	@FXML
	private TextField		textFieldId;
	@FXML
	private TextField		textFieldRavitaillement;
	@FXML
	private TextField		textFieldParking;
	@FXML
	private TextField		textFieldDossards;
	@FXML
	private TextField		textFieldBuvette;
	@FXML
	private TextField		textFieldRepas;
	@FXML
	private TextField		textFieldSignaleur;

	
	// Autres champs
	
	@Inject
	private IManagerGui		managerGui;
	@Inject
	private ModelBoldair	modelBoldair;


	// Initialisation du Controller

	@FXML
	private void initialize() {

		// Data binding
		
		Boldair courant = modelBoldair.getCourant();

		textFieldId.textProperty().bindBidirectional( courant.idProperty(), new IntegerStringConverter()  );

		
		textFieldRavitaillement.textProperty().bindBidirectional( courant.ravitaillementProperty(), new ConverterStringInteger( "###0" ) );
		textFieldRavitaillement.focusedProperty().addListener( new ListenerFocusValidation( courant.ravitaillementProperty()  ));
		
		textFieldParking.textProperty().bindBidirectional( courant.parkingProperty(), new ConverterStringInteger( "###0" ) );
		textFieldParking.focusedProperty().addListener( new ListenerFocusValidation( courant.parkingProperty()  ));
		
		textFieldDossards.textProperty().bindBidirectional( courant.dossardsProperty(), new ConverterStringInteger( "###0" ) );
		textFieldDossards.focusedProperty().addListener( new ListenerFocusValidation( courant.dossardsProperty()  ));
		
		textFieldBuvette.textProperty().bindBidirectional( courant.buvetteProperty(), new ConverterStringInteger( "###0" ) );
		textFieldBuvette.focusedProperty().addListener( new ListenerFocusValidation( courant.buvetteProperty()  ));
		
		textFieldRepas.textProperty().bindBidirectional( courant.repasProperty(), new ConverterStringInteger( "###0" ) );
		textFieldRepas.focusedProperty().addListener( new ListenerFocusValidation( courant.repasProperty()  ));
		
		textFieldSignaleur.textProperty().bindBidirectional( courant.signaleurProperty(), new ConverterStringInteger( "###0" ) );
		textFieldSignaleur.focusedProperty().addListener( new ListenerFocusValidation( courant.signaleurProperty()  ));
		
	}
	
	
	// Actions
	
	@FXML
	private void doAnnuler() {
		managerGui.showView( EnumView.BoldairListe );
	}
	
	@FXML
	private void doValider() {
		modelBoldair.validerMiseAJour();
		managerGui.showView( EnumView.BoldairListe );
	}
	
}
