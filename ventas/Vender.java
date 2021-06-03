package ventas;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;

public class Vender extends JDialog implements ActionListener {
	
	DecimalFormat df = new DecimalFormat("#.00");
	
	// Datos mínimos de la primera lavadora
	public static String modelo0 = "WHIRLPOOL WWI16BSBLA";
	public static double precio0 = 999.0;
	public static double fondo0 = 67.0;
	public static double ancho0 = 64.0;
	public static double alto0 = 105.0;
	public static double capacidad0 = 16;
	
	// Datos mínimos de la segunda lavadora
	public static String modelo1 = "SAMSUNG WA17T6260BW";
	public static double precio1 = 1199.0;
	public static double ancho1 = 63.0;
	public static double alto1 = 108.0;
	public static double fondo1 = 69.0;
	public static double capacidad1 = 17;
	
	// Datos mínimos de la tercera lavadora
	public static String modelo2 = "MABE LMA72200WDBB1";
	public static double precio2 = 1599.0;
	public static double ancho2 = 68.0;
	public static double alto2 = 109.0;
	public static double fondo2 = 68.0;
	public static double capacidad2 = 22;
	
	// Datos mínimos de la cuarta lavadora
	public static String modelo3 = "WINIA WLA-195ECG";
	public static double precio3 = 899.0;
	public static double ancho3 = 52.5;
	public static double alto3 = 85.5;
	public static double fondo3 = 53.5;
	public static double capacidad3 = 6.5;
	
	// Datos mínimos de la quinta lavadora
	public static String modelo4 = "LG TS1604NW";
	public static double precio4 = 1099.0;
	public static double ancho4 = 63.2;
	public static double alto4 = 102.0;
	public static double fondo4 = 67;
	public static double capacidad4 = 17;
	
	// Porcentajes de descuento
	public static double porcentaje1 = 7.5;
	public static double porcentaje2 = 10;
	public static double porcentaje3 = 12.5;
	public static double porcentaje4 = 15;
	
	// Obsequios
	public static String obsequio1 = "Cafetera";
	public static String obsequio2 = "Licuadora";
	public static String obsequio3 = "Extractor";
	
	// Cuota diaria
	public static double cuotaDiaria = 30000;
	
	private final JPanel contentPanel = new JPanel();
	private JLabel lblModelo;
	private JComboBox cboModelo;
	private JButton btnVender;
	private JButton btnCerrar;
	private JLabel lblPrecio;
	private JTextField txtPrecio;
	private JLabel lblCantidad;
	private JTextField txtCantidad;
	private JScrollPane scrollPane;
	private JTextArea txtS;
	
