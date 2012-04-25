package com.titan.dacl;

import com.titan.bll.Song;
import com.titan.bll.User;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DataAccess {

    public static void save(User user, Connection con) throws Exception {
        try {
            con.setAutoCommit(false);

            final PreparedStatement userDetails = con.prepareStatement("INSERT INTO APP.USERS (ID,EMAIL,PASSWORD) VALUES (?,?,?) ");
            userDetails.clearParameters();
            userDetails.setString(1, user.getUsername());
            userDetails.setString(2, user.getEmail());
            userDetails.setString(3, String.valueOf(user.getPassword()));
            userDetails.execute();
            con.commit();
        } finally {
            con.setAutoCommit(true);
        }

    }
    
    public static void save(Song song, User user, Connection con) throws Exception{
        try {
            con.setAutoCommit(false);

            final PreparedStatement songDetails = con.prepareStatement("INSERT INTO APP.SONGS (TITLE,ID,ARTIST,SONG_PATH) VALUES (?,?,?,?) ");
            songDetails.clearParameters();
            songDetails.setString(1, song.getTitle() );
            songDetails.setString(2, user.getUsername());
            songDetails.setString(3, song.getArtist());
            songDetails.setString(4, song.getSongFile());
            songDetails.execute();
            con.commit();
        } finally {
            con.setAutoCommit(true);
        }

        
    }
    public static User load(String username, Connection con) throws Exception {

        final PreparedStatement getUser = con.prepareStatement("SELECT * FROM APP.USERS WHERE ID = ?");
        getUser.clearParameters();
        getUser.setString(1, username);
        ResultSet rs = getUser.executeQuery();

        User user = null;

        if (rs.next()) {
            user = new User(rs.getString(1), rs.getString(2), rs.getString(3).toCharArray());


        }
        return user;

    }

}
