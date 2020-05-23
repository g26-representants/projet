package projet.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import javax.inject.Inject;
import javax.sql.DataSource;

import jfox.dao.jdbc.UtilJdbc;
import projet.data.Boldair;
import projet.data.Service;

public class DaoBoldair {

	// Champs

	@Inject
	private DataSource		dataSource;
	
	// Actions

	public int inserer( Boldair boldair ) {

		Connection			cn		= null;
		PreparedStatement	stmt	= null;
		ResultSet 			rs		= null;
		String				sql;
		
		try {
			cn = dataSource.getConnection();
			sql = "INSERT INTO boldair ( ravitaillement, parking, dossards, buvette, repas, signaleur ) VALUES( ?, ?, ?, ?, ?, ? ) ";
			stmt = cn.prepareStatement( sql, Statement.RETURN_GENERATED_KEYS );
			stmt.setObject( 1, boldair.getRavitaillement() );
			stmt.setObject( 2, boldair.getParking() );
			stmt.setObject( 3, boldair.getDossards() );
			stmt.setObject( 4, boldair.getBuvette() );
			stmt.setObject( 5, boldair.getRepas() );
			stmt.setObject( 6, boldair.getSignaleur() );
			stmt.executeUpdate();

			// Récupère l'identifiant généré par le SGBD
			rs = stmt.getGeneratedKeys();
			rs.next();
			boldair.setId( rs.getObject( 1, Integer.class) );
			return boldair.getId();
	
		} catch ( SQLException e ) {
			throw new RuntimeException(e);
		} finally {
			UtilJdbc.close( rs, stmt, cn );
		}
	}
	
	public void modifier( Boldair boldair ) {

		Connection			cn		= null;
		PreparedStatement	stmt	= null;
		String				sql;

		try {
			cn = dataSource.getConnection();
			sql = "UPDATE boldair SET ravitaillement = ?, parking = ?, dossards = ?, buvette = ?, repas = ?, signaleur = ? = ? WHERE idboldair =  ?";
			stmt = cn.prepareStatement( sql );
			stmt.setObject( 1, boldair.getRavitaillement() );
			stmt.setObject( 2, boldair.getParking() );
			stmt.setObject( 3, boldair.getDossards() );
			stmt.setObject( 4, boldair.getBuvette() );
			stmt.setObject( 5, boldair.getRepas() );
			stmt.setObject( 6, boldair.getSignaleur() );
			stmt.setObject( 7, boldair.getId() );
			stmt.executeUpdate();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			UtilJdbc.close( stmt, cn );
		}
	}
	
	public void supprimer( int idBoldair ) {

		Connection			cn 		= null;
		PreparedStatement	stmt 	= null;
		String				sql;

		try {
			cn = dataSource.getConnection();
			sql = "DELETE FROM boldair WHERE idboldair = ? ";
			stmt = cn.prepareStatement( sql );
			stmt.setInt( 1, idBoldair );
			stmt.executeUpdate();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			UtilJdbc.close( stmt, cn );
		}
	}
	
	public Boldair retrouver( int idBoldair ) {

		Connection			cn 		= null;
		PreparedStatement	stmt	= null;
		ResultSet 			rs		= null;
		String				sql;

		try {
			cn = dataSource.getConnection();
			sql = "SELECT * FROM boldair WHERE idboldair = ?";
			stmt = cn.prepareStatement( sql );
			stmt.setInt(1, idBoldair);
			rs = stmt.executeQuery();

			if ( rs.next() ) {
				return construireBoldair( rs );
			} else {
				return null;
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			UtilJdbc.close( rs, stmt, cn );
		}
	}
	
	// Méthodes auxiliaires
	
	private Boldair construireBoldair( ResultSet rs ) throws SQLException {
		Boldair boldair = new Boldair();
		boldair.setId( rs.getObject( "idboldair", Integer.class ) );
		boldair.setRavitaillement( rs.getObject( "ravitaillement", Integer.class ) );
		boldair.setParking( rs.getObject( "parking", Integer.class ) );
		boldair.setDossards( rs.getObject( "dossards", Integer.class ) );
		boldair.setBuvette( rs.getObject( "buvette", Integer.class ) );
		boldair.setRepas( rs.getObject( "repas", Integer.class ) );
		boldair.setSignaleur( rs.getObject( "signaleur", Integer.class ) );
		return boldair;
	}

	public List<Boldair> listerTout() {

		Connection			cn 		= null;
		PreparedStatement	stmt 	= null;
		ResultSet 			rs		= null;
		String				sql;

		try {
			cn = dataSource.getConnection();
			sql = "SELECT * FROM boldair ORDER BY date";
			stmt = cn.prepareStatement( sql );
			rs = stmt.executeQuery();

			List<Boldair> boldair = new LinkedList<>();
			while (rs.next()) {
				boldair.add( construireBoldair( rs ) );
			}
			return boldair;

		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			UtilJdbc.close( rs, stmt, cn );
		}
	}
	
	
	
}

