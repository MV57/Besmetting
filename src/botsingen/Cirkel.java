/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package botsingen;

import java.awt.*;

public class Cirkel extends AbstractPlaatje {
  private Color kleur;
  
  public Cirkel( int x, int y, int diameter, int dx, int dy, Color kleur, Rectangle wereld ) {
    super( x, y, dx, dy, wereld );
    
    setAfmeting( diameter, diameter );
    this.kleur = kleur;
  }
  
  public void teken( Graphics g ) {
    g.setColor( kleur );
    g.fillOval( x, y, breedte, hoogte );
  }
  
  public void setKleur(Color kleur){
      this.kleur=kleur;
  }
}
