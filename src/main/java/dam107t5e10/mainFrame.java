/*
 Realizar un programa que dibuje un tablero de ajedrez con un array de 8 x 8 botones, en colores
alternos. Al pulsar un botón, mostrará una ventana de diálogo con la fila y columna del botón pulsado.
Pista: la fila y columna pueden ser reflejadas en el nombre del botón manipulable con setName() y
getName().

 */
package dam107t5e10;

import java.awt.Color;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author dam107
 */
public class mainFrame extends javax.swing.JFrame {

    JButton[][] casillas;

    /**
     * Creates new form mainFrame
     */
    public mainFrame() {
        initComponents();
        boolean blanco= true;
        this.setSize(500, 500);
        casillas = new JButton[8][8];
        for (int i = 0; i < casillas.length; i++) {
            for (int j = 0; j < casillas[i].length; j++) {
                
                casillas[i][j] = new JButton();
                casillas[i][j].setName("Fila " + (i+1) + " Columna " + (j+1));
                casillas[i][j].addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        tarea(evt);
                    }
                });
                
                if(blanco){ casillas[i][j].setBackground(Color.white); blanco=false;}
                else{ casillas[i][j].setBackground(Color.black); blanco=true;}
                this.add(casillas[i][j]);
             
            }
            if(blanco) blanco=false;
            else blanco=true;
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.GridLayout(8, 8));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void tarea(java.awt.event.ActionEvent evt) {
        int fila, columna;
        String nom = ((JButton) evt.getSource()).getName();
        JOptionPane.showMessageDialog(this, nom);
        
    }

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
            java.util.logging.Logger.getLogger(mainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(mainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(mainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(mainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new mainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
