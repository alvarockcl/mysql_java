package cl.fuentes.app;

import cl.clase.view.Login;
import cl.fuentes.db.Mysqlconn;

public class App{
	
	private Mysqlconn con;
	
	public App() {
		con = new Mysqlconn("localhost", "ventas", "usuventas", "passventas");
		try {
			con.open();
		} catch (Exception e) {
			System.out.println("No se ha establecido la conexi�n a la db");
		}
	}
	
    public void iniciar(){
    	Login login = new Login(con);
    	login.setVisible(true);
    }

    public static void main( String[] args ){
    	App app = new App();
    	app.iniciar();
    }

}
