package com.company;
import javax.swing.*;
public class Main {

    public static void main(String[] args) {
JFrame f = new JFrame("!Sakura drive!");
f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//закрывает игру на крестик
f.setSize(1600,900); // длина и высота окна
        f.add(new Road());
        f.setVisible(true);
    }
}
