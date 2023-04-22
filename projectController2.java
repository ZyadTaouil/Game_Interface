package application;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Labeled;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class projectController2 {
	
	private MediaPlayer mediaPlayer;
	
	public projectController2() {
		String musicFile = "src/application/imagesPuzzle/Pendu.mp3";
		Media sound = new Media(new File(musicFile).toURI().toString());
		mediaPlayer = new MediaPlayer(sound);
		mediaPlayer.play();
	}
	
	int lettresPasTrouvees;
	String nom1;
	String nom2;
	int countError=0;
	List<String> lettresTrouvees = new ArrayList<>();
	
		@FXML
		private Button retourr;
	
	 	@FXML
	    private ImageView i1;

	    @FXML
	    private ImageView i2;

	    @FXML
	    private ImageView i3;

	    @FXML
	    private ImageView i4;

	    @FXML
	    private ImageView i5;

	    @FXML
	    private ImageView i6;

	    @FXML
	    private ImageView i7;

	    @FXML
	    private ImageView i8;

	    @FXML
	    private ImageView i9;

    @FXML
    private HBox lemot;

    @FXML
    private TextField lettre;

    @FXML
    private Button start;
    
    @FXML
    private Text phrase;
    
    @FXML
    private Label dejaChoisi;

    @FXML
    void letterCheck(ActionEvent event) throws InterruptedException {
    	
    	boolean InWord=false;
    	int count = 0;
    	dejaChoisi.setText("");	
    	if(lettresTrouvees.contains(lettre.getText()) && (!lettre.getText().equals(""))) {
    		dejaChoisi.setText("Tu as d�j� choisi cette lettre, choisis une autre lettre !");	

    	}
    	else {
    	
    	for(Node n : lemot.getChildren()) {
    		if(((Labeled) n).getText().equals((lettre.getText())) ){
    		((Labeled) n).setStyle("-fx-text-fill:red; -fx-font-size:26px; -fx-font-weight:bold; -fx-border-width: 0 0 1 0; -fx-border-color:white; -fx-font-family:Tw Cen MT Condensed Extra Bold;");
    		InWord = true;
    		count++;
    		}
    		
    	}
    	if(!(lettresTrouvees.contains(lettre.getText())) && InWord == true){
    		lettresTrouvees.add(lettre.getText());
    		lettresPasTrouvees=lettresPasTrouvees - count;
    		}
    	if(lettresPasTrouvees==0) {
			lettre.setOpacity(0);
			phrase.setText(nom2 + " a surv�cu !!!");
			mediaPlayer.setMute(false);
			mediaPlayer.stop();
			try {
	            AudioClip clip = new AudioClip(new File("src/application/imagesPuzzle/Win.mp3").toURI().toString());
	            clip.play();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
		}
    	if(InWord==false){
    		countError++;
    		if(countError==1) {
    			i1.setOpacity(1);
    		}
    			else if(countError==2) {
    			i2.setOpacity(1);
    		}
    			else if(countError==3) {
    			i3.setOpacity(1);
    		}
    			else if(countError==4) {
    			i4.setOpacity(1);
    		}
    			else if(countError==5) {
    			i5.setOpacity(1);
    		}
    			else if(countError==6) {
    			i6.setOpacity(1);
    		}
    			else if(countError==7) {
    			i7.setOpacity(1);
    		}
    			else if(countError==8) {
    			i8.setOpacity(1);
    		}
    			else {
    				i9.setOpacity(1);
        			phrase.setText(nom2 + " est Mort ! " + nom1 + " a gagn� !");
        			mediaPlayer.setMute(false);
        			mediaPlayer.stop();
        			try {
        	            AudioClip clip = new AudioClip(new File("src/application/imagesPuzzle/Incorrect.mp3").toURI().toString());
        	            clip.play();
        	        } catch (Exception e) {
        	            e.printStackTrace();
        	        }
    			}
    		
    	}
    	
    	}
    	lettre.setText("");
    	}
    
	public void recupereDonnees(TextField mot, String s, String m) {
		   	nom1 = s;
		   	nom2 = m;
			String myWord = mot.getText();
		    lettresPasTrouvees = myWord.length();
			String[] word = myWord.split("");
	    
	    	for(int i=0;i<word.length;i++) {
	    		Label label = new Label(word[i]);
	    		label.setStyle("-fx-text-fill:red; -fx-font-size:26px; -fx-font-weight:bold; -fx-border-width: 0 0 1 0; -fx-border-color:white; -fx-font-family:Tw Cen MT Condensed Extra Bold;");
	    	    lemot.getChildren().add(label);
	    	for ( Node n : lemot.getChildren() ) {
	    		((Labeled) n).setStyle("-fx-text-fill:  #101324; -fx-font-size:26px; -fx-font-weight:bold; -fx-border-width: 0 0 1 0; -fx-border-color:white; -fx-font-family:Tw Cen MT Condensed Extra Bold;");
	    	}
	    	}
		    }
	
	@FXML
    protected void unHover(MouseEvent event) {
    	start.setStyle("-fx-background-color: linear-gradient(black, grey)");
    }
	
	 @FXML
	    protected void Hover(MouseEvent event) {
	    	start.setStyle("-fx-background-color: linear-gradient(white, grey)");
	    }

	 public void lancerRetour() throws Exception {
		 mediaPlayer.setMute(false);
		 mediaPlayer.stop();
		 try {
	            AudioClip clip = new AudioClip(new File("src/application/imagesPuzzle/Return.mp3").toURI().toString());
	            clip.play();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
		Parent root = FXMLLoader.load(getClass().getResource("MenuPrincipal.fxml"));
		
		Stage window = (Stage) retourr.getScene().getWindow();
		window.setScene(new Scene(root, 1280, 720));
	    }
	 
	}
    
    
