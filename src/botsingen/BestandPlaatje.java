/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package botsingen;

import java.awt.*;
import javax.swing.*;

public class BestandPlaatje extends AbstractPlaatje {
  private ImageIcon plaatje;
  
  public BestandPlaatje( String bestandsnaam, int x, int y, 
                         int dx, int dy, Rectangle wereld ) {
    super( x, y, dx, dy, wereld );
    plaatje = new ImageIcon( bestandsnaam );
    setAfmeting( plaatje.getIconWidth(), plaatje.getIconHeight() );
  }
  
  public void teken( Graphics g ) {
    plaatje.paintIcon( null, g, x, y ); 
  }
}
