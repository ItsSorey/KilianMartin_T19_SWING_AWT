package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class frmMenu extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmMenu frame = new frmMenu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	int menu=0;
	public frmMenu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 508, 442);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Menu Principal");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblNewLabel.setBackground(new Color(255, 255, 255));
		lblNewLabel.setOpaque(true);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 11, 472, 41);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Inicializar Tablas");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menu=1;
			}
		});
		btnNewButton.setBounds(126, 87, 222, 41);
		contentPane.add(btnNewButton);
		
		JButton btnInsertarDatos = new JButton("Insertar datos Automaticos");
		btnInsertarDatos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menu=2;
			}
		});
		btnInsertarDatos.setBounds(126, 153, 222, 41);
		contentPane.add(btnInsertarDatos);
		
		JButton btnBorrarTabla = new JButton("Borrar Tabla");
		btnBorrarTabla.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menu=3;
			}
		});
		btnBorrarTabla.setBounds(126, 221, 222, 41);
		contentPane.add(btnBorrarTabla);
		
		JButton btnCrud = new JButton("CRUD");
		btnCrud.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menu=4;
			}
		});
		btnCrud.setBounds(126, 288, 222, 41);
		contentPane.add(btnCrud);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menu=5;
			}
		});
		btnSalir.setBounds(260, 351, 222, 41);
		contentPane.add(btnSalir);
	}
	
	//damos el numero al controlador
	public int menu() {
		return menu;
	}
	
	//mostramos mensaje al usuario
	public void msg(String msg) {
		JOptionPane.showMessageDialog(null, msg);
		menu=0; //evitamos bucle
	}
}
