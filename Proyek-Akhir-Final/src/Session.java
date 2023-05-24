/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ACER
 */
public class Session {
   private static String id_user;
   private static String username;
   private static String lvl;
   private static String NoFaktur;
   
   public static String get_id_user(){
       return id_user;
   }
   public static void set_id_user(String id_user){
       Session.id_user = id_user;
   }
   public static String get_username(){
       return username;
   }
   public static void set_username(String username){
       Session.username = username;
   }
   public static String get_lvl(){
       return lvl;
   }
   public static void set_lvl(String lvl){
       Session.lvl = lvl;
   }
   public static String get_NoFaktur(){
       return NoFaktur;
   }
   public static void set_NoFaktur(String NoFaktur){
       Session.NoFaktur = NoFaktur;
   }
}
