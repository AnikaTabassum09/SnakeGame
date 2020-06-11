package application;
	

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JFrame;

import application.Main.Corner;
import application.Main.Dir;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;


public class Main extends Application {
	
	//Variables
	static int width=25;
	static int height=25;
	static int speed= 5;
	static int foodX=0;
	static int foodY=0;
	static int foodcolor=0;
	static int cornersize= 25;
	static List<Corner> snake= new ArrayList<>();
	static Dir direction = Dir.right;
	static Random rand = new Random();
	static boolean gameover = false;

	
	
	public enum Dir{
		left, right, up, down
	}

	public static class Corner {
		int x;
		int y;

		public Corner(int x, int y) {
			this.x = x;
			this.y = y;
		}

	}
	
	
	
	public void start(Stage primaryStage) {
		try {
			
			

			JFrame obj = new JFrame();
			
			GamePlay gamePlay = new GamePlay();
			
			
			/*
			 * Canvas c = new Canvas(width * cornersize, height * cornersize);
			 * GraphicsContext gc = c.getGraphicsContext2D();
			 */
			//obj.getChildren().add(c);
			
			
			obj.setBounds(10, 10, 905, 700);
			obj.setBackground(Color.DARK_GRAY);
			obj.setResizable(false);
			obj.setVisible(true);
			obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			obj.add(gamePlay);
			
			

			
			
			/*
			 * scene.getStylesheets().add(getClass().getResource("application.css").
			 * toExternalForm()); primaryStage.setScene(scene); primaryStage.show();
			 */
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	

	public static void main(String[] args) {
		launch(args);
	}
}

