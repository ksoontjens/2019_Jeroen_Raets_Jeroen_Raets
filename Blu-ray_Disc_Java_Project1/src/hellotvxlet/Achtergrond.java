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
public class Achtergrond extends HComponent {

	//we maken een nieuw component dat een aantal png's gaat bevatten
	
	//gewoon een aantal lokale variabelen 
    int x = 300;
    int y = 500;
    int ay = 0;
    
	// een image is gewoon hey ik wil een foto in mijn programma zetten hoe doe ik dat ah image 

    Image sterren;
    Image spaceship;
	
    //zet hier je fotos en noem ze sterren.png en spaceship.png
	//C:\Program Files\TechnoTrend\TT-MHP-Browser\fileio\DSMCC\0.0.3

	//constructor van MijnComponent, elke keer als je een MijnComponent aanmaakt
	//moet je een x en y coordinaat meegeven voor hoogte en breedte en een x2 en y2 voor hun postitie op je scene
    
	public Achtergrond(int x, int y, int x2, int y2) {

		//Op dit component gaan we met setbounds de eigenschappen hierboven instellen want tot nu toe waren dit gewoon getallen
		//die je met je object hebt meegegeven bij de creatie
        this.setBounds(x, y, x2, y2);
		
		//hier zetten we bijhorende beelden in de variabelen die we gaan toevoegen aan de scene
        sterren = this.getToolkit().getImage("sterren.png");
    //    spaceship = this.getToolkit().getImage("spaceship.png");
		
		//een mediatracker houdt de positie bij van een image
		//als ge die wilt doen bewegen moet u programma kunnen onthouden waar die is en da doe een mediatracker
        MediaTracker mt = new MediaTracker(this);
		//voeg de img toe aan de mediatracker
        mt.addImage(spaceship, 1);

    }

	//paint methode gaan we gebruiken in hellotvxlet om onze images te tekenen.
	//die staat hier omdat die gebruikt moet worden op objecten van het type MijnComponent
    public void paint(Graphics g) {
		
		/*
		g.drawImage tekent object
		sterren, 0, ay, this
		naam	x	y	hallojaditobjectennidegelijkaardigefilemetzelfdenaam
		*/		
		//ay hebben we vanboven op 0 gezet om makkelijk te kunnen werken met een veranderende y coordinaat.
		//we laten een sterrenkaat schuiven op onze scene, en een 2e sterrenkaart er onder om deze aan te vullen
        g.drawImage(sterren, 0, ay, this);
        g.drawImage(sterren, 0, ay-570, this);
		//teken ruimteship
      //  g.drawImage(spaceship, x, y, this);


    }
}
