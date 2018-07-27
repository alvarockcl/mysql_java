package cl.fuentes.app;

import java.sql.ResultSet;

import cl.clase.modelo.Usuario;
import cl.clase.querys.UsuarioQuery;
import cl.fuentes.db.Mysqlconn;

public class App 
{
    public static void main( String[] args ) throws Exception
    {
    	/*
    	ResultSet resultSet = null;
    	    	
    	Mysqlconn mc = new Mysqlconn("localhost", "ventas", "root", "1234");
    	try {
        	mc.open();
        	resultSet = mc.ejecutarQuery("select * from usuario");
        	//mc.obtenerColumnas(resultSet);
        	mc.mostrarQuery(resultSet);
        	//mc.ejecutarUpdate("delete .....");
        	mc.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
    	Usuario usuario = new Usuario("Carlos","5555","Carlos Tapia");
    	UsuarioQuery uq = new UsuarioQuery();
    	uq.create(usuario);
    	*/
    	//Usuario u = new Usuario();
    	UsuarioQuery uq = new UsuarioQuery();
    	uq.delete("pamela");
    	//System.out.println(u.getUsuario() + " " + u.getClave() + " " + u.getNombre());
    	
    }

}
