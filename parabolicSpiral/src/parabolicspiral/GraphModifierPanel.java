/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parabolicspiral;

/**
 *
 * @author VADIM
 */
public class GraphModifierPanel extends javax.swing.JPanel {

    /**
     * Creates new form GraphModifierPanel
     */
    public GraphModifierPanel() {
        initComponents();
        this.setSize(900, 100);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        constLabel = new javax.swing.JLabel();
        constSpinner = new javax.swing.JSpinner();
        fiMinLabel = new javax.swing.JLabel();
        fiMinSpinner = new javax.swing.JSpinner();
        fiMaxLabel = new javax.swing.JLabel();
        fiMaxSpinner = new javax.swing.JSpinner();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        drawGraphButton = new javax.swing.JButton();

        setMaximumSize(new java.awt.Dimension(600, 100));
        setMinimumSize(new java.awt.Dimension(600, 100));
        setPreferredSize(new java.awt.Dimension(600, 100));
        setLayout(new java.awt.GridBagLayout());

        constLabel.setText("const a:");
        add(constLabel, new java.awt.GridBagConstraints());

        constSpinner.setModel(new javax.swing.SpinnerNumberModel(2, 1, null, 1));
        add(constSpinner, new java.awt.GridBagConstraints());

        fiMinLabel.setText("fi min: PI *");
        add(fiMinLabel, new java.awt.GridBagConstraints());

        fiMinSpinner.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));
        add(fiMinSpinner, new java.awt.GridBagConstraints());

        fiMaxLabel.setText("fi max: PI *");
        add(fiMaxLabel, new java.awt.GridBagConstraints());

        fiMaxSpinner.setModel(new javax.swing.SpinnerNumberModel(4, 1, null, 1));
        add(fiMaxSpinner, new java.awt.GridBagConstraints());

        jButton2.setText("jButton2");
        add(jButton2, new java.awt.GridBagConstraints());

        jButton3.setText("jButton3");
        add(jButton3, new java.awt.GridBagConstraints());

        drawGraphButton.setText("Draw");
        add(drawGraphButton, new java.awt.GridBagConstraints());
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel constLabel;
    private javax.swing.JSpinner constSpinner;
    private javax.swing.JButton drawGraphButton;
    private javax.swing.JLabel fiMaxLabel;
    private javax.swing.JSpinner fiMaxSpinner;
    private javax.swing.JLabel fiMinLabel;
    private javax.swing.JSpinner fiMinSpinner;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    // End of variables declaration//GEN-END:variables
}
