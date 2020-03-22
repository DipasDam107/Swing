/*
 JUEGO BUSCAMINAS
 */
package dam107t5e11;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class mainFrame extends javax.swing.JFrame {

    _BuscaMinas buscaminas;
    JButton[][] tablero;
    final int FILAS = 8;
    final int COLUMNAS = 8;
    int numBombas;

    /**
     * Creates new form mainFrame
     */
    public mainFrame() {
        initComponents();
        numBombas = Integer.valueOf(JOptionPane.showInputDialog(this, "Introduce numero de bombas: "));    
        tablero = new JButton[8][8];
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                tablero[i][j] = new JButton();
                tablero[i][j].setFont(new java.awt.Font("Tahoma", 0, 36));
                tablero[i][j].addActionListener(new java.awt.event.ActionListener() {
                    @Override
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        FActionPerformed(evt);
                    }
                });
                tablero[i][j].addMouseListener(new java.awt.event.MouseAdapter() {
                    @Override
                    public void mouseClicked(java.awt.event.MouseEvent evt) {
                        FActionPerformed(evt);
                    }
                });
                tablero[i][j].setName(Integer.toString(i) + Integer.toString(j));
                tablero[i][j].setBackground(Color.WHITE);
                tablero[i][j].setText("");
                panelBotones.add(tablero[i][j]);
            }
        }
        this.buscaminas = new _BuscaMinas(FILAS, COLUMNAS, numBombas);

    }

    public void FActionPerformed(java.awt.event.MouseEvent evt) {

        if (((java.awt.event.MouseEvent) evt).getButton() == java.awt.event.MouseEvent.BUTTON3
                && ((JButton) evt.getSource()).getBackground() != Color.yellow) {
            if (((JButton) evt.getSource()).getBackground() != Color.orange) {
                ((JButton) evt.getSource()).setBackground(Color.orange);
            } else {
                ((JButton) evt.getSource()).setBackground(Color.white);
            }

        }
    }

    public void FActionPerformed(java.awt.event.ActionEvent evt) {
        String nn = ((JButton) evt.getSource()).getName();
        int fila = Integer.parseInt(nn.substring(0, 1));
        int col = Integer.parseInt(nn.substring(1, 2));
        int x = buscaminas.elegir(fila, col);
        if (x == -1) { //perdiste
            ((JButton) evt.getSource()).setBackground(Color.red);
            JOptionPane.showMessageDialog(this, "Has perdido");
            mostrarCasillas();
            int seleccion = JOptionPane.showOptionDialog(
                    null, "¿Quiere Jugar Otra Vez?", "Fin Partida", //ventana, mensaje, título
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null, // icono: null para icono por defecto
                    new Object[]{"Si", "No"}, // opciones
                    //null para YES, NO y CANCEL
                    "Si" //opción con el foco
            );

            if (seleccion == JOptionPane.OK_OPTION) {
                reconstruir();
            } else {
                System.exit(0);
            }

        } else {
            for (int f = 0; f < 8; f++) {
                for (int c = 0; c < 8; c++) {
                    if (buscaminas.casillas[f][c].descubierta) {
                        tablero[f][c].setText(Integer.toString(buscaminas.casillas[f][c].valor));
                        tablero[f][c].setBackground(Color.yellow);
                    }
                }
            }
        }
        if (buscaminas.ganaste()) {
            JOptionPane.showMessageDialog(this, "Has ganado");
            mostrarCasillas();
            int seleccion = JOptionPane.showOptionDialog(
                    null, "¿Quiere Jugar Otra Vez?", "Fin de Juego", //ventana, mensaje, título
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null, // icono: null para icono por defecto
                    new Object[]{"Si", "No"}, // opciones
                    //null para YES, NO y CANCEL
                    "Si" //opción con el foco
            );

            if (seleccion == JOptionPane.OK_OPTION) {
                reconstruir();
            } else {
                System.exit(0);
            }
        }
    }

    public void reconstruir() {
        numBombas = Integer.valueOf(JOptionPane.showInputDialog(this, "Introduce numero de bombas: ")); 
        this.buscaminas = new _BuscaMinas(FILAS, COLUMNAS, numBombas);
        for (int f = 0; f < 8; f++) {
            for (int c = 0; c < 8; c++) {
                tablero[f][c].setBackground(Color.white);
                tablero[f][c].setText("");
            }
        }
    }

    public void mostrarCasillas() {
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                if (buscaminas.casillas[i][j].valor != -1) {
                    tablero[i][j].setText(Integer.toString(buscaminas.casillas[i][j].valor));
                    tablero[i][j].setBackground(Color.yellow);
                } else {
                    tablero[i][j].setBackground(Color.red);
                }

            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelBotones = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelBotones.setOpaque(false);
        panelBotones.setPreferredSize(new java.awt.Dimension(500, 500));
        panelBotones.setLayout(new java.awt.GridLayout(8, 8));
        getContentPane().add(panelBotones, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
    private javax.swing.JPanel panelBotones;
    // End of variables declaration//GEN-END:variables
}
