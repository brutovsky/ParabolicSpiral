/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parabolicspiral;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;

/**
 *
 * @author VADYM NAKYTNIAK
 */
public class PaintGraphPanel extends javax.swing.JPanel {

    //Variables declaration
    private int segmentation, indent_y, indent_x, lenght_y, lenght_x, l2;
    private float kx, ky, a;
    private double fi_min, fi_max, r, x, y, precision;
    private ArrayList<Double> list_x, list_y;

    private int div_intend;

    private int x_range;
    private int y_range;

    private final ChooseGraphPanel choosePanel;
    private final GraphModifierPanel modifyPanel;
    private final CoordinateSystemModifierPanel coordinatePanel;

    //Objects are initialized
    {
        list_x = new ArrayList<>();
        list_y = new ArrayList<>();
    }

    //Getters
    public float getA() {
        return a;
    }

    public double getFi_min() {
        return fi_min;
    }

    public double getFi_max() {
        return fi_max;
    }

    /**
     * Creates new form PaintGraphPanel
     *
     * @param choosePanel
     * @param modifyPanel
     * @param coordinatePanel
     */
    public PaintGraphPanel(ChooseGraphPanel choosePanel, GraphModifierPanel modifyPanel, CoordinateSystemModifierPanel coordinatePanel) {
        this.choosePanel = choosePanel;
        this.modifyPanel = modifyPanel;
        this.coordinatePanel = coordinatePanel;
        initComponents();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        //Initializes all variables
        initVariables();
        // paint Parabolic Spiral graph
        //positive
        if (choosePanel.getPositiveGraphRButton().isSelected()) {
            drawPositiveGraph(g);
        }
        //negative
        if (choosePanel.getNegativeGraphRButton().isSelected()) {
            drawNegativeGraph(g);
        }
        //set ranges
        g.setColor(Color.white);
        g.fillRect(0, 0, lenght_x / 2 - x_range, lenght_y);
        g.fillRect(lenght_x / 2 + x_range, 0, lenght_x / 2, lenght_y);
        g.fillRect(0, 0, lenght_x + 5, lenght_y / 2 - y_range);
        g.fillRect(0, lenght_y / 2 + y_range, lenght_x + 5, lenght_y / 2 - y_range);
        g.setColor(Color.black);
        //draw coordinate system
        drawCoordinateSystem(g);
        //draw all formulas
        drawFormulas(g);
        //draw mine signature
        drawSignature(g);
    }

    private void drawFormulas(Graphics g) {
        int x_length = 250;
        int y_length = 160;
        int start_y = this.getHeight() - y_length;
        int start_x = 1;
        int gap = 30;
        g.drawRect(start_x - 1, start_y, x_length, y_length);
        Font old_font = g.getFont();
        Font formulas_font = new Font("Microsoft JhengHei Light", Font.PLAIN, 20);
        g.setFont(formulas_font);
        g.drawString("FORMULAS", start_x, start_y);
        g.drawString("r^2 = 2*a*fi", start_x, start_y + gap);
        g.drawString("x = r*cos(fi)", start_x, start_y + 2 * gap);
        g.drawString("y = r*sin(fi)", start_x, start_y + 3 * gap);
        g.drawString("a = " + modifyPanel.getConstField().getText(), start_x, start_y + 4 * gap);
        g.drawString("fi = [" + modifyPanel.getFiMinField().getText() + "PI," + modifyPanel.getFiMaxField().getText() + "PI]", start_x, start_y + 5 * gap);
        g.setFont(old_font);
    }

    private void drawSignature(Graphics g) {
        Font old_font = g.getFont();
        Font signature_font = new Font("Microsoft JhengHei Light", Font.PLAIN, 20);
        g.setFont(signature_font);
        int width = 180;
        int height = 5;
        g.drawString("Nakytniak Vadym", getWidth() - width, getHeight() - height);
        g.setFont(old_font);
    }

