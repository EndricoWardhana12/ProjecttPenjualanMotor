
import javax.swing.JOptionPane;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.*;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ACER
 */
public class ModelLogin extends Konektor {
    Connection koneksi;
    Statement stat;
    ResultSet rs;
    Konektor conn;
    public boolean isLogin(String username, String password){
        try {
            String sql = "SELECT * FROM users WHERE username='" + username + "' and password='" + password + "'";
            conn = new Konektor();
            koneksi = conn.getKoneksi();
            stat = koneksi.createStatement();
            rs = stat.executeQuery(sql);
            if (rs.next()) {
                if (username.equals(rs.getString("username")) && password.equals(rs.getString("password"))) {
                    return true;
                }
            } else {
                return false;
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }
    
    public String get_lvl(String username){
        String sql = "SELECT lvl FROM users WHERE username = '"+username+"'";
        
        String lvl = null;
        try{
            conn = new Konektor();
            koneksi = conn.getKoneksi();
            stat = koneksi.createStatement();
            rs = stat.executeQuery(sql);
            
            while(rs.next()){
                lvl = rs.getString("lvl");
            }
            return lvl;
        }catch(Exception e){
            
        }
        return lvl;
    }
    
    public String get_id_user(String username){
        String sql = "SELECT id_user FROM users WHERE username = '"+username+"'";
        
        String id_user = null;
        try{
            conn = new Konektor();
            koneksi = conn.getKoneksi();
            stat = koneksi.createStatement();
            rs = stat.executeQuery(sql);
            
            while(rs.next()){
                id_user = rs.getString("id_user");
            }
            return id_user;
        }catch(Exception e){
            
        }
        return id_user;
    }
    
    public String get_username(String username){
        String sql = "SELECT username FROM users WHERE username = '"+username+"'";
        
        String nama = null;
        try{
            conn = new Konektor();
            koneksi = conn.getKoneksi();
            stat = koneksi.createStatement();
            rs = stat.executeQuery(sql);
            
            while(rs.next()){
                nama= rs.getString("username");
            }
            return nama;
        }catch(Exception e){
            
        }
        return nama;
    }
    
    public boolean isRegister(String username, String password){
        try {
            conn = new Konektor();
            koneksi = conn.getKoneksi();
            String query = "INSERT INTO users (username, password, lvl) VALUES ('" + username + "','" + password + "','customer')";
            stat = koneksi.createStatement();
            stat.executeUpdate(query);
            return true;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }
}
