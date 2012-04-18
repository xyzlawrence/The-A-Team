///*
// * To change this template, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.titan.dacl;
//
//import com.titan.bll.User;
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import org.hibernate.SessionFactory;
//import org.hibernate.classic.Session;
//
///**
// *
// * @author Brandon
// */
//public class DataAccess {
//    
//    public static void save(User user, SessionFactory sessions){
//        final Session session = new sessions.openSession();
//        final tx = session.beginTransaction();
//        
//        try{
//            session.saveOrUpdate(user);
//            tx.commit();
//        }
//        finally
//        {
//            session.close();
//        }
//        
//    }
//    
//        public static User load(String username, SessionFactory sessions){
//            
//        final Session session = new sessions.openSession();
//        final tx = session.beginTransaction();
//        
//        User user = null;
//        
//        try{
//            user = (User) session.get(User.class, username);
//            tx.commit();
//        }
//        finally
//        {
//            session.close();
//        }
//        
//        return user;
//        
//    }
//    
//    
////    public static void save(User user, Connection con) throws Exception{
////        try{
////            con.setAutoCommit(false);
////            
////            final PreparedStatement userDetails = con.prepareStatement("{call [dbo] .spSaveUser(?,?,?,?)}");
////            final PreparedStatement deleteAuthorities = con.prepareStatement("{call [dbo] .spDeleteAuthorities(?)}");
////            final PreparedStatement saveAuthority = con.prepareStatement("{call [dbo] .spSaveAuthority(?)}");
////            
////            userDetails.setString(1, user.getUsername());
////            userDetails.setString(2, user.getPassword());
////            userDetails.setString(3, user.getEmail());
////            userDetails.setBoolean(4, user.isEnabled());
////            userDetails.execute();
////            
////            deleteAuthorities.setString(1, user.getUsername());
////            deleteAuthorities.execute();
////            
////            saveAuthority.setString(1, user.getUsername());
////            
////            for(String auth : user.getAuths()){
////                saveAuthority.setString(2, auth);
////                saveAuthority.execute();
////            }
////            
////            con.commit();
////        
////        }
////        finally
////        {
////            con.setAutoCommit(true);
////        }
////        
////    }
////    
////    
////        public static User load(String username, Connection con) throws Exception{
////
////            final PreparedStatement getUser = con.prepareStatement("{call [dbo] .spGetUser(?)}");
////            final PreparedStatement getAuthorities = con.prepareStatement("{call [dbo] .spGetAuthorities(?)}");
////            
////            getUser.setString(1, username);
////            getAuthorities.setString(1, username);
////            ResultSet rs = getUser.executeQuery();
////            
////            User user = null;
////            
////            if (rs.next()){
////                user = new User(rs.getString(1), rs.getString(2), rs.getString(3), rs.getBoolean(4));
////                
////                rs = getAuthorities.executeQuery();
////                while(rs.next()){
////                    user.addAuths(rs.getString(1));
////                }
////            }
////            return user;
////     
////        }
//    
//}
