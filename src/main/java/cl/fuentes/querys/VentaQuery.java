package cl.fuentes.querys;

import java.sql.SQLException;

import cl.fuentes.db.Mysqlconn;
import cl.fuentes.modelo.Venta;

public class VentaQuery implements Crud<Venta> {

	Mysqlconn conn;
	
	public VentaQuery(Mysqlconn con) {
		conn = con;
	}
	
	
	@Override
	public void create(Venta objeto) {
		String txtsql ="INSERT INTO venta (fechadocumento,"
				+ "cantidad,codproducto,codcliente,totalventa) VALUES ("
				+ "'"+objeto.getFechadocumento()
				+"' ,"+objeto.getCantidad()
				+","+objeto.getCodProducto()
				+","+objeto.getCodCliente()
				+","+objeto.getTotalVenta()+")";
		try {
			conn.ejecutarUpdate(txtsql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("No se pudo registrar la venta|");
		}
		
	}

	@Override
	public Venta read(String valor) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Venta objeto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(String valor) {
		// TODO Auto-generated method stub
		
	}

	
	
}
