package projet.view;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import javafx.application.Platform;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import jfox.javafx.view.IManagerGui;
import projet.commun.Roles;
import projet.data.Compte;
import projet.report.EnumReport;
import projet.report.ManagerReport;
import projet.view.systeme.ModelConnexion;


public class MenuBarAppli extends MenuBar {

	
	// Champs
	
	private Menu	menuDonnees;
	private Menu	menuEtats;
	private Menu	menuTests;
	private Menu    menuBoldair;
	
	private MenuItem itemDeconnecter;

	private MenuItem itemCategories;
	private MenuItem itemComptes;
	
	@Inject
	private IManagerGui 	managerGui;
	@Inject
	private ManagerReport 	managerReport;
	@Inject
	private ModelConnexion	modelConnexion;	
	
	
	// Initialisation
	
	@PostConstruct
	public void init() {

		
		// Variables de travail
		Menu menu;
		MenuItem item;
		
		
		// Manu Syst�me
		
		menu =  new Menu( "Syst�me" );;
		this.getMenus().add(menu);
		
		item = new MenuItem( "Se d�connecter" );
		item.setOnAction(  (e) -> managerGui.showView( EnumView.Connexion )  );
		menu.getItems().add( item );
		itemDeconnecter = item;
		
		item = new MenuItem( "Quitter" );
		item.setOnAction(  (e) -> managerGui.exit()  );
		menu.getItems().add( item );

		
		// Manu Donn�es
		
		menu =  new Menu( "Donn�es" );;
		this.getMenus().add(menu);
		menuDonnees = menu;
		
		item = new MenuItem( "M�mos" );
		item.setOnAction(  (e) -> managerGui.showView( EnumView.MemoListe )  );
		menu.getItems().add( item );
		
		item = new MenuItem( "Inscription" );
		item.setOnAction(  (e) -> managerGui.showView( EnumView.InscriptionListe )  );
		menu.getItems().add( item );
		
		item = new MenuItem( "Services" );
		item.setOnAction(  (e) -> managerGui.showView( EnumView.ServiceListe )  );
		menu.getItems().add( item );
		
		item = new MenuItem( "Personnes" );
		item.setOnAction(  (e) -> managerGui.showView( EnumView.PersonneListe )  );
		menu.getItems().add( item );
		
		item = new MenuItem( "Cat�gories" );
		item.setOnAction(  (e) -> managerGui.showView( EnumView.CategorieListe )  );
		menu.getItems().add( item );
		itemCategories = item;
		
		item = new MenuItem( "Comptes" );
		item.setOnAction(  (e) -> managerGui.showView( EnumView.CompteListe )  );
		menu.getItems().add( item );
		itemComptes = item;

		
		// Manu Etats
		
		menu =  new Menu( "Etats" );;
		this.getMenus().add(menu);
		menuEtats = menu;
		
		item = new MenuItem( "Personnes par cat�gorie v1" );
		item.setOnAction(  (e) ->  
				managerGui.showDialog( EnumView.EtatPersonnesParCateogire1 ) );
		menu.getItems().add( item );
		
		item = new MenuItem( "Personnes par cat�gorie v2" );
		item.setOnAction(  (e) ->  
				managerGui.showDialog( EnumView.EtatPersonnesParCateogire2 ) );
		menu.getItems().add( item );
		
		item = new MenuItem( "Liste des personnes (PDF)" );
		item.setOnAction(  (e) ->  
				managerReport.openFilePdf( EnumReport.PersonnesListeSimple, null ) );
		menu.getItems().add( item );
		
		item = new MenuItem( "Liste des personnes (viewer)" );
		item.setOnAction(  (e) ->  
				managerReport.showViewer( EnumReport.PersonnesListeSimple, null ) );
		menu.getItems().add( item );
		
		item = new MenuItem( "Annuaire t�l�phonique" );
		item.setOnAction(  (e) ->  
//				managerReport.print( EnumReport.AnnuaireTelephone, null ) );
				managerReport.showViewer( EnumReport.AnnuaireTelephone, null ) );
		menu.getItems().add( item );
		
		item = new MenuItem( "Liste bol d'air" );
		item.setOnAction(  (e) ->  
				managerGui.showDialog( EnumView.BoldairListe ) );
		menu.getItems().add( item );
		

		
		// Menu Tests
		
		menu =  new Menu( "Tests" );;
		this.getMenus().add(menu);
		menuTests = menu;
		

		
		item = new MenuItem( "DaoCategorie" );
		item.setOnAction(  (e) -> managerGui.showView( EnumView.TestDaoCategorie )  );
		menu.getItems().add( item );
		
		item = new MenuItem( "DaoMemo" );
		item.setOnAction(  (e) -> managerGui.showView( EnumView.TestDaoMemo )  );
		menu.getItems().add( item );
		
		//item = new MenuItem( "DaoInscription" );
		//item.setOnAction(  (e) -> managerGui.showView( EnumView.TestDaoInscription )  );
		//menu.getItems().add( item );
		
		item = new MenuItem( "DaoService" );
		item.setOnAction(  (e) -> managerGui.showView( EnumView.TestDaoService )  );
		menu.getItems().add( item );
		
		item = new MenuItem( "DaoBoldair" );
		item.setOnAction(  (e) -> managerGui.showView( EnumView.TestDaoBoldair )  );
		menu.getItems().add( item );


		



		// Configuration initiale du menu
		configurerMenu( modelConnexion.getCompteActif() );

		// Le changement du compte connect� modifie automatiquement le menu
		modelConnexion.compteActifProperty().addListener( (obs) -> {
					Platform.runLater( () -> configurerMenu( modelConnexion.getCompteActif() ) );
				}
			); 
		
	}

	
	// M�thodes auxiliaires
	
	private void configurerMenu( Compte compteActif  ) {

		itemDeconnecter.setDisable(true);
		
		menuDonnees.setVisible(false);
		itemCategories.setVisible(false);
		itemComptes.setVisible(false);
		menuEtats.setVisible(false);
		menuTests.setVisible(false);
		menuEtats.setVisible(false);
		
		if( compteActif != null ) {
			itemDeconnecter.setDisable(false);
			if( compteActif.isInRole( Roles.UTILISATEUR) ) {
				menuDonnees.setVisible(true);
				menuEtats.setVisible(true);
			}
			if( compteActif.isInRole( Roles.ADMINISTRATEUR ) ) {
				menuDonnees.setVisible(true);
				itemCategories.setVisible(true);
				itemComptes.setVisible(true);
				menuTests.setVisible(true);
			}
		}
	}
	
}
