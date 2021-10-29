/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package botsingen;

/**
 *
 * @author rini
 */
import java.awt.*;

public class Rechthoek extends AbstractPlaatje {
  private Color kleur;
  
  public Rechthoek( int x, int y, int breedte, int hoogte, 
                 int dx, int dy, Color kleur, Rectangle wereld ) {
    super( x, y, dx, dy, wereld );
    
    setAfmeting( breedte, hoogte );
    this.kleur = kleur;
  }
  
  public void teken( Graphics g ) {
    g.setColor( kleur );
    g.fillRect( x, y, breedte, hoogte );
  }
}
	
