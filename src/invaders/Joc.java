package invaders;

import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.TextField;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;


public class Joc implements Runnable{

	public static final int AMPLE=800,ALT=800;
	private BufferedImage gameover;
	public static Finestra finestra;
	private boolean running = false;
	private Thread thread;
	public String title;
	private BufferStrategy bs;
	private Graphics g;
	int x=-1,punts=0,vida=3;
	private KeyManager keyManager;
	private Player player;
	private Aliens aliens;
	private SuperAlien superAlien;
	public Joc joc;
	private MouseManager mouseManager;
	private MouseManager2 mouseManager2;
	private MouseManagerUser mouseManagerUser;
	public long[][] cronos= new long[3][8];
	public ArrayList<Barrera> escuts = new ArrayList<Barrera>();
	protected Barrera barrera;
	public int nivell=1;
	private long crononivell, cronomusica, cronosuperalien;
	public long cronoexplo;
	MusicPlayer musica, mamamia, mort, jugador;
	Button b1,b2;
	TextField t1 = new TextField(20);
	
	//Estats
	
	private Ranking ranking;
	private Menu menu;
	private Help help;
	private User user;
	private HighScore highScore;
	
	
	public static enum STATE{
		MENU, GAME, HELP,HELPCATALAN,HELPSPANISH, CLASSIFICATION, GAMEOVER, LEVEL, USER
	};
	
	public static STATE State= STATE.MENU;
	
	
	
	public Joc(String title, int AMPLE, int ALT) {
		this.title=title;
		//this.AMPLE=AMPLE;
		//this.ALT=ALT;
		keyManager = new KeyManager();
		mouseManager = new MouseManager();
		mouseManager2 = new MouseManager2();
		mouseManagerUser = new MouseManagerUser();
	}
	
	public static void main(String[] args) {
		Joc joc= new Joc("Space Invaders",AMPLE,ALT); //si no fem aixo la finestra mai no es creara
		joc.start();
	}
	
