package application;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

import application.Main.Corner;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.*;

public class GamePlay extends JPanel implements KeyListener, ActionListener {

	private int[] snakeXlength = new int[750];
	private int[] snakeYlength = new int[750];

	private boolean left = false;
	private boolean right = false;
	private boolean up = false;
	private boolean down = false;

	private ImageIcon title;

	private ImageIcon leftmouth;
	private ImageIcon rightmouth;
	private ImageIcon upmouth;
	private ImageIcon downmouth;
	private ImageIcon snakebody;
	private ImageIcon food;

	private int[] foodxpos = { 25, 50, 75, 100, 125, 150, 175, 200, 225, 250, 275, 300, 325, 350, 375, 400, 425, 450,
			475, 500, 525, 550, 575, 600, 625, 650, 675, 700, 725, 750, 775, 800, 825, 850 };
	private int[] foodypos = { 75, 100, 125, 150, 175, 200, 225, 250, 275, 300, 325, 350, 375, 400, 425, 450, 475, 500,
			525, 550, 575, 600, 625 };

	private Random random = new Random();

	private int xpos = random.nextInt(34);
	private int ypos = random.nextInt(23);
	

	private int score = 0;

	private int snakelength = 3;

	private int move = 0;


	private Timer timer;
	private int delay = 100;

	public GamePlay() {

		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		timer = new Timer(delay, this);
		timer.start();

	}

