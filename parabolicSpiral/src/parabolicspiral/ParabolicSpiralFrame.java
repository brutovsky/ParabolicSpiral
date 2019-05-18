/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parabolicspiral;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JOptionPane;

/**
 *
 * @author VADIM
 */
public class ParabolicSpiralFrame extends javax.swing.JFrame {

    private PaintGraphPanel paintGraph; // class that draws the graph
    private ChooseGraphPanel chooseGraph; // class for radioButtons to choose the graph
    private GraphModifierPanel modifyGraph; // class for modifying the graph
    private CoordinateSystemModifierPanel coordinateModifier; // class for modifying the coordinate system

    /**
     * Creates new form ParabolicSpiralFrame
     */
    public ParabolicSpiralFrame() {
        initComponents();
        chooseGraph = new ChooseGraphPanel();
        modifyGraph = new GraphModifierPanel(this);
        coordinateModifier = new CoordinateSystemModifierPanel();
        paintGraph = new PaintGraphPanel(chooseGraph, modifyGraph, coordinateModifier);
        paintGraph.setBackground(Color.white);
        add(chooseGraph, BorderLayout.NORTH);
        add(paintGraph, BorderLayout.CENTER);
        add(coordinateModifier, BorderLayout.EAST);
        add(modifyGraph, BorderLayout.SOUTH);

        /*
        this.add(chooseGraph);
        this.add(paintGraph);
        this.add(modifyGraph);
         */
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
        setTitle("Parabolic Spiral Graph");
        setBackground(new java.awt.Color(255, 255, 255));
        setMaximumSize(new java.awt.Dimension(1200, 650));
        setMinimumSize(new java.awt.Dimension(1200, 650));
        setPreferredSize(new java.awt.Dimension(1200, 650));
        setResizable(false);

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
            java.util.logging.Logger.getLogger(ParabolicSpiralFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ParabolicSpiralFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ParabolicSpiralFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ParabolicSpiralFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ParabolicSpiralFrame().setVisible(true);
            }
        });
    }

    public void repaintGraph() {
       paintGraph.repaint();
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
