/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.titan.bll;

/**
 *
 * @author Brandon
 */
public class Song {
    
    protected String title;
    protected String artist;
    protected String songFile;
    
    public Song(){
    }
    
    public Song(String title, String artist, String songFile) {
        this.title = title;
        this.artist = artist;
        this.songFile = songFile;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSongFile() {
        return songFile;
    }

    public void setSongFile(String songFile) {
        this.songFile = songFile;
    }
    
     @Override
     public boolean equals(Object songToDelete){

     Song ourSong = (Song) songToDelete;
     if(songToDelete instanceof Song){
     return (ourSong.title == null ? this.title == null : ourSong.title.equals(this.title));
     }
     return false;
     }
    

}
