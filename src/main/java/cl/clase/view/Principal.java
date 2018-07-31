package cl.clase.view;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;

import com.sun.xml.internal.fastinfoset.tools.SAXEventSerializer;

import cl.fuentes.db.Mysqlconn;

public class Principal extends JFrame {

	JButton btnUsuariogui;
	private Mysqlconn conn;
	
	public Principal(Mysqlconn con) {
		super("Principal");
		conn = con;
		iniciaPrincipal();
	}
	
	public void iniciaPrincipal() {
		this.setLayout(null);
		this.setSize(800, 500);
		this.setLocationRelativeTo(null); // centra la ventana
		
		btnUsuariogui = new JButton("Abrir usuario");
		btnUsuariogui.setLocation(20, 20);
		btnUsuariogui.setSize(200, 20);
		btnUsuariogui.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				abrirUsuariogui();
			}
		});
		this.addWindowListener(new WindowAdapter() {
			public void WindowClosing(WindowEvent e) {
		        salirAplicacion();
		    }
		});
		
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.add(btnUsuariogui);
	}
	
	public void abrirUsuariogui(){
		Usuariogui ugui = new Usuariogui(conn);
		ugui.setVisible(true);
	}
	
	public void salirAplicacion() {
	    this.dispose();
	    System.exit(0);
	}
	
}