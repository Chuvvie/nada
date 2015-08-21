package ponggame;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GraphicsEnvironment;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;

public class MainClass extends Applet implements Runnable,KeyListener {
	public static Thread thread;
	public static final int width = 800, height = 480;
	public static Paddle player1, player2; 
	public static Ball ball;
	public Font font; 
	enum GameState {
		Running, Paused,End
	}
	GameState state = GameState.Running;


	public void init() {	
		setSize(width,height);
		setBackground(Color.BLACK);
		setFocusable(true);
		addKeyListener(this);
		ball = new Ball();
		player1 = new Paddle(50,200);
		player2 = new Paddle(730,200);
		try {
			font = Font.createFont(Font.TRUETYPE_FONT, new File("data/8bit.TTF")).deriveFont(60f);
			GraphicsEnvironment ge = 
					GraphicsEnvironment.getLocalGraphicsEnvironment();
			ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("data/8bit.TTF")));
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		if (state == GameState.Running) {
			while (true){
				if(state == GameState.Running)
				{
					ball.update();
					player1.update();
					player2.update();
					repaint();
					try{
						Thread.sleep(17);
					} catch (InterruptedException e){
						e.printStackTrace();
					}


					if (player1.score == 5) {
						state = GameState.End;
					}
					else if (player2.score == 5) {
						state = GameState.End;
					}
				}
				else
				{
					repaint();
				}


			}
		}

	}
	
	@Override
	public void start() {
		thread = new Thread(this);
		thread.start();
	}

	@Override
	public void stop() {
		// TODO Auto-generated method stub
		super.stop();
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		super.destroy();
	}



	@Override
	public void paint(Graphics g) {
		if (state == GameState.Running || state == GameState.Paused) {

			ball.paint(g);
			player1.paint(g);
			player2.paint(g);
			g.setFont(font);
			g.drawString(Integer.toString(player2.score), 150, 100);
			g.drawString(Integer.toString(player1.score), 600, 100);
		}
		else if (state == GameState.End)
		{
			if(player1.score == 5)
			{
				g.drawString("Player 1 Wins", 200, 200);
			}
			else
			{
				g.drawString("Player 2 Wins", 200, 200);
			}
		}
	}


	@Override
	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {

		case KeyEvent.VK_SPACE:
			pause();
			break;
		case KeyEvent.VK_UP:
			if(true)
			{
				player2.dy = -4;
			}
			break;
		case KeyEvent.VK_DOWN:
			if(true)
			{
				player2.dy = 4;
			}
			break;
		case KeyEvent.VK_W:
			if(true)
			{
				player1.dy = -4;
			}
			break;
		case KeyEvent.VK_S:
			if(true)
			{
				player1.dy = 4;
			}
			break;
		}

	}
    @Override
    public void keyReleased(KeyEvent arg0) {
        switch (arg0.getKeyCode()) {
        
        case KeyEvent.VK_UP:
            if(true)
            {
                player2.dy = 0;
            }
            break;
        case KeyEvent.VK_DOWN:
            if(true)
            {
                player2.dy = 0;
            }
            break;
        case KeyEvent.VK_W:
            if(true)
            {
                player1.dy = 0;
            }
            break;
        case KeyEvent.VK_S:
            if(true)
            {
                player1.dy = 0;
            }
            break;
        }
    }
	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}
	public void pause() {
		if (state == GameState.Running)
		{
			state = GameState.Paused;
		}
		else
		{
			state = GameState.Running;
		}
		System.out.println(state);

	}


}
