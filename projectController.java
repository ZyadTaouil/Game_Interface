package application;

import javafx.stage.Stage;

import java.io.File;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class projectController {
	
	private MediaPlayer mediaPlayer;
	
	public projectController() {
		String musicFile = "src/application/imagesPuzzle/Pendu2.mp3";
		Media sound = new Media(new File(musicFile).toURI().toString());
		mediaPlayer = new MediaPlayer(sound);
		mediaPlayer.play();
	}

    @FXML
    private TextField nom1;

    @FXML
	protected TextField mot;

    @FXML
    private TextField nom2;

    @FXML
    private Button start;
    
    @FXML
    private Button barrer;


    @FXML
    protected void Hover(MouseEvent event) {
    	start.setStyle("-fx-background-color: linear-gradient(white, grey)");
    }

    @FXML
    void startGame(ActionEvent event) {
    	try {
    	mediaPlayer.setMute(false);
    	mediaPlayer.stop();
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("The pendu 2.fxml"));
    	Parent root = loader.load();
    	projectController2 pC2 = loader.getController();
    	pC2.recupereDonnees(mot,nom1.getText(),nom2.getText());
    	Scene scene2 = new Scene(root);
    	Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
    	window.setScene(scene2);
    	window.setTitle("The Pendu Game");
    	window.show();
    }
    	
    	catch(Exception e) {
			e.printStackTrace();
		}	
    }
    
    
    
    @FXML
    protected void unHover(MouseEvent event) {
    	start.setStyle("-fx-background-color: linear-gradient(black, grey)");
    }
  
    
    public void ciao() throws Exception {
    	mediaPlayer.setMute(false);
		mediaPlayer.stop();
    	try {
            AudioClip clip = new AudioClip(new File("src/application/imagesPuzzle/Return.mp3").toURI().toString());
            clip.play();
        } catch (Exception e) {
            e.printStackTrace();
        }
    	Parent root = FXMLLoader.load(getClass().getResource("MenuPrincipal.fxml"));
		
		Stage window = (Stage) barrer.getScene().getWindow();
		window.setScene(new Scene(root, 1280, 720));
    }
}