package com.company;

import javax.swing.*;
import java.awt.*;

public class Evil {
 int x;
 int y;
 Image img = new ImageIcon("image/evil.gif").getImage();
 Image img2 = new ImageIcon("image/evils.gif").getImage();
 Road road;
 public Rectangle getRect(){
  return new Rectangle(x,y,280,79);
 }

 public Evil(int x, int y, Road road){
  this.x=x;
  this.y=y;
  this.road=road;
 }

 public void move(){
  x=x-road.p.v;

 }

}
