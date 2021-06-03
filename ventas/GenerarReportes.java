package ventas;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JList;

public class GenerarReportes extends JDialog {
	
	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			GenerarReportes dialog = new GenerarReportes();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public GenerarReportes() {
		setTitle("Generar Reportes");
		setBounds(100, 100, 598, 436);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblTipo = new JLabel("Tipo de Reporte");
			lblTipo.setBounds(10, 27, 83, 14);
			contentPanel.add(lblTipo);
		}
		{
			JComboBox cboTipo = new JComboBox();
			cboTipo.setModel(new DefaultComboBoxModel(new String[] {"Seleccione tipo de Reporte", "Ventas por modelo", "Ventas en relaci\u00F3n a la venta \u00F3ptima", "Precios en relaci\u00F3n al precio promedio", "Promedios, menores y mayores"}));
			cboTipo.setBounds(117, 23, 310, 22);
			contentPanel.add(cboTipo);
		}
		{
			JButton btnCerrar = new JButton("Cerrar");
			btnCerrar.setBounds(483, 23, 89, 23);
			contentPanel.add(btnCerrar);
		}
		{
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 63, 562, 323);
			contentPanel.add(scrollPane);
			{
				JTextArea txtS = new JTextArea();
				txtS.setEditable(false);
				scrollPane.setViewportView(txtS);
			}
		}
	}
}
