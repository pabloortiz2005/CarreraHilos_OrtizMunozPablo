/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.carrerahilos_ortizmunozpablo;


import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;

/**
 *
 * @author alumno
 */
public class carrera_OrtizMunozPablo extends javax.swing.JFrame {

     private JLabel dorado, negro, rojo, verde;
    
    // Declaramos las barras de progreso
    private JProgressBar barraDorado, barraNegro, barraRojo, barraVerde;
    static private int distanciaDorado, distanciaNegro, distanciaRojo, distanciaVerde;

    
    public carrera_OrtizMunozPablo() {
        initComponents();
         // Inicializamos los JLabel para los coches
        this.setLayout(null);  // Desactivar el layout para poder usar setBounds
        
        // Inicializar los JLabel para los coches
                // Agregar la imagen de fondo
                
         // Crear un JLayeredPane
        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setBounds(0, 0, this.getWidth(), this.getHeight()); // Tamaño del JLayeredPane
        panel1.add(layeredPane); // Añadir el JLayeredPane al JPanel
        
        
        ImageIcon fondo = (new ImageIcon(getClass().getResource("/carrera.png")));
        JLabel labelFondo = new JLabel(fondo);
        labelFondo.setBounds(0, 0, this.getWidth(), this.getHeight());
        layeredPane.add(labelFondo, 3);  // Agregar fondo al panel
        
        dorado = new JLabel(new ImageIcon(getClass().getResource("/dorado.png")));
        negro = new JLabel(new ImageIcon(getClass().getResource("/negro.png")));
        rojo = new JLabel(new ImageIcon(getClass().getResource("/rojo.png")));
        verde = new JLabel(new ImageIcon(getClass().getResource("/verde.png")));
        
        // Posicionar los coches
        dorado.setBounds(50, 80, 250, 150);
        negro.setBounds(50, 330, 250, 150);
        rojo.setBounds(50, 580, 250, 150);
        verde.setBounds(50, 820, 250, 150);
        
        
        
        // Inicializar las barras de progreso
        barraDorado = new JProgressBar();
        barraNegro = new JProgressBar();
        barraRojo = new JProgressBar();
        barraVerde = new JProgressBar();
        
        // Configurar las barras de progreso
        barraDorado.setBounds(50, 50, 950, 20);
        barraNegro.setBounds(50, 150, 950, 20);
        barraRojo.setBounds(50, 250, 950, 20);
        barraVerde.setBounds(50, 350, 950, 20);
        

      
        layeredPane.add(dorado,0);
        layeredPane.add(negro,0);
        layeredPane.add(rojo,0);
        layeredPane.add(verde,0);
        layeredPane.add(barraDorado,9);
        layeredPane.add(barraNegro,9); 
        layeredPane.add(barraRojo,9);
        layeredPane.add(barraVerde,9);
        layeredPane.add(btnReiniciar, 0);
        layeredPane.repaint();
        
        Carrera();
  
       
        
    }
     static public void actualizarDistancia(int id, int distancia) {
        switch (id) {
            case 1:
                distanciaDorado = distancia;
                break;
            case 2:
                distanciaNegro = distancia;
                break;
            case 3:
                distanciaRojo = distancia;
                break;
            case 4:
                distanciaVerde = distancia;
                break;
        }
    }
   private void reiniciarCarrera() {
    // Reiniciar las barras de progreso
    barraDorado.setValue(0);
    barraNegro.setValue(0);
    barraRojo.setValue(0);
    barraVerde.setValue(0);

    // Restablecer la posición de los coches
    dorado.setBounds(0, 80, 250, 150);
    negro.setBounds(0, 330, 250, 150);
    rojo.setBounds(0, 580, 250, 150);
    verde.setBounds(0, 820, 250, 150);
    
    // Restablecer las imágenes de los coches a su estado inicial
    dorado.setIcon(new ImageIcon(getClass().getResource("/dorado.png")));
    negro.setIcon(new ImageIcon(getClass().getResource("/negro.png")));
    rojo.setIcon(new ImageIcon(getClass().getResource("/rojo.png")));
    verde.setIcon(new ImageIcon(getClass().getResource("/verde.png")));
    
    // Restablecer la variable hayGanador
    carrera.hayGanador = false;

    // Volver a iniciar los hilos
    Carrera();
}
    private void Carrera() {
    // Crear y lanzar los hilos nuevamente
    Thread hiloDorado = new Thread(new carrera(barraDorado, dorado, 1));
    Thread hiloNegro = new Thread(new carrera(barraNegro, negro, 2));
    Thread hiloRojo = new Thread(new carrera(barraRojo, rojo, 3));
    Thread hiloVerde = new Thread(new carrera(barraVerde, verde, 4));

    hiloDorado.start();
    hiloNegro.start();
    hiloRojo.start();
    hiloVerde.start();
}
   public static void mostrarResultados() {
    String mensaje = "Resultados de la Carrera:\n";
    mensaje += "Cohete Dorado recorrió: " + distanciaDorado + " unidades.\n";
    mensaje += "Cohete Negro recorrió: " + distanciaNegro + " unidades.\n";
    mensaje += "Cohete Rojo recorrió: " + distanciaRojo + " unidades.\n";
    mensaje += "Cohete Verde recorrió: " + distanciaVerde + " unidades.\n";

    JOptionPane.showMessageDialog(null, mensaje, "Resultados de la Carrera", JOptionPane.INFORMATION_MESSAGE);
}

    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel1 = new javax.swing.JPanel();
        btnReiniciar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnReiniciar.setText("Reiniciar");
        btnReiniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReiniciarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addGap(529, 529, 529)
                .addComponent(btnReiniciar, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(638, Short.MAX_VALUE))
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                .addGap(0, 1013, Short.MAX_VALUE)
                .addComponent(btnReiniciar, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnReiniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReiniciarActionPerformed
        reiniciarCarrera();
        
    }//GEN-LAST:event_btnReiniciarActionPerformed

    /**
     * @param args the command line arguments
     */
    
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(carrera_OrtizMunozPablo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(carrera_OrtizMunozPablo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(carrera_OrtizMunozPablo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(carrera_OrtizMunozPablo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new carrera_OrtizMunozPablo().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnReiniciar;
    private javax.swing.JPanel panel1;
    // End of variables declaration//GEN-END:variables
}
