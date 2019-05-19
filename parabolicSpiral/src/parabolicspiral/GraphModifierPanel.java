/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parabolicspiral;

import java.awt.Component;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.text.DecimalFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.InputVerifier;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.text.DefaultFormatterFactory;

/**
 *
 * @author VADIM
 */
public class GraphModifierPanel extends javax.swing.JPanel {

    ParabolicSpiralFrame frame;

    /**
     * Creates new form GraphModifierPanel
     */
    public GraphModifierPanel(ParabolicSpiralFrame frame) {
        initComponents();
        this.setSize(900, 100);
        this.frame = frame;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        constLabel = new javax.swing.JLabel();
        constField = new javax.swing.JTextField();
        fiMinLabel = new javax.swing.JLabel();
        fiMinField = new javax.swing.JFormattedTextField();
        fiMaxLabel = new javax.swing.JLabel();
        fiMaxField = new javax.swing.JFormattedTextField();
        rangeXLabel = new javax.swing.JLabel();
        rangeXSpinner = new javax.swing.JSpinner();
        rangeYLabel = new javax.swing.JLabel();
        rangeYSpinner = new javax.swing.JSpinner();
        stepLabel = new javax.swing.JLabel();
        stepField = new javax.swing.JFormattedTextField();
        drawGraphButton = new javax.swing.JButton();
        saveButton = new javax.swing.JButton();

        setMaximumSize(new java.awt.Dimension(600, 100));
        setMinimumSize(new java.awt.Dimension(600, 100));
        setPreferredSize(new java.awt.Dimension(1200, 100));
        setLayout(new java.awt.GridBagLayout());

        constLabel.setText("const a:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.weightx = 1.0;
        add(constLabel, gridBagConstraints);

        constField.setText("2");
        constField.setPreferredSize(new java.awt.Dimension(50, 30));
        add(constField, new java.awt.GridBagConstraints());

        fiMinLabel.setText("fi min: PI *");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.weightx = 1.0;
        add(fiMinLabel, gridBagConstraints);

        fiMinField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter()));
        fiMinField.setText("0");
        fiMinField.setMinimumSize(new java.awt.Dimension(50, 22));
        fiMinField.setPreferredSize(new java.awt.Dimension(50, 30));
        add(fiMinField, new java.awt.GridBagConstraints());

        fiMaxLabel.setText("fi max: PI *");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.weightx = 1.0;
        add(fiMaxLabel, gridBagConstraints);

        fiMaxField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter()));
        fiMaxField.setText("4");
        fiMaxField.setMinimumSize(new java.awt.Dimension(50, 22));
        fiMaxField.setPreferredSize(new java.awt.Dimension(50, 30));
        add(fiMaxField, new java.awt.GridBagConstraints());

        rangeXLabel.setText("range x:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.weightx = 1.0;
        add(rangeXLabel, gridBagConstraints);

        rangeXSpinner.setModel(new javax.swing.SpinnerNumberModel(450, 0, 450, 1));
        add(rangeXSpinner, new java.awt.GridBagConstraints());

        rangeYLabel.setText("range y:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.weightx = 1.0;
        add(rangeYLabel, gridBagConstraints);

        rangeYSpinner.setModel(new javax.swing.SpinnerNumberModel(250, 0, 250, 1));
        add(rangeYSpinner, new java.awt.GridBagConstraints());

        stepLabel.setText("step:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.weightx = 1.0;
        add(stepLabel, gridBagConstraints);

        stepField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter()));
        stepField.setText("1");
        stepField.setPreferredSize(new java.awt.Dimension(50, 30));
        add(stepField, new java.awt.GridBagConstraints());

        drawGraphButton.setText("Draw");
        drawGraphButton.setPreferredSize(new java.awt.Dimension(150, 100));
        drawGraphButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                drawGraphButtonMouseReleased(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.weightx = 5.0;
        add(drawGraphButton, gridBagConstraints);

        saveButton.setText("Save");
        saveButton.setMaximumSize(new java.awt.Dimension(150, 100));
        saveButton.setMinimumSize(new java.awt.Dimension(150, 100));
        saveButton.setPreferredSize(new java.awt.Dimension(150, 100));
        saveButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                saveButtonMouseReleased(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        add(saveButton, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void drawGraphButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_drawGraphButtonMouseReleased
        frame.repaintGraph();
    }//GEN-LAST:event_drawGraphButtonMouseReleased

    private void saveButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_saveButtonMouseReleased
        BufferedImage bImage = getScreenComponent(frame.getPaintGraph());
        try {
            File file = new File(System.getProperty("user.dir") + "/graphPictures/" + "Graph(a=" + frame.getPaintGraph().getA()/100 +";fi=["+frame.getPaintGraph().getFi_min()/Math.PI+"PI,"+frame.getPaintGraph().getFi_max()/Math.PI+"PI])" + ".png");
            if (file.exists()) {
                int res = JOptionPane.showConfirmDialog(null, "�� ��������, �� ������ ������������ ���� " + file.getName() + "?", "������������ ?", JOptionPane.YES_NO_CANCEL_OPTION);
                if (res == JOptionPane.YES_OPTION) {
                    file.createNewFile();
                } else {
                    return;
                }
            } else {
                file.createNewFile();
            }
            ImageIO.write(bImage, "png", file);
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        /*try {
            File file = new File("hello" + ".png");
            file.createNewFile();
            
        } catch (IOException ex) {
            Logger.getLogger(GraphModifierPanel.class.getName()).log(Level.SEVERE, null, ex);
        }*/
    }//GEN-LAST:event_saveButtonMouseReleased

    public JTextField getConstField() {
        return constField;
    }

    public JLabel getConstLabel() {
        return constLabel;
    }

    public JButton getDrawGraphButton() {
        return drawGraphButton;
    }

    public JFormattedTextField getFiMaxField() {
        return fiMaxField;
    }

    public JLabel getFiMaxLabel() {
        return fiMaxLabel;
    }

    public JFormattedTextField getFiMinField() {
        return fiMinField;
    }

    public JLabel getFiMinLabel() {
        return fiMinLabel;
    }

    public JLabel getRangeXLabel() {
        return rangeXLabel;
    }

    public JSpinner getRangeXSpinner() {
        return rangeXSpinner;
    }

    public JLabel getRangeYLabel() {
        return rangeYLabel;
    }

    public JSpinner getRangeYSpinner() {
        return rangeYSpinner;
    }

    public JFormattedTextField getStepField() {
        return stepField;
    }

    public JLabel getStepLabel() {
        return stepLabel;
    }

    public static BufferedImage getScreenComponent(Component component) {
        BufferedImage image = new BufferedImage(
                component.getWidth(),
                component.getHeight(),
                BufferedImage.TYPE_INT_RGB
        );
        component.paint(image.getGraphics());
        return image;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField constField;
    private javax.swing.JLabel constLabel;
    private javax.swing.JButton drawGraphButton;
    private javax.swing.JFormattedTextField fiMaxField;
    private javax.swing.JLabel fiMaxLabel;
    private javax.swing.JFormattedTextField fiMinField;
    private javax.swing.JLabel fiMinLabel;
    private javax.swing.JLabel rangeXLabel;
    private javax.swing.JSpinner rangeXSpinner;
    private javax.swing.JLabel rangeYLabel;
    private javax.swing.JSpinner rangeYSpinner;
    private javax.swing.JButton saveButton;
    private javax.swing.JFormattedTextField stepField;
    private javax.swing.JLabel stepLabel;
    // End of variables declaration//GEN-END:variables
}
