package projet.view.application;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import javafx.scene.Parent;
import javafx.scene.Scene;
import jfox.commun.context.IContext;
import jfox.javafx.view.ManagerGuiAbstract;


public class ManagerGui extends ManagerGuiAbstract {

	
	// Champs
	
	@Inject
	private IContext		context;
	
	
	// Initialisation
	
	@PostConstruct
	public void init() {
		setFactoryController( context::getBeanNew );
		addRessourcesToClose( context );
	}
	
	
	// Actions

	@Override
	protected void configureStage()  {
		
		// Choisit la vue à afficher
		showView( EnumView.Accueil);
		
		
		
		// Configure le stage
		stage.setTitle( "Accueil Bol d'Air" );
		stage.sizeToScene();
		stage.setResizable( false );
//		stage.getIcons().add(new Image(getClass().getResource("images/icone.png").toExternalForm()));

		// Configuration par défaut pour les boîtes de dialogue
//		typeConfigDialogDefault = ConfigDialog.class;
	}


	@Override
	public Scene createScene( Parent root ) {
		Scene scene = new Scene( root );
//		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		return scene;
	}
	
}