/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.carrerahilos_ortizmunozpablo;

import java.util.Random;
import javax.swing.JLabel;
import javax.swing.JProgressBar;

/**
 *
 * @author alumno
 */
public class carrera implements Runnable {
        private JProgressBar barra;
        private JLabel coche;
        
        public carrera(JProgressBar barra, JLabel coche) {
            this.barra = barra;
            this.coche = coche;
        }
        
        @Override
        public void run() {
            Random rand = new Random();
            int avance;
            
            
            while (barra.getValue() < 100) {
                avance = rand.nextInt(10) + 1;  // Avance aleatorio entre 1 y 10
                barra.setValue(barra.getValue() + avance);
                
                // Mover el coche
                int nX = 200 + barra.getValue() * 8;  // Hacemos que el coche se mueva en función de la barra
                coche.setBounds(nX, coche.getY(), coche.getWidth(), coche.getHeight());
                
                try {
                    Thread.sleep(100);  //pa que no vaya mu rapido
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
