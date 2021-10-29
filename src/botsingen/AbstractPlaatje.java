/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package botsingen;

import java.awt.*;

public abstract class AbstractPlaatje implements Plaatje {
  private int dx, dy;            // richting waarin plaatje beweegt
  private Rectangle wereld;      // venster waarin plaatje beweegt
  protected int x, y;            // lokatie van linker bovenhoek van plaatje
  protected int breedte, hoogte; // afmeting van plaatje
  
  public AbstractPlaatje( int x, int y, int dx, int dy, Rectangle wereld ) {
    this.x = x;
    this.y = y;
    this.dx = dx;
    this.dy = dy;
    this.wereld = wereld;
  }

  // Abstracte methode
  public abstract void teken( Graphics g );

  // Concrete methoden
  public Point getRichting() {
    return new Point( dx, dy );
  }
  
  public Rectangle getBox() {
    return new Rectangle( x, y, breedte, hoogte ); 
  }
  
  public void setRichting( Point richting ) {
    dx = richting.x;
    dy = richting.y;
  }
  
  public void setAfmeting( int breedte, int hoogte ) {
    this.breedte = breedte;
    this.hoogte = hoogte;
  }
  
  public boolean botstMet( Plaatje p ) {
    return getBox().intersects( p.getBox() );
  }
  
  public void verplaats() {
    if( x + dx <= wereld.x ||
        x + dx + breedte >= wereld.x + wereld.width )
      dx = -dx;

    if( y + dy <= wereld.y ||
        y + dy + hoogte >= wereld.y + wereld.height )
      dy = -dy;
    x += dx;
    y += dy;
  }
  
  public void setDx(int dx){
      this.dx=dx;
  }
  
  public void setDy(int dy){
      this.dy=dy;
  }
}
	
