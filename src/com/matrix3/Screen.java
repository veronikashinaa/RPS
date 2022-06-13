package com.matrix3;


import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.GridBagConstraints;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import javax.swing.JButton;
import javax.swing.JComboBox;

public class Screen extends JFrame implements ActionListener {
    final private int PLUS = 0;
    final private int MINUS = 1;
    final private int MULTIPLICATION = 2;
    final Character[] SIGN = {'+', '-', '*'};
    private MatrixPanel leftPanel, rightPanel;
    private JButton resultButton;
    private JComboBox<Character> signSelector;
    private Matrix m1, m2;
    Screen(){
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(900, 500));
        setMinimumSize(new Dimension(900, 500));
        setResizable(true);

        setLocationRelativeTo(null);

        setLayout(new GridBagLayout());

        GridBagConstraints contentGridBC = new GridBagConstraints();
        contentGridBC.insets = new Insets(0, 5, 5, 15);

        contentGridBC.gridx = 0;
        contentGridBC.gridy = 0;

        leftPanel = new MatrixPanel();
        add(leftPanel,contentGridBC);

        contentGridBC.gridx = 10;

        rightPanel = new MatrixPanel();
        add(rightPanel,contentGridBC);

        signSelector = new JComboBox<Character>(SIGN);
        resultButton = new JButton("=");
        resultButton.addActionListener(this);

        contentGridBC.gridx = 15;
        add(resultButton,contentGridBC);

        contentGridBC.gridx = 5;
        add(signSelector,contentGridBC);

        pack();
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        m1 = new Matrix(leftPanel.cells);
        m2 = new Matrix(rightPanel.cells);

        switch(signSelector.getSelectedIndex()) {
            case PLUS:
                Matrix.Add(m1, m2);
                break;
            case MINUS:
                Matrix.Sub(m1, m2);
                break;
            case MULTIPLICATION:
                Matrix.Mul(m1, m2);
                break;
        }
    }

}
