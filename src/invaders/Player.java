package invaders;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Player {

	protected Joc joc;
	float x,y;
	private BufferedImage tirador;
	protected ArrayList<Bala> firedBullets = new ArrayList<Bala>();
	protected Bala bala;
	long tempsDispar;
	int ample=45, alt=25,velocitat=-9;
	
	public Player(Joc joc, float x, float y) {
		this.joc=joc;
		this.x=x;
		this.y=y;
	}
	
	public void tick() {
		//shot = new MusicPlayer("/sound/shot.wav");
		if(joc.getKeyManager().left) {
			if(x-4>0) {
				x -= 10;
			}
		}
		if(joc.getKeyManager().right) {
			if(x+15<Joc.AMPLE-30) {
				x += 10;
			}
		}
		if(joc.getKeyManager().space) {
			if(System.currentTimeMillis()-tempsDispar>500) {
				Bala bala = new Bala(joc,(int)(x+22),Joc.ALT-72,velocitat,0);
		        firedBullets.add(bala);
		        //shot.play();
				tempsDispar=System.currentTimeMillis();
			}
		}
	}
	
	public void render(Graphics g) {
		tirador=ImageLoader.loadImage("/image/player.png");
		g.drawImage(tirador,(int)x, (int)y, ample, alt, null);
		
		g.setColor(Color.white);
		//g.fillRect((int)x+4,(int)y+7, 37, 17);
		barra(g);
		if(firedBullets.size()>0) {
		for(int i=0;i<firedBullets.size();i++){
			if(firedBullets.get(i).y-10>0) {
				(firedBullets.get(i)).shootBala(g,velocitat,0);
			}
			else if(firedBullets.get(i).y-10<0){
				firedBullets.remove(firedBullets.get(i));  //bala surt de la pantalla fora de la llista
			}
		}
		}
	}
	
	public void barra(Graphics g) {
		
		//VIDES
		
		g.setColor(Color.white);
		Font fnt1= new Font("verdana",Font.BOLD,alt);
		g.setFont(fnt1);
		g.drawString("LIVES", 10, Joc.ALT-10);

		Graphics2D g2 = (Graphics2D) g;
		g2.setStroke(new BasicStroke(5));
		g2.draw(new Line2D.Float(0,Joc.ALT-45 , Joc.AMPLE, Joc.ALT-45));
		
		for(int i=0;i<joc.vida;i++) {
			g.drawImage(tirador,120+i*ample, Joc.ALT-33, ample, alt, null);
		}
		
		//NIVELL
		g.drawString("LEVEL",Joc.AMPLE/2-50, Joc.ALT-10);
		g.drawString(Integer.toString(joc.nivell),Joc.AMPLE/2+70,Joc.ALT-10);
		
		//PUNTS
		
		g.drawString("SCORE", Joc.AMPLE-200, Joc.ALT-10);
		g.setColor(Color.red);
		g.drawString(Integer.toString(joc.punts), Joc.AMPLE-80, Joc.ALT-10);
	}
	
}
