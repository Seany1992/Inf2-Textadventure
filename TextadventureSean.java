/**
 * Created by Markus Alpers on 20.10.2016.
 */

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Textadventure extends Application {

    private int aktuellerAbschnitt;
    private String[] abschnitte;
    private String[][] beschriftungen;
    private int[][] naechsterAbschnitt;
    private Text beschreibung;
    private Button button1;
    private Button button2;

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Textadventure");

        int abenteuerlaenge = 11;
        aktuellerAbschnitt = 0;

        abschnitte = new String[abenteuerlaenge];
        beschriftungen = new String[abenteuerlaenge][2];
        naechsterAbschnitt = new int[abenteuerlaenge][2];

         // 0: Schlafen - Der Traum (Startpunkt)
        abschnitte[0] = "Es ist alles perfekt, du liegst sorgenlos am Strand einer einsamen Insel und lässt dir die Sonne auf den Bauch scheinen. Plötzlich fängt der Wecker wie verrückt an zu klingeln, der Traum ist vorbei";
        beschriftungen[0][0] = "Du schaltest den Wecker genervt aus und stehst auf";
        naechsterAbschnitt[0][0] = 1;
        beschriftungen[0][1] = "Du schaust mit verschlafenden Blick auf die Uhrzeit und drückst auf den schlummer Button.";
        naechsterAbschnitt[0][1] = 2;

        // 1: Nachdem Aufstehen
        abschnitte[1] = "Es ist montagmorgens und dir wird bewusst, dass du verschlafen hast und die Gefahr besteht zur spät zur Uni zu erscheinen. Wäre das nicht schon Schlimm genug, steht genau heute eine wichtige Klausur an!";
        beschriftungen[1][0] = "Du wirst panisch und sprintest in das badezimmer.";
        naechsterAbschnitt[1][0] = 3;
        beschriftungen[1][1] = "Du entscheidest dich dafür lieber weiterzuschlafen, weil das Bett einfach zu gemütlich ist.";
        naechsterAbschnitt[1][1] = 0;

        // 2: Schlummern
        abschnitte[2] = "nach weiteren 20 Minuten Schlaf, klingelt der Wecker ein weiteres Mal";
        beschriftungen[2][0] = "Du entscheidest dich dafür im Bett liegen zu bleiben und den Wecker auszuschalten";
        naechsterAbschnitt[2][0] = 9;
        beschriftungen[2][1] = "Du entscheidest dich endlich aufzustehen, wird aber auch Zeit!!";
        naechsterAbschnitt[2][1] =1 ;

        // 3: Das Badezimmer
        abschnitte[3] = "Mit erhöhter Herzfrequenz erreichst du das Badezimmer und schaust in den Spiegel.";
        beschriftungen[3][0] = "Du entscheidest dich für deine übliche Morgenroutine, da du dich ohne nicht aus dem Haus traust. ";
        naechsterAbschnitt[3][0] = 4;
        beschriftungen[3][1] = "Du willst so schnell wie möglich zur Uni und sprühst dich lediglich mit dem Deodorant ein";
        naechsterAbschnitt[3][1] = 5;

        // 4: Langsame Methode
        abschnitte[4] = "Du verlässt die Haustür und schaust auf deine Uhr, es ist bereits 8:20 Uhr!!";
        beschriftungen[4][0] = "Du entscheidest dich dafür ein Taxi zu nehmen, die Dinger sind eh schneller als der Bus!
        naechsterAbschnitt[4][0] = 8;
        beschriftungen[4][1] = "Du schaust auf die andere Strassenseite und siehst bereits den richtigen Bus ankommen und entscheidest dich einzusteigen";
        naechsterAbschnitt[4][1] = 7;

        // 5: Schnelle Methode
        abschnitte[5] = "Du verlässt die Haustür und schaust auf deine Uhr, 8:00!! Knapp 30 Minuten bis zur Klausur!";
        beschriftungen[5][0] = "Du entscheidest dich die Bahn zu nehmen, diese sind immer zuverlässig";
        naechsterAbschnitt[5][0] = 6;
        beschriftungen[5][1] = "Du entscheidest dich für den Bus, der ist generell etwas langsamer aber bietet mehr komfort";
        naechsterAbschnitt[5][1] = 7;
	
		// 6: Die Bahn
        abschnitte[6] = "Leider ";
        beschriftungen[6][0] = "Du entscheidest dich den restlichen weg zu laufen ";
        naechsterAbschnitt[6][0] = 11 ;
        beschriftungen[6][1] = "Du entscheidest dich auf den Bus zu warten. Die Busse hier haben zum Glück immer eine eigene Fahrspur. ";
        naechsterAbschnitt[6][1] = 7 ;

		// 7: Der Bus
        abschnitte[7] = "Der Bus ist zum Glück leer und die Fahrt ist aufgrund von wenigen Verkehrsbehinderungen zügig";
        beschriftungen[7][0] = "Du steigst bei deiner Uni-haltestelle aus ";
        naechsterAbschnitt[7][0] = 9 ;
        beschriftungen[7][1] = "Vor lauter Aufregung hast du das Frühstücken vergessen, ohne richtige Mahlzeit lässt sich die Kalusur nicht bewältigen! Deshalb entscheidest du dich eine Station weiter zu fahren und dem Bäcker deines Vertrauens einen Besuch abzustatten";
        naechsterAbschnitt[7][1] = 11 ;

	// 8: Das Taxi
        abschnitte[8] = "Das Taxi war wohl keine gute Entscheidung, ständig rote Ampeln und dazu noch ein Berufsverkehr, der das vorankommen erschwert";
        beschriftungen[8][0] = "Du entscheidest dich an der nächsten Bushaltestelle auszusteigen. Die Busse hier, haben zum Glück immer eine eigene Fahrspur.";
        naechsterAbschnitt[8][0] = 7 ;
        beschriftungen[8][1] = "Du entscheidest dich sitzen zu bleiben und zu hoffen püntklich anzukommen, der Stau ist bestimmt gleich vorbei.";
        naechsterAbschnitt[8][1] =11 ;

	 // 9: Pünktlich auf den Punkt (Spielende - Gutes Ende)
        abschnitte[9] = "8:30! Die Klausur beginnt und du bist rechtzeitig - Glückwunsch!";
        beschriftungen[9][0] = "Nochmal von vorne.";
        naechsterAbschnitt[9][0] = 0;
        beschriftungen[9][1] = "Spiel beenden.";
        naechsterAbschnitt[9][1] = 0;

	
	 // 10: Zuhause ist es immernoch am schönsten (GameOver - Schlechtes Ende)
        abschnitte[10] = "Es gibt nichts schöneres als ein warmes Bett und eine Mütze voll Schlaf";
        beschriftungen[10][0] = "Nochmal von vorne.";
        naechsterAbschnitt[10][0] = 0;
        beschriftungen[10][1] = "Spiel beenden."; //Ende
        naechsterAbschnitt[10][1] = 0;

	 // 11: zu Spät! (GameOver - Schlechtes Ende)
        abschnitte[11] = "Die Klausur hat seit 20 Minuten begonnen eine Teilnahme ist nicht mehr möglich";
        beschriftungen[11][0] = "Nochmal von vorne.";
        naechsterAbschnitt[10][0] = 0;
        beschriftungen[11][1] = "Spiel beenden."; //Ende
        naechsterAbschnitt[11][1] = 0;

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        Scene scene = new Scene(grid, 1200, 400);
        primaryStage.setScene(scene);

        Text scenetitle = new Text("Kleines Textadventure");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(scenetitle, 0, 0, 2, 1);

        beschreibung = new Text(abschnitte[aktuellerAbschnitt]);
        grid.add(beschreibung, 0, 1, 2, 2);

        button1 = new Button(beschriftungen[aktuellerAbschnitt][0]);
        grid.add(button1, 0, 3);
        grid.setHalignment(button1, HPos.RIGHT);

        button2 = new Button(beschriftungen[aktuellerAbschnitt][1]);
        grid.add(button2, 1, 3);
        grid.setHalignment(button2, HPos.LEFT);

        button1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                aktuellerAbschnitt = naechsterAbschnitt[aktuellerAbschnitt][0];
                rewriteEntries(aktuellerAbschnitt);
            }
        });

        button2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                aktuellerAbschnitt = naechsterAbschnitt[aktuellerAbschnitt][1];
                rewriteEntries(aktuellerAbschnitt);
            }
        });

        primaryStage.show();
    }

    private void rewriteEntries(int abschnnitt){
        beschreibung.setText(abschnitte[aktuellerAbschnitt]);
        button1.setText(beschriftungen[aktuellerAbschnitt][0]);
        button2.setText(beschriftungen[aktuellerAbschnitt][1]);
    }

    public static void main(String[] args) {
        launch(args);
    }

}

/**
 * Grundsätzlich nötig:
 * Textanzeige
 * Buttons für Auswahl der Antwort
 *
 * Texte aus Array von Abschnitten
 * Dazu Array mit Anzahl Buttons zum Abschnitt
 * Dazu Array mit Texten für jeden der Buttons
 */