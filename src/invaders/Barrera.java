package invaders;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Barrera {

	public int x,y;
	protected Joc joc;
	static int ample=15;
	static int alt=17;
	
	public Barrera(int x, int y) {
		this.x=x;
		this.y=y;
	}
	
	void render(Graphics g) {
		//g.setColor(Color.gray);
		//g.drawRect(x, y, ample, alt);
		Rectangle brick = new Rectangle(x,y,ample,alt);
		Graphics2D g2d= (Graphics2D) g;
		g2d.setColor(Color.magenta);
		g2d.fill(brick);
	}
}