	int contador=0;
	double total=0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Vender dialog = new Vender();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Vender() {
		setBounds(100, 100, 451, 366);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		lblModelo = new JLabel("Modelo");
		lblModelo.setBounds(24, 28, 46, 14);
		contentPanel.add(lblModelo);
		
		cboModelo = new JComboBox();
		cboModelo.addActionListener(this);
		cboModelo.setModel(new DefaultComboBoxModel(new String[] {
				"Seleccione Modelo",
				modelo0,
				modelo1,
				modelo2,
				modelo3,
				modelo4
		}));
		cboModelo.setBounds(111, 24, 155, 22);
		contentPanel.add(cboModelo);
		
		btnVender = new JButton("Vender");
		btnVender.addActionListener(this);
		btnVender.setBounds(318, 24, 89, 23);
		contentPanel.add(btnVender);
		
		btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(this);
		btnCerrar.setBounds(318, 75, 89, 23);
		contentPanel.add(btnCerrar);
		
		lblPrecio = new JLabel("Precio");
		lblPrecio.setBounds(24, 79, 46, 14);
		contentPanel.add(lblPrecio);
		
		txtPrecio = new JTextField();
		txtPrecio.setEditable(false);
		txtPrecio.setBounds(111, 76, 86, 20);
		contentPanel.add(txtPrecio);
		txtPrecio.setColumns(10);
		
		lblCantidad = new JLabel("Cantidad");
		lblCantidad.setBounds(24, 124, 46, 14);
		contentPanel.add(lblCantidad);
		
		txtCantidad = new JTextField();
		txtCantidad.setBounds(111, 121, 86, 20);
		contentPanel.add(txtCantidad);
		txtCantidad.setColumns(10);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(24, 162, 401, 154);
		contentPanel.add(scrollPane);
		
		txtS = new JTextArea();
		scrollPane.setViewportView(txtS);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == cboModelo) {
			actionPerformedCboModelo(e);
		}		
		if (e.getSource() == btnVender) {
			actionPerformedBtnVender(e);
			contador++;
			if(contador>4) {
				JOptionPane.showMessageDialog(null, "Venta Nro "+contador+
													"\nImporte total general acumulado: S/"+total+
													"\nPorcentaje de la cuota diaria: "+ df.format((total/cuotaDiaria)*100)+"%");
			}
			
		}
		if (e.getSource() == btnCerrar) {
			actionPerformedBtnCerrar(e);
		}
	}
	
	protected void actionPerformedBtnCerrar(ActionEvent e) {
		dispose();
	}
		int LeerModelo() {
		return cboModelo.getSelectedIndex();
	}
	
	//Obtener cantidad
	int LeerCantidad() {
		return Integer.parseInt(txtCantidad.getText());
	}
	
	//Metodos Procesos
	
	//Mostrar precio del producto - automático
	protected void actionPerformedCboModelo(ActionEvent e) {
		int model;
		model= cboModelo.getSelectedIndex();
		
		switch (model) {
		case 1: txtPrecio.setText(String.valueOf(precio0)); break;
		case 2: txtPrecio.setText(String.valueOf(precio1)); break;
		case 3: txtPrecio.setText(String.valueOf(precio2)); break;
		case 4: txtPrecio.setText(String.valueOf(precio3)); break;
		case 5: txtPrecio.setText(String.valueOf(precio4)); break;
		default: txtPrecio.setText("");
		}
				
	}
	
	//Calcular precio
		double CalcularPrecio(int mod) {
			switch (mod) {
			case 1: return precio0;
			case 2: return precio1;
			case 3: return precio2;
			case 4: return precio3;
			case 5: return precio4;
			default: return 0; }
		}

	
	//Calcular importe
	double CalcularImporteCompra(double precio,int cantidad) {
		return cantidad*precio;
	}

	//Metodo para calcular descuento
	double CalcularDescuento(int cant, double ic) {
	if(cant>=1 && cant<5) {
		return ic*(porcentaje1/100);}
	else if (cant>=6 && cant<10) {
		return ic*(porcentaje2/100);}
	else if (cant>=11 && cant<15) {
		return ic*(porcentaje3/100);}
	else
		return ic*(porcentaje4/100);
	}
		
	//Metodo para calcular obsequio
	String CalcularObs(int cantidad) {
		if(cantidad==1)
			return obsequio1;
		else if(cantidad>=2 && cantidad<5)
			return obsequio2;
		else 
			return obsequio3;
	}
	
	//metodo para calcular ip
	double Calcularip(double ic, double id) {
		return ic-id;}
	
	public String detalleModelo(int mod) {
		switch (mod) {
		case 1: return modelo0;
		case 2: return modelo1;
		case 3: return modelo2;
		case 4: return modelo3;
		case 5: return modelo4;
		default: return ""; }
	}
	
	//metodo para la salida de datos
	void MostrarResultado(int model, double ic, double id, double ip, String obs) {
	txtS.setText("");
	
		String marca = detalleModelo(model);
		
		imprimir ("BOLETA DE VENTA\n");
		imprimir ("Modelo                            :  "+marca);
		imprimir ("Importe de compra       :  S/."+ic);
		imprimir ("Importe de descuento  :  "+id);
		imprimir ("Importe de pagar           :  "+ip);
		imprimir ("Obsequio                        :  "+obs+"\n");
		
	}
		
	public void imprimir (String s) {
	txtS.append(s+"\n");
	}

	protected void actionPerformedBtnVender(ActionEvent e) {
			
		//declaracion de variabes locales
		int modelo, cantidad;
		String obs, desc;
		double precio,ic,id,ip;
		
		//entrada de datos
		modelo = LeerModelo();
		cantidad = LeerCantidad();
		
		//proceso
		precio= CalcularPrecio(modelo);
		ic=CalcularImporteCompra(precio,cantidad);
		id=CalcularDescuento(cantidad,ic);
		ip=Calcularip(ic,id);
		obs=CalcularObs(cantidad);
		
		//salida
		MostrarResultado(modelo, ic,id,ip,obs);
		
		total=total+ip;
	
		//fin	
	}
	}






