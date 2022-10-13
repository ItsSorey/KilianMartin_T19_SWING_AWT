package vista;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class frmMenuCRUD extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmMenuCRUD frame = new frmMenuCRUD();
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
	public frmMenuCRUD() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 508, 442);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Menu CRUD");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblNewLabel.setBackground(new Color(255, 255, 255));
		lblNewLabel.setOpaque(true);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 11, 472, 41);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Añadir Registro");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menu=1;
			}
		});
		btnNewButton.setBounds(126, 63, 222, 41);
		contentPane.add(btnNewButton);
		
		JButton btnInsertarDatos = new JButton("Buscar Registro");
		btnInsertarDatos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menu=2;
			}
		});
		btnInsertarDatos.setBounds(126, 115, 222, 41);
		contentPane.add(btnInsertarDatos);
		
		JButton btnBorrarTabla = new JButton("Listar Registros");
		btnBorrarTabla.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menu=3;
			}
		});
		btnBorrarTabla.setBounds(126, 167, 222, 41);
		contentPane.add(btnBorrarTabla);
		
		JButton btnCrud = new JButton("Modificar Registro");
		btnCrud.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menu=4;
			}
		});
		btnCrud.setBounds(126, 219, 222, 41);
		contentPane.add(btnCrud);
		
		
		JButton btnBorrarRegistro = new JButton("Borrar Registro");
		btnBorrarRegistro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menu=5;
			}
		});
		btnBorrarRegistro.setBounds(126, 271, 222, 41);
		contentPane.add(btnBorrarRegistro);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menu=6;
			}
		});
		btnSalir.setBounds(260, 351, 222, 41);
		contentPane.add(btnSalir);
	}
	
	//damos el numero al controlador
	public int menu() {
		return menu;
	}
	public int limpiar() {
		menu=0;
		return menu;
	}
	
	//mostramos mensaje al usuario
	public void msg(String msg) {
		JOptionPane.showMessageDialog(null, msg);
		menu=0; //evitamos bucle
	}
	
	public void listarRegistros(String[][] matriz) { //recorremos la matrix y enseñamos los datos
		String respuesta="IdPieza  IdProveedor  Precio\n";
		for (int f=0;f<matriz.length;f++) {
			respuesta=respuesta+"---------------------------------------\n";
			for(int c=0;c<matriz[f].length;c++) {
				respuesta=respuesta+matriz[f][c]+"                    ";  //mostrar contingut de la matriu
			}
			respuesta=respuesta+"\n";
		}
		menu=0; //evitamos bucle
		JOptionPane.showInputDialog(respuesta);
	}
	
	//PEDIMOS LOS DATOS
		public int idPieza,Precio;
		public char idProveedor;
		
		public int getIdPieza() {
			String id = JOptionPane.showInputDialog("IdPieza:");
			idPieza= Integer.parseInt(id);
			return idPieza;
		}
		public int getPrecio() {
			String id = JOptionPane.showInputDialog("Precio:");
			Precio= Integer.parseInt(id);
			return Precio;
		}
		public char getidProveedor() {
			String id = JOptionPane.showInputDialog("idProveedor:");
			idProveedor= id.charAt(0);
			return idProveedor;
		}
}
