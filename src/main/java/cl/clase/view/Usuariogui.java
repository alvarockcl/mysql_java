package cl.clase.view;

import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Usuariogui extends JFrame{
  
	
	JLabel lbUsuario;
	JTextField txtUsuario;
	JLabel lbClave;
	JPasswordField txtPassword;
	JLabel lbNombre;
	JTextField txtNombre;
	JButton btnAgregar;
	JButton btnGuardar;
	JButton btnEliminar;
	JLabel lbTipousuario;
	JComboBox<String> cbTipousuario;	
	
	
	public Usuariogui() {
		super("Formulario Usuario");
		iniciarComponentes();
	}
	
	public void iniciarComponentes() {
		this.setLayout(null);
		this.setLocationRelativeTo(null);  
		
		this.setSize(400, 300);
		
		lbUsuario = new JLabel("Usuario");
		lbUsuario.setLocation(20, 20);
		lbUsuario.setSize(100, 20);
		lbClave = new JLabel("Clave");
		lbClave.setLocation(20, 60);
		lbClave.setSize(100, 20);
		lbNombre = new JLabel("Nombre");
		lbNombre.setLocation(20, 100);
		lbNombre.setSize(100, 20);
		
		txtUsuario = new JTextField();
		txtUsuario.setLocation(100, 20);
		txtUsuario.setSize(100, 20);
		
		txtPassword = new JPasswordField();
		txtPassword.setLocation(100, 60);
		txtPassword.setSize(100, 20);
		
		txtNombre = new JTextField();
		txtNombre.setLocation(100, 100);
		txtNombre.setSize(100, 20);
		
		btnAgregar = new JButton("Agregar");
		btnAgregar.setLocation(20, 180);
		btnAgregar.setSize(80, 20);
		btnGuardar = new JButton("Guardar");
		btnGuardar.setLocation(100, 180);
		btnGuardar.setSize(100, 20);
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setLocation(200, 180);
		btnEliminar.setSize(80, 20);
		
		lbTipousuario = new JLabel("Tipo usuario");
		lbTipousuario.setLocation(20,140);
		lbTipousuario.setSize(100, 20);

		
		Vector<String> tipousuario = new Vector<String>();
		tipousuario.addElement("Administrador");
		tipousuario.addElement("Operador");
		tipousuario.addElement("Vendedor");
		
		//String[] tipousuario = new String[] {"Administrador", "Vendedor"};
		cbTipousuario = new JComboBox<String>(tipousuario);
		cbTipousuario.setLocation(100,140);
		cbTipousuario.setSize(100, 20);
		

		 		
		
		
		this.add(lbClave);
		this.add(lbNombre);
		this.add(lbUsuario);

		this.add(txtNombre);
		this.add(txtPassword);
		this.add(txtUsuario);
		
		this.add(btnAgregar);
		this.add(btnEliminar);
		this.add(btnGuardar);
		
		this.add(lbTipousuario);
		this.add(cbTipousuario);



		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static void main(String[] args) {
	
		Usuariogui ugui = new Usuariogui();
		ugui.setVisible(true);
	}

}
