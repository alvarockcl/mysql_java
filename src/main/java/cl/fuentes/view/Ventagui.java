package cl.fuentes.view;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import cl.fuentes.db.Mysqlconn;
import cl.fuentes.querys.VentaQuery;
import cl.fuentes.modelo.Carrito;


public class Ventagui extends JFrame{

	Mysqlconn conn;
	VentaQuery vq;
	
	JTable table;
	JScrollPane scrollPane;
	ResultSet rsGrilla;
	String txtsql = "select * from venta";
	DefaultTableModel tableModel;
	List<Carrito> carroCompra;
	
	JLabel lbCodCliente;
	JTextField txtCodCliente;
	JLabel lbCliente;
	JTextField txtCliente;
	JLabel lbTipoCliente;
	JTextField txtTipoCliente;
	JButton btnLeerCliente;
	JLabel lbCodProducto;
	JTextField txtCodProducto;
	JLabel lbCantidad;
	JTextField txtCantidad;
	JButton btnAgregarCompra;
	
	
	public Ventagui(Mysqlconn con) {
		conn = con;
		vq = new VentaQuery(conn);
		iniciarComponentes();
	}

	private void iniciarComponentes() {
		this.setTitle("Venta");
		this.setLayout(null);
		this.setLocationRelativeTo(null);
		this.setSize(550, 450);
		
		
		
		
		this.setResizable(false);
		
		lbCodCliente = new JLabel("Cod Cliente");
		lbCodCliente.setLocation(20, 20);
		lbCodCliente.setSize(100,20);
		
		txtCodCliente = new JTextField();
		txtCodCliente.setLocation(120, 20);
		txtCodCliente.setSize(100,20);
		
		lbCliente = new JLabel("Cliente");
		lbCliente.setLocation(20, 60);
		lbCliente.setSize(100,20);
		
		txtCliente = new JTextField();
		txtCliente.setLocation(120, 60);
		txtCliente.setSize(100,20);		
		
		lbTipoCliente = new JLabel("Tipo");
		lbTipoCliente.setLocation(20, 100);
		lbTipoCliente.setSize(100,20);
		
		txtTipoCliente = new JTextField();
		txtTipoCliente.setLocation(120, 100);
		txtTipoCliente.setSize(100,20);		
		
		btnLeerCliente = new JButton("Leer");
		btnLeerCliente.setLocation(240, 20);
		btnLeerCliente.setSize(100,20);
		
		lbCodProducto = new JLabel("Cod Producto");
		lbCodProducto.setLocation(20, 130);
		lbCodProducto.setSize(100,20);
		
		txtCodProducto = new JTextField();
		txtCodProducto.setLocation(120, 130);
		txtCodProducto.setSize(100,20);		
		
		lbCantidad = new JLabel("Cantidad");
		lbCantidad.setLocation(240, 130);
		lbCantidad.setSize(100,20);
		
		txtCantidad = new JTextField();
		txtCantidad.setLocation(300, 130);
		txtCantidad.setSize(50,20);
		
		btnAgregarCompra = new JButton("Agregar Carrito");
		btnAgregarCompra.setLocation(370, 130);
		btnAgregarCompra.setSize(150,20);
		
		carroCompra = new ArrayList<Carrito>();
		//carroCompra.add(new Carrito(1, "PC", 350000));
		//carroCompra.clear();
		Object columnas[] = {"COD PROD","PRODUCO","PRECIO"};
		tableModel = new DefaultTableModel(columnas,0);
		for(int i=0 ; i < carroCompra.size() ; i++){
			tableModel.addRow(new Object[] {carroCompra.get(i).getCodproducto(), carroCompra.get(i).getProducto(), carroCompra.get(i).getPrecio()});
		}		
		table = new JTable(tableModel);
		table.setSize(400, 150);
		table.setRowHeight(20);

		scrollPane = new JScrollPane();
		scrollPane.setLocation(20, 180);
		scrollPane.setSize(400, 150);
		scrollPane.setViewportView(table);
		
		
		this.add(lbCodCliente);
		this.add(lbCliente);
		this.add(lbTipoCliente);
		this.add(txtCodCliente);
		this.add(txtCliente);
		this.add(txtTipoCliente);
		this.add(btnLeerCliente);
		this.add(lbCodProducto);
		this.add(txtCodProducto);
		this.add(lbCantidad);
		this.add(txtCantidad);
		this.add(btnAgregarCompra);
		this.add(scrollPane);
		
	}
	
}
