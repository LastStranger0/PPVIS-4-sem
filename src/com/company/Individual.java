package com.company;

import javax.swing.*;
import java.awt.*;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

public class Individual {

    static boolean needWork = false;
    static Thread threadMover;

    Individual(){
        JFrame frame = new JFrame("PPVIS1_individual");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);

        ArrayList<Component> moveThis = new ArrayList<>();

        JTextField jTextField = new JTextField();
        JComboBox jButtonJComboBox = new JComboBox(new String[]{"Shift+r - start"});
        JButton button1 = new JButton("Shift+s - stop");

        moveThis.add(jTextField);
        moveThis.add(jButtonJComboBox);
        moveThis.add(button1);
        JPanel panel = new JPanel(new GridBagLayout());
        //panel.add(jButtonJComboBox);
        panel.add(jTextField);
        //panel.add(button1);

        jTextField.setFocusable(true);
        KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(
                e -> {
                    //System.out.println(e.getKeyCode());
                    if (e.getKeyChar() == 'R' || e.getKeyChar() == 'К') {
                        needWork = true;
                    }
                    if (e.getKeyChar() == 'S' || e.getKeyChar() == 'Ы') {
                        needWork = false;
                    }
                    return false;
                }
        );


        swingElements(moveThis);
        frame.getContentPane().setLayout(new GridLayout());
        frame.getContentPane().add(BorderLayout.NORTH, button1);
        frame.getContentPane().add(BorderLayout.CENTER, jTextField);
        frame.getContentPane().add(BorderLayout.SOUTH, jButtonJComboBox);
        frame.setVisible(true);

        threadMover.start();
    }

    static void swingElements(ArrayList<Component> moveThis) {
        threadMover = new Thread(new Runnable() {
            int curNum = 0;

            public void run() {
                while (true) {

                    System.out.println(needWork);
                    if (needWork) {
                        try {
                            movingTitles();
                            Thread.sleep(1000);
                        } catch (Exception e) {
                            System.out.println("f");
                        }
                    }
                }
            }

            public void movingTitles() {
                try {
                    SwingUtilities.invokeAndWait(() -> movingProcess(moveThis, curNum++));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    static void movingProcess(ArrayList<Component> moveThis, int curIteration) {
        curIteration = curIteration % moveThis.size();
        int x, y;
        int moveElemNum1 = clamp(0, moveThis.size(), curIteration - 1);
        int moveElemNum2 = clamp(0, moveThis.size(), curIteration);

        System.out.println(moveElemNum2 + " " + moveElemNum1);
        x = moveThis.get(moveElemNum1).getX();
        y = moveThis.get(moveElemNum1).getY();
        moveThis.get(moveElemNum1).
                move(
                        moveThis.get(moveElemNum2).getX(),
                        moveThis.get(moveElemNum2).getY());
        moveThis.get(moveElemNum2).move(x, y);
    }

    static  int clamp(int min,int max,int val){
        if(val>max)return (val-max-1);
        if(val<min)return (val+max);
        return  val;
    }
}
