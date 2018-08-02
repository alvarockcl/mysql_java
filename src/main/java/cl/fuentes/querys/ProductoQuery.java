package cl.fuentes.querys;

import java.sql.SQLException;

import cl.fuentes.db.Mysqlconn;
import cl.fuentes.modelo.Producto;

public class ProductoQuery implements Crud<Producto>{

    private Mysqlconn con;
	
	public ProductoQuery(Mysqlconn con){
		this.con = con;
	}
	
	@Override
	public void create(Producto objeto) {
		String txtsql = "insert into producto"
				+ " (producto, precio) values ('"+objeto.getProducto()+"',"+objeto.getPrecio()+")";
		try {
			con.ejecutarUpdate(txtsql);
			//con.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public Producto read(String valor) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Producto objeto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(String valor) {
		// TODO Auto-generated method stub
		
	}

}
