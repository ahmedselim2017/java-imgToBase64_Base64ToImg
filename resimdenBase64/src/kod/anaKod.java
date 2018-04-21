//EuzubillAhimineşşeydanirracim Bismillahirrahmanirrahim
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package kod;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Base64;
import javax.swing.JOptionPane;

/**
 *
 * @author ahmed
 */
public class anaKod {
    public anaKod (){

    }
    public static void main(String[] args) {
        String resimYol = "C:\\Users\\ahmed\\Desktop\\kodlar\\java\\Tugva_Netbeans_Java_Dersleri\\resimdenBase64\\src\\resim\\resim.jpg";
		System.out.println("Resim Base64 apılıyor!");
		String base64Kodu = sifrele(resimYol);
		System.out.println("Base64 Kodu = " + base64Kodu);
                System.out.println("Base64 Kodu Resim Yapılıyor!");
                deSifrele(base64Kodu, "C:\\Users\\ahmed\\Desktop\\kodlar\\java\\Tugva_Netbeans_Java_Dersleri\\resimdenBase64\\src\\resim\\resim2.jpg");
		System.out.println("DONE!");
    }
    public static String sifrele(String resimYol){
        String sifrelenmisResim="";
        File resim=new File(resimYol);
        try(FileInputStream dosyadakiResim=new FileInputStream(resim)){
            byte resimVeri[]=new byte[(int)resim.length()];
            dosyadakiResim.read(resimVeri);
            sifrelenmisResim=Base64.getEncoder().encodeToString(resimVeri);
        }
        catch(FileNotFoundException hata){
            JOptionPane.showMessageDialog(null, "Resim bulunamadı.Hata:\n"+hata);
        }
        catch(IOException h){
            JOptionPane.showMessageDialog(null, "Resim açılamadı.Hata:\n"+h);
        }
        
        
        return sifrelenmisResim;
    }
    public static void deSifrele(String base64Kodu,String kaydedilcekYer){
        try(FileOutputStream resimCikis=new FileOutputStream(kaydedilcekYer)){
            byte[] resiVeri=Base64.getDecoder().decode(base64Kodu);
            resimCikis.write(resiVeri);
        } 
        catch (FileNotFoundException hata) {
            JOptionPane.showMessageDialog(null, "Resim bulunamadı.Hata:\n"+hata);
        } 
        catch (IOException h) {
            JOptionPane.showMessageDialog(null, "Resim açılamadı.Hata:\n"+h);
        }
    }
}
