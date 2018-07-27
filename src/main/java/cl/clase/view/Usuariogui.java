package cl.clase.view;

import javax.swing.JButton;
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
	
	
	public Usuariogui() {
		super("Formulario Usuario");
		iniciarComponentes();
	}
	
	public void iniciarComponentes() {
		this.setLayout(null);
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
		
		
		
		
		
		
		
		this.add(lbClave);
		this.add(lbNombre);
		this.add(lbUsuario);
		/*
		this.add(btnAgregar);
		this.add(btnEliminar);
		this.add(btnGuardar);
		this.add(txtNombre);
		this.add(txtPassword);
		this.add(txtUsuario);
		*/
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static void main(String[] args) {
	
		Usuariogui ugui = new Usuariogui();
		ugui.setVisible(true);
	}

}
