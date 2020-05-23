package projet.data;

import java.util.Objects;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.Property;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;


public class Boldair {
	private final Property<Integer>		id				= new SimpleObjectProperty<>();
	private final Property<Integer>		ravitaillement	= new SimpleObjectProperty<>();
	private final Property<Integer>		parking	= new SimpleObjectProperty<>();
	private final Property<Integer>		dossards	= new SimpleObjectProperty<>();
	private final Property<Integer>		buvette	= new SimpleObjectProperty<>();
	private final Property<Integer>		repas	= new SimpleObjectProperty<>();
	private final Property<Integer>		signaleur	= new SimpleObjectProperty<>();
	
	public final Property<Integer> idProperty() {
		return this.id;
	}
	
	public final Integer getId() {
		return this.idProperty().getValue();
	}
	
	public final void setId(final Integer id) {
		this.idProperty().setValue(id);
	}
	
	public final Property<Integer> ravitaillementProperty() {
		return this.ravitaillement;
	}
	
	public final Integer getRavitaillement() {
		return this.ravitaillementProperty().getValue();
	}
	
	public final void setRavitaillement(final Integer ravitaillement) {
		this.ravitaillementProperty().setValue(ravitaillement);
	}
	

	public final Property<Integer> parkingProperty() {
		return this.parking;
	}
	
	public final Integer getParking() {
		return this.parkingProperty().getValue();
	}
	
	public final void setParking(final Integer parking) {
		this.parkingProperty().setValue(parking);
	}
	
	public final Property<Integer> dossardsProperty() {
		return this.dossards;
	}
	
	public final Integer getDossards() {
		return this.dossardsProperty().getValue();
	}
	
	public final void setDossards(final Integer dossards) {
		this.dossardsProperty().setValue(dossards);
	}
	
	public final Property<Integer> buvetteProperty() {
		return this.buvette;
	}
	
	public final Integer getBuvette() {
		return this.buvetteProperty().getValue();
	}
	
	public final void setBuvette(final Integer buvette) {
		this.buvetteProperty().setValue(buvette);
	}
	
	public final Property<Integer> repasProperty() {
		return this.repas;
	}
	
	public final Integer getRepas() {
		return this.repasProperty().getValue();
	}
	
	public final void setRepas(final Integer repas) {
		this.repasProperty().setValue(repas);
	}
	
	public final Property<Integer> signaleurProperty() {
		return this.signaleur;
	}
	
	public final Integer getSignaleur() {
		return this.signaleurProperty().getValue();
	}
	
	public final void setSignaleur(final Integer signaleur) {
		this.signaleurProperty().setValue(signaleur);
	}
	
	// hashCode() & equals()

	@Override
	public int hashCode() {
		return Objects.hash(id.getValue());
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Boldair other = (Boldair) obj;
		return Objects.equals(id.getValue(), other.id.getValue());
	}

	
}
