package org.usco.dao;

import java.util.List;

import org.usco.model.Datos;

import com.mongodb.BasicDBObject;

public interface DatosDAO {
	
	public void insertar(BasicDBObject dato);
	
	public List<Datos> list();

}
