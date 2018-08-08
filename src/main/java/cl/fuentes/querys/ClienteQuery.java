package cl.fuentes.querys;

import java.sql.ResultSet;
import java.sql.SQLException;

import cl.fuentes.db.Mysqlconn;
import cl.fuentes.modelo.Cliente;

public class ClienteQuery  implements Crud<Cliente>{

	Mysqlconn conn;
	
	public ClienteQuery(Mysqlconn con) {
		this.conn = con;
	}
	
	@Override
	public void create(Cliente objeto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Cliente read(String valor) {
		String txtsql = "select * from cliente where codcliente = "
				+ valor;
		Cliente cliente = new Cliente();
		ResultSet rs;
		try {
			rs = conn.ejecutarQuery(txtsql);
			while(rs.next()) {
				cliente.setCodcliente(rs.getInt(1));	
				cliente.setNombreCliente(rs.getString(2));
				cliente.setTipoCliente(rs.getString(3));
			}
		} catch (SQLException e) {
			System.out.println("No se puede cargar el cliente");
		}
		return cliente;
	}

	@Override
	public void update(Cliente objeto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(String valor) {
		// TODO Auto-generated method stub
		
	}
	
	

}
