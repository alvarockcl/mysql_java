package cl.fuentes.app;

import java.sql.ResultSet;

import cl.fuentes.db.Mysqlconn;

public class App 
{
    public static void main( String[] args )
    {
    	ResultSet resultSet = null;
    	    	
    	Mysqlconn mc = new Mysqlconn("localhost", "basedatos", "usuario", "clave");
    	try {
        	mc.open();
        	resultSet = mc.ejecutarQuery("select * ......");
        	mc.obtenerColumnas(resultSet);
        	mc.mostrarQuery(resultSet);
        	mc.ejecutarUpdate("delete .....");
        	mc.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
    }

}
