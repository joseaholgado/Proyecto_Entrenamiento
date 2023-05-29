package interfaces;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JRadioButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PantallaEjercicioMiguel extends JPanel{
	private JTextField campoNombre;
	private Ventana ventana;
	private final ButtonGroup botonAgrupado = new ButtonGroup();
	
	public PantallaEjercicioMiguel(Ventana v) {
		this.ventana=v;
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel etTitulo = new JLabel("Dime tu nombre");
		etTitulo.setFont(new Font("Arial", Font.ITALIC, 20));
		GridBagConstraints gbc_etTitulo = new GridBagConstraints();
		gbc_etTitulo.insets = new Insets(0, 0, 5, 0);
		gbc_etTitulo.gridx = 2;
		gbc_etTitulo.gridy = 1;
		add(etTitulo, gbc_etTitulo);
		
		campoNombre = new JTextField();
		GridBagConstraints gbc_campoNombre = new GridBagConstraints();
		gbc_campoNombre.insets = new Insets(0, 0, 5, 0);
		gbc_campoNombre.gridx = 2;
		gbc_campoNombre.gridy = 2;
		add(campoNombre, gbc_campoNombre);
		campoNombre.setColumns(10);
		
		JButton btnSiguiente = new JButton("Siguiente");
		btnSiguiente.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				ventana.cambiarAPantalla(PantallaEjercicioListado.class);
			}
		});
		
		JLabel etSexo = new JLabel("Dime tu sexo");
		etSexo.setFont(new Font("Arial", Font.ITALIC, 16));
		GridBagConstraints gbc_etSexo = new GridBagConstraints();
		gbc_etSexo.insets = new Insets(0, 0, 5, 0);
		gbc_etSexo.gridx = 2;
		gbc_etSexo.gridy = 3;
		add(etSexo, gbc_etSexo);
		
		JRadioButton btnHombre = new JRadioButton("Hombre");
		botonAgrupado.add(btnHombre);
		GridBagConstraints gbc_btnHombre = new GridBagConstraints();
		gbc_btnHombre.insets = new Insets(0, 0, 5, 0);
		gbc_btnHombre.gridx = 2;
		gbc_btnHombre.gridy = 4;
		add(btnHombre, gbc_btnHombre);
		
		JRadioButton btnMujer = new JRadioButton("Mujer");
		botonAgrupado.add(btnMujer);
		GridBagConstraints gbc_btnMujer = new GridBagConstraints();
		gbc_btnMujer.insets = new Insets(0, 0, 5, 0);
		gbc_btnMujer.gridx = 2;
		gbc_btnMujer.gridy = 5;
		add(btnMujer, gbc_btnMujer);
		
		JRadioButton btnOtros = new JRadioButton("Otros");
		botonAgrupado.add(btnOtros);
		GridBagConstraints gbc_btnOtros = new GridBagConstraints();
		gbc_btnOtros.insets = new Insets(0, 0, 5, 0);
		gbc_btnOtros.gridx = 2;
		gbc_btnOtros.gridy = 6;
		add(btnOtros, gbc_btnOtros);
		GridBagConstraints gbc_btnSiguiente = new GridBagConstraints();
		gbc_btnSiguiente.gridx = 2;
		gbc_btnSiguiente.gridy = 7;
		add(btnSiguiente, gbc_btnSiguiente);
	}
	

}
