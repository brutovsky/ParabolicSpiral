/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parabolicspiral;

import java.awt.Color;
import java.awt.Graphics;
import java.text.AttributedCharacterIterator;
import java.util.ArrayList;

/**
 *
 * @author VADIM
 */
public class PaintGraphPanel extends javax.swing.JPanel {

    private int segmentation, nx, indent_y, oyk, oyx, indent_x, oxk, oxy, lenght_y, lenght_x, sw, xln, l2;
    private float xng, kx, ky, hx, yg, xk;
    private float a;
    private float fi_min = 0;
    private double fi_max = Math.PI * 4;
    private double r;
    private double x;
    private double y;
    private double precision = 0.01;
    private ArrayList<Double> list_x;
    private ArrayList<Double> list_y;

    private int div_intend;

    private int x_range;
    private int y_range;

    ChooseGraphPanel choosePanel;
    GraphModifierPanel modifyPanel;
    CoordinateSystemModifierPanel coordinatePanel;

    {
        list_x = new ArrayList<>();
        list_y = new ArrayList<>();
    }

    /**
     * Creates new form PaintGraphPanel
     */
    public PaintGraphPanel(ChooseGraphPanel choosePanel, GraphModifierPanel modifyPanel, CoordinateSystemModifierPanel coordinatePanel) {
        this.choosePanel =choosePanel;
        this.modifyPanel = modifyPanel;
        this.coordinatePanel = coordinatePanel;
        initComponents();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        segmentation = 20;// цена деления  по шкалам
        ky = (float) 0.5; // коэф шкалы по у
        kx = (float) 0.5; // коэф шкалы по x
        indent_y = 0; // начальный отступ по y
        indent_x = 0; //начальный отступ по х
        lenght_y = 500 - 10; // длина оси у
        lenght_x = 900 - 10; // длина оси х

        hx = (float) 0.011;//шаг табуляции

        //for graph
        a = Float.parseFloat(modifyPanel.getConstField().getText()) * 100;
        fi_min = 0;
        fi_max = Math.PI * 4;
        precision = 0.1;
        list_x = new ArrayList<>();
        list_y = new ArrayList<>();

        div_intend = 15;
        x_range = 450;
        y_range = 250;
        // paint Parabolic Spiral graph
        //positive
        drawPositiveGraph(g);
        //negative
        drawNegativeGraph(g);
        //set ranges
        g.setColor(Color.white);
        g.fillRect(0, 0, lenght_x / 2 - x_range, lenght_y);
        g.fillRect(lenght_x / 2 + x_range, 0, lenght_x / 2 - x_range, lenght_y);
        g.fillRect(0, 0, lenght_x, lenght_y / 2 - y_range);
        g.fillRect(0, lenght_y / 2 + y_range, lenght_x, lenght_y / 2 - y_range);
        g.setColor(Color.black);
        //Разбиваем каждую ось на две части для удобства переноса центра координат
        // Ось Y
        g.drawLine((int) (lenght_x * kx + indent_x), indent_y,
                (int) (lenght_x * kx + indent_x), lenght_y + indent_y);
        // Стрелки
        g.drawLine((int) (lenght_x * kx + indent_x), indent_y,
                (int) (lenght_x * kx + indent_x) - 3, indent_y + 10);
        g.drawLine((int) (lenght_x * kx + indent_x), indent_y,
                (int) (lenght_x * kx + indent_x) + 3, indent_y + 10);
        // Надпись
        g.drawString("Y", (int) (lenght_x * kx + indent_x) - 10, indent_y + 10);
        g.drawString("0", (int) (lenght_x * kx + indent_x) - 10, (int) (lenght_y * ky + indent_y) + 10);
        //Деления
        int l1 = (int) (lenght_y * ky);
        l2 = lenght_y - l1;
        int k1 = (int) l1 / segmentation;
        int k2 = (int) l2 / segmentation;
        for (int i = 1; i < k1; i++) {
            int lx = (int) (lenght_x * kx - 2 + indent_x);
            int ly = l1 - segmentation + indent_y;
            g.drawLine(lx, ly,
                    (int) (lenght_x * kx + 2 + indent_x), l1 - segmentation + indent_y);
            //MY CODE GOES HERE
            g.drawString(new Integer(i).toString(), lx - div_intend, ly);
            //
            l1 = l1 - segmentation;
        }
        l1 = lenght_y - l2;
        for (int i = 1; i < k2 + 1; i++) {
            int lx = (int) (lenght_x * kx - 2 + indent_x);
            int ly = l1 + segmentation + indent_y;
            g.drawLine(lx, ly,
                    (int) (lenght_x * kx + 2 + indent_x), l1 + segmentation + indent_y);
            //MY CODE GOES HERE
            g.drawString(new Integer(-i).toString(), lx - div_intend, ly);
            //
            l1 = l1 + segmentation;
        }
        // Ось Х
        g.drawLine(indent_x, (int) (lenght_y * ky + indent_y), lenght_x + indent_x, (int) (lenght_y * ky + indent_y));
        g.drawLine(lenght_x + indent_x, (int) (lenght_y * ky + indent_y), lenght_x + indent_x - 10,
                (int) (lenght_y * ky + indent_y) - 3);
        g.drawLine(lenght_x + indent_x, (int) (lenght_y * ky + indent_y), lenght_x + indent_x - 10,
                (int) (lenght_y * ky + indent_y) + 3);
        // Надпись
        g.drawString("Х", lenght_x + indent_y - 10, (int) (lenght_y * ky + indent_y) - 10);
        // Деления
        l1 = (int) (lenght_x * kx);
        l2 = lenght_x - l1;
        k1 = (int) l1 / segmentation;
        k2 = (int) l2 / segmentation;
        for (int i = 1; i < k1 + 1; i++) {
            int lx = l1 - segmentation + indent_x;
            int ly = (int) (lenght_y * ky - 2 + indent_y);
            g.drawLine(lx, ly,
                    l1 - segmentation + indent_x, (int) (lenght_y * ky + 2 + indent_y));
            //MY CODE GOES HERE
            g.drawString(new Integer(-i).toString(), lx, ly + div_intend);
            //
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
            //MY CODE GOES HERE
            g.drawString(new Integer(i).toString(), lx, ly + div_intend);
            //
            l1 = l1 + segmentation;
        }
    }

    public void drawPositiveGraph(Graphics g) {
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

    public void drawNegativeGraph(Graphics g) {
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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
