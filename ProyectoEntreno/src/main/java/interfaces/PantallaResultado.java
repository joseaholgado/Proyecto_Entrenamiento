package interfaces;

import javax.swing.JPanel;
import java.awt.GridBagLayout;

public class PantallaResultado extends JPanel{
	private Ventana ventana;
	public PantallaResultado(Ventana v) {
		this.ventana=v;
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0};
		gridBagLayout.rowHeights = new int[]{0};
		gridBagLayout.columnWeights = new double[]{Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{Double.MIN_VALUE};
		setLayout(gridBagLayout);
	}
	

}
