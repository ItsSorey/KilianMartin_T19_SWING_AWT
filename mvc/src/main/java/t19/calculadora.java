package t19;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class calculadora extends JFrame {

	private JPanel contentPane;
	private JTextField num1;
	private JTextField num2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					calculadora frame = new calculadora();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public static String Resultado;
	
	
	//METODOS PARA CALCULAR
	public String multiplicar(String num1, String num2) {
		double n1,n2;
		//convertimos string a double
		n1=Double.valueOf(num1);
		n2=Double.valueOf(num2);
		//sumamos y cambiamos de dobule a String
		return Resultado=String.valueOf(n1*n2);
	}
	
	public String dividir(String num1, String num2) {
		double n1,n2;
		//convertimos string a double
		n1=Double.valueOf(num1);
		n2=Double.valueOf(num2);
		//sumamos y cambiamos de dobule a String
		return Resultado=String.valueOf(n1/n2);
	}
	
	public String restar(String num1, String num2) {
		double n1,n2;
		//convertimos string a double
		n1=Double.valueOf(num1);
		n2=Double.valueOf(num2);
		//sumamos y cambiamos de dobule a String
		return Resultado=String.valueOf(n1-n2);
	}
	
	public String sumar(String num1, String num2) {
		double n1,n2;
		//convertimos string a double
		n1=Double.valueOf(num1);
		n2=Double.valueOf(num2);
		//sumamos y cambiamos de dobule a String
		return Resultado=String.valueOf(n1+n2);
	}

	//CALCULADORA
	public calculadora() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 333, 390);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JLabel Panel = new JLabel("CALCULADORA");
		Panel.setOpaque(true);
		Panel.setBackground(new Color(255, 255, 255));
		Panel.setForeground(new Color(0, 0, 0));
		Panel.setFont(new Font("Tahoma", Font.PLAIN, 27));
		Panel.setHorizontalAlignment(SwingConstants.CENTER);
		Panel.setBounds(10, 11, 297, 54);
		contentPane.add(Panel);
		
		JButton multiplicar = new JButton("*");
		multiplicar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,multiplicar(num1.getText(), num2.getText()));
			}
		});
		multiplicar.setBounds(10, 82, 66, 62);
		contentPane.add(multiplicar);
		
		JButton dividir = new JButton("/");
		dividir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,dividir(num1.getText(), num2.getText()));
			}
		});
		dividir.setBounds(86, 82, 66, 62);
		contentPane.add(dividir);
		
		JButton restar = new JButton("-");
		restar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,restar(num1.getText(), num2.getText()));
			}
		});
		restar.setBounds(162, 82, 66, 62);
		contentPane.add(restar);
		
		JButton sumar = new JButton("+");
		sumar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,sumar(num1.getText(), num2.getText()));
			}
		});
		sumar.setBounds(238, 82, 66, 62);
		contentPane.add(sumar);
		
		JButton salir = new JButton("Salir");
		salir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,"Bye");
				System.exit(0); //salimos
			}
		});
		salir.setBounds(162, 286, 145, 54);
		contentPane.add(salir);
		
		num1 = new JTextField();
		num1.setBounds(86, 170, 218, 35);
		contentPane.add(num1);
		num1.setColumns(10);
		
		num2 = new JTextField();
		num2.setColumns(10);
		num2.setBounds(86, 229, 218, 35);
		contentPane.add(num2);
		
		JLabel lblNewLabel_1 = new JLabel("Numero 1:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setBounds(10, 180, 66, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Numero 2:");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1.setBounds(10, 239, 66, 14);
		contentPane.add(lblNewLabel_1_1);
		
	}
}
