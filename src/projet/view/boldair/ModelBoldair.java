package projet.view.boldair;

import javax.inject.Inject;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import jfox.commun.exception.ExceptionValidation;
import jfox.javafx.util.UtilFX;
import projet.commun.IMapper;
import projet.dao.DaoBoldair;
import projet.data.Boldair;


public class ModelBoldair  {
	
	
	// Données observables 
	
	private final ObservableList<Boldair> liste = FXCollections.observableArrayList(); 
	
	private final Boldair	courant = new Boldair();

	
	// Autres champs
    @Inject
	private IMapper			mapper;
    @Inject
	private DaoBoldair		daoBoldair;
	
	
	// Getters 
	
	public ObservableList<Boldair> getListe() {
		return liste;
	}
	
	public Boldair getCourant() {
		return courant;
	}
	
	
	// Actualisations
	
	public void actualiserListe() {
		liste.setAll( daoBoldair.listerTout() );
 	}


	// Actions
	
	public void preparerAjouter() {
		mapper.update( courant, new Boldair() );
	}
	
	public void preparerModifier( Boldair item ) {
		mapper.update( courant, daoBoldair.retrouver( item.getId() ) );
	}
	
	
	public void validerMiseAJour() {

		// Vérifie la validité des données
		
		StringBuilder message = new StringBuilder();


		if( courant.getAnneeBoldair() != null ) {
			if ( courant.getAnneeBoldair() < 1900  
					|| courant.getAnneeBoldair() > 2100 ) {
				message.append( "\nValeur incorrecte pour l'année de création." );
			}
		}
		
		if( courant.getRavitaillement() != null ) {
			if ( courant.getRavitaillement() < 0  
					|| courant.getRavitaillement() > 400 ) {
				message.append( "\nValeur incorrecte." );
			}
		}

		if( courant.getParking() != null ) {
			if ( courant.getParking() < 0  
					|| courant.getParking() > 400 ) {
				message.append( "\nValeur incorrecte." );
			}
		}
		
		if( courant.getDossards() != null ) {
			if ( courant.getDossards() < 0  
					|| courant.getDossards() > 400 ) {
				message.append( "\nValeur incorrecte." );
			}
		}
		
		if( courant.getBuvette() != null ) {
			if ( courant.getBuvette() < 0  
					|| courant.getBuvette() > 400 ) {
				message.append( "\nValeur incorrecte." );
			}
		}
		
		if( courant.getRepas() != null ) {
			if ( courant.getRepas() < 0  
					|| courant.getRepas() > 400 ) {
				message.append( "\nValeur incorrecte." );
			}
		}
		
		if( courant.getSignaleur() != null ) {
			if ( courant.getSignaleur() < 0  
					|| courant.getSignaleur() > 400 ) {
				message.append( "\nValeur incorrecte." );
			}
		}
		
		
		
		
		if ( message.length() > 0 ) {
			throw new ExceptionValidation( message.toString().substring(1) );
		}
		
		
		// Effectue la mise à jour
		
		if ( courant.getId() == null ) {
			// Insertion
			courant.setId( daoBoldair.inserer( courant ) );
		} else {
			// modficiation
			daoBoldair.modifier( courant );
		}
	}
	
	
	public void supprimer( Boldair item ) {
		
		daoBoldair.supprimer( item.getId() );
		System.out.println( UtilFX.findNext( liste, item ) );
		mapper.update( courant, UtilFX.findNext( liste, item ) );
	}
	
}
