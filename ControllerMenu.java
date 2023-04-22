package application;

import java.io.File;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.*;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class ControllerMenu {
	
	private MediaPlayer mediaPlayer;
	
	public ControllerMenu() {
		String musicFile = "src/application/imagesPuzzle/Menu.mp3";
		Media sound = new Media(new File(musicFile).toURI().toString());
		mediaPlayer = new MediaPlayer(sound);
		mediaPlayer.play();
	}
	
	@FXML
	private Button buttonRetour;
	
	@FXML
	private Button buttonLevel1;
	
	@FXML
	private Button buttonLevel2;
	
	@FXML
	private Button buttonLevel3;
	
	@FXML
	public void clickOnLevel1(MouseEvent event) {
		try {
            AudioClip clip = new AudioClip(new File("src/application/imagesPuzzle/Select.mp3").toURI().toString());
            clip.play();
        } catch (Exception e) {
            e.printStackTrace();
        }
			
		try {
		    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("puzzleSceneBuilderLevel1.fxml"));
		    Parent root1 = (Parent) fxmlLoader.load();
		    Stage stage = new Stage();
		    stage.initModality(Modality.APPLICATION_MODAL);
		    stage.setTitle("Level1");
		    stage.setScene(new Scene(root1));  
		    stage.show();
		    
		    this.mediaPlayer.stop();
		    Stage stage2 = (Stage) buttonLevel1.getScene().getWindow();
			stage2.close();
		} catch(Exception e) {
	        e.printStackTrace();
	    }
	}
	
	@FXML
	public void clickOnLevel2(MouseEvent event) {
		try {
            AudioClip clip = new AudioClip(new File("src/application/imagesPuzzle/Select.mp3").toURI().toString());
            clip.play();
        } catch (Exception e) {
            e.printStackTrace();
        }
		
		try {
		    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("puzzleSceneBuilderLevel2.fxml"));
		    Parent root1 = (Parent) fxmlLoader.load();
		    Stage stage = new Stage();
		    stage.initModality(Modality.APPLICATION_MODAL);
		    stage.setTitle("Level2");
		    stage.setScene(new Scene(root1));  
		    stage.show();
		    
		    this.mediaPlayer.stop();
		    Stage stage2 = (Stage) buttonLevel2.getScene().getWindow();
			stage2.close();
		} catch(Exception e) {
	        e.printStackTrace();
	    }
	}
	
	@FXML
	public void clickOnLevel3(MouseEvent event) {
		try {
            AudioClip clip = new AudioClip(new File("src/application/imagesPuzzle/Select.mp3").toURI().toString());
            clip.play();
        } catch (Exception e) {
            e.printStackTrace();
        }
		
		try {
		    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("puzzleSceneBuilderLevel3.fxml"));
		    Parent root1 = (Parent) fxmlLoader.load();
		    Stage stage = new Stage();
		    stage.initModality(Modality.APPLICATION_MODAL);
		    stage.setTitle("Level3");
		    stage.setScene(new Scene(root1));  
		    stage.show();
		    
		    this.mediaPlayer.stop();
		    Stage stage2 = (Stage) buttonLevel3.getScene().getWindow();
			stage2.close();
		} catch(Exception e) {
	        e.printStackTrace();
	    }
	}
	
    @FXML
    void faireRetour(ActionEvent event) throws Exception {
    	this.mediaPlayer.stop();
    	try {
            AudioClip clip = new AudioClip(new File("src/application/imagesPuzzle/Return.mp3").toURI().toString());
            clip.play();
        } catch (Exception e) {
            e.printStackTrace();
        }
    	Parent root = FXMLLoader.load(getClass().getResource("MenuPrincipal.fxml"));
		
		Stage window = (Stage) buttonRetour.getScene().getWindow();
		window.setScene(new Scene(root, 1280, 720));
    }
	
}
