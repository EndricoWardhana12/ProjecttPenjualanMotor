
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ACER
 */
public class ControllerLogin {
    public ControllerLogin(Login login, ModelLogin ML){
        login.getbtnLogin().addActionListener(new ActionListener(){
            
            public void actionPerformed(ActionEvent e){
                String username = login.get_username().getText();
                String password = login.get_password().getText();
                
                if(ML.isLogin(username, password)){
                    JOptionPane.showMessageDialog(null, "Berhasil Login cuy");
                    Session.set_lvl(ML.get_lvl(username));
                    Session.set_id_user(ML.get_id_user(username));
                    Session.set_username(ML.get_username(username));
                    new MenuUtama().show();
                    login.dispose();
                }
                else {
                    JOptionPane.showMessageDialog(null, "Gagal Login cuy : Pastikan Username dan Password terisi dan benar");
                }
            }
        });
        
        login.getbtnRegister().addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                String username = login.get_username().getText();
                String password = login.get_password().getText();
                
                if(ML.isRegister(username, password)){
                    System.out.println("yey");
                    JOptionPane.showMessageDialog(null, "berhasil register");
                }
                else {
                    JOptionPane.showMessageDialog(null, "Register gagal");
                }
            }
        });
    }
        
}