    private void drawPositiveGraph(Graphics g) {
        list_x = new ArrayList<>();
        list_y = new ArrayList<>();
        for (double fi = fi_min; fi <= fi_max; fi += precision) {
            r = Math.sqrt(2 * a * fi);
            x = r * Math.cos(fi);
            y = -r * Math.sin(fi);
            list_x.add(x);
            list_y.add(y);
        }
        int[] array_x = new int[list_x.size()];
        for (int i = 0; i < list_x.size(); i++) {
            array_x[i] = list_x.get(i).intValue() + lenght_x / 2;
        }
        int[] array_y = new int[list_y.size()];
        for (int i = 0; i < list_y.size(); i++) {
            array_y[i] = list_y.get(i).intValue() + lenght_y / 2;
        }
        g.setColor(Color.BLUE);
        g.drawPolyline(array_x, array_y, array_x.length);
    }

    private void drawNegativeGraph(Graphics g) {
        list_x = new ArrayList<>();
        list_y = new ArrayList<>();
        for (double fi = fi_min; fi <= fi_max; fi += precision) {
            r = Math.sqrt(2 * a * fi);
            x = -r * Math.cos(fi);
            y = r * Math.sin(fi);
            list_x.add(x);
            list_y.add(y);
        }
        int[] array_x = new int[list_x.size()];
        for (int i = 0; i < list_x.size(); i++) {
            array_x[i] = list_x.get(i).intValue() + lenght_x / 2;
        }
        int[] array_y = new int[list_y.size()];
        for (int i = 0; i < list_y.size(); i++) {
            array_y[i] = list_y.get(i).intValue() + lenght_y / 2;
        }
        g.setColor(Color.RED);
        g.drawPolyline(array_x, array_y, array_x.length);
    }

