package application;

import java.io.File;
import java.io.IOException;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

public class MainController {
	
	private MediaPlayer mediaPlayer;
	
	public MainController () {
		String musicFile = "src/application/imagesPuzzle/Principal.mp3";
		Media sound = new Media(new File(musicFile).toURI().toString());
		
		mediaPlayer = new MediaPlayer(sound);
		mediaPlayer.play();
	}
	
	@FXML
	private Button pquatre;
	
	@FXML
	private Button back;
	
	@FXML
	private Button puzzle;
	
	@FXML
	private Button pendu;
	
	@FXML
	private Button options;
	
	
    public void puissance() throws Exception {
    	mediaPlayer.setMute(false);
    	mediaPlayer.stop();
    	try {
            AudioClip clip = new AudioClip(new File("src/application/imagesPuzzle/Select.mp3").toURI().toString());
            clip.play();
        } catch (Exception e) {
            e.printStackTrace();
        }
		Parent root = FXMLLoader.load(getClass().getResource("Puissance4.fxml"));
		
		Stage window = (Stage) pquatre.getScene().getWindow();
		window.setScene(new Scene(root, 864, 636));
    }
    
    public void retour() throws Exception {
    	mediaPlayer.setMute(false);
    	mediaPlayer.stop();
    	try {
            AudioClip clip = new AudioClip(new File("src/application/imagesPuzzle/Return.mp3").toURI().toString());
            clip.play();
        } catch (Exception e) {
            e.printStackTrace();
        }
		Parent root = FXMLLoader.load(getClass().getResource("MenuPrincipal.fxml"));
		
		Stage window = (Stage) back.getScene().getWindow();
		window.setScene(new Scene(root, 1280, 720));
    }
    
    public void lancerPendu() throws Exception {
    	mediaPlayer.setMute(false);
    	mediaPlayer.stop();
    	try {
            AudioClip clip = new AudioClip(new File("src/application/imagesPuzzle/Select.mp3").toURI().toString());
            clip.play();
        } catch (Exception e) {
            e.printStackTrace();
        }
    	Parent root = FXMLLoader.load(getClass().getResource("The pendu.fxml"));
		
		Stage window = (Stage) pendu.getScene().getWindow();
		window.setScene(new Scene(root, 600, 400));
    }
    
    public void lancerPuzzle() throws Exception {
    	mediaPlayer.setMute(false);
    	mediaPlayer.stop();
    	try {
            AudioClip clip = new AudioClip(new File("src/application/imagesPuzzle/Select.mp3").toURI().toString());
            clip.play();
        } catch (Exception e) {
            e.printStackTrace();
        }
    	Parent root = FXMLLoader.load(getClass().getResource("puzzleSceneBuilderMenu.fxml"));
		
		Stage window = (Stage) puzzle.getScene().getWindow();
		window.setScene(new Scene(root, 1000, 770));
    }
    
    public void lancerOptions() throws Exception {
    	mediaPlayer.setMute(false);
    	mediaPlayer.stop();
    	try {
            AudioClip clip = new AudioClip(new File("src/application/imagesPuzzle/Select.mp3").toURI().toString());
            clip.play();
        } catch (Exception e) {
            e.printStackTrace();
        }
    	Parent root = FXMLLoader.load(getClass().getResource("MenuOptions.fxml"));
		
		Stage window = (Stage) puzzle.getScene().getWindow();
		window.setTitle("Option");
		window.setScene(new Scene(root, 1280, 720));
    }
    
    public void quitterProgramme() throws Exception {
    	mediaPlayer.setMute(false);
    	mediaPlayer.stop();
    	try {
            AudioClip clip = new AudioClip(new File("src/application/imagesPuzzle/Return.mp3").toURI().toString());
            clip.play();
        } catch (Exception e) {
            e.printStackTrace();
        }
    	Platform.exit();
    }

}
