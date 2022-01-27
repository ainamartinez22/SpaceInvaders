package invaders;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.awt.image.BufferedImage;

public class Bala {
    public int x;
    public int y;
    protected Joc joc;
    public int velocitat;
    int tipus;
    private BufferedImage bomba = ImageLoader.loadImage("/image/bomb.png");;

    public Bala(Joc joc, int x, int y, int velocitat, int tipus){
         this.x =x; 
         this.joc=joc;
         this.y=y;
         this.velocitat=velocitat;
         this.tipus=tipus;
    }
    
    public void drawBullet(Graphics g, int tipus) {
    	if(tipus==0) {
    	g.setColor(Color.white);
    	Graphics2D g2 = (Graphics2D) g;
		g2.setStroke(new BasicStroke(3));
		g2.draw(new Line2D.Float(x,y-4,x,y));
    	}
    	else if(tipus==1){
    	 g.drawImage(bomba, x-3, y-5, 7, 8, null); //BALA DE L'ALIEN
    	}
    }
    
    public void shootBala(Graphics g, int velocitat, int tipus) {
    	if (y < Joc.ALT-50 && y>0) {
            y += velocitat;
            drawBullet(g,tipus);
        }
    }
}