	public void paint(Graphics g) {
		// title

		if (move == 0) {
			snakeXlength[2] = 50;
			snakeXlength[1] = 75;
			snakeXlength[0] = 100;

			snakeYlength[2] = 100;
			snakeYlength[1] = 100;
			snakeYlength[0] = 100;

		}

		g.setColor(Color.white);
		g.drawRect(24, 10, 851, 55);

		/*
		 * title = new ImageIcon("snaketitle.jpg");
		 * 
		 * title.paintIcon(this, g, 25, 11);
		 */
		// title

		title = new ImageIcon("title4.png");
		JLabel label = new JLabel(title);
		label.setVerticalAlignment(JLabel.CENTER);

		title.paintIcon(this, g, 250, -7);

		g.setColor(Color.black);
		g.drawRect(24, 10, 851, 55);
		// g.fillRect(25, -7, 250, -7);

		// draw background
		g.setColor(Color.BLACK);
		g.fillRect(25, 75, 850, 575);

		// Draw Score
		g.setColor(Color.MAGENTA);
		g.setFont(new Font("arial", Font.BOLD, 17));
		g.drawString("Scores : "+ score, 780, 30);

		// Draw Snake length
		g.setColor(Color.magenta );
		g.setFont(new Font("arial", Font.BOLD, 17));
		g.drawString("Length : "+ snakelength, 780, 50);

		// draw snake
		leftmouth = new ImageIcon("right3.png");
		leftmouth.paintIcon(this, g, snakeXlength[0], snakeYlength[0]);

		for (int a = 0; a < snakelength; a++) {

			if (a == 0 && right) {
				rightmouth = new ImageIcon("right3.png");
				rightmouth.paintIcon(this, g, snakeXlength[a], snakeYlength[a]);
			}

			if (a == 0 && left) {
				leftmouth = new ImageIcon("left3.png");
				leftmouth.paintIcon(this, g, snakeXlength[a], snakeYlength[a]);
			}

			if (a == 0 && up) {
				upmouth = new ImageIcon("up3.png");
				upmouth.paintIcon(this, g, snakeXlength[a], snakeYlength[a]);
			}

			if (a == 0 && down) {
				downmouth = new ImageIcon("down3.png");
				downmouth.paintIcon(this, g, snakeXlength[a], snakeYlength[a]);
			}

			if (a != 0) {
				snakebody = new ImageIcon("body3.png");
				snakebody.paintIcon(this, g, snakeXlength[a], snakeYlength[a]);
			}
		}
		food = new ImageIcon("food3.png");

		if ((foodxpos[xpos] == snakeXlength[0]) && foodypos[ypos] == snakeYlength[0]) {
			
			 score++; 
			 snakelength++;
			 
			xpos = random.nextInt(34);
			ypos = random.nextInt(23);
		}

		food.paintIcon(this, g, foodxpos[xpos], foodypos[ypos]);

		for (int i = 1; i < snakelength; i++) {
			if (snakeXlength[i] == snakeXlength[0] && snakeYlength[i] == snakeYlength[0]) {
				
				right = false;
				left = false;
				up = false;
				down = false;

				// Draw Gave over

				g.setColor(Color.RED);
				g.setFont(new Font("arial", Font.BOLD, 50));
				g.drawString("Game Over", 300, 300);

				g.setColor(Color.lightGray);
				g.setFont(new Font("arial", Font.BOLD, 20));
				g.drawString("Wanna Play Again?? ", 350, 340);

				g.setColor(Color.GREEN);
				g.setFont(new Font("arial", Font.BOLD, 20));
				g.drawString("Press Space", 370, 380);
			}
		}
		g.dispose();

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		timer.start();
		if (right) {
			////////////////////////////////
			for (int i = snakelength - 1; i >= 0; i--) {
				snakeYlength[i + 1] = snakeYlength[i];

			}

			for (int i = snakelength; i>= 0; i--)

			{
				if (i == 0) {
					snakeXlength[i] = snakeXlength[i] + 25;
				} else {
					snakeXlength[i] = snakeXlength[i - 1];
				}
				if (snakeXlength[i] > 850) {
					snakeXlength[i] = 25;
				}

			}
			repaint();
		}

		if (left) {

			for (int i = snakelength - 1; i >= 0; i--) {
				snakeYlength[i + 1] = snakeYlength[i];

			}

			for (int i = snakelength; i >= 0; i--)

			{
				if (i == 0) {
					snakeXlength[i] = snakeXlength[i] - 25;
				} else {
					snakeXlength[i] = snakeXlength[i - 1];
				}
				if (snakeXlength[i] < 25) {
					snakeXlength[i] = 850;
				}

			}
			repaint();

		}
		if (down) {
			for (int i = snakelength - 1; i >= 0; i--) {
				snakeXlength[i + 1] = snakeXlength[i];

			}

			for (int i = snakelength; i >= 0; i--)

			{
				if (i == 0) {
					snakeYlength[i] = snakeYlength[i] + 25;
				} else {
					snakeYlength[i] = snakeYlength[i - 1];
				}
				if (snakeYlength[i] > 625) {
					snakeYlength[i] = 75;
				}

			}
			repaint();

		}
		if (up) {

			for (int i = snakelength - 1; i >= 0; i--) {
				snakeXlength[i + 1] = snakeXlength[i];

			}

			for (int i = snakelength; i >= 0; i--)

			{
				if (i == 0) {
					snakeYlength[i] = snakeYlength[i] - 25;
				} else {
					snakeYlength[i] = snakeYlength[i - 1];
				}
				if (snakeYlength[i] < 75) {
					snakeYlength[i] = 625;
				}

			}
			repaint();

		}

	}

	@Override
	public void keyPressed(KeyEvent key) {
		if (key.getKeyCode() == KeyEvent.VK_RIGHT) {
			move++;
			right = true;

			if (!left) {
				right = true;

			} else {
				left = true;
				right = false;
			}
			up = false;
			down = false;
		}

		if (key.getKeyCode() == KeyEvent.VK_LEFT) {
			move++;
			left = true;

			if (!right) {
				left = true;

			} else {
				right = true;
				left = false;
			}
			up = false;
			down = false;
		}

		if (key.getKeyCode() == KeyEvent.VK_UP) {
			move++;
			up = true;

			if (!down) {
				up = true;

			} else {
				down = true;
				up = false;
			}
			left = false;
			right = false;
		}

		if (key.getKeyCode() == KeyEvent.VK_DOWN) {
			move++;
			down = true;

			if (!up) {
				down = true;

			} else {
				up = true;
				down = false;
			}
			left = false;
			right = false;
		}

		if (key.getKeyCode() == KeyEvent.VK_SPACE) {
			move = 0;
			score = 0;
			snakelength = 3;
			repaint();
		}

	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

}
