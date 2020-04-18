/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Medicine.FrontEnd;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import javax.swing.JOptionPane;

/**
 *
 * @author Apirak Oulis
 */
public class MUSIC {
    public static void main(String[] args) {
        
    }
     public static void playmusic(String filepath) 
     {
         InputStream music;
         try {
             music = new FileInputStream(new File(filepath));
             AudioStream audios;
             audios = new AudioStream(music);
             AudioPlayer.player.start(audios);
         } catch (FileNotFoundException e) {
             JOptionPane.showMessageDialog(null, "KOKOKOKOKO");
         }
      
    }
}
