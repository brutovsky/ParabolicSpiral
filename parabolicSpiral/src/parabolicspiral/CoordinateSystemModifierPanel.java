/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parabolicspiral;

import javax.swing.JSlider;

/**
 *
 * @author VADYM NAKYTNIAK
 */
public class CoordinateSystemModifierPanel extends javax.swing.JPanel {

    ParabolicSpiralFrame frame;

    /**
     * Creates new form CoordinateSystemModifierPanel
     */
    public CoordinateSystemModifierPanel(ParabolicSpiralFrame frame) {
        this.frame = frame;
        initComponents();
        this.setSize(300, 680);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scaleLabel = new javax.swing.JLabel();
        scaleSlider = new javax.swing.JSlider();

        setMaximumSize(new java.awt.Dimension(300, 680));
        setMinimumSize(new java.awt.Dimension(300, 680));
        setPreferredSize(new java.awt.Dimension(300, 680));
        addMouseWheelListener(new java.awt.event.MouseWheelListener() {
            public void mouseWheelMoved(java.awt.event.MouseWheelEvent evt) {
                formMouseWheelMoved(evt);
            }
        });
        setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.LINE_AXIS));

        scaleLabel.setFont(new java.awt.Font("Microsoft JhengHei Light", 0, 36)); // NOI18N
        scaleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        scaleLabel.setText("Scale:");
        scaleLabel.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        scaleLabel.setMaximumSize(new java.awt.Dimension(136, 49));
        scaleLabel.setMinimumSize(new java.awt.Dimension(136, 49));
        scaleLabel.setPreferredSize(new java.awt.Dimension(136, 49));
        add(scaleLabel);

        scaleSlider.setFont(new java.awt.Font("Microsoft JhengHei Light", 0, 14)); // NOI18N
        scaleSlider.setMajorTickSpacing(30);
        scaleSlider.setMaximum(400);
        scaleSlider.setMinimum(10);
        scaleSlider.setMinorTickSpacing(10);
        scaleSlider.setOrientation(javax.swing.JSlider.VERTICAL);
        scaleSlider.setPaintLabels(true);
        scaleSlider.setPaintTicks(true);
        scaleSlider.setValue(100);
        scaleSlider.setPreferredSize(new java.awt.Dimension(100, 475));
        scaleSlider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                scaleSliderStateChanged(evt);
            }
        });
        add(scaleSlider);
    }// </editor-fold>//GEN-END:initComponents

    private void scaleSliderStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_scaleSliderStateChanged
        frame.repaintGraph();
    }//GEN-LAST:event_scaleSliderStateChanged

    private void formMouseWheelMoved(java.awt.event.MouseWheelEvent evt) {//GEN-FIRST:event_formMouseWheelMoved
        scaleSlider.setValue(scaleSlider.getValue() + (int) evt.getPreciseWheelRotation());
    }//GEN-LAST:event_formMouseWheelMoved

    public JSlider getScaleSlider() {
        return scaleSlider;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel scaleLabel;
    private javax.swing.JSlider scaleSlider;
    // End of variables declaration//GEN-END:variables
}
