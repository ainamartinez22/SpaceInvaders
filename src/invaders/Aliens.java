package invaders;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Aliens {

	protected Joc joc;
	int x1=170,y1=75,x2=170,y2=40,x0=170,y0=105;
	private BufferedImage alien,alien0,alien1,alien2,alien11,alien21;
	int vida;
	int angleX=3, index=0, angleY=3;
	private long temps,crono=0,tempsDispar=0,tempsdispar2=0,crono2=0,temps2;
	public long tempsexplo=0;
	int separacio=45;
	public boolean[][] aliensVius;
	private BufferedImage explosion;
	public ArrayList<Bala> firedBullets = new ArrayList<Bala>();
	protected Bala bala;
	private int velocitat=8;

	public Aliens(Joc joc) {
	this.joc=joc;
	vida=1;
	aliensVius=new boolean[][] { {true,true,true,true,true,true,true,true},  //fila0=fila baixa
								 {true,true,true,true,true,true,true,true},
								 {true,true,true,true,true,true,true,true}};}
	
	public void tick() {
		
		crono2= System.currentTimeMillis()-temps2;
		temps2=System.currentTimeMillis();
		
		if(crono2>19000) {
			angleY+=3;
			
			if(angleX<0) {
				angleX-=3;
			}
			else {
				angleX+=3;
			}
			crono=0;
		}
		
		if(x0<0 && x1<0 &&x2<0) {
			angleX=Math.abs(angleX);
			y2 += angleY;
			y1 += angleY;
			y0 += angleY;
			
		}
		else if(x0+separacio*7+35+angleX>Joc.AMPLE && x1+separacio*7+35+angleX>Joc.AMPLE && x2+separacio*7+35+angleX>Joc.AMPLE) {
			angleX=-Math.abs(angleX);
			y2 += angleY;
			y1 += angleY;
			y0 += angleY;
		}
		x0 += angleX;
		x1 += angleX;
		x2 += angleX; 
		
		//BALES
		
		if(System.currentTimeMillis()-tempsDispar>800-joc.nivell*50) {
			int shot = (int) (Math.random()*(24+1));
			//System.out.println(shot);
			if(shot<=8 && aliensVius[2][shot%8]==true) {
				Bala bala = new Bala(joc,separacio*((shot)%8)+x0+16,y2+28,velocitat+joc.nivell*2,1);
		        firedBullets.add(bala);
			}
			else if(shot<=16 && shot>8 && aliensVius[1][shot%8]==true) {
				Bala bala = new Bala(joc,separacio*((shot)%8)+x1+17,y1+12,velocitat+joc.nivell*2,1);
		        firedBullets.add(bala);
			}
			else if (aliensVius[0][shot%8]==true){
				Bala bala = new Bala(joc,separacio*((shot)%8)+x2+16,y0+31,velocitat+joc.nivell*2,1);
		        firedBullets.add(bala);
			}
			else {
				for(int i=0;i<8;i++) {
					if(aliensVius[0][i]==true) {
						Bala bala = new Bala(joc,separacio*i+x2+16,y0+31,velocitat+joc.nivell*2,1);
				        firedBullets.add(bala);
				        break;
					}
					else if(aliensVius[1][i]==true) {
						Bala bala = new Bala(joc,separacio*i+x1+17,y1+12,velocitat+joc.nivell*2,1);
				        firedBullets.add(bala);
				        break;
					}
					else if(aliensVius[2][i]==true) {
						Bala bala = new Bala(joc,separacio*i+x0+16,y2+28,velocitat+joc.nivell*2,1);
				        firedBullets.add(bala);
				        break;
					}
				}
			}
			tempsDispar=System.currentTimeMillis();
		}
		if(joc.nivell>=3) {
		if(System.currentTimeMillis()-tempsdispar2>700-joc.nivell*50) {
			int shot = (int) (Math.random()*(24+1));
			//System.out.println(shot);
			if(shot<=8 && aliensVius[2][shot%8]==true) {
				Bala bala = new Bala(joc,separacio*((shot)%8)+x0+16,y2+28,velocitat+joc.nivell*2,1);
		        firedBullets.add(bala);
			}
			else if(shot<=16 && shot>8 && aliensVius[1][shot%8]==true) {
				Bala bala = new Bala(joc,separacio*((shot)%8)+x1+17,y1+12,velocitat+joc.nivell*2,1);
		        firedBullets.add(bala);
			}
			else if (aliensVius[0][shot%8]==true){
				Bala bala = new Bala(joc,separacio*((shot)%8)+x2+16,y0+31,velocitat+joc.nivell*2,1);
		        firedBullets.add(bala);
			}
			else {
				for(int i=0;i<8;i++) {
					if(aliensVius[0][i]==true) {
						Bala bala = new Bala(joc,separacio*i+x2+16,y0+31,velocitat+joc.nivell*2,1);
				        firedBullets.add(bala);
				        break;
					}
					else if(aliensVius[1][i]==true) {
						Bala bala = new Bala(joc,separacio*i+x1+17,y1+12,velocitat+joc.nivell*2,1);
				        firedBullets.add(bala);
				        break;
					}
					else if(aliensVius[2][i]==true) {
						Bala bala = new Bala(joc,separacio*i+x0+16,y2+28,velocitat+joc.nivell*2,1);
				        firedBullets.add(bala);
				        break;
					}
				}
			}
			tempsdispar2=System.currentTimeMillis();
		}
		}
	}
	
	public void render(Graphics g) {
		
		alien=ImageLoader.loadImage("/image/Aliens2.png");
		alien0 = ImageLoader.loadImage("/image/alien.png");
		alien1=ImageLoader.loadImage("/image/Aliens1.png");
		alien11=ImageLoader.loadImage("/image/Aliens11.png");
		alien2=ImageLoader.loadImage("/image/Aliens3.png");
		alien21=ImageLoader.loadImage("/image/Aliens31.png");
		explosion=ImageLoader.loadImage("/image/explosion.png");
		
		//ALIENS
		crono += System.currentTimeMillis()-temps;
		temps = System.currentTimeMillis();
		if(crono>500) {
			index += 1;
			crono=0;
		}
		//primera fila
		if(index%2==0) {
		for(int i=0;i<8;i++) {
			if(aliensVius[2][i]==true) {
				g.drawImage(alien2, separacio*i+x0,y2,35,30,null);
			}
			else {
				if(System.currentTimeMillis()-joc.cronos[2][i]<80) {
					g.drawImage(explosion,x0+separacio*i+2,y2,31,28,null);
				}
				else {
					joc.cronos[2][i]=0;
				}
			}
		}
		//segona
		for(int i=0;i<8;i++) {
			if(aliensVius[1][i]==true) {
			g.drawImage(alien1, separacio*i+x1,y1,35,25,null);

			}
			
			else {
				if(System.currentTimeMillis()-joc.cronos[1][i]<80) {
					g.drawImage(explosion,x1+separacio*i+2,y1+2,32,22,null);
				}
				else {
					joc.cronos[1][i]=0;
				}
			}
			
		}
		//tercera
		
		for(int i=0;i<8;i++) {
			if(aliensVius[0][i]==true) {
			g.drawImage(alien, separacio*i+x2,y0,35,30,null);
			}
			else {
				if(System.currentTimeMillis()-joc.cronos[0][i]<80) {
					g.drawImage(explosion,x2+separacio*i+2,y0+4,31,27,null);
				}
				else {
					joc.cronos[0][i]=0;
				}
			}
		}
		}
		else {
			//tercera
			for(int i=0;i<8;i++) {
				if(aliensVius[0][i]==true) {
					g.drawImage(alien0, separacio*i+x2,y0+2,35,30,null);
				}
				else {
					if(System.currentTimeMillis()-joc.cronos[0][i]<80) {
						g.drawImage(explosion,x2+separacio*i+2,y0+4,31,27,null);
					}
					else {
						joc.cronos[0][i]=0;
					}
				}
		}
			//segona
			for(int i=0;i<8;i++) {
				if(aliensVius[1][i]==true) {
				g.drawImage(alien11, separacio*i+x1,y1,35,25,null);
				}
				else {
					if(System.currentTimeMillis()-joc.cronos[1][i]<80) {
						g.drawImage(explosion,x1+separacio*i+2,y1+2,32,22,null);
					}
					else {
						joc.cronos[1][i]=0;
					}
				}
			}
			//primera
			
			for(int i=0;i<8;i++) {
				if(aliensVius[2][i]==true) {
				g.drawImage(alien21, separacio*i+x0,y2,35,30,null);
				}
				else {
					if(System.currentTimeMillis()-joc.cronos[2][i]<80) {
						g.drawImage(explosion,x0+separacio*i+2,y2,31,28,null);
					}
					else {
						joc.cronos[2][i]=0;
					}
				}
			}
		}
		
		//BALES
		
		if(firedBullets.size()>0) {
			for(int i=0;i<firedBullets.size();i++){
				if(firedBullets.get(i).y-10<Joc.ALT-50) {
					(firedBullets.get(i)).shootBala(g,velocitat+joc.nivell,1);
				}
				else if(firedBullets.get(i).y-10>Joc.ALT-50){
					firedBullets.remove(firedBullets.get(i));  //bala surt de la pantalla fora de la llista
				}
			}
			}
	}
}
