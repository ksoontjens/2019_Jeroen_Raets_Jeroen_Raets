package hellotvxlet;

import java.util.Timer;
import javax.tv.xlet.*;
import org.bluray.ui.event.HRcEvent;
import org.dvb.event.EventManager;
import org.dvb.event.UserEvent;
import org.dvb.event.UserEventListener;
import org.dvb.event.UserEventRepository;
import org.havi.ui.HScene;
import org.havi.ui.HSceneFactory;

//Deze fucking image map is het C:\Program Files\TechnoTrend\TT-MHP-Browser\fileio\DSMCC\0.0.3
import org.havi.ui.HStaticText;
import org.havi.ui.HVisible;

public class HelloTVXlet implements Xlet, UserEventListener {

	//deze klasse neemt grote stukken over van oef1 dus die ga ik niet opnieuw uitleggen grts

    HScene scene;
	//hier maken we een nieuw object aan van het type MijnComponent, wat een klasse is die we gaan maken
	//beste is om nu ff naar mijncomponent te kijken en te zien wat die doet
	//voegen nieuw component toe met 0 0 postitie en 720 576 breedte hoogte
    Achtergrond achtergrond = new Achtergrond(0, 0, 720, 576);

    Sprite enemy[]=new Sprite[10];
    Sprite kogels[]=new Sprite[50];
    Sprite ship =new Sprite("spaceship.png",500, 500);
    Sprite kogel=null;
    String GoLeft = "++";
    String Goright = "--";
    String Direction ;
    int score =0;
    HStaticText hst=new HStaticText("SCORE:",0,10,100,50);
    HStaticText scoreBoard=new HStaticText(String.valueOf(score),60,10,100,50);
    
    
    public HelloTVXlet() {
    }

    public void initXlet(XletContext context) {
        
for (int i=0;i<5;i++)   enemy[i]  =new Sprite("fs_enemy02A.png",100*i, 100);
for (int i=5;i<10;i++)   enemy[i]  =new Sprite("fs_enemy02A.png",100*(i-5), 200);
	//scene maken
        scene = HSceneFactory.getInstance().getDefaultHScene();
scene.add(hst);
scene.add(scoreBoard);


	//hiermee maken we een nieuwe UserEventRepository aan, welke een hoop knoppen en functies bevat
	//hier gaan we ze gebruiken om de pijltjes toe te voegen
	//de naam hier is gewoon omdat die een naam moet hebben, ge kunt die evengoed ook "rep" of "aardbei" noemen ofzo w/e
        UserEventRepository rep = new UserEventRepository("naam");
	//voeg pijltjes toe aan rep
        rep.addAllArrowKeys();
	//nieuwe eventmanager zie oef 1	
        EventManager manager = EventManager.getInstance();
	//voegen een actie toe aan rep zodat rep iets doet als we hem aanroepen door op een pijltje te duwen
        manager.addUserEventListener(this, rep);
	//voegen onze elementen toe aan de scene (zie oef 1)
        scene.add(achtergrond);
      //  enemy=new EnemyShip();
    	//maken een nieuwe timer aan
        Timer t = new Timer();
	//maken een nieuwe timertask
        MijnTimerTask mtt = new MijnTimerTask();
	/*
	oke deze kan een grote verwar zijn, dus vanboven hebben we mc aangemaakt
	een component met positie 0, 0 en grootte 720 576, waarin we onze sterrenkaart
	gestoken hebben; Wat we nu gaan doen is deze doen bewegen.
	
	mtt.setMc(mc)
	stelt in de timertask klasse in de methode setMc de waarde van deze mc gelijk aan een variabele die daar mc_p heet
	lees verder in mtt klasse
	*/
        mtt.setHp(this);
    
		//we geven aan dat timer t een taak moet uitvoeren aan een vaste snelheid, namelijk de mtt timertask,
		//waarbij hij begint op 0 en elke 50 milliseconden deze timer task uitvoert
		t.scheduleAtFixedRate(mtt, 0, 20);

scene.add(ship);
for (int i=0;i<10;i++){  scene.add(enemy[i]);
        scene.popToFront(enemy[i]);
}

    
              scene.popToFront(ship);
        scene.validate();
        scene.setVisible(true);

    }

    public boolean testCollision(Sprite a, Sprite b)
    {
        return a.getBounds().intersects(b.getBounds());
    }
            
    public void run()
    { if (enemy[9].x>=600){ Direction = GoLeft; } if (enemy[0].x<5){ Direction = Goright; }
    for (int i=0;i<10;i++)  {  
    if  (Direction.equals(Goright)) enemy[i].x++;
        if  (Direction.equals(GoLeft)) enemy[i].x--;
        enemy[i].hezetBound();
    }
        achtergrond.ay++;
        if (achtergrond.ay>570) achtergrond.ay=0;
        achtergrond.repaint();
        if (kogel!=null) { kogel.y-=5; kogel.hezetBound(); }
        if (kogel!=null) 
            for (int i=0;i<10;i++)  {
            if (testCollision(kogel,enemy[i]))
        {
                            enemy[i].y=-1000;
            enemy[i].hezetBound();
            scene.remove(enemy[i]);
            scene.remove(kogel);
            kogel=null;
            score += 100;
            scoreBoard.setTextContent(String.valueOf(score), HVisible.NORMAL_STATE);
            scoreBoard.repaint();
            break;
        }
            }
        // 720 x 576
    }
	//pijltjes een functie geven om het ruimteschip te doen bewegen
    public void userEventReceived(UserEvent e) {
if (e.getType()==HRcEvent.KEY_RELEASED) return;
	//de 37, 39 etc, zijn de waardes van de pijltjes in userEvents, ge kunt da ook me ARROW_LEFT ofzoiets doen
	// maar ik ben dees gewoon dus da gaget worden sorry x
	
		//als het keyevent een code doorgeeft die matcht met een pijltje
        if (e.getCode() == HRcEvent.VK_LEFT) {
			//verschuiven we de x of y coordinaat van het ruimteschip in de richting van dat pijltje
            ship.x -= 5;
			//obligatory repaint
            ship.repaint();
            ship.hezetBound();
        }

        if (e.getCode() == HRcEvent.VK_RIGHT) {
            ship.x += 5;
            ship.repaint();
            ship.hezetBound();
                    
        }

        if (e.getCode() == HRcEvent.VK_UP && (kogel==null || kogel.y<-kogel.getHeight())) {
            kogel=new Sprite("bullet.png",ship.x, ship.y);
            
            scene.add(kogel);
            scene.popToFront(kogel);
                 }




    }

    public void startXlet() {
    }

    public void pauseXlet() {
    }

    public void destroyXlet(boolean unconditional) {
    }
}