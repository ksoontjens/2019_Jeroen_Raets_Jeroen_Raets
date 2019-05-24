/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hellotvxlet;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.MediaTracker;
import org.havi.ui.HComponent;

/**
 *
 * @author student
 */
public class Sprite extends HComponent {

	//we maken een nieuw component dat een aantal png's gaat bevatten
	
	//gewoon een aantal lokale variabelen 
    int x = 300;
    int y = 10;
    int ay = 0;
	// een image is gewoon hey ik wil een foto in mijn programma zetten hoe doe ik dat ah image 

    Image Enemy;
	
    //zet hier je fotos en noem ze sterren.png en spaceship.png
	//C:\Program Files\TechnoTrend\TT-MHP-Browser\fileio\DSMCC\0.0.3

	//constructor van MijnComponent, elke keer als je een MijnComponent aanmaakt
	//moet je een x en y coordinaat meegeven voor hoogte en breedte en een x2 en y2 voor hun postitie op je scene
    
	public Sprite(String fn, int x, int y) {

		//Op dit component gaan we met setbounds de eigenschappen hierboven instellen want tot nu toe waren dit gewoon getallen
		//die je met je object hebt meegegeven bij de creatie
     //   this.setBounds(x, y);
		
		//hier zetten we bijhorende beelden in de variabelen die we gaan toevoegen aan de scene
        
        Enemy = this.getToolkit().getImage(fn);
		
		//een mediatracker houdt de positie bij van een image
		//als ge die wilt doen bewegen moet u programma kunnen onthouden waar die is en da doe een mediatracker
        MediaTracker mt = new MediaTracker(this);
		//voeg de img toe aan de mediatracker
        mt.addImage(Enemy, 1);

        try{mt.waitForAll();}
        catch (Exception e) { e.printStackTrace(); 
                System.out.println(Enemy);
        
    }
this.setBounds(x, y, Enemy.getWidth(this), Enemy.getHeight(this));
this.x=x;
this.y=y;
        }

	//paint methode gaan we gebruiken in hellotvxlet om onze images te tekenen.
	//die staat hier omdat die gebruikt moet worden op objecten van het type Enemy
        public void hezetBound()
        {
this.setBounds(x, y, Enemy.getWidth(this), Enemy.getHeight(this));
        }
        public void paint(Graphics g) {
		
		/*
		g.drawImage tekent object
		sterren, 0, ay, this
		naam	x	y	hallojaditobjectennidegelijkaardigefilemetzelfdenaam
		*/		
		//ay hebben we vanboven op 0 gezet om makkelijk te kunnen werken met een veranderende y coordinaat.
		//we laten een sterrenkaat schuiven op onze scene, en een 2e sterrenkaart er onder om deze aan te vullen
        
		//teken ruimteship
        g.drawImage(Enemy, 0, 0, this);


    }
}
