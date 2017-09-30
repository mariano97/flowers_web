package org.usco.rest;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;

import org.usco.dao.DatosDAO;
import org.usco.implement.DatosImpl;
import org.usco.model.Datos;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.POST;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;


/**
 * REST Web Service
 *
 * @author Johnfe Vargas
 */
@Path("classjson")
public class JsonClase {

    @Context
    private UriInfo context;

    @GET
    @Path("/datosJson")
    //@Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public List<Datos> Json(){

    	
    	
    	DatosDAO dao = new DatosImpl();
    	List<Datos> lista = dao.list();
    	
    	int iset = 0;
    	int ivirg = 0;
    	int iversi = 0;
    	double isetsl = 0.0;
    	double isetsw = 0.0;
    	double isetpl = 0.0;
    	double isetpw = 0.0;
    	
    	double ivirgsl = 0.0;
    	double ivirgsw = 0.0;
    	double ivirgpl = 0.0;
    	double ivirgpw = 0.0;
    	
    	double iversisl = 0.0;
    	double iversisw = 0.0;
    	double iversipl = 0.0;
    	double iversipw = 0.0;
    	
    	for(Datos d: lista) {
    		
    		if(d.getCategoria().equals("Iris-setosa")) {
    			
    			iset ++;
    			isetsl += d.getSl();
    			isetsw += d.getSw();
    			isetpl += d.getPl();
    			isetpw += d.getPw();
    			
    		}
    		
    		if(d.getCategoria().equals("Iris-versicolor")) {
    			
    			iversi ++;
    			iversisl += d.getSl();
    			iversisw += d.getSw();
    			iversipl += d.getPl();
    			iversipw += d.getPw();
    			
    		}
    		
    		if(d.getCategoria().equals("Iris-virginica")) {
    			
    			ivirg ++;
    			ivirgsl += d.getSl();
    			ivirgsw += d.getSw();
    			ivirgpl += d.getPl();
    			ivirgpw += d.getPw();
    			
    		}
    		
    	}
    	
    	double pisetsl = 0.0;
    	double pisetsw = 0.0;
    	double pisetpl = 0.0;
    	double pisetpw = 0.0;
    	
    	double pivirgsl = 0.0;
    	double pivirgsw = 0.0;
    	double pivirgpl = 0.0;
    	double pivirgpw = 0.0;
    	
    	double piversisl = 0.0;
    	double piversisw = 0.0;
    	double piversipl = 0.0;
    	double piversipw = 0.0;
    	
    	if(iset != 0) {
    		
    		pisetsl = isetsl/iset;
        	pisetsw = isetsw/iset;
        	pisetpl = isetpl/iset;
        	pisetpw = isetpw/iset;
        	
    		
    	}
    	
    	if(ivirg != 0) {
    		
    		pivirgsl = ivirgsl/ivirg;
        	pivirgsw = ivirgsw/ivirg;
        	pivirgpl = ivirgpl/ivirg;
        	pivirgpw = ivirgpw/ivirg;
        	
    		
    	}
    	
    	if(iversi != 0) {
    		
    		piversisl = iversisl/iversi;
        	piversisw = iversisw/iversi;
        	piversipl = iversipl/iversi;
        	piversipw = iversipw/iversi;
        	
    		
    	}
    	
    	List<Datos> listjson = new ArrayList<>();
    	
    	
    	
    	//Map <String, Datos> maping = new HashMap<String, Datos>();
    	
    	Datos dato1 = new Datos();
    	Datos dato2 = new Datos();
    	Datos dato3 = new Datos();
    	
    	dato1.setCategoria("Iris-virginica");
    	dato1.setSl(pivirgsl);
    	dato1.setSw(pivirgsw);
    	dato1.setPl(pivirgpl);
    	dato1.setPw(pivirgpw);
    	
    	
    	dato2.setCategoria("Iris-versicolor");
    	dato2.setSl(piversisl);
    	dato2.setSw(piversisw);
    	dato2.setPl(piversipl);
    	dato2.setPw(piversipw);
    	
    	dato3.setCategoria("Iris-setosa");
    	dato3.setSl(pisetsl);
    	dato3.setSw(pisetsw);
    	dato3.setPl(pisetpl);
    	dato3.setPw(pisetpw);
    	
    	/*maping.put("valor1", dato1);
    	maping.put("dato2", dato2);
    	maping.put("dato3", dato3);*/
    	
    	listjson.add(dato1);
    	listjson.add(dato2);
    	listjson.add(dato3);
    	
    	System.out.println("virginica  " + dato1.getCategoria());
    	System.out.println(pivirgsl +"  "+ dato1.getSl() + " , " + pivirgsw + "  "+ dato1.getSw() + " ," + pivirgpl + "  "+ dato1.getPl() +" , "+ pivirgpw + "  " + dato1.getPw());
    	
    	System.out.println("setosa" + dato3.getCategoria());
    	System.out.println(pisetsl +"  "+ dato3.getSl() + " , " + pisetsw + "  "+ dato3.getSw() + " ," + pisetpl + "  "+ dato3.getPl() +" , "+ pisetpw + "  " + dato3.getPw());
    	
    	System.out.println("versicolor" + dato2.getCategoria());
    	System.out.println(piversisl +"  "+ dato2.getSl() + " , " + piversisw + "  "+ dato2.getSw() + " ," + piversipl + "  "+ dato2.getPl() +" , "+ piversipw + "  " + dato2.getPw());
    	
    	
    	
    	return listjson;
    	
    }
    
    
    
}
