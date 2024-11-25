package com.mycompany.carrerahilos_ortizmunozpablo;

import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;

public class carrera implements Runnable {
    private JProgressBar barra;
    private JLabel coche;
    static boolean hayGanador = false;
    private long tiempoInicio;
    private long tiempoFinal;
    private int id;
    private int distanciaRecorrida = 0;
    private static int cochesTerminados = 0; // Variable para contar coches terminados

    public carrera(JProgressBar barra, JLabel coche, int id) {
        this.barra = barra;
        this.coche = coche;
        this.id = id;
    }

    @Override
    public void run() {
        Random rand = new Random();
        
        tiempoInicio = System.currentTimeMillis();
        
        
        int avance;
        
        while (barra.getValue() < 100) {
            if (hayGanador) {
                break;
            }
            
            avance = rand.nextInt(10) + 1;  // Avance aleatorio entre 1 y 10
            barra.setValue(barra.getValue() + avance);
             distanciaRecorrida += avance;

      int nX = barra.getValue() * 16;

        // Actualizar la distancia en la ventana
        carrera_OrtizMunozPablo.actualizarDistancia(id, distanciaRecorrida);
            
            
            
            if (barra.getValue() == 100 && !hayGanador) {
                hayGanador = true;
                coche.setIcon(new ImageIcon(getClass().getResource("/explosion.png")));
                
                tiempoFinal = System.currentTimeMillis();
                JOptionPane.showMessageDialog(coche, "¡PUUUM! El Cohete " + id + " ha ganado. \nTiempo: " + 
                                              (tiempoFinal - tiempoInicio) + " milisegundos.",
                                              "Mensaje", JOptionPane.INFORMATION_MESSAGE);
            }
            
            coche.setBounds(nX, coche.getY(), coche.getWidth(), coche.getHeight());
            
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        
      
     
            synchronized (carrera.class) {
            cochesTerminados++;
            if (cochesTerminados == 4) {
                // Llamar a la función para mostrar los resultados cuando todos los coches terminen
                carrera_OrtizMunozPablo.mostrarResultados();
            }
        }
        
    }

    public int getDistanciaRecorrida() {
        return distanciaRecorrida;
    }

    public int getId() {
        return id;
    }


    }

