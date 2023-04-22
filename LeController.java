package application;

import java.io.File;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class LeController {
	
	private MediaPlayer mediaPlayer;
	
	public LeController () {
		String musicFile = "src/application/imagesPuzzle/Puissance.mp3";
		Media sound = new Media(new File(musicFile).toURI().toString());
		mediaPlayer = new MediaPlayer(sound);
		mediaPlayer.play();
	}

	char[][] tab = new char[7][8];
	boolean tabInit = false;
	boolean joueur = false;
	boolean partieEnCour = false;

	@FXML
	private Label msgVictoire;
	
	@FXML
	private Button backk;

	@FXML
	private Button btnStart;
	@FXML
	private Label tour;

	@FXML
	private Button B00;

	@FXML
	private Button B01;

	@FXML
	private Button B02;

	@FXML
	private Button B03;

	@FXML
	private Button BO4;

	@FXML
	private Button B05;

	@FXML
	private Button B06;

	@FXML
	private Button B10;

	@FXML
	private Button B11;

	@FXML
	private Button B12;

	@FXML
	private Button B13;

	@FXML
	private Button B14;

	@FXML
	private Button B15;

	@FXML
	private Button B16;
	@FXML
	private Button B20;

	@FXML
	private Button B21;

	@FXML
	private Button B22;

	@FXML
	private Button B23;

	@FXML
	private Button B24;

	@FXML
	private Button B25;

	@FXML
	private Button B26;

	@FXML
	private Button B30;

	@FXML
	private Button B31;

	@FXML
	private Button B32;

	@FXML
	private Button B33;

	@FXML
	private Button B34;

	@FXML
	private Button B35;

	@FXML
	private Button B36;

	@FXML
	private Button B40;

	@FXML
	private Button B41;

	@FXML
	private Button B42;

	@FXML
	private Button B43;

	@FXML
	private Button B44;

	@FXML
	private Button B45;

	@FXML
	private Button B46;

	@FXML
	private Button B50;

	@FXML
	private Button B51;

	@FXML
	private Button B52;

	@FXML
	private Button B53;

	@FXML
	private Button B54;

	@FXML
	private Button B55;

	@FXML
	private Button B56;

	@FXML
	private Button B60;

	@FXML
	private Button B61;

	@FXML
	private Button B62;

	@FXML
	private Button B63;

	@FXML
	private Button B64;

	@FXML
	private Button B65;

	@FXML
	private Button B66;

	@FXML
	private Button B70;

	@FXML
	private Button B71;

	@FXML
	private Button B72;

	@FXML
	private Button B73;

	@FXML
	private Button B74;

	@FXML
	private Button B75;

	@FXML
	private Button B76;

	@FXML
	void loca1(ActionEvent event) {
		tabInit();
		int mem = lastEtage(0);
		if (partieEnCour && mem != -1) {
			remplirTableau(mem, 0);
			changerBouton(mem, 0);
			if (aGagne(mem, 0))
				msgVictoire();
		}

	}

	@FXML
	void loca2(ActionEvent event) {
		tabInit();
		int mem = lastEtage(1);
		if (partieEnCour && mem != -1) {
			remplirTableau(mem, 1);
			changerBouton(mem, 1);
			if (aGagne(mem, 1))
				msgVictoire();
		}
	}

	@FXML
	void loca3(ActionEvent event) {
		tabInit();
		int mem = lastEtage(2);
		if (partieEnCour && mem != -1) {
			remplirTableau(mem, 2);
			changerBouton(mem, 2);
			if (aGagne(mem, 2))
				msgVictoire();
		}
	}

	@FXML
	void loca4(ActionEvent event) {
		tabInit();
		int mem = lastEtage(3);
		if (partieEnCour && mem != -1) {
			remplirTableau(mem, 3);
			changerBouton(mem, 3);
			if (aGagne(mem, 3))
				msgVictoire();
		}

	}

	@FXML
	void loca5(ActionEvent event) {
		tabInit();
		int mem = lastEtage(4);
		if (partieEnCour && mem != -1) {
			remplirTableau(mem, 4);
			changerBouton(mem, 4);
			if (aGagne(mem, 4))
				msgVictoire();
		}
	}

	@FXML
	void loca6(ActionEvent event) {
		tabInit();
		int mem = lastEtage(5);
		remplirTableau(mem, 5);
		if (partieEnCour && mem != -1) {
			remplirTableau(mem, 4);
			changerBouton(mem, 5);
			if (aGagne(mem, 5))
				msgVictoire();
		}
	}

	@FXML
	void loca7(ActionEvent event) {
		tabInit();
		int mem = lastEtage(6);
		if (partieEnCour && mem != -1) {
			remplirTableau(mem, 6);
			changerBouton(mem, 6);
			if (aGagne(mem, 6))
				msgVictoire();
		}
	}

	@FXML
	void loca8(ActionEvent event) {
		tabInit();
		int mem = lastEtage(7);
		if (partieEnCour && mem != -1) {
			remplirTableau(mem, 7);
			changerBouton(mem, 7);
			if (aGagne(mem, 7))
				msgVictoire();
		}
	}

	int lastEtage(int colonne) {
		int mem = -1;
		if (tab[0][colonne] != 'x')
			return -1;
		for (int i = 0; i < 7 && tab[i][colonne] == 'x'; i++) {
			mem = i;

		}
		if (mem == -1) {
			mem = 6;
		}
		return mem;
	}

	void remplirTableau(int mem, int col) {
		if (joueur) {
			tab[mem][col] = 'r';
		} else {
			tab[mem][col] = 'o';
		}
	}

	void msgVictoire() {
		String vainqueur;
		String color;
		partieEnCour = !partieEnCour;
		if (joueur) {
			vainqueur = "ROUGE";
			color = "red";
		} else {
			vainqueur = "JAUNE";
			color = "yellow";
		}
		msgVictoire.setText("LE JOUEUR " + vainqueur + " A GAGNE !");
		msgVictoire.setStyle("-fx-text-fill: " + color + ";");
		mediaPlayer.stop();
		try {
            AudioClip clip = new AudioClip(new File("src/application/imagesPuzzle/Win.mp3").toURI().toString());
            clip.play();
        } catch (Exception e) {
            e.printStackTrace();
        }
	}

	void changerBouton(int ligne, int colonne) {
		String couleur;
		if (joueur) {
			couleur = "./images/CASEJAUNE.png";
		} else {
			couleur = "./images/CASEROUGE.png";
		}
		ImageView img = new ImageView(new Image(getClass().getResourceAsStream(couleur)));
		img.setFitHeight(50);
		img.setFitWidth(50);
		if (colonne == 0) {
			if (ligne == 0)
				B00.setGraphic(img);
			if (ligne == 1)
				B01.setGraphic(img);
			if (ligne == 2)
				B02.setGraphic(img);
			if (ligne == 3)
				B03.setGraphic(img);
			if (ligne == 4)
				BO4.setGraphic(img);
			if (ligne == 5)
				B05.setGraphic(img);
			if (ligne == 6)
				B06.setGraphic(img);
		}
		if (colonne == 1) {
			if (ligne == 0) {

				B10.setGraphic(img);
			}
			if (ligne == 1) {

				B11.setGraphic(img);
			}
			if (ligne == 2) {

				B12.setGraphic(img);
			}
			if (ligne == 3) {

				B13.setGraphic(img);
			}
			if (ligne == 4) {

				B14.setGraphic(img);
			}
			if (ligne == 5) {

				B15.setGraphic(img);
			}
			if (ligne == 6) {

				B16.setGraphic(img);
			}

		}
		if (colonne == 2) {
			if (ligne == 0) {

				B20.setGraphic(img);
			}
			if (ligne == 1) {

				B21.setGraphic(img);
			}
			if (ligne == 2) {

				B22.setGraphic(img);
			}
			if (ligne == 3) {

				B23.setGraphic(img);
			}
			if (ligne == 4) {

				B24.setGraphic(img);
			}
			if (ligne == 5) {

				B25.setGraphic(img);
			}
			if (ligne == 6) {

				B26.setGraphic(img);
			}

		}
		if (colonne == 3) {
			if (ligne == 0) {

				B30.setGraphic(img);
			}
			if (ligne == 1) {

				B31.setGraphic(img);
			}
			if (ligne == 2) {

				B32.setGraphic(img);
			}
			if (ligne == 3) {

				B33.setGraphic(img);
			}
			if (ligne == 4) {

				B34.setGraphic(img);
			}
			if (ligne == 5) {

				B35.setGraphic(img);
			}
			if (ligne == 6) {

				B36.setGraphic(img);
			}

		}
		if (colonne == 4) {
			if (ligne == 0) {

				B40.setGraphic(img);
			}
			if (ligne == 1) {

				B41.setGraphic(img);
			}
			if (ligne == 2) {

				B42.setGraphic(img);
			}
			if (ligne == 3) {

				B43.setGraphic(img);
			}
			if (ligne == 4) {

				B44.setGraphic(img);
			}
			if (ligne == 5) {

				B45.setGraphic(img);
			}
			if (ligne == 6) {

				B46.setGraphic(img);
			}

		}
		if (colonne == 5) {
			if (ligne == 0) {

				B50.setGraphic(img);
			}
			if (ligne == 1) {

				B51.setGraphic(img);
			}
			if (ligne == 2) {

				B52.setGraphic(img);
			}
			if (ligne == 3) {

				B53.setGraphic(img);
			}
			if (ligne == 4) {

				B54.setGraphic(img);
			}
			if (ligne == 5) {

				B55.setGraphic(img);
			}
			if (ligne == 6) {

				B56.setGraphic(img);
			}

		}
		if (colonne == 6) {
			if (ligne == 0) {

				B60.setGraphic(img);
			}
			if (ligne == 1) {

				B61.setGraphic(img);
			}
			if (ligne == 2) {

				B62.setGraphic(img);
			}
			if (ligne == 3) {

				B63.setGraphic(img);
			}
			if (ligne == 4) {

				B64.setGraphic(img);
			}
			if (ligne == 5) {

				B65.setGraphic(img);
			}
			if (ligne == 6) {

				B66.setGraphic(img);
			}

		}
		if (colonne == 7) {
			if (ligne == 0) {

				B70.setGraphic(img);
			}
			if (ligne == 1) {

				B71.setGraphic(img);
			}
			if (ligne == 2) {

				B72.setGraphic(img);
			}
			if (ligne == 3) {

				B73.setGraphic(img);
			}
			if (ligne == 4) {

				B74.setGraphic(img);
			}
			if (ligne == 5)

				B75.setGraphic(img);

			if (ligne == 6)
				B76.setGraphic(img);

		}
		passeUnTour();

	}

	void passeUnTour() {
		joueur = !joueur;
		String couleur;
		String color;
		if (joueur) {
			couleur = "Jaune";
			color = "yellow";
		} else {
			couleur = "Rouge";
			color = "red";
		}
		tour.setText("Joueur " + couleur + " à vous de jouer.");

		tour.setStyle("-fx-text-fill: " + color + "; -fx-font-size: 16px;");
	}

	boolean aGagne(int mem, int n) {
		return victoireH(mem) || victoireV(n) || victoireD(mem, n);
	}

	boolean victoireV(int colonne) {
		char verif;
		int compt = 0;
		if (joueur) {
			verif = 'o';
		} else {
			verif = 'r';
		}

		for (int ligne = 0; ligne < 7; ligne++) {
			if (tab[ligne][colonne] == verif) {
				compt++;
				if (compt >= 4) {
					return true;
				}
			} else {
				compt = 0;
			}

		}
		return compt >= 4;
	}

	boolean victoireH(int ligne) {
		char verif;
		int compt = 0;
		if (joueur) {
			verif = 'o';
		} else {
			verif = 'r';
		}

		for (int colonne = 0; colonne < 8; colonne++) {
			if (tab[ligne][colonne] == verif) {
				compt++;
				if (compt >= 4) {
					return true;
				}
			} else {
				compt = 0;
			}

		}
		return compt >= 4;

	}

	boolean victoireD(int ligne, int colonne) {

		int[] diag1 = recupDiag1(ligne, colonne);
		int[] diag2 = recupDiag2(ligne, colonne);

		char verif;
		int compt = 0;
		if (joueur) {
			verif = 'o';
		} else {
			verif = 'r';
		}
		ligne = diag1[0];
		colonne = diag1[1];

		for (; colonne >= 0 && ligne >= 0 && colonne < 8 && ligne < 7;) {
			if (tab[ligne][colonne] == verif) {
				compt++;
				if (compt >= 4) {
					return true;
				}
			} else {
				compt = 0;
			}
			ligne--;
			colonne--;
		}
		if (compt >= 4) {
			return true;
		}
		compt = 0;
		ligne = diag2[0];
		colonne = diag2[1];
		for (; colonne < 8 && ligne >= 0 && colonne >= 0 && ligne < 7;) {
			if (tab[ligne][colonne] == verif) {
				compt++;
				if (compt >= 4) {
					return true;
				}
			} else {
				compt = 0;
			}
			ligne--;
			colonne++;
		}
		if (compt >= 4)
			return true;

		return false;

	}

	int[] recupDiag1(int ligne, int colonne) {
		for (; ligne < 6 && colonne < 7;) {
			ligne++;
			colonne++;
		}
		int[] tabDiag = new int[2];
		tabDiag[0] = ligne;
		tabDiag[1] = colonne;
		return tabDiag;
	}

	int[] recupDiag2(int ligne, int colonne) {
		for (; ligne < 6 && colonne > 0;) {
			ligne++;
			colonne--;
		}
		int[] tabDiag = new int[2];
		tabDiag[0] = ligne;
		tabDiag[1] = colonne;
		return tabDiag;
	}

	void printTab() {
		for (int i = 0; i < 7; i++) {
			for (int j = 0; j < 8; j++) {
				System.out.print(tab[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}

	@FXML
	void commencer(ActionEvent event) {
		ImageView img = new ImageView(new Image(getClass().getResourceAsStream("./images/CASEVIDE.png")));
		img.setFitHeight(50);
		img.setFitWidth(50);
		B00.setGraphic(img);
		img = new ImageView(new Image(getClass().getResourceAsStream("./images/CASEVIDE.png")));
		img.setFitHeight(50);
		img.setFitWidth(50);
		B01.setGraphic(img);
		img = new ImageView(new Image(getClass().getResourceAsStream("./images/CASEVIDE.png")));
		img.setFitHeight(50);
		img.setFitWidth(50);
		B02.setGraphic(img);
		img = new ImageView(new Image(getClass().getResourceAsStream("./images/CASEVIDE.png")));
		img.setFitHeight(50);
		img.setFitWidth(50);
		B03.setGraphic(img);
		img = new ImageView(new Image(getClass().getResourceAsStream("./images/CASEVIDE.png")));
		img.setFitHeight(50);
		img.setFitWidth(50);
		BO4.setGraphic(img);
		img = new ImageView(new Image(getClass().getResourceAsStream("./images/CASEVIDE.png")));
		img.setFitHeight(50);
		img.setFitWidth(50);
		B05.setGraphic(img);
		img = new ImageView(new Image(getClass().getResourceAsStream("./images/CASEVIDE.png")));
		img.setFitHeight(50);
		img.setFitWidth(50);
		B06.setGraphic(img);
		img = new ImageView(new Image(getClass().getResourceAsStream("./images/CASEVIDE.png")));
		img.setFitHeight(50);
		img.setFitWidth(50);
		B10.setGraphic(img);
		img = new ImageView(new Image(getClass().getResourceAsStream("./images/CASEVIDE.png")));
		img.setFitHeight(50);
		img.setFitWidth(50);
		B11.setGraphic(img);
		img = new ImageView(new Image(getClass().getResourceAsStream("./images/CASEVIDE.png")));
		img.setFitHeight(50);
		img.setFitWidth(50);
		B12.setGraphic(img);
		img = new ImageView(new Image(getClass().getResourceAsStream("./images/CASEVIDE.png")));
		img.setFitHeight(50);
		img.setFitWidth(50);
		B13.setGraphic(img);
		img = new ImageView(new Image(getClass().getResourceAsStream("./images/CASEVIDE.png")));
		img.setFitHeight(50);
		img.setFitWidth(50);
		B14.setGraphic(img);
		img = new ImageView(new Image(getClass().getResourceAsStream("./images/CASEVIDE.png")));
		img.setFitHeight(50);
		img.setFitWidth(50);
		B15.setGraphic(img);
		img = new ImageView(new Image(getClass().getResourceAsStream("./images/CASEVIDE.png")));
		img.setFitHeight(50);
		img.setFitWidth(50);
		B16.setGraphic(img);
		img = new ImageView(new Image(getClass().getResourceAsStream("./images/CASEVIDE.png")));
		img.setFitHeight(50);
		img.setFitWidth(50);
		B20.setGraphic(img);
		img = new ImageView(new Image(getClass().getResourceAsStream("./images/CASEVIDE.png")));
		img.setFitHeight(50);
		img.setFitWidth(50);
		B21.setGraphic(img);
		img = new ImageView(new Image(getClass().getResourceAsStream("./images/CASEVIDE.png")));
		img.setFitHeight(50);
		img.setFitWidth(50);
		B22.setGraphic(img);
		img = new ImageView(new Image(getClass().getResourceAsStream("./images/CASEVIDE.png")));
		img.setFitHeight(50);
		img.setFitWidth(50);
		B23.setGraphic(img);
		img = new ImageView(new Image(getClass().getResourceAsStream("./images/CASEVIDE.png")));
		img.setFitHeight(50);
		img.setFitWidth(50);
		B24.setGraphic(img);
		img = new ImageView(new Image(getClass().getResourceAsStream("./images/CASEVIDE.png")));
		img.setFitHeight(50);
		img.setFitWidth(50);
		B25.setGraphic(img);
		img = new ImageView(new Image(getClass().getResourceAsStream("./images/CASEVIDE.png")));
		img.setFitHeight(50);
		img.setFitWidth(50);
		B26.setGraphic(img);
		img = new ImageView(new Image(getClass().getResourceAsStream("./images/CASEVIDE.png")));
		img.setFitHeight(50);
		img.setFitWidth(50);
		B30.setGraphic(img);
		img = new ImageView(new Image(getClass().getResourceAsStream("./images/CASEVIDE.png")));
		img.setFitHeight(50);
		img.setFitWidth(50);
		B31.setGraphic(img);
		img = new ImageView(new Image(getClass().getResourceAsStream("./images/CASEVIDE.png")));
		img.setFitHeight(50);
		img.setFitWidth(50);
		B32.setGraphic(img);
		img = new ImageView(new Image(getClass().getResourceAsStream("./images/CASEVIDE.png")));
		img.setFitHeight(50);
		img.setFitWidth(50);
		B33.setGraphic(img);
		img = new ImageView(new Image(getClass().getResourceAsStream("./images/CASEVIDE.png")));
		img.setFitHeight(50);
		img.setFitWidth(50);
		B34.setGraphic(img);
		img = new ImageView(new Image(getClass().getResourceAsStream("./images/CASEVIDE.png")));
		img.setFitHeight(50);
		img.setFitWidth(50);
		B35.setGraphic(img);
		img = new ImageView(new Image(getClass().getResourceAsStream("./images/CASEVIDE.png")));
		img.setFitHeight(50);
		img.setFitWidth(50);
		B36.setGraphic(img);
		img = new ImageView(new Image(getClass().getResourceAsStream("./images/CASEVIDE.png")));
		img.setFitHeight(50);
		img.setFitWidth(50);
		B40.setGraphic(img);
		img = new ImageView(new Image(getClass().getResourceAsStream("./images/CASEVIDE.png")));
		img.setFitHeight(50);
		img.setFitWidth(50);
		B41.setGraphic(img);
		img = new ImageView(new Image(getClass().getResourceAsStream("./images/CASEVIDE.png")));
		img.setFitHeight(50);
		img.setFitWidth(50);
		B42.setGraphic(img);
		img = new ImageView(new Image(getClass().getResourceAsStream("./images/CASEVIDE.png")));
		img.setFitHeight(50);
		img.setFitWidth(50);
		B43.setGraphic(img);
		img = new ImageView(new Image(getClass().getResourceAsStream("./images/CASEVIDE.png")));
		img.setFitHeight(50);
		img.setFitWidth(50);
		B44.setGraphic(img);
		img = new ImageView(new Image(getClass().getResourceAsStream("./images/CASEVIDE.png")));
		img.setFitHeight(50);
		img.setFitWidth(50);
		B45.setGraphic(img);
		img = new ImageView(new Image(getClass().getResourceAsStream("./images/CASEVIDE.png")));
		img.setFitHeight(50);
		img.setFitWidth(50);
		B46.setGraphic(img);
		img = new ImageView(new Image(getClass().getResourceAsStream("./images/CASEVIDE.png")));
		img.setFitHeight(50);
		img.setFitWidth(50);
		B50.setGraphic(img);
		img = new ImageView(new Image(getClass().getResourceAsStream("./images/CASEVIDE.png")));
		img.setFitHeight(50);
		img.setFitWidth(50);
		B51.setGraphic(img);
		img = new ImageView(new Image(getClass().getResourceAsStream("./images/CASEVIDE.png")));
		img.setFitHeight(50);
		img.setFitWidth(50);
		B52.setGraphic(img);
		img = new ImageView(new Image(getClass().getResourceAsStream("./images/CASEVIDE.png")));
		img.setFitHeight(50);
		img.setFitWidth(50);
		B53.setGraphic(img);
		img = new ImageView(new Image(getClass().getResourceAsStream("./images/CASEVIDE.png")));
		img.setFitHeight(50);
		img.setFitWidth(50);
		B54.setGraphic(img);
		img = new ImageView(new Image(getClass().getResourceAsStream("./images/CASEVIDE.png")));
		img.setFitHeight(50);
		img.setFitWidth(50);
		B55.setGraphic(img);
		img = new ImageView(new Image(getClass().getResourceAsStream("./images/CASEVIDE.png")));
		img.setFitHeight(50);
		img.setFitWidth(50);
		B56.setGraphic(img);
		img = new ImageView(new Image(getClass().getResourceAsStream("./images/CASEVIDE.png")));
		img.setFitHeight(50);
		img.setFitWidth(50);
		B60.setGraphic(img);
		img = new ImageView(new Image(getClass().getResourceAsStream("./images/CASEVIDE.png")));
		img.setFitHeight(50);
		img.setFitWidth(50);
		B61.setGraphic(img);
		img = new ImageView(new Image(getClass().getResourceAsStream("./images/CASEVIDE.png")));
		img.setFitHeight(50);
		img.setFitWidth(50);
		B62.setGraphic(img);
		img = new ImageView(new Image(getClass().getResourceAsStream("./images/CASEVIDE.png")));
		img.setFitHeight(50);
		img.setFitWidth(50);
		B63.setGraphic(img);
		img = new ImageView(new Image(getClass().getResourceAsStream("./images/CASEVIDE.png")));
		img.setFitHeight(50);
		img.setFitWidth(50);
		B64.setGraphic(img);
		img = new ImageView(new Image(getClass().getResourceAsStream("./images/CASEVIDE.png")));
		img.setFitHeight(50);
		img.setFitWidth(50);
		B65.setGraphic(img);
		img = new ImageView(new Image(getClass().getResourceAsStream("./images/CASEVIDE.png")));
		img.setFitHeight(50);
		img.setFitWidth(50);
		B66.setGraphic(img);
		img = new ImageView(new Image(getClass().getResourceAsStream("./images/CASEVIDE.png")));
		img.setFitHeight(50);
		img.setFitWidth(50);
		B70.setGraphic(img);
		img = new ImageView(new Image(getClass().getResourceAsStream("./images/CASEVIDE.png")));
		img.setFitHeight(50);
		img.setFitWidth(50);
		B71.setGraphic(img);
		img = new ImageView(new Image(getClass().getResourceAsStream("./images/CASEVIDE.png")));
		img.setFitHeight(50);
		img.setFitWidth(50);
		B72.setGraphic(img);
		img = new ImageView(new Image(getClass().getResourceAsStream("./images/CASEVIDE.png")));
		img.setFitHeight(50);
		img.setFitWidth(50);
		B73.setGraphic(img);
		img = new ImageView(new Image(getClass().getResourceAsStream("./images/CASEVIDE.png")));
		img.setFitHeight(50);
		img.setFitWidth(50);
		B74.setGraphic(img);
		img = new ImageView(new Image(getClass().getResourceAsStream("./images/CASEVIDE.png")));
		img.setFitHeight(50);
		img.setFitWidth(50);
		B75.setGraphic(img);
		img = new ImageView(new Image(getClass().getResourceAsStream("./images/CASEVIDE.png")));
		img.setFitHeight(50);
		img.setFitWidth(50);
		B76.setGraphic(img);
		img = new ImageView(new Image(getClass().getResourceAsStream("./images/CASEVIDE.png")));
		img.setFitHeight(50);
		img.setFitWidth(50);

		btnStart.setText("Recommencer");
		partieEnCour = true;
		videTableau();
		msgVictoire.setText("");
		tour.setText("");

	}

	void videTableau() {
		for (int i = 0; i < 7; i++) {
			for (int j = 0; j < 8; j++) {
				tab[i][j] = 'x';
			}
		}
	}

	void tabInit() {
		if (!tabInit) {
			tabInit = true;
			for (int i = 0; i < 7; i++) {
				for (int j = 0; j < 8; j++) {
					tab[i][j] = 'x';
				}
			}
		}

	}
	
	public void backer() throws Exception {
		mediaPlayer.stop();
		try {
            AudioClip clip = new AudioClip(new File("src/application/imagesPuzzle/Return.mp3").toURI().toString());
            clip.play();
        } catch (Exception e) {
            e.printStackTrace();
        }
    	Parent root = FXMLLoader.load(getClass().getResource("MenuPrincipal.fxml"));
		
		Stage window = (Stage) backk.getScene().getWindow();
		window.setScene(new Scene(root, 1280, 720));
    }

}
