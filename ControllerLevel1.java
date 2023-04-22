package application;

import java.io.File;
import java.util.ArrayList;
import java.util.Random;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Effect;
import javafx.scene.effect.InnerShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class ControllerLevel1 {
	
	private MediaPlayer mediaPlayer;
	
	public ControllerLevel1() {
		String musicFile = "src/application/imagesPuzzle/Level.mp3";
		Media sound = new Media(new File(musicFile).toURI().toString());
		mediaPlayer = new MediaPlayer(sound);
		mediaPlayer.play();
	}
	
	private int nbrCoup;
	
	private int depart;
	
	private int destination;
	
	private int start = 0;
	
	@FXML
	private ImageView puzzle1;
	
	@FXML
	private ImageView puzzle2;
	
	@FXML
	private ImageView puzzle3;
	
	@FXML
	private ImageView puzzle4;
	
	@FXML
	private ImageView puzzle5;
	
	@FXML
	private ImageView puzzle6;
	
	@FXML
	private ImageView puzzle7;
	
	@FXML
	private ImageView puzzle8;
	
	@FXML
	private ImageView puzzle9;
	
	@FXML
	private Text coup;
	
	@FXML
	private Button buttonGame;
	
	private ArrayList<ImageView> puzzle;
	
	@FXML
	private Button buttonReturn;
	
	@FXML
	public void clickOnReturn(MouseEvent event) {
		try {
            AudioClip clip = new AudioClip(new File("src/application/imagesPuzzle/Return.mp3").toURI().toString());
            clip.play();
        } catch (Exception e) {
            e.printStackTrace();
        }
		
		try {
		    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("puzzleSceneBuilderMenu.fxml"));
		    Parent root1 = (Parent) fxmlLoader.load();
		    Stage stage = new Stage();
		    stage.initModality(Modality.APPLICATION_MODAL);
		    stage.setTitle("Menu");
		    stage.setScene(new Scene(root1));  
		    stage.show();
		    
		    mediaPlayer.stop();
		    Stage stage2 = (Stage) buttonReturn.getScene().getWindow();
			stage2.close();
		} catch(Exception e) {
	        e.printStackTrace();
	    }
	}
	
	public void initializeMe() {
		if (mediaPlayer.isMute()) {
			String musicFile = "src/application/imagesPuzzle/Level.mp3";
			Media sound = new Media(new File(musicFile).toURI().toString());
			mediaPlayer = new MediaPlayer(sound);
			mediaPlayer.play();
		}
		start = 1;
		ArrayList<ImageView> tab = new ArrayList<ImageView>();
		tab.add(puzzle1); tab.add(puzzle2); tab.add(puzzle3); 
		tab.add(puzzle4); tab.add(puzzle5); tab.add(puzzle6); 
		tab.add(puzzle7); tab.add(puzzle8); tab.add(puzzle9);
		this.puzzle = tab;
		this.depart = -1; this.destination = -1; 
		this.nbrCoup = 0; coup.setText("0");
		
		InnerShadow innerShadow = new InnerShadow();
		innerShadow.setOffsetX(4);
		innerShadow.setOffsetY(4);
		innerShadow.setColor(Color.web("0x3b596d"));
		 
		buttonGame.setText("Restart");
		buttonGame.setEffect(innerShadow);
		buttonGame.setStyle("-fx-background-color: BFC7C7; -fx-border-radius: 10; -fx-background-radius: 10;");
	}
	
	@FXML
	public void shuffleMe(MouseEvent event) {
		try {
            AudioClip clip = new AudioClip(new File("src/application/imagesPuzzle/Shuffle.mp3").toURI().toString());
            clip.play();
        } catch (Exception e) {
            e.printStackTrace();
        }
		
		initializeMe();
		Random rand = new Random();
		for (int i = 0; i < puzzle.size(); i++) {
			int randomIndexToSwap = rand.nextInt(puzzle.size());
			
			String image1 = puzzle.get(randomIndexToSwap).getImage().getUrl();
			String image2 = puzzle.get(i).getImage().getUrl();
			
			puzzle.get(randomIndexToSwap).setImage(new Image(image2));
			puzzle.get(i).setImage(new Image(image1));
		}
	}
	
	public void isItAWin() {
		boolean flag = true;
		for (int i = 1; i < puzzle.size(); i++) {
			String[] index1 = puzzle.get(i - 1).getImage().getUrl().split("/");
			String[] index2 = puzzle.get(i).getImage().getUrl().split("/");
			if (index1[index1.length - 1].charAt(0) > index2[index2.length - 1].charAt(0)) flag = false;
		}
		if (flag) {
			mediaPlayer.setMute(true);
			try {
	            AudioClip clip = new AudioClip(new File("src/application/imagesPuzzle/Win.mp3").toURI().toString());
	            clip.play();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
			
			coup.setText("Bravo !");
			start = 0;
			
			DropShadow dropShadow = new DropShadow();
			dropShadow.setOffsetX(0);
			dropShadow.setOffsetY(0);
			dropShadow.setColor(Color.rgb(204, 232, 23));
			
			buttonGame.setText("Replay");
			buttonGame.setEffect(dropShadow);
			buttonGame.setStyle("-fx-background-color: #40D4B8; -fx-border-radius: 10; -fx-background-radius: 10;");
		}
	}
	
	public void toSwipe() {		
		String image1 = puzzle.get(depart).getImage().getUrl();
		String image2 = puzzle.get(destination).getImage().getUrl();
		
		puzzle.get(depart).setImage(new Image(image2));
		puzzle.get(destination).setImage(new Image(image1));
		
		nbrCoup++; coup.setText(nbrCoup + "");
		depart = -1; destination = -1;
		
		isItAWin();
	}
	
	@FXML
	public void onClickPuzzle(MouseEvent event) {
		String id = event.getPickResult().getIntersectedNode().getId();
		if (start == 0) {
			try {
	            AudioClip clip = new AudioClip(new File("src/application/imagesPuzzle/Incorrect.mp3").toURI().toString());
	            clip.play();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
			
			coup.setText("Mélangez d'abord !");
		}
		else {
			
			for (int i = 0; i < puzzle.size(); i++) {
				if (puzzle.get(i).getId().equals(id)) {
					ImageView element = puzzle.get(i);
					if (depart != -1) {
						destination = i;
						puzzle.get(depart).setEffect(null);
						toSwipe();
					}
					else {
						depart = i;
						ColorAdjust colorAdjust = new ColorAdjust();
						colorAdjust.setBrightness(0.5);
						element.setEffect(colorAdjust);
					}
				}
			}
		}
	}
}
