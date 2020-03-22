/* JUEGO NIM
 */
package dam107t5e12;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class mainFrame extends javax.swing.JFrame {

    _Nim juego;
    JButton[][] tablero;
    int[] maxFila = {3, 5, 7};

    /**
     * Creates new form mainFrame
     */
    public mainFrame() {

        initComponents();
        tablero = new JButton[3][7];
        juego = new _Nim();
        for (int f = 0; f < 3; f++) {
            for (int c = 0; c < maxFila[f]; c++) {
                tablero[f][c] = new JButton();
                tablero[f][c].addMouseListener(new java.awt.event.MouseAdapter() {
                    @Override
                    public void mouseEntered(java.awt.event.MouseEvent evt) {
                        FMouseEntered(evt);
                    }

                    @Override
                    public void mouseExited(java.awt.event.MouseEvent evt) {
                        FMouseExited(evt);
                    }
                });
                tablero[f][c].addActionListener(new java.awt.event.ActionListener() {
                    @Override
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        FActionPerformed(evt);
                    }
                });
                tablero[f][c].setName(Integer.toString(f) + Integer.toString(c));
                tablero[f][c].setBackground(Color.white);
                add(tablero[f][c]);
                tablero[f][c].setBounds(c * 40, f * 40, 30, 30);

            }
        }
        NuevaPartida();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public void FMouseEntered(java.awt.event.MouseEvent evt) {
        String nn = evt.getComponent().getName();
        int fila = Integer.parseInt(nn.substring(0, 1));
        int col = Integer.parseInt(nn.substring(1, 2));
        for (int i = col; i < maxFila[fila]; i++) {
            tablero[fila][i].setBackground(Color.gray);
        }
    }

    public void FMouseExited(java.awt.event.MouseEvent evt) {
        evt.getComponent().setBackground(Color.red);
        String nn = evt.getComponent().getName();
        int fila = Integer.parseInt(nn.substring(0, 1));
        int col = Integer.parseInt(nn.substring(1, 2));
        for (int i = col; i < maxFila[fila]; i++) {
            tablero[fila][i].setBackground(Color.white);
        }

    }

    private void FActionPerformed(java.awt.event.ActionEvent evt) {
        evt.getSource();
        String nn = ((JButton) evt.getSource()).getName();
        int fila = Integer.parseInt(nn.substring(0, 1));
        int col = Integer.parseInt(nn.substring(1, 2));
        for (int i = col; i < maxFila[fila]; i++) {
            tablero[fila][i].setVisible(false);
        }
        jugadaUsuario(fila, col);
        jugadaMaquina();
    }

    public void jugadaUsuario(int f, int c) {
        int cant = maxFila[f] - c;
        boolean ok = juego.Juega(f, cant);
        if (juego.Fin()) {
            FinPartida("Has ganado");
        } else {
            maxFila[f] = c;
        }
    }

    public void jugadaMaquina() {
        int jugada = juego.Piensa();
        int f = (int) (jugada / 10);
        int cant = jugada % 10;
        JOptionPane.showMessageDialog(this, "Quito " + cant + " de la fila " + (f + 1));
        for (int i = maxFila[f] - cant; i < maxFila[f]; i++) {
            tablero[f][i].setVisible(false);
        }
        boolean ok = juego.Juega(f, cant);
        if (juego.Fin()) {
            FinPartida("He ganado");
        } else {
            maxFila[f] -= cant;
        }
    }

    public void FinPartida(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje);
        int seleccion = JOptionPane.showOptionDialog(
                    null, "¿Quiere Jugar Otra Vez?", "Fin Partida", //ventana, mensaje, título
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null, // icono: null para icono por defecto
                    new Object[]{"Si", "No"}, // opciones
                    //null para YES, NO y CANCEL
                    "Si" //opción con el foco
            );
        if (seleccion == JOptionPane.YES_OPTION) {
            NuevaPartida();
        } else {
            System.exit(0);
        }
    }

    public void NuevaPartida() {
        maxFila[0] = 3;
        maxFila[1] = 5;
        maxFila[2] = 7;
        juego = new _Nim();
        for (int f = 0; f < 3; f++) {
            for (int c = 0; c < maxFila[f]; c++) {
                tablero[f][c].setBackground(Color.white);
                tablero[f][c].setVisible(true);
            }
        }
        this.setVisible(true);
        int seleccion = JOptionPane.showOptionDialog(
                    null, "¿Empieza la Maquina?", "Nueva Partida", //ventana, mensaje, título
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null, // icono: null para icono por defecto
                    new Object[]{"Si", "No"}, // opciones
                    //null para YES, NO y CANCEL
                    "No" //opción con el foco
            );
        if (seleccion == JOptionPane.YES_OPTION ) jugadaMaquina(); 
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
