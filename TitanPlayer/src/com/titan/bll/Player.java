/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.titan.bll;

import java.util.logging.Level;
import java.util.logging.Logger;
import javazoom.jl.player.advanced.*;

/**
 *
 * @author Brandon
 */
public class Player extends PlaybackListener implements Runnable{
    
    protected Playlist playlist;
    protected int currentSong = 0;
    protected Player myPlayer;
    protected String filePath;
    protected AdvancedPlayer player;
    protected Thread playerThread;
    protected boolean isPaused = false;
    
    public Player(){
    }
    
    public void loadPlaylist(Playlist playlistToLoad) {
        this.playlist = playlistToLoad; 
        currentSong = 0;
        this.filePath = playlist.songList.get(currentSong).songFile;
        
    }
    
    public String getCurrentSong(){
        return playlist.songList.get(currentSong).title;
    }
    
    public String isPlaylistLoaded(String title){
        return playlist.playlistTitle; 
    }
    
    public void skipSong() {
        currentSong+=1;
    }
    
    public void backSong() {
        currentSong-=1;
    }

    public void playSong(){
         try
        {
            String urlAsString = 
                "file:///" 
                + new java.io.File(".").getCanonicalPath() 
                + "/" 
                + this.filePath;

            this.player = new AdvancedPlayer
            (
                new java.net.URL(urlAsString).openStream(),
                javazoom.jl.player.FactoryRegistry.systemRegistry().createAudioDevice()
            );
    
            this.player.setPlayBackListener(this);
    
            this.playerThread = new Thread(this, "AudioPlayerThread");
    
            this.playerThread.start();
            
            currentSong+=1;
            
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    
        
    }
    
    public void pauseSong(){
        synchronized (this.playerThread){
        try {
            this.playerThread.wait();
            this.isPaused = true;
        }catch (InterruptedException ex) {
            Logger.getLogger(Player.class.getName()).log(Level.SEVERE, null, ex);
            }
        }      
    }
        public void stopSong(){
        synchronized (this.playerThread){
        try {
            this.playerThread.wait();
            this.playerThread = null;
        }catch (InterruptedException ex) {
            Logger.getLogger(Player.class.getName()).log(Level.SEVERE, null, ex);
            }
        }      
    }
    
    public boolean isPaused(){
        if(isPaused){
        return true;
        }else{
            return false;
        }
    }
    
    public boolean isPlaying(){
        return this.playerThread.isAlive();
    }
    
    public void resumeSong() throws InterruptedException {
        synchronized (this.playerThread){      
	    this.playerThread.notify();  
        }
        
        this.isPaused = false;
    }
    
    public boolean isPlayerCreated(){
        return true;
    }
  
  
  public void run()
    {
      
        try
        {
            this.player.play();
        }
        catch (javazoom.jl.decoder.JavaLayerException ex)
        {
            ex.printStackTrace();
        }
        
    }

}




 
