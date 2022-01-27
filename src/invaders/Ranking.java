package invaders;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

//NOTA: aquesta funció només llegeix el fitxer User.txt i posa per pantalla el ranking (ha d'estar ordenat)

public class Ranking{
	Font fnt0= new Font("verdana",Font.BOLD,50);
	Font fnt1= new Font("calibri",Font.BOLD,60);
	Font fnt2= new Font("verdana",Font.BOLD,20);
	public Rectangle backButton = new Rectangle(10,10,100,40);
	private BufferedImage copa;
	private BufferedReader buf;
	String[] classif = new String[6];
		
	public void llegir() throws IOException {
		
		FileReader read = new FileReader("User.txt");
		buf = new BufferedReader(read);
		String s= "";
		int i = 0;
		while(i<6){
			s=buf.readLine();
			classif[i]=s;
			i += 1;
	  	}
	}
	
	public void render(Graphics g) {
		copa=ImageLoader.loadImage("/image/win.png");
		g.drawImage(copa, Joc.AMPLE/3+320, 35, 50,50 ,null);
		g.drawImage(copa, Joc.AMPLE/3-40, 35, 50,50 ,null);
		Graphics2D g2d= (Graphics2D) g;
		g2d.setColor(Color.black);
		g2d.fill(backButton);
		g2d.setColor(Color.blue);
		g2d.draw(backButton);
		g.setColor(Color.white);
		g.setFont(fnt2);
		g.drawString("BACK",backButton.x+20, backButton.y+25);
		g.setFont(fnt0);
		g.drawString("RANKING", Joc.AMPLE/3+30, 80);
		g.setFont(fnt1);
			for(int j=0;j<5;j++) {
				g.setFont(fnt0);
				g.setColor(Color.green);
				g.drawString("TOP "+(j+1), 90, 200+120*j);
				g.setColor(Color.white);
				g.drawString(classif[4-j], Joc.AMPLE/3+90, 200+120*j);
		}
	}
}