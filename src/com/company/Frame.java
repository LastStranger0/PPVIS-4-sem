package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Frame {
    Frame(){
        JFrame frame = new JFrame("PPVIS1");


        frame.setSize(1700, 880);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JPanel container1 = new JPanel();
        JTextField textField1 = new JTextField(15);
        ArrayList<String> fromTextField = new ArrayList<String>();
        JComboBox comboBox1 = new JComboBox(fromTextField.toArray());
        JButton button1 = new JButton("Add");

        button1.addActionListener(e ->  {
            if(!fromTextField.contains(textField1.getText())) {
                fromTextField.add(textField1.getText());
                comboBox1.addItem(textField1.getText());
            } else {
                JOptionPane.showMessageDialog(button1, "Already in JComboBox");
            }
        });
        container1.add(textField1, BorderLayout.WEST);
        container1.add(button1, BorderLayout.CENTER);
        container1.add(comboBox1, BorderLayout.EAST);



        JPanel container2 = new JPanel();

        JButton button21 = new JButton("Set 2 name");
        JButton button22 = new JButton("Reverse name");
        JTextField textField2 = new JTextField(15);
        button21.addActionListener(e -> {
            button22.setText(textField2.getText());
        });
        button22.addActionListener(e -> {
            String s = button22.getText();
            button22.setText(button21.getText());
            button21.setText(s);
        });
        container2.add(textField2, BorderLayout.WEST);
        container2.add(button21, BorderLayout.CENTER);
        container2.add(button22, BorderLayout.EAST);



        JPanel container3 = new JPanel();

        JTextField textField3 = new JTextField(15);
        JButton button3 = new JButton("On/Off");
        JRadioButton radioButton31 = new JRadioButton("1");
        JRadioButton radioButton32 = new JRadioButton("2");
        JRadioButton radioButton33 = new JRadioButton("3");

        button3.addActionListener(e -> {
            if(textField3.getText().equals(radioButton31.getText())) {
                radioButton31.setSelected(true);
                radioButton32.setSelected(false);
                radioButton33.setSelected(false);
            }

            else if(textField3.getText().equals(radioButton32.getText())) {
                radioButton31.setSelected(false);
                radioButton32.setSelected(true);
                radioButton33.setSelected(false);
            }

            else if(textField3.getText().equals(radioButton33.getText())) {
                radioButton31.setSelected(false);
                radioButton32.setSelected(false);
                radioButton33.setSelected(true);
            }
            else {
                JOptionPane.showMessageDialog(button3, "Write 1,2 or 3");
            }
        });
        container3.add(textField3, BorderLayout.WEST);
        container3.add(button3, BorderLayout.CENTER);
        container3.add(radioButton31, BorderLayout.EAST);
        container3.add(radioButton32, BorderLayout.EAST);
        container3.add(radioButton33, BorderLayout.EAST);


        JPanel container4 = new JPanel();

        JTextField textField4 = new JTextField(15);
        JButton button4 = new JButton("On/Off");
        JCheckBox checkBox41 = new JCheckBox("1");
        JCheckBox checkBox42 = new JCheckBox("2");
        JCheckBox checkBox43 = new JCheckBox("3");

        button4.addActionListener(e -> {
            if(textField4.getText().equals(checkBox41.getText())){
                if(checkBox41.isSelected()){
                    checkBox41.setSelected(false);
                } else {
                    checkBox41.setSelected(true);
                }
            }

            else if(textField4.getText().equals(checkBox42.getText())){
                if(checkBox42.isSelected()){
                    checkBox42.setSelected(false);
                } else {
                    checkBox42.setSelected(true);
                }
            }

            else if(textField4.getText().equals(checkBox43.getText())){
                if(checkBox43.isSelected()){
                    checkBox43.setSelected(false);
                } else {
                    checkBox43.setSelected(true);
                }
            }
            else {
                JOptionPane.showMessageDialog(button4, "Write 1, 2, or 3");
            }
        });
        container4.add(textField4, BorderLayout.WEST);
        container4.add(button4, BorderLayout.CENTER);
        container4.add(checkBox41, BorderLayout.EAST);
        container4.add(checkBox42, BorderLayout.EAST);
        container4.add(checkBox43, BorderLayout.EAST);

        JPanel container5 = new JPanel();

        JTextField textField5 = new JTextField(15);
        JButton button51 = new JButton("To first");
        JButton button52 = new JButton("1->2");
        JButton button53 = new JButton("2->1");
        JTable table = new JTable(8,2);

        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        table.setCellSelectionEnabled(true);

        button51.addActionListener(e -> {
            table.setValueAt(textField5.getText(), table.getSelectedRow(), 0);
        });

        button52.addActionListener(e->{
            int selectedRow = table.getSelectedRow();
            int selectedColumn = table.getSelectedColumn();
            String value = (String) table.getValueAt(selectedRow, selectedColumn);
            if (value != null && !value.equals("")) {
                table.setValueAt(
                        table.getValueAt(selectedRow, selectedColumn), selectedRow, selectedColumn == 1 ? 0 : 1);
                table.setValueAt("", selectedRow, selectedColumn == 0 ? 0 : 1);
                table.changeSelection(selectedRow, selectedColumn == 1 ? 0 : 1, true, true);
            } else JOptionPane.showMessageDialog(table, "No data in 1st col");
        });

        button53.addActionListener(e -> {

            int selectedRow = table.getSelectedRow();
            int selectedColoumn = table.getSelectedColumn();
            String value = (String) table.getValueAt(selectedRow, selectedColoumn);
            if (value != null && !value.equals("")) {
                table.setValueAt(value, selectedRow, selectedColoumn == 0 ? 1 : 0);
                table.setValueAt("", selectedRow, selectedColoumn == 1 ? 1 : 0);
                table.changeSelection(selectedRow, selectedColoumn == 0 ? 1 : 0, true, false);

            } else JOptionPane.showMessageDialog(table, "No data in 2nd col");
        });
        container5.add(textField5, BorderLayout.WEST);
        container5.add(table, BorderLayout.CENTER);
        container5.add(button51, BorderLayout.EAST);
        container5.add(button52, BorderLayout.EAST);
        container5.add(button53, BorderLayout.EAST);



        panel.add(container1);
        panel.add(container2);
        panel.add(container3);
        panel.add(container4);
        panel.add(container5);
        frame.add(panel);

        frame.setVisible(true);
    }
}
