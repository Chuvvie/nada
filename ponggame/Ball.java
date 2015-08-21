package ponggame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Ball {
	private final int width = 30;
	private final int height = 30;
	public int x,y;
	public int dx,dy;
	Rectangle ball;
	boolean turn = true;

	public Ball() {
		dx = 2;
		dy = 2;
		reset();
		ball = new Rectangle(x,y,width,height);
	}
	
	public void update()
	{
		x += dx;
		y += dy;
		ball.setBounds(x, y, width, height);
		checkCollision();
		if(x < 50)
		{
			MainClass.player1.score +=1;
			//System.out.println("Player 1: "+MainClass.player1.score);
			reset();
		}
		else if(x>730)
		{
			MainClass.player2.score +=1;
			//System.out.println("Player 2: "+MainClass.player2.score);
			reset();
		}
		else if (y < 0 || y>450)
		{
			dy = -dy;
		}
		
	}
	
	public void checkCollision()
	{
		if(ball.intersects(MainClass.player1.rect) || ball.intersects(MainClass.player2.rect))
		{
			if(dx < 0)
			{
				dx--;
			}
		
			else
			{
				dx++;
			}
			
			dx = -(dx);
			dy = -(dy);
			System.out.println("dx: " + dx);
			System.out.println("dy: " + dy);
			System.out.println("");
		}
	}
	
	public void paint(Graphics g)
	{
		g.setColor(Color.WHITE);
		g.fillOval(x, y, width, height);
	}
	public void reset()
	{
		if(turn)
		{
			dx = -2;
			dy = -2;
			turn = false;
		}
		else
		{
			dx = 2;
			dy = 2;
			turn = true;
			
		}
		x = MainClass.width/2;
		y = MainClass.height/2;
	}

}
