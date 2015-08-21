package ponggame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Paddle {
	Rectangle rect;
	public static final int width = 20,height = 100;
	
	int x, y;
	int dy;
	int score = 0;
	public Paddle(int x, int y) {
		this.x = x;
		this.y = y;
		rect = new Rectangle(x,y, 20, 100);
	}
	
	public void paint(Graphics g)
	{
		g.setColor(Color.WHITE);
		g.fillRect(x, y, 20, 100);
	}
	public void update()
	{
		//System.out.println(y);
		if(y>0 && y<380)
		{
		y+=dy;
		
		}
		else if (y == 0)
		{
		 if(dy == -4)
		 {
			 dy=0;
			 y+=dy;
			
		 }
		 else
		 {
			 y+=dy;
			
		 }
		}
		else
		{
			 if(dy == 4)
			 {
				 dy=0;
				 y+=dy;
			
			 }
			 else
			 {
				 y+=dy;
		
			 }
		}
		rect.setBounds(x, y, width, height);
	}
	

}
