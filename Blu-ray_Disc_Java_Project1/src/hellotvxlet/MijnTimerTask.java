package hellotvxlet;

import java.util.TimerTask;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author student
 */
public class MijnTimerTask extends TimerTask {

// maken een nieuw component aan
    HelloTVXlet hoofdprogramma;

//stellen nieuwe mc gelijk aan de meegegeven huidige waarde van het component mc_p
    public void setHp(HelloTVXlet mc_p) {
        hoofdprogramma = mc_p;
    }
	
	
	
    public void run() {
	//punt printen om timing te testen    
		System.out.println(".");
	//mc.ay=mc.ay+10
	//we tellen elke keer de timertask in hellotvxlet uitgevoerd wordt 10 op bij de y coordinaat van onze sterrenkaart
	//waardoor deze lijkt te bewegen
	
	// mtt.setMc(mc);
    // t.scheduleAtFixedRate(mtt, 0, 50);
	// daar dus ^
        hoofdprogramma.run();
        
    }
}
