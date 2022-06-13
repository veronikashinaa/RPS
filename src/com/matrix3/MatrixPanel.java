package com.matrix3;


import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.JLabel;

import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class MatrixPanel extends JPanel implements ActionListener {
    final private Integer[] SIZE = {1,2,3,4,5};
    private JPanel tools, matrix;
    private JLabel labelDemo;
    private JComboBox<Integer> rSizeSelector, cSizeSelector;
    public JSpinner cells[][];

    MatrixPanel() {
        setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(350, 350));
        setMinimumSize(new Dimension(350, 350));
        tools = new JPanel();


        labelDemo = new JLabel(" X ");
        rSizeSelector = new JComboBox<Integer>(SIZE);
        cSizeSelector = new JComboBox<Integer>(SIZE);
        rSizeSelector.addActionListener(this);
        cSizeSelector.addActionListener(this);

        tools.add(rSizeSelector);
        tools.add(labelDemo);
        tools.add(cSizeSelector);

        resizeArray((int)rSizeSelector.getSelectedItem(),
                (int)cSizeSelector.getSelectedItem());

        add(tools, BorderLayout.NORTH);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        remove(matrix);
        resizeArray((int)rSizeSelector.getSelectedItem(),
                (int)cSizeSelector.getSelectedItem());
        this.revalidate();
    }

    private void resizeArray(int rows, int cols) {
        matrix = new JPanel();
        matrix.setLayout(new GridLayout(rows, cols));
        cells = new JSpinner[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                JSpinner tp = new JSpinner(new SpinnerNumberModel(0.00, -1000.00, 1000.00, 0.25));
                JPanel p = new JPanel();

                tp.setBounds(0, 0, 100, 25);
                tp.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                tp.setPreferredSize(new Dimension(50,30));
                tp.setFont(new Font("Serif", Font.PLAIN, 18));

                cells[i][j] = tp;
                p.add(cells[i][j]);
                matrix.add(p);
            }
        }
        add(matrix, BorderLayout.CENTER);
    }


}
