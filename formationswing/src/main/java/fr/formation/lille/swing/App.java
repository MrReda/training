package fr.formation.lille.swing;

import UI.PersonUI;

import javax.swing.*;
import java.awt.*;

/**
 * Hello Lille,Whatsup (::)!
 */

public class App {
    public static void main(String[] args) {

        JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER));
        f.getContentPane().add(new PersonUI());
        f.setSize(600, 280);
        f.setVisible(true);
    }
}
