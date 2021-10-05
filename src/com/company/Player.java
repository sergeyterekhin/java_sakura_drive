package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class Player {
    public static final int maxx=0;
    public static final int maxx2=1285;
 public static final int maxy=390;
    public static final int maxy2=770;
    Image img = new ImageIcon("image/car2.gif").getImage();
    Image img2 = new ImageIcon("image/car.gif").getImage();
    public Rectangle getRect(){
        return new Rectangle(x,y,281,71);
    }
    int v = 20; // скорость
    int dv = 0; // ускорение
    int s = 0; // величина пути
    int layer1=0;
    int x=80;
    int y=700;
    int dy=0;
    int vs=0;
    int layer2=3118;
    double score=0;
    String tra = "Нажмите 1-5 чтобы включить";
    public static Music mp1;
    public static Music mp2;
    public static Music mp3;
    public static Music mp4;
    public static Music mp5;
    public void move(){
        vs+=1;
        if (vs==200) { v=v+1; vs=0;}
        s=s+v;
        x+=dv;
        score=score+v/120;
        if (x<=maxx) x=maxx;
        if (x>=maxx2) x=maxx2;
        y-=dy;
        if (y<=maxy) y=maxy;
        if (y>=maxy2) y=maxy2;
        if (layer2 - v <=0){
            layer1=0;
            layer2=3118;
        } else{
        layer1 = layer1 - v;
        layer2 = layer2 - v;
        }
    }

    public void  keyPressed(KeyEvent e){
int key=e.getKeyCode();
        if (key == KeyEvent.VK_W) { dy=15;}
        if (key == KeyEvent.VK_S) { dy=-15;}
        if (key == KeyEvent.VK_D) { dv=15;}
        if (key == KeyEvent.VK_A) { dv=-10;}
        if (key == KeyEvent.VK_1 && !tra.equals("Nightmare - plenka")) { tra="Nightmare - plenka"; mp1 =new Music("sound/sound1.wav",0.8); mp1.sound(); mp1.setVolume(); mp2.stop(); mp3.stop(); mp4.stop(); mp5.stop();}
        if (key == KeyEvent.VK_2 && !tra.equals("MACINTOSH PLUS - 420")) { tra="MACINTOSH PLUS - 420"; mp2 =new Music("sound/sound2.wav",0.8); mp2.sound(); mp2.setVolume(); mp1.stop(); mp3.stop(); mp4.stop(); mp5.stop();}
        if (key == KeyEvent.VK_3 && !tra.equals("Nightcall - Kavinsky")) { tra="Nightcall - Kavinsky"; mp3 =new Music("sound/sound3.wav",0.8); mp3.sound(); mp3.setVolume(); mp1.stop(); mp2.stop(); mp4.stop(); mp5.stop();}
        if (key == KeyEvent.VK_4 && !tra.equals("Resonance - HOME")) { tra="Resonance - HOME"; mp4 =new Music("sound/sound4.wav",0.8); mp4.sound(); mp4.setVolume(); mp1.stop(); mp3.stop(); mp2.stop(); mp5.stop();}
        if (key == KeyEvent.VK_5 && !tra.equals("Dogewell - Вишнёвая семерёка")) { tra="Dogewell - Вишнёвая семерёка"; mp5 =new Music("sound/sound5.wav",0.8); mp5.sound(); mp5.setVolume(); mp2.stop(); mp3.stop(); mp4.stop(); mp1.stop();}
    }

    public void  keyReleased(KeyEvent e){
        int key=e.getKeyCode();
        if (key == KeyEvent.VK_W) { dy=0;}
        if (key == KeyEvent.VK_S) { dy=0;}
        if (key == KeyEvent.VK_A) { dv=0;}
        if (key == KeyEvent.VK_D) { dv=0;}
    }

}