    private void drawCoordinateSystem(Graphics g) {
        // Y axis
        g.drawLine((int) (lenght_x * kx + indent_x), indent_y,
                (int) (lenght_x * kx + indent_x), lenght_y + indent_y);
        // Arrows
        g.drawLine((int) (lenght_x * kx + indent_x), indent_y,
                (int) (lenght_x * kx + indent_x) - 3, indent_y + 10);
        g.drawLine((int) (lenght_x * kx + indent_x), indent_y,
                (int) (lenght_x * kx + indent_x) + 3, indent_y + 10);
        // Y String + 0
        g.drawString("Y", (int) (lenght_x * kx + indent_x) - 10, indent_y + 10);
        g.drawString("0", (int) (lenght_x * kx + indent_x) - 10, (int) (lenght_y * ky + indent_y) + 10);
        // Segmantations + coordinate numbers lettering
        int l1 = (int) (lenght_y * ky);
        l2 = lenght_y - l1;
        int k1 = (int) l1 / segmentation;
        int k2 = (int) l2 / segmentation;
        for (int i = 1; i < k1; i++) {
            int lx = (int) (lenght_x * kx - 2 + indent_x);
            int ly = l1 - segmentation + indent_y;
            g.drawLine(lx, ly,
                    (int) (lenght_x * kx + 2 + indent_x), l1 - segmentation + indent_y);
            g.setColor(Color.GRAY);
            double d = (double) (long) (i / ((double) coordinatePanel.getScaleSlider().getValue() / 100) * 10) / 10;
            g.drawString((new Double(d)).toString(), lx - div_intend, ly);
            g.setColor(Color.black);
            l1 = l1 - segmentation;
        }
        l1 = lenght_y - l2;
        for (int i = 1; i < k2 + 1; i++) {
            int lx = (int) (lenght_x * kx - 2 + indent_x);
            int ly = l1 + segmentation + indent_y;
            g.drawLine(lx, ly,
                    (int) (lenght_x * kx + 2 + indent_x), l1 + segmentation + indent_y);
            g.setColor(Color.GRAY);
            double d = -(double) (long) (i / ((double) coordinatePanel.getScaleSlider().getValue() / 100) * 10) / 10;
            g.drawString((new Double(d)).toString(), lx - div_intend, ly);
            g.setColor(Color.black);
            l1 = l1 + segmentation;
        }
        // Axis X
        g.drawLine(indent_x, (int) (lenght_y * ky + indent_y), lenght_x + indent_x, (int) (lenght_y * ky + indent_y));
        g.drawLine(lenght_x + indent_x, (int) (lenght_y * ky + indent_y), lenght_x + indent_x - 10,
                (int) (lenght_y * ky + indent_y) - 3);
        g.drawLine(lenght_x + indent_x, (int) (lenght_y * ky + indent_y), lenght_x + indent_x - 10,
                (int) (lenght_y * ky + indent_y) + 3);
        // X String
        g.drawString("�", lenght_x + indent_y - 10, (int) (lenght_y * ky + indent_y) - 10);
        // Segmantations
        l1 = (int) (lenght_x * kx);
        l2 = lenght_x - l1;
        k1 = (int) l1 / segmentation;
        k2 = (int) l2 / segmentation;
        for (int i = 1; i < k1 + 1; i++) {
            int lx = l1 - segmentation + indent_x;
            int ly = (int) (lenght_y * ky - 2 + indent_y);
            g.drawLine(lx, ly,
                    l1 - segmentation + indent_x, (int) (lenght_y * ky + 2 + indent_y));
            if (i % 3 == 0) {
                g.setColor(Color.GRAY);
                double d = -(double) (long) (i / ((double) coordinatePanel.getScaleSlider().getValue() / 100) * 10) / 10;
                g.drawString((new Double(d)).toString(), lx, ly + div_intend);
                g.setColor(Color.black);
            }
            l1 = l1 - segmentation;
        }
        l1 = lenght_x - l2;
        double xl = l1 / segmentation;
        double xl1 = l2 / segmentation;
        for (int i = 1; i < k2; i++) {
            int lx = l1 + segmentation + indent_x;
            int ly = (int) (lenght_y * ky - 2 + indent_y);
            g.drawLine(lx, ly,
                    l1 + segmentation + indent_x, (int) (lenght_y * ky + 2 + indent_y));
            if (i % 3 == 0) {
                g.setColor(Color.GRAY);
                double d = (double) (long) (i / ((double) coordinatePanel.getScaleSlider().getValue() / 100) * 10) / 10;
                g.drawString((new Double(d)).toString(), lx, ly + div_intend);
                g.setColor(Color.black);
            }
            l1 = l1 + segmentation;
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        setMaximumSize(new java.awt.Dimension(900, 500));
        setMinimumSize(new java.awt.Dimension(900, 500));
        setPreferredSize(new java.awt.Dimension(900, 500));
        setLayout(new java.awt.GridLayout());
    }// </editor-fold>//GEN-END:initComponents

    private void initVariables() {
        //for axis
        segmentation = 20;// value of division
        ky = (float) 0.5; // scale factor for y
        kx = (float) 0.5; // scale factor for x
        indent_y = 0; // initial indent for y
        indent_x = 0; //initial indent for x
        lenght_y = 500 - 10; // y axis length
        lenght_x = 900 - 10; // x axis length

        //for graph
        a = Float.parseFloat(modifyPanel.getConstField().getText()) * coordinatePanel.getScaleSlider().getValue() * coordinatePanel.getScaleSlider().getValue() / 100;
        fi_min = Math.PI * Float.parseFloat(modifyPanel.getFiMinField().getText());
        fi_max = Math.PI * Float.parseFloat(modifyPanel.getFiMaxField().getText());
        precision = Double.parseDouble(modifyPanel.getStepField().getText()) * 0.1;
        list_x = new ArrayList<>();
        list_y = new ArrayList<>();
        div_intend = 35;
        x_range = 2 * (Integer) modifyPanel.getRangeXSpinner().getValue();
        y_range = 2 * (Integer) modifyPanel.getRangeYSpinner().getValue();
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
