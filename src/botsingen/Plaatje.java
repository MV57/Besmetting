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

public interface Plaatje {
  public boolean botstMet( Plaatje plaatje );
  public Rectangle getBox();
  public Point getRichting();
  public void setRichting( Point richting );
  public void teken( Graphics g );
  public void verplaats();
}  
