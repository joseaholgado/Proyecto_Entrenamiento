package interfaces;

import javax.swing.JPanel;
import java.awt.GridBagLayout;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class VentanaCronometro extends JPanel {
    private Timer tiempo;
    private int centesimasSegundos = 0;
    private int segundos = 0;
    private int minutos = 0;
    private int horas = 0;

    private Ventana ventana;
    private JLabel etReloj;

    @Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		try {
			BufferedImage imagen = ImageIO.read(new File("./Crono.png"));
			g.drawImage(imagen, 0, 0, this);
			g.drawImage(imagen, 0, 0, this.getWidth(), this.getHeight(), new Color(0, 0, 0), null);
		} catch (IOException e) {

			e.printStackTrace();
		}
	}
    
    private void actualizarEtiquetaTiempo() {
    	String texto = (horas <= 9 ? "0" : "") + horas + ":" + (minutos <= 9 ? "0" : "") + minutos + ":"
                + (segundos <= 9 ? "0" : "") + segundos + ":" + (centesimasSegundos <= 9 ? "0" : "")
                + centesimasSegundos;
        etReloj.setText(texto);
    }

    public VentanaCronometro(Ventana v) {
    	this.ventana=v;
        GridBagLayout gridBagLayout = new GridBagLayout();
        gridBagLayout.columnWidths = new int[] { 104, 57, 49, 61, 63, 69, 0, 0 };
        gridBagLayout.rowHeights = new int[] { 30, 31, 54, 32, 0, 0, 0, 0, 0, 0 };
        gridBagLayout.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
        gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
        setLayout(gridBagLayout);

        JLabel etTitulo = new JLabel("Cronómetro");
        etTitulo.setFont(new Font("Tahoma", Font.PLAIN, 25));
        GridBagConstraints gbc_etTitulo = new GridBagConstraints();
        gbc_etTitulo.insets = new Insets(0, 0, 5, 5);
        gbc_etTitulo.gridwidth = 5;
        gbc_etTitulo.gridx = 1;
        gbc_etTitulo.gridy = 1;
        add(etTitulo, gbc_etTitulo);
        
                JButton btnIniciar = new JButton("Iniciar");
                GridBagConstraints gbc_btnIniciar = new GridBagConstraints();
                gbc_btnIniciar.insets = new Insets(0, 0, 5, 5);
                gbc_btnIniciar.gridx = 0;
                gbc_btnIniciar.gridy = 2;
                add(btnIniciar, gbc_btnIniciar);
                
                        btnIniciar.addActionListener(e -> {
                            if (tiempo == null) {
                                tiempo = new Timer();
                                tiempo.scheduleAtFixedRate(new TimerTask() {
                                    @Override
                                    public void run() {
                                        centesimasSegundos++;
                                        if (centesimasSegundos >= 100) {
                                            centesimasSegundos = 0;
                                            segundos++;
                                            if (segundos >= 60) {
                                                segundos = 0;
                                                minutos++;
                                                if (minutos >= 60) {
                                                    minutos = 0;
                                                    horas++;
                                                }
                                            }
                                        }
                                        actualizarEtiquetaTiempo();
                                    }
                                }, 10, 10);
                            }
                        });
        
                JButton btnPausar = new JButton("Pausar");
                GridBagConstraints gbc_btnPausar = new GridBagConstraints();
                gbc_btnPausar.insets = new Insets(0, 0, 5, 5);
                gbc_btnPausar.gridx = 1;
                gbc_btnPausar.gridy = 2;
                add(btnPausar, gbc_btnPausar);
                
                        btnPausar.addActionListener(e -> {
                            if (tiempo != null) {
                                tiempo.cancel();
                                tiempo = null;
                            }
                        });
        
                JButton btnDetener = new JButton("Detener");
                GridBagConstraints gbc_btnDetener = new GridBagConstraints();
                gbc_btnDetener.insets = new Insets(0, 0, 5, 5);
                gbc_btnDetener.gridx = 2;
                gbc_btnDetener.gridy = 2;
                add(btnDetener, gbc_btnDetener);
                
                        btnDetener.addActionListener(e -> {
                            if (tiempo != null) {
                                tiempo.cancel();
                                tiempo = null;
                            }
                            centesimasSegundos = 0;
                            segundos = 0;
                            minutos = 0;
                            horas = 0;
                            actualizarEtiquetaTiempo();
                        });

        etReloj = new JLabel("00:00:00:00");
        etReloj.setFont(new Font("Tahoma", Font.PLAIN, 35));
        GridBagConstraints gbc_etReloj = new GridBagConstraints();
        gbc_etReloj.insets = new Insets(0, 0, 5, 5);
        gbc_etReloj.gridx = 1;
        gbc_etReloj.gridy = 3;
        add(etReloj, gbc_etReloj);
        
        JButton btnAtras = new JButton("Atrás");
        btnAtras.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		ventana.cambiarAPantalla(PantallaEntreno.class);
        	}
        });
        GridBagConstraints gbc_btnAtras = new GridBagConstraints();
        gbc_btnAtras.gridx = 6;
        gbc_btnAtras.gridy = 8;
        add(btnAtras, gbc_btnAtras);
    }
}