	private void init() throws IOException {
		player = new Player(this,AMPLE/2-23,ALT-80);
		aliens = new Aliens(this);
		superAlien = new SuperAlien(this);
		if(nivell==1) {
		finestra=new Finestra(title,AMPLE,ALT);
		finestra.getFrame().addKeyListener(keyManager);
		menu=new Menu();
		help = new Help();
		user = new User();
		ranking = new Ranking();
		highScore = new HighScore();
		finestra.getFrame().addMouseListener(mouseManager);
		finestra.getCanvas().addMouseListener(mouseManager);
		musica = new MusicPlayer("/sound/music.wav");
		mamamia = new MusicPlayer("/sound/mamamia.wav");
		mort = new MusicPlayer("/sound/alien.wav");
		jugador = new MusicPlayer("/sound/player.wav");
		musica.play();
		cronomusica=System.currentTimeMillis();
		cronosuperalien=System.currentTimeMillis();
		}
		
		//ESCUTS
		
		//ESCUT ESQUERRE
		for(int i=0;i<6;i++) {
			Barrera barrera= new Barrera(AMPLE/8+i*Barrera.ample,ALT-350+2*Barrera.alt);
			escuts.add(barrera);
		}
		for(int i=0;i<8;i++) {
			Barrera barrera= new Barrera(AMPLE/8+i*Barrera.ample-Barrera.ample,ALT-350+3*Barrera.alt);
			escuts.add(barrera);
		}
		for(int i=0;i<10;i++) {
			Barrera barrera= new Barrera(AMPLE/8+i*Barrera.ample-2*Barrera.ample,ALT-350+4*Barrera.alt);
			escuts.add(barrera);
		}
		//POTES ESQUERRES
		//nivell 1
		for(int i=0;i<3;i++) {
			Barrera barrera= new Barrera(AMPLE/8+i*Barrera.ample-2*Barrera.ample,ALT-350+5*Barrera.alt);
			escuts.add(barrera);
		}
		for(int i=0;i<3;i++) {
			Barrera barrera= new Barrera(AMPLE/8-i*Barrera.ample+7*Barrera.ample,ALT-350+5*Barrera.alt);
			escuts.add(barrera);
		}
		//nivell 2
		for(int i=0;i<3;i++) {
			Barrera barrera= new Barrera(AMPLE/8+i*Barrera.ample-2*Barrera.ample,ALT-350+6*Barrera.alt);
			escuts.add(barrera);
		}
		for(int i=0;i<3;i++) {
			Barrera barrera= new Barrera(AMPLE/8-i*Barrera.ample+7*Barrera.ample,ALT-350+6*Barrera.alt);
			escuts.add(barrera);
		}
		//ESCUT MIG
		for(int i=0;i<6;i++) {
			Barrera barrera= new Barrera(AMPLE/2+i*Barrera.ample-45,ALT-350+2*Barrera.alt);
			escuts.add(barrera);
		}
		for(int i=0;i<8;i++) {
			Barrera barrera= new Barrera(AMPLE/2+i*Barrera.ample-Barrera.ample-45,ALT-350+3*Barrera.alt);
			escuts.add(barrera);
		}
		for(int i=0;i<10;i++) {
			Barrera barrera= new Barrera(AMPLE/2+i*Barrera.ample-2*Barrera.ample-45,ALT-350+4*Barrera.alt);
			escuts.add(barrera);
		}
		//POTES ESQUERRES
		//nivell 1
		for(int i=0;i<3;i++) {
			Barrera barrera= new Barrera(AMPLE/2+i*Barrera.ample-2*Barrera.ample-45,ALT-350+5*Barrera.alt);
			escuts.add(barrera);
		}
		for(int i=0;i<3;i++) {
			Barrera barrera= new Barrera(AMPLE/2-i*Barrera.ample+7*Barrera.ample-45,ALT-350+5*Barrera.alt);
			escuts.add(barrera);
		}
		//nivell 2
		for(int i=0;i<3;i++) {
			Barrera barrera= new Barrera(AMPLE/2+i*Barrera.ample-2*Barrera.ample-45,ALT-350+6*Barrera.alt);
			escuts.add(barrera);
		}
		for(int i=0;i<3;i++) {
			Barrera barrera= new Barrera(AMPLE/2-i*Barrera.ample+7*Barrera.ample-45,ALT-350+6*Barrera.alt);
			escuts.add(barrera);
		}

		//ESCUT DRET
		for(int i=0;i<6;i++) {
			Barrera barrera= new Barrera(4*AMPLE/5+i*Barrera.ample-35,ALT-350+2*Barrera.alt);
			escuts.add(barrera);
		}
		for(int i=0;i<8;i++) {
			Barrera barrera= new Barrera(4*AMPLE/5+i*Barrera.ample-Barrera.ample-35,ALT-350+3*Barrera.alt);
			escuts.add(barrera);
		}
		for(int i=0;i<10;i++) {
			Barrera barrera= new Barrera(4*AMPLE/5+i*Barrera.ample-2*Barrera.ample-35,ALT-350+4*Barrera.alt);
			escuts.add(barrera);
		}
		//POTES ESQUERRES
		//nivell 1
		for(int i=0;i<3;i++) {
			Barrera barrera= new Barrera(4*AMPLE/5+i*Barrera.ample-2*Barrera.ample-35,ALT-350+5*Barrera.alt);
			escuts.add(barrera);
		}
		for(int i=0;i<3;i++) {
			Barrera barrera= new Barrera(4*AMPLE/5-i*Barrera.ample+7*Barrera.ample-35,ALT-350+5*Barrera.alt);
			escuts.add(barrera);
		}
		//nivell 2
		for(int i=0;i<3;i++) {
			Barrera barrera= new Barrera(4*AMPLE/5+i*Barrera.ample-2*Barrera.ample-35,ALT-350+6*Barrera.alt);
			escuts.add(barrera);
		}
		for(int i=0;i<3;i++) {
			Barrera barrera= new Barrera(4*AMPLE/5-i*Barrera.ample+7*Barrera.ample-35,ALT-350+6*Barrera.alt);
			escuts.add(barrera);
		}
	}
	
	
	private void update() throws InterruptedException, IOException {
		if(System.currentTimeMillis()-cronomusica>=230000) {
			musica.stop();
			musica.play();
			cronomusica=System.currentTimeMillis();
		}
		
		if(State==STATE.GAME) {
		finestra.getFrame().removeMouseListener(mouseManager);
		finestra.getCanvas().removeMouseListener(mouseManager);
		finestra.getFrame().removeMouseListener(mouseManager2);
		finestra.getCanvas().removeMouseListener(mouseManager2);
		finestra.getFrame().removeMouseListener(mouseManagerUser);
		finestra.getCanvas().removeMouseListener(mouseManagerUser);
		boolean balaEliminada=false;
		keyManager.tick();
		player.tick();
		aliens.tick();
		
		//SUPERALIEN
		//cada 30 segons
		if(System.currentTimeMillis()-cronosuperalien>=30000) {
			superAlien.vida=true;
			cronosuperalien = System.currentTimeMillis();
		}
		
		if(superAlien.vida==true) {
			superAlien.tick();
		}
		
		//SUPER ALIEN MORT
		if(superAlien.vida==true) {
			if(player.firedBullets.size()>0) {
				for(int i=0;i<player.firedBullets.size();i++) {
					if(player.firedBullets.get(i).y<=superAlien.y+superAlien.alt+5 && player.firedBullets.get(i).y>=superAlien.y-5) {
							if(player.firedBullets.get(i).x>=superAlien.x-5 && player.firedBullets.get(i).x<=superAlien.x+superAlien.ample+5) {
								player.firedBullets.remove(player.firedBullets.get(i));
								superAlien.vida=false;
								cronoexplo=System.currentTimeMillis();
								punts += 50;
								cronosuperalien=System.currentTimeMillis();
								break;
							}
					}
				}
			}
		}
		
		if(superAlien.x+superAlien.ample <= 0 && superAlien.vida==true) {
			superAlien.vida=false;
			cronosuperalien=System.currentTimeMillis();
			superAlien.reinici();
		}
		
		//ALIENS MORTS
		
		if(player.firedBullets.size()>0) {
			for(int i=0;i<player.firedBullets.size();i++){
				for(int j=0;j<8;j++) {
					if(player.firedBullets.get(i).y<=aliens.y0+29 && player.firedBullets.get(i).y>=aliens.y0+4) { //primera fila
						if(aliens.aliensVius[0][j]==true) {
							if(player.firedBullets.get(i).x>=aliens.x2+aliens.separacio*j && player.firedBullets.get(i).x<=aliens.x2+aliens.separacio*j+34) {
								player.firedBullets.remove(player.firedBullets.get(i));
								balaEliminada=true;
								aliens.aliensVius[0][j]=false;
								mort.play();
								cronos[0][j]=System.currentTimeMillis();
								punts+=10;
								break;
							}
						}
					}
				}
				if (balaEliminada) {
					balaEliminada=false;
					continue;
				}
				for(int j=0;j<8;j++) {
					if(player.firedBullets.get(i).y<=aliens.y1+25 && player.firedBullets.get(i).y>=aliens.y1+2) { //segona fila
						if(aliens.aliensVius[1][j]==true) {
							if(player.firedBullets.get(i).x>=aliens.x1+aliens.separacio*j && player.firedBullets.get(i).x<=aliens.x1+aliens.separacio*j+34) {
								player.firedBullets.remove(player.firedBullets.get(i));
								balaEliminada=true;
								aliens.aliensVius[1][j]=false;
								mort.play();
								cronos[1][j]=System.currentTimeMillis();
								punts+=20;
								break;
							}
						}
					}
				}
				if (balaEliminada) {
					balaEliminada=false;
					continue;
				}
				for(int j=0;j<8;j++) {
					if(player.firedBullets.get(i).y<=aliens.y2+29 && player.firedBullets.get(i).y>=aliens.y2) { //tercera fila
						if(aliens.aliensVius[2][j]==true) {
							if(player.firedBullets.get(i).x>=aliens.x0+aliens.separacio*j && player.firedBullets.get(i).x<=aliens.x0+aliens.separacio*j+33) {
								player.firedBullets.remove(player.firedBullets.get(i));
								balaEliminada=true;
								aliens.aliensVius[2][j]=false;
								mort.play();
								cronos[2][j]=System.currentTimeMillis();
								punts+=30;
								break;
							}
						}
					}
				}
				if (balaEliminada) {
					balaEliminada=false;
					continue;
				}
			}
		}
		
		//JUGADOR MORT
		
		if(aliens.firedBullets.size()>0 && vida>0) {
			for(int i=0;i<aliens.firedBullets.size();i++){
				if(aliens.firedBullets.get(i).y+3<=(int)player.y+17 && aliens.firedBullets.get(i).y+3>=(int)player.y+7 ) {
					if((aliens.firedBullets.get(i).x-3<=(int)player.x+38 && aliens.firedBullets.get(i).x-3>=(int)player.x+2 )|| 
							(aliens.firedBullets.get(i).x+5<=(int)player.x+38 && aliens.firedBullets.get(i).x+5>=(int)player.x+2)) {
						aliens.firedBullets.remove(aliens.firedBullets.get(i));
						vida -= 1;
						jugador.play();
					}
				}
			}
		}
		
		if(vida==0) {
			State=STATE.GAMEOVER;
			highScore.actualitzaFitxer(User.nom.substring(1, User.nom.length()-1), punts);
			mamamia.play();
		}
		
		
		//BARRERES DESTRUIDES
		
		if(player.firedBullets.size()>0 && escuts.size()>0) {
			for(int i=0;i<player.firedBullets.size();i++){
				for(int j=0;j<escuts.size();j++) {
					if(player.firedBullets.get(i).y<=escuts.get(j).y+Barrera.alt+2 && player.firedBullets.get(i).y>=escuts.get(j).y-2) {
						if(player.firedBullets.get(i).x>=escuts.get(j).x-2 && player.firedBullets.get(i).x<=escuts.get(j).x+Barrera.ample+2) {
								player.firedBullets.remove(player.firedBullets.get(i));
								escuts.remove(escuts.get(j));
								break;
							}
						}
					}
				}
		}
		
		if(aliens.firedBullets.size()>0&&escuts.size()>0) {
			for(int i=0;i<aliens.firedBullets.size();i++){
				for(int j=0;j<escuts.size();j++) {
					if( (aliens.firedBullets.get(i).y+3<=escuts.get(j).y+Barrera.alt+2 && aliens.firedBullets.get(i).y+3>=escuts.get(j).y-2 ) ||
							 (aliens.firedBullets.get(i).y-5<=escuts.get(j).y+Barrera.alt+2 && aliens.firedBullets.get(i).y-5>=escuts.get(j).y-2)) {
						if((aliens.firedBullets.get(i).x-3<=escuts.get(j).x+Barrera.ample+2 && aliens.firedBullets.get(i).x-3>=escuts.get(j).x-2)|| 
								(aliens.firedBullets.get(i).x+4<=escuts.get(j).x+Barrera.ample+2 && aliens.firedBullets.get(i).x+4>=escuts.get(j).x-2)) {
								aliens.firedBullets.remove(aliens.firedBullets.get(i));
								escuts.remove(escuts.get(j));
								break;
							}
						}
					}
				}
		}
		
		
		//COMPROVEM SI ENS HAN INVAIT
		
		for(int i=0;i<8;i++) {
			if(aliens.aliensVius[2][i]==true &&aliens.y2+30>=player.y) {
				State=STATE.GAMEOVER;
				break;
			}
			else if(aliens.aliensVius[1][i]==true &&aliens.y1+30>=player.y) {
				State=STATE.GAMEOVER;
				break;
			}
			else if(aliens.aliensVius[0][i]==true &&aliens.y0+30>=player.y) {
				State=STATE.GAMEOVER;
				break;
			}
		}
		
		int morts=0;
		
		//COMPROVEM SI HEM PASSAT DE NIVELL
		
		for(int i=0;i<8;i++) {
			if(aliens.aliensVius[0][i]==false) {
				morts=morts+1;
			}
			if(aliens.aliensVius[1][i]==false) {
				morts=morts+1;
			}
			if(aliens.aliensVius[2][i]==false) {
				morts=morts+1;	
				}
			}
		if(morts==8*3) {
			State=STATE.LEVEL;
			crononivell=System.currentTimeMillis();
		}
		
		}
		
		else if(State==STATE.LEVEL) {
			if(System.currentTimeMillis()-crononivell>2000) {
				for(int i=0;i<aliens.firedBullets.size();i++) {
					aliens.firedBullets.remove(aliens.firedBullets.get(i));
				}
				for(int i=0;i<player.firedBullets.size();i++) {
					player.firedBullets.remove(player.firedBullets.get(i));
				}
				for(int j=0;j<escuts.size();j++) {
					escuts.remove(escuts.get(j));
				}
				crononivell=System.currentTimeMillis();
				nivell += 1;
				State=STATE.GAME;
				run();
			}
		}
		
		
		}
	
