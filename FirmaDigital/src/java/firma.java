/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

/**
 *
 * @author CESAR M
 */
public class firma {
     public static void firmardocumento(String archi,  PrivateKey priva){
        try {
            byte[] data = archi.getBytes("UTF8");
            Signature firma = Signature.getInstance("MD5WithRSA");
            firma.initSign(priva);
            firma.update(data);
            byte[] firmadocumento = firma.sign();
            FileOutputStream fos = new FileOutputStream("Firma.txt");
            fos.write(firmadocumento);
            fos.close();
        } catch (Exception e) {
           
        }
    }
    
    public static boolean Verificarfirma(String archi, PublicKey publi){
        try{
            byte[] data = archi.getBytes("UTF8");
            FileInputStream fis = new FileInputStream("Firma.txt");
            int numbytes = fis.available();
            byte[] docfirma = new byte[numbytes];
            fis.read(docfirma);
            fis.close();
            Signature firma = Signature.getInstance("MD5WithRSA");
            firma.initVerify(publi);
            firma.update(data);
            return firma.verify(docfirma);
        }catch(Exception e){
            
            return false;
        }
    }
    public static void Guardarllaves()throws Exception{
        KeyPairGenerator generadorRSA = KeyPairGenerator.getInstance("RSA");
        generadorRSA.initialize(4096);
        KeyPair llaves = generadorRSA.genKeyPair();
        PublicKey llavePublica = llaves.getPublic();
        PrivateKey llavePrivada = llaves.getPrivate();
        FileOutputStream fos = new FileOutputStream("publicKey.key");
        fos.write(llavePublica.getEncoded());
        fos.close();
        FileOutputStream foss = new FileOutputStream("privateKey.key");
        foss.write(llavePrivada.getEncoded());
        foss.close();
        
    }
    
    public static PublicKey loadPublicKey() throws FileNotFoundException, IOException, NoSuchAlgorithmException, InvalidKeySpecException {
       
        FileInputStream fis = new FileInputStream("publicKey.key");
        int numbytes = fis.available();
        byte[] bytes = new byte[numbytes];
        fis.read(bytes);
        fis.close();
        
        KeyFactory fabricallaves = KeyFactory.getInstance("RSA");
        KeySpec keyspec = new X509EncodedKeySpec(bytes);
        PublicKey llavedelarchivo = fabricallaves.generatePublic(keyspec);
        return llavedelarchivo;
    }
    
    public static PrivateKey loadPrivateKey() throws FileNotFoundException, IOException, NoSuchAlgorithmException, InvalidKeySpecException {
        FileInputStream fis = new FileInputStream("privateKey.key");
        int numbytes = fis.available();
        byte[] bytes = new byte[numbytes];
        fis.read(bytes);
        fis.close();
        KeyFactory fabricallaves = KeyFactory.getInstance("RSA");
        KeySpec keyspecprivada = new PKCS8EncodedKeySpec(bytes);
        PrivateKey llavedelarchivopriv = fabricallaves.generatePrivate(keyspecprivada);
        return llavedelarchivopriv;
    }
}