/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package botsingen;

import javax.swing.*;

public class Botsingen extends JFrame {
    private Animatiepaneel animatiepaneel;
    
    public Botsingen(){
        animatiepaneel = new Animatiepaneel();
        setContentPane(animatiepaneel);
    }
    
    public static void main(String[] args) {
	JFrame frame=new Botsingen();
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setSize(1200,1020);
	frame.setTitle("Bots");
	frame.setVisible(true);		
    }
}