		private void render() throws IOException, InterruptedException { //els Buffers serveixen pq no s'encallin els grafics del joc
			bs=finestra.getCanvas().getBufferStrategy(); //dibuixarem a la memoria de lordinador
			if(bs==null) { //el nostre ordinador no te cap estrategia de buffer
				finestra.getCanvas().createBufferStrategy(3); //ho farem amb 3 buffers
				return;
			}
			g=bs.getDrawGraphics();
	
			//PRIMER NETEGEM PANTALLA
			g.clearRect(0, 0, AMPLE, ALT); //netegem tot el rectangle
	
			//DIBUIXEM
			
			g.setColor(Color.black);
			g.fillRect(0,0,AMPLE,ALT); //aixi pintem del pixel (0,0) (esquerra a dalt) al (AMPLE,ALT) de negre
			
			if(State==STATE.GAME) {
			player.render(g);
			aliens.render(g);
			if(escuts.size()>0) {
				for(int i=0;i<escuts.size();i++){
						(escuts.get(i)).render(g);
					}
				}
			if(superAlien.vida==true) {
			superAlien.render(g);
			}
			else {
				if(System.currentTimeMillis()-cronoexplo < 130) {
					superAlien.mort(g);
				}
				else {
					if(cronoexplo>0) {
						superAlien.reinici();
					}
					cronoexplo=0;
				}
			}
			}
			
			else if(State==STATE.LEVEL) {
				g.setColor(Color.black);
				g.fillRect(0, 0, AMPLE, ALT);
				Font fnt0= new Font("verdana",Font.BOLD,50);
				g.setFont(fnt0);
				g.setColor(Color.white);
				g.drawString("LEVEL", Joc.AMPLE/3+30, 300);
				g.drawString(Integer.toString(nivell+1), Joc.AMPLE/3+90, 400);
			}
			
			else if(State==STATE.MENU) {
				finestra.getFrame().removeMouseListener(mouseManagerUser);
				finestra.getCanvas().removeMouseListener(mouseManagerUser);
				finestra.getFrame().removeMouseListener(mouseManager2);
				finestra.getCanvas().removeMouseListener(mouseManager2);
				finestra.getFrame().addMouseListener(mouseManager);
				finestra.getCanvas().addMouseListener(mouseManager);
				menu.render(g);
			}
			else if(State==STATE.HELP||State==STATE.HELPCATALAN||State==STATE.HELPSPANISH) {
				finestra.getFrame().removeMouseListener(mouseManager);
				finestra.getCanvas().removeMouseListener(mouseManager);
				finestra.getFrame().addMouseListener(mouseManager2);
				finestra.getCanvas().addMouseListener(mouseManager2);
				help.render(g);
			}
			else if(State==STATE.GAMEOVER) {
				finestra.getFrame().removeMouseListener(mouseManager);
				finestra.getCanvas().removeMouseListener(mouseManager);
				gameover=ImageLoader.loadImage("/image/gameover.png");
				g.drawImage(gameover, 0, 0, AMPLE, ALT,null);
				
			}
			
			else if(State==STATE.USER) {
				finestra.getFrame().removeMouseListener(mouseManager);
				finestra.getCanvas().removeMouseListener(mouseManager);
				finestra.getFrame().removeMouseListener(mouseManager2);
				finestra.getCanvas().removeMouseListener(mouseManager2);
				finestra.getFrame().addMouseListener(mouseManagerUser);
				finestra.getCanvas().addMouseListener(mouseManagerUser);
				user.render(g);
				g.setFont(new Font("arial",Font.BOLD,60));
				g.setColor(Color.green);
				g.drawString("WELCOME PLAYER", 120, Joc.ALT-300);
				
				
			}
			else if(State==STATE.CLASSIFICATION) {
				finestra.getFrame().removeMouseListener(mouseManager);
				finestra.getCanvas().removeMouseListener(mouseManager);
				finestra.getFrame().addMouseListener(mouseManager2);
				finestra.getCanvas().addMouseListener(mouseManager2);
				finestra.getFrame().removeMouseListener(mouseManagerUser);
				finestra.getCanvas().removeMouseListener(mouseManagerUser);
				
				ranking.llegir();
				ranking.render(g);
				
			}
			
			
			bs.show(); //sino no mostrara el que hem dibuixat
			g.dispose(); //pq es faci adequadament
	
		}
	
		public void run() {
			running = true;
			try {
				init();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			int fps=60; //frames per second
			double timePerUpdate=2000000000/fps;
			double delta=0;
			long now;
			long lastTime=System.nanoTime();//cronometre de lordinador en nanosegons
	
			while(running) { //mentre la variable running sigui true ho fara
				now= System.nanoTime();
				delta+= (now-lastTime)/timePerUpdate;//quan de temps esperar per tornar a cridar lupdate i render
				lastTime=now;
	
				if(delta>=1) { //farem 60tickspersecond
					try {
						update();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					try {
						render();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					delta--;
				}
			}
			stop();
		}
	
		public KeyManager getKeyManager() {
			return keyManager;
		}
		
		public MouseManager getMouseManager() {
			return mouseManager;
		}
	
		public synchronized void start() { //per iniciar el thread
			if(running) {   //si el nostre joc ja esta funcionant, que no faci res, sino que linicialitzi
				return;
			}
			running=true;
			thread = new Thread(this); //pq el thread que volem es el joc en si
			thread.start(); //aixo crida a la funcio run()
		}
		
		public synchronized void stop() {
			if(!running) { //si el joc ja esta parat que no faci res
				return;
			}
	
			running=false;
			try {
				thread.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}
