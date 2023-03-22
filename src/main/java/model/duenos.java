package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class duenos {

	private String nombreDue�o;
	private String dni;
	
	
	public duenos(String string, String string2) {
		// TODO Auto-generated constructor stub
	}
	public String getNombreDue�o() {
		return nombreDue�o;
	}
	public void setNombreDue�o(String nombreDue�o) {
		this.nombreDue�o = nombreDue�o;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}

	
	public List<duenos> getOwners() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<duenos> owners = new ArrayList<>();

        try {
            conn = getConnection();
            String sql = "SELECT nombre, dni FROM owners";
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                duenos owner = new duenos(rs.getString("nombre"), rs.getString("dni"));
                owners.add(owner);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResultSet(rs);
            closeStatement(stmt);
            closeConnection(conn);
        }

        return owners;
    }

}
