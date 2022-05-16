package it.polito.tdp.borders.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import it.polito.tdp.borders.model.Border;
import it.polito.tdp.borders.model.Country;

public class BordersDAO {

	public List<Country> loadAllCountries() {

		String sql = "SELECT ccode, StateAbb, StateNme FROM country ORDER BY StateAbb";
		List<Country> result = new ArrayList<Country>();
		
		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				
				result.add(new Country(rs.getInt("ccode"), rs.getString("StateAbb"), rs.getString("StateNme")));
				//System.out.format("%d %s %s\n", rs.getInt("ccode"), rs.getString("StateAbb"), rs.getString("StateNme"));
			}
			
			conn.close();
			return result;

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Errore connessione al database");
			throw new RuntimeException("Error Connection Database");
		}
	}

	public List<Border> getCountryPairs(int anno) {

		String sql = "select confini.`state1no`, confini.`state2no`, confini.`state1ab`, confini.`state2ab` "
				+ "from contiguity as confini "
				+ "where confini.year <= ? and confini.`conttype`= 1";
		
	List<Border> coppieConfini = new ArrayList<>();
		
		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1, anno);
			ResultSet rs = st.executeQuery();

			while(rs.next()) {
				
				coppieConfini.add(new Border(rs.getInt("state1no"),rs.getInt("state2no"), rs.getString("state1ab"), rs.getString("state2ab")));
				// System.out.format("%d %s %s\n", rs.getInt("ccode"), rs.getString("StateAbb"), rs.getString("StateNme"));
				
			}
			
			conn.close();
			return coppieConfini;

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Errore connessione al database");
			throw new RuntimeException("Error Connection Database");
			
		}
		
		
	}
}
