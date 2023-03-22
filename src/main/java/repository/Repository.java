package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectionH2;
import connection.ConnectionManager;
import model.animales;
import model.duenos;
import model.DuenoAnimalDto;

public class Repository {

	private static final String SQL_SEARCH = "SELECT USER.name, CLASSROOM.name FROM USER INNER JOIN CLASSROOM ON USER.course=CLASSROOM.id;";
	private static final String jdbcUrl = "jdbc:h2:file:./src/main/resources/test";
	ConnectionManager manager = new ConnectionH2();
	
	
	public duenos search(duenos duenoFormulario) {
		duenos userInDatabase = null;
		ResultSet resultSet = null;
		PreparedStatement prepareStatement = null;
		Connection conn = manager.open(jdbcUrl);
		try {
			prepareStatement = conn.prepareStatement("SELECT * FROM USER WHERE name = ?");
			prepareStatement.setString(1, duenoFormulario.getNombreDue�o());
			resultSet = prepareStatement.executeQuery();
			while (resultSet.next()) {
				userInDatabase = new duenos();
				userInDatabase.setNombreDue�o(resultSet.getString(1));
				userInDatabase.setMascota(resultSet.getInt(2));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			close(resultSet);
			close(prepareStatement);

		}
		manager.close(conn);
		return userInDatabase;
	}
	
	
	private void close(PreparedStatement prepareStatement) {
		if (null != prepareStatement) {
			try {
				prepareStatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
				throw new RuntimeException(e);
			}
		}
	}

	private void close(ResultSet resultSet) {
		if (null != resultSet) {

			try {
				resultSet.close();
			} catch (SQLException e) {
				e.printStackTrace();
				throw new RuntimeException(e);
			}
		}
	}
	
	
	public void insert(duenos userFormulario) {
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conn
					.prepareStatement("INSERT INTO USER (name)" + "VALUES (?)");
			preparedStatement.setString(1, userFormulario.getNombreDue�o());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			close(preparedStatement);
		}

		manager.close(conn);
	}

	public void update(duenos userFormulario) {
		Connection conn = manager.open(jdbcUrl);

		// codigo sql que inserta un usuario :P
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conn
					.prepareStatement("UPDATE USER SET name = ? WHERE name = ?");
			preparedStatement.setString(1, userFormulario.getNombreDue�o());
			preparedStatement.setString(2, userFormulario.getNombreDue�o());

			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			close(preparedStatement);
			manager.close(conn);
		}

	}
	

	public List<DuenoAnimalDto> searchAll() {
		List<DuenoAnimalDto> listUsers = new ArrayList<DuenoAnimalDto>();
		Connection conn = manager.open(jdbcUrl);
		ResultSet resultSet = null;
		PreparedStatement prepareStatement = null;
		try {
			prepareStatement = conn.prepareStatement(SQL_SEARCH);
			resultSet = prepareStatement.executeQuery();
			while (resultSet.next()) {
				DuenoAnimalDto dto = new DuenoAnimalDto();
				dto.setDuenoName(resultSet.getString(1));
				dto.setAnimalName(resultSet.getString(2));
				listUsers.add(dto);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			close(resultSet);
			close(prepareStatement);
			manager.close(conn);
		}

		return listUsers;
	}

}
