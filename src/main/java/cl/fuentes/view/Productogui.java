package cl.fuentes.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import cl.fuentes.db.Mysqlconn;
import cl.fuentes.modelo.Producto;
import cl.fuentes.querys.ProductoQuery;

public class Productogui extends JFrame{

	Mysqlconn conn;
	JLabel lbProducto;
	JLabel lbPrecio;
	JLabel lbStock;
	JTextField txtProducto;
	JTextField txtPrecio;
	JTextField txtStock;
	JButton btnAgregar;
	ProductoQuery pq;
	JButton btnBuscar;
	JButton btnGuardar;
	JTable table;
	JScrollPane scrollPane;
	ResultSet rsGrilla;
	String txtsql = "select * from producto";
	
	
	public Productogui(Mysqlconn con) {
		conn = con;
		pq = new ProductoQuery(conn);
		iniciarComponentes();
	}
	
	public void iniciarComponentes() {
		this.setTitle("Producto");
		this.setLayout(null);
		this.setLocationRelativeTo(null);
		this.setSize(500, 450);
		
		lbProducto = new JLabel("Producto");
		lbProducto.setLocation(20,20);
		lbProducto.setSize(100, 20);
		
		txtProducto = new JTextField();
		txtProducto.setLocation(120, 20);
		txtProducto.setSize(100, 20);
		
		
		lbPrecio = new JLabel("Precio");
		lbPrecio.setLocation(20,60);
		lbPrecio.setSize(100, 20);
		
		txtPrecio = new JTextField();
		txtPrecio.setLocation(120, 60);
		txtPrecio.setSize(100, 20);

		lbStock = new JLabel("Stock");
		lbStock.setLocation(20,100);
		lbStock.setSize(100, 20);
		
		txtStock = new JTextField();
		txtStock.setLocation(120, 100);
		txtStock.setSize(100, 20);		
		
		btnAgregar = new JButton("Agregar");
		btnAgregar.setLocation(20, 140);
		btnAgregar.setSize(100,20);
		btnAgregar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				agregarProducto();
				
			}
		});
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.setLocation(240, 20);
		btnBuscar.setSize(100,20);
		btnBuscar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				buscarProducto();
				
			}
		});
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.setLocation(240, 140);
		btnGuardar.setSize(100,20);
		btnGuardar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				guardarProducto();
				
			}
		});
		
		// Inicio grilla
		try {
			rsGrilla = conn.ejecutarQuery(txtsql);
			table = new JTable(buildTableModel(rsGrilla));
		} catch (SQLException e1) {
		}
		table.setSize(400, 150);
		table.setRowHeight(20);
		scrollPane = new JScrollPane();
		scrollPane.setLocation(20, 250);
		scrollPane.setSize(400, 150);
		scrollPane.setViewportView(table);
		this.add(scrollPane);		
		// Fin grilla		
		
		
		this.add(btnAgregar);
		this.add(lbPrecio);
		this.add(lbProducto);
		this.add(txtPrecio);
		this.add(txtProducto);
		this.add(lbStock);
		this.add(txtStock);
		this.add(btnBuscar);
		this.add(btnGuardar);

	}
	
	public void agregarProducto() {
		Producto producto = new Producto();
		producto.setProducto(txtProducto.getText());
		producto.setPrecio(Integer.parseInt(txtPrecio.getText()));
		producto.setStock(Integer.parseInt(txtStock.getText()));
		pq.create(producto);
		actualizarGrilla();
		JOptionPane.showMessageDialog(this, "Producto creado",
				"Información",JOptionPane.INFORMATION_MESSAGE);
	}
	
	public void buscarProducto() {
		Producto producto = new Producto();
		producto = pq.read(txtProducto.getText());
		txtPrecio.setText(String.valueOf(producto.getPrecio()));
		txtStock.setText(String.valueOf(producto.getStock()));
	}
	
	public void guardarProducto() {
		pq.update(new Producto(0
				, txtProducto.getText()
				,Integer.parseInt(txtPrecio.getText())
				,Integer.parseInt(txtStock.getText())
				));
		actualizarGrilla();
		JOptionPane.showMessageDialog(this, "Producto actualizado",
				"Información",JOptionPane.INFORMATION_MESSAGE);
	}
	
	public DefaultTableModel buildTableModel(ResultSet rs) throws SQLException {
	
		ResultSetMetaData metaData = rs.getMetaData();
   
	    Vector<String> columnNames = new Vector<String>();
	    int columnCount = metaData.getColumnCount();
	    for (int column = 1; column <= columnCount; column++) {
	        columnNames.add(metaData.getColumnName(column));
	    }

	    Vector<Vector<Object>> data = new Vector<Vector<Object>>();
	    while (rs.next()) {
	        Vector<Object> vector = new Vector<Object>();
	        for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
	            vector.add(rs.getObject(columnIndex));
	        }
	        data.add(vector);
	    }
	    return new DefaultTableModel(data, columnNames);
	}
	
	public void actualizarGrilla() {
		try {
			rsGrilla = conn.ejecutarQuery(txtsql);
			table.setModel(buildTableModel(rsGrilla));
		} catch (SQLException e) {
			
		}
	}

	
}
