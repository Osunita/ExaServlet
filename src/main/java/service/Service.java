package service;

import java.sql.Connection;
import java.util.Date;
import java.util.List;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


import connection.ConnectionH2;
import connection.ConnectionManager;
import model.duenos;
import model.DuenoAnimalDto;
import model.animales;
import model.assembler.DuenoAssembler;
import repository.Repository;

public class Service {
	
	
	private Repository repository = new Repository();
	
	
	public duenos assembleUserFromRequest(HttpServletRequest req) {
		return DuenoAssembler.assembleUserFrom(req);
	}

	public void insertOrUpdate(duenos userFormulario) {
		duenos userInDatabase = repository.search(userFormulario);
		if(null == userInDatabase){
			repository.insert(userFormulario);
		}else{
			repository.update(userFormulario);
		}
	}
	
	
	public List<DuenoAnimalDto> listAllUsers() {
		return repository.searchAll();
	}
	

	public Repository getRepository() {
		return repository;
	}

	public void setRepository(Repository repository) {
		this.repository = repository;
	}
	
	
	

}
