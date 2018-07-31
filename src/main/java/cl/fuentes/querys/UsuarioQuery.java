package cl.fuentes.querys;

import java.sql.ResultSet;
import java.sql.SQLException;

import cl.fuentes.db.Mysqlconn;
import cl.fuentes.modelo.Usuario;

public class UsuarioQuery implements Crud<Usuario>{

	private Mysqlconn con;
	
	public UsuarioQuery(Mysqlconn con){
		this.con = con;
	}
	
	@Override
	public void create(Usuario objeto) {
		// insert into usuario values ('admin','1234','Administrador');
		try {
			con.ejecutarUpdate("insert into usuario"
					+ " (usuario, clave, nombre,"
					+ " tipousuario, estado)"
					+ " values ('" 
					+ objeto.getUsuario() 
					+ "','" + objeto.getClave()
					+"','"+objeto.getNombre() + "','"
					+ objeto.getTipousuario()+"','V');");
			//con.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public Usuario read(String valor) {
		// select * from usuario where usuario = 'pamela';
		Usuario usuario = new Usuario();
		try {
			ResultSet rs = con.ejecutarQuery("select * from usuario"
					+ " where usuario = '"
					+ valor +"'");
			//while (rs.next()) {
				usuario.setIdusuario(rs.getInt(0));
				usuario.setUsuario(rs.getString(1));
				usuario.setClave(rs.getString(2));
				usuario.setNombre(rs.getString(3));
				usuario.setTipousuario(rs.getString(4));
				usuario.setEstado(rs.getString(5));
				
	        //}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
			return usuario;
	}

	@Override
	public void update(Usuario objeto) {
		// update usuario set clave = '1234' where usuario = 'pamela';
		try {
			con.ejecutarUpdate("update usuario"
								+ " set clave = '"
								+objeto.getClave()
								+", tipousuario = '"
								+objeto.getTipousuario()+"'"
								+", estado = '"
								+objeto.getEstado()+"' "
								+"' where usuario = '"
								+objeto.getUsuario()
								+"'");
		} catch (SQLException e) {
			
			System.out.println(e.getMessage());
		}
		
	}

	@Override
	public void delete(String valor) {
		// 
		try {
			con.ejecutarUpdate("delete from usuario where usuario = '"+ valor +"'");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
	}

}
