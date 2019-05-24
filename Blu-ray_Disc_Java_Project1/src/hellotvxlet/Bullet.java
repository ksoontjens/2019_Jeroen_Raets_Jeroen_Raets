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
public class Bullet extends HComponent {

    //zeggen dat ik een image wil gebruiken voor de bullet. 
    Image bullet;
    
    int x = 300;
    int y = 500;
    
    public Bullet(int x, int y, int x2, int y2) {
		//Op dit component gaan we met setbounds de eigenschappen hierboven instellen want tot nu toe waren dit gewoon getallen
		//die je met je object hebt meegegeven bij de creatie
		
		//hier zetten we bijhorende beelden in de variabelen die we gaan toevoegen aan de scene
        bullet = this.getToolkit().getImage("bullet.png");
		
		//een mediatracker houdt de positie bij van een image
		//als ge die wilt doen bewegen moet u programma kunnen onthouden waar die is en da doe een mediatracker
        MediaTracker mt = new MediaTracker(this);
		//voeg de img toe aan de mediatracker
        mt.addImage(bullet, 1);
    }
    //de volgende methode gaat de bullet tekenen.
    public void paint(Graphics g) {
		
		/*
		g.drawImage tekent object
		sterren, 0, ay, this
		naam	x	y	hallojaditobjectennidegelijkaardigefilemetzelfdenaam
		*/		
		//ay hebben we vanboven op 0 gezet om makkelijk te kunnen werken met een veranderende y coordinaat.
		//we laten een sterrenkaat schuiven op onze scene, en een 2e sterrenkaart er onder om deze aan te vullen

		//teken ruimteship
        g.drawImage(bullet, x, y, this);
    }
}
