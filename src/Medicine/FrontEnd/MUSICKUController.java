/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Medicine.FrontEnd;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

/**
 * FXML Controller class
 *
 * @author Apirak Oulis
 */
public class MUSICKUController implements Initializable {

    String path ="C:\\Users\\Apirak Oulis\\Documents\\GitHub\\project\\Java_Assignment_Medicine\\src\\Medicine\\FrontEnd\\Music\\Synchronicity.wav";

    Media media = new Media(new File(path).toURI().toString());
    
    MediaPlayer mediaPlayer = new MediaPlayer(media);
    /**
     * Initializes the controller class.
     * @param url
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        mediaPlayer.play();
    }    
   
}
