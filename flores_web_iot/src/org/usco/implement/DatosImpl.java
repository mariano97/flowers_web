package org.usco.implement;

import java.util.ArrayList;
import java.util.List;

import org.usco.conexion.ConexionMongo;
import org.usco.dao.DatosDAO;
import org.usco.model.Datos;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

public class DatosImpl implements DatosDAO{

	@Override
	public void insertar(BasicDBObject dato) {
		
		ConexionMongo conexion = new ConexionMongo();
		
		DBCollection collection = conexion.getConexion().getCollection("dato");
		
		collection.insert(dato);
		
	}

	@Override
	public List<Datos> list() {
		
		ConexionMongo conexion = new ConexionMongo();
		
		DBCollection collection = conexion.getConexion().getCollection("dato");
		
		DBCursor cursor = collection.find();
		
		List<Datos> datos = new ArrayList<>();
		
		while(cursor.hasNext()) {
			
			Datos dato = new Datos();
			
			DBObject db = cursor.next();
			
			dato.setSl((double)db.get("sl"));
			dato.setSw((double)db.get("sw"));
			dato.setPl((double)db.get("pl"));
			dato.setPw((double)db.get("pw"));
			dato.setCategoria((String)db.get("categoria"));
			datos.add(dato);
		}
		
		return datos;
	}

}
