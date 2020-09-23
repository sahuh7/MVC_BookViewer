/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.MyBooksDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import dbutil.DBConnection;

/**
 *
 * @author HARSHIT
 */
public class MyBooksModel {
     
    public static ArrayList<MyBooksDTO> getBooksBySubject(String subject){
        
        ArrayList<MyBooksDTO> books = new ArrayList<>();
        try{
            Connection conn = DBConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement("SELECT book_id, book_name, book_price FROM mybooks WHERE subject = ?");
            
            ps.setString(1, subject);
            
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                MyBooksDTO book = new MyBooksDTO();
                book.setBookID(rs.getInt(1));
                book.setBookName(rs.getString(2));
                book.setBookPrice(rs.getFloat(3));
                book.setSubject(subject);
                books.add(book);
            }
        } catch(SQLException ex){
            System.out.println("DB Exception : "+ex.getMessage());
        } finally{
            return books;
        }        
    }
    
    public static boolean insertBook(MyBooksDTO book){
        
        int ans=0;
        try{
            Connection conn = DBConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement("INSERT INTO mybooks VALUES(?,?,?,?)");
            
            ps.setInt(1, book.getBookID());
            ps.setString(2, book.getBookName());
            ps.setFloat(3, book.getBookPrice());
            ps.setString(4, book.getSubject());
            
            ans = ps.executeUpdate();
        } catch(SQLException ex){
            System.out.println("DB Exception : "+ex.getMessage());
        } finally{
            return ans>0;
        }
    }
    
    public static ArrayList<MyBooksDTO> getAllBooks(){
        
        ArrayList<MyBooksDTO> books = new ArrayList<>();
        try{
            Connection conn = DBConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM mybooks");
                                  
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                MyBooksDTO book = new MyBooksDTO();
                book.setBookID(rs.getInt(1));
                book.setBookName(rs.getString(2));
                book.setBookPrice(rs.getFloat(3));
                book.setSubject(rs.getString(4));
                books.add(book);
            }
        } catch(SQLException ex){
            System.out.println("DB Exception : "+ex.getMessage());
        } finally{
            return books;
        }        
    }
}
