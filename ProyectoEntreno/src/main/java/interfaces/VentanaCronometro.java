package interfaces;

import javax.swing.JPanel;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Font;
import java.awt.Insets;
import java.util.Timer;
import java.util.TimerTask;

public class VentanaCronometro extends JPanel {
    private Timer tiempo;
    private int centesimasSegundos = 0;
    private int segundos = 0;
    private int minutos = 0;
    private int horas = 0;

    private Ventana ventana;
    private JLabel etReloj;

    private void actualizarEtiquetaTiempo() {
    	String texto = (horas <= 9 ? "0" : "") + horas + ":" + (minutos <= 9 ? "0" : "") + minutos + ":"
                + (segundos <= 9 ? "0" : "") + segundos + ":" + (centesimasSegundos <= 9 ? "0" : "")
                + centesimasSegundos;
        etReloj.setText(texto);
    }

    public VentanaCronometro(Ventana v) {
    	this.ventana=v;
        GridBagLayout gridBagLayout = new GridBagLayout();
        gridBagLayout.columnWidths = new int[] { 104, 57, 49, 61, 63, 69, 0 };
        gridBagLayout.rowHeights = new int[] { 30, 31, 54, 32, 0 };
        gridBagLayout.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
        gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
        setLayout(gridBagLayout);

        JLabel etTitulo = new JLabel("Cronómetro");
        etTitulo.setFont(new Font("Tahoma", Font.PLAIN, 25));
        GridBagConstraints gbc_etTitulo = new GridBagConstraints();
        gbc_etTitulo.insets = new Insets(0, 0, 5, 0);
        gbc_etTitulo.gridwidth = 5;
        gbc_etTitulo.gridx = 1;
        gbc_etTitulo.gridy = 1;
        add(etTitulo, gbc_etTitulo);

        etReloj = new JLabel("00:00:00:00");
        etReloj.setFont(new Font("Tahoma", Font.PLAIN, 35));
        GridBagConstraints gbc_etReloj = new GridBagConstraints();
        gbc_etReloj.insets = new Insets(0, 0, 0, 5);
        gbc_etReloj.gridx = 1;
        gbc_etReloj.gridy = 3;
        add(etReloj, gbc_etReloj);

        JButton btnIniciar = new JButton("Iniciar");
        GridBagConstraints gbc_btnIniciar = new GridBagConstraints();
        gbc_btnIniciar.insets = new Insets(0, 0, 0, 5);
        gbc_btnIniciar.gridx = 3;
        gbc_btnIniciar.gridy = 3;
        add(btnIniciar, gbc_btnIniciar);

        JButton btnPausar = new JButton("Pausar");
        GridBagConstraints gbc_btnPausar = new GridBagConstraints();
        gbc_btnPausar.insets = new Insets(0, 0, 0, 5);
        gbc_btnPausar.gridx = 4;
        gbc_btnPausar.gridy = 3;
        add(btnPausar, gbc_btnPausar);

        JButton btnDetener = new JButton("Detener");
        GridBagConstraints gbc_btnDetener = new GridBagConstraints();
        gbc_btnDetener.gridx = 5;
        gbc_btnDetener.gridy = 3;
        add(btnDetener, gbc_btnDetener);

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

        btnPausar.addActionListener(e -> {
            if (tiempo != null) {
                tiempo.cancel();
                tiempo = null;
            }
        });

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
    }
}
