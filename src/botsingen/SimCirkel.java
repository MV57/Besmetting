/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package botsingen;
/**
 * Write a description of class SimCirkel here.
 *
 * @author Rini
 * @version 18-10-2021
 */
import java.awt.*;

public class SimCirkel extends Cirkel
{
    // instance variables - replace the example below with your own
    private int tbesmet; //tijd (of aantal timeticks) besmet
    private boolean besmet;
    private boolean immuun;
    private int tmaxbesmet=1000;

    /**
     * Constructor for objects of class SimCirkel
     */
    public SimCirkel(int x, int y, int dx, int dy, Rectangle wereld)
    {
        // initialise instance variables
        super(x,y,10,dx,dy,Color.green,wereld);
        tbesmet=0;
        besmet=false;
        immuun=false;       
    }
    
    public SimCirkel(int x, int y, int dx, int dy, Rectangle wereld,boolean bsmt)
    {
        super(x,y,10,dx,dy,Color.green,wereld);
        besmet = bsmt;
        if (besmet) 
            setKleur(Color.red);
        tbesmet=0;
        immuun=false;
    }
    

    /**
     * methods
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public boolean getBesmet(){
        return besmet;
    }
    
    public void setBesmet(boolean besmet){
        this.besmet=besmet;
        if (besmet)
        {
            setKleur(Color.red);
        }
    }
    
    public boolean getImmuun(){
        return immuun;
    }
    
    public void setImmuun(boolean immuun){
        this.immuun=immuun;
        this.setKleur(Color.BLUE);
        this.setBesmet(false);
    }
    
    public void verplaats()
    {
        super.verplaats();
        if (!immuun)
        {
            if (besmet)
            {
                tbesmet+=1;
                if (tbesmet>=tmaxbesmet)
                {
                    setImmuun(true);
                }
            }
        }
    }  
    
}
