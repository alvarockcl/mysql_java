package cl.fuentes.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import cl.fuentes.db.Mysqlconn;
import cl.fuentes.modelo.Producto;
import cl.fuentes.querys.ProductoQuery;

public class Productogui extends JFrame{

	Mysqlconn conn;
	JLabel lbProducto;
	JLabel lbPrecio;
	JTextField txtProducto;
	JTextField txtPrecio;
	JButton btnAgregar;
	ProductoQuery pq;
	JButton btnBuscar;
	JButton btnGuardar;
	
	
	public Productogui(Mysqlconn con) {
		conn = con;
		pq = new ProductoQuery(conn);
		iniciarComponentes();
	}
	
	public void iniciarComponentes() {
		this.setTitle("Producto");
		this.setLayout(null);
		this.setLocationRelativeTo(null);
		this.setSize(400, 250);
		
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
		
		
		this.add(btnAgregar);
		this.add(lbPrecio);
		this.add(lbProducto);
		this.add(txtPrecio);
		this.add(txtProducto);
		this.add(btnBuscar);
		this.add(btnGuardar);
	}
	
	public void agregarProducto() {
		Producto producto = new Producto();
		producto.setProducto(txtProducto.getText());
		producto.setPrecio(Integer.parseInt(txtPrecio.getText()));
		pq.create(producto);
		JOptionPane.showMessageDialog(this, "Producto creado",
				"Información",JOptionPane.INFORMATION_MESSAGE);
	}
	
	public void buscarProducto() {
		Producto producto = new Producto();
		producto = pq.read(txtProducto.getText());
		txtPrecio.setText(String.valueOf(producto.getPrecio()));
		
	}
	
	public void guardarProducto() {
		pq.update(new Producto(0, txtProducto.getText(), 
				Integer.parseInt(txtPrecio.getText())));
		JOptionPane.showMessageDialog(this, "Producto actualizado",
				"Información",JOptionPane.INFORMATION_MESSAGE);
	}
	
}
