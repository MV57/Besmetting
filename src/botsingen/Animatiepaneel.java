/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package botsingen;

import java.awt.*;
import java.util.*;
import java.awt.event.*;
import javax.swing.*;

public class Animatiepaneel extends JPanel {
  private ArrayList<SimCirkel> lijst;
  private javax.swing.Timer timer;
  private int aantalPersonen = 50;
  private int aantalBesmet = 0;
  private int aantalImmuun =0;
  private int tijdPaniek = 0;
  private int tijdPaniek80 = 0;
  
  public Animatiepaneel() {
    double t;
    int r;
    int x, y, dx, dy;
    setSize( 1180, 980 );
    timer = new javax.swing.Timer( 10, new TimerHandler() );
    lijst = new ArrayList<SimCirkel>();
    for (int i=0; i<aantalPersonen; i++){
        t=Math.random();
        t*=1180;
        x = (int)t;
        t=Math.random();
        t*=980;
        y = (int)t;
        t = Math.random();
        t*=8;
        r=(int)t;
        switch(r){
                case 0:
                {
                    dx=0; dy=1; break;
                }
                case 1:
                {
                    dx=1; dy=1; break;
                }
                case 2:
                {
                    dx=1; dy=0; break;
                }
                case 3:
                {
                    dx=1; dy=-1; break;
                }
                case 4:
                {
                    dx=0; dy=-1; break;
                }
                case 5:
                {
                    dx=-1; dy=-1; break;
                }
                case 6:
                {
                    dx=-1; dy=0; break;
                }
                case 7:
                {
                    dx=-1; dy=1; break;
                }
                default: 
                {
                    dx=0; dy=0;
                    System.out.println("geen geldig resultaat");
                }
        }
        //dx = (int)t-1;
        //t = Math.random();
        //t*=3;
        //dy = (int)t-1;
        lijst.add(new SimCirkel(x,y,dx,dy,getBounds()));
        //System.out.println(dx);
        //System.out.println(dy);
    }

    lijst.add( new SimCirkel( 200, 120, 1, 1, getBounds(), true ));

    timer.start();
  }

  public void paintComponent( Graphics g ) {
    super.paintComponent( g );
    setBackground( Color.WHITE );
    for( SimCirkel p : lijst ) {
      p.teken( g );
    }
  }
  
  private void verplaatsAlles() {
    for( SimCirkel p : lijst ) {
      p.verplaats();
    }
  }
  
  public int aantalBesmet(){
      int n = 0;
      for (SimCirkel p: lijst){
          if (p.getBesmet()){
              n+=1;
          }
      }
      return n;
  }
  
  public int aantalImmuun(){
      int n=0;
      for (SimCirkel p: lijst){
          if (p.getImmuun()){
              n=n+1;
          }
      }
      return n;
  }
  
  public int aantalResterend(){
      int n = 0;
      for (SimCirkel p: lijst){
          if (!p.getImmuun()){
              n+=1;
          }
      }
      return n;
  }
  
  private void controleerBotsingen() {
    int pos = 0;
    for( SimCirkel p : lijst ) {
      pos++;
      java.util.List<SimCirkel> sublijst =
                              lijst.subList( pos, lijst.size() );
      for( SimCirkel q : sublijst ) {
        if( p.botstMet( q ) ) {
          Point pRichting = p.getRichting();
          p.setRichting( q.getRichting() );
          q.setRichting( pRichting );
          if (p.getBesmet()){//als p besmet is
              if (!q.getBesmet()&&!q.getImmuun()){ //en q is niet besmet, en niet immuun
                  q.setBesmet(true); //dan wordt q besmet door p
                  break;//
              }
          }
          if (q.getBesmet()){//als q besmet is
              if (!p.getBesmet()&&!p.getImmuun()){//en p is niet besmet, en niet immuun
                  p.setBesmet(true);//dan wordt p besmet door q
              }
          }
        }
      }
    }
  }
  
  
  
  class TimerHandler implements ActionListener{
    public void actionPerformed( ActionEvent e ) {
        int d = (int)(aantalPersonen*0.8);
        int f = (int)(aantalPersonen*0.1);
        if (aantalBesmet()!=0){
            verplaatsAlles();
            controleerBotsingen();
            if (aantalBesmet()>f){
                if (aantalImmuun()>d){
                    tijdPaniek80+=1;
                }
                else {
                    tijdPaniek+=1;
                }
            }
            repaint();
        }
        else
        {
            System.out.println(aantalResterend());
            System.out.println(tijdPaniek);
            System.out.println(tijdPaniek80);
            System.exit(0);
        }
    }
  }
}
	
