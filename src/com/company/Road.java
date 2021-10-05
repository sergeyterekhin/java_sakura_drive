package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;
import java.util.Random;

public class Road extends JPanel implements ActionListener, Runnable {
Timer mainTimer = new Timer(20,this);
//загружает фон
 Player p = new Player();
 Image img = new ImageIcon("image/road.png").getImage();
 Thread evilFactory = new Thread(this);
 List<Evil> evils = new ArrayList<Evil>();
    long startTime = System.nanoTime();
    long estimatedTime;

    public Road(){
    mainTimer.start();
    evilFactory.start();
    addKeyListener(new myKeyAdapter());
    setFocusable(true);
}


    private class myKeyAdapter extends KeyAdapter{
     public void keyPressed(KeyEvent e){
       p.keyPressed(e);
     }
    public void keyReleased(KeyEvent e){
        p.keyReleased(e);
    }

}

    public void paint(Graphics g) {
    g = (Graphics2D) g;
    g.drawImage(img,p.layer1,0,null);//рисовать фон
        g.drawImage(img,p.layer2,0,null);//рисовать фон 2
        if(p.v>=60) { g.drawImage(p.img2,p.x,p.y,null);} else g.drawImage(p.img,p.x,p.y,null);
        if(p.v==42) { img = new ImageIcon("image/road2.png").getImage();}
        if(p.v==52) { img = new ImageIcon("image/road3.png").getImage();}
        if(p.v==60) { img = new ImageIcon("image/road4.png").getImage(); }
        g.setColor(Color.MAGENTA);
   Font font=new Font("Arial",Font.BOLD,20);
   g.setFont(font);
   g.drawString("Скорость: "+p.v*2+" Км/ч",0,30);
   g.drawString("Время поездки: "+((System.nanoTime() - startTime)/1000000000)+" секунд",0,50);
        g.drawString("Трек: "+p.tra,0,70);

   Iterator<Evil> i = evils.iterator();
        while(i.hasNext()){
            Evil e=i.next();
            if (e.x<-3118) {
                i.remove();
            } else {
                e.move();
   if (p.v>=60) {g.drawImage(e.img2,e.x,e.y,this);} else {g.drawImage(e.img,e.x,e.y,this);}
            }
        }
        }//рисует



    public void actionPerformed(ActionEvent e){ //что двигает таймер
        p.move();
        repaint();
testCollisionWithEvils();
    }

    private void testCollisionWithEvils(){
        Iterator<Evil> i = evils.iterator();
        while(i.hasNext()){
            Evil e = i.next();
            if (p.getRect().intersects(e.getRect())) {
               JOptionPane.showMessageDialog(null,"Вы разбились");
               System.exit(1);
            }


        }
    }

    @Override
    public void run() {
        while(true){
            Random random = new Random();
            try {
                Thread.sleep(1800);
              evils.add(new Evil(1900,390+random.nextInt(390),this));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
