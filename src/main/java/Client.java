/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author frabi
 */
import java.net.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

// link google documenti https://docs.google.com/document/d/14p1swf3fdv6j_qFKLwvQyYl-6aWkqWIe9vS_GoHxQVc/edit

public class Client {
    
    public static void main(String[] args){
        
        try {
          DataOutputStream out;
          BufferedReader in;
            
                         
            Socket client = new Socket(InetAddress.getLocalHost(),2000);
             //RICHIESTA CONNESSIONE DEL CLIENT IN CORSO
        // 
             
             out= new DataOutputStream( client.getOutputStream());
             
             
            in= new BufferedReader( new InputStreamReader(client.getInputStream()));
            
            String stringaRicevuta;
            stringaRicevuta=in.readLine();
                      System.out.println("5) MESSAGGIO DEL SERVER: " +stringaRicevuta+"\n");
                      
                    String messaggioBenevnuto="MI DAI DATA E ORA?";
         out.writeBytes(messaggioBenevnuto+"\r\n");
              //richiesta data e ora
              out.flush();
            
            stringaRicevuta=in.readLine();
                      System.out.println("9) LA DATA RICEVUTA E': " +stringaRicevuta+"\n");
              
              
                client.close();
                //CONNESSIONE TERMINATA 
        }
       
        
    
        catch (UnknownHostException ex) {
              System.out.println("HOST SCONOSCIUTO \n");
            }
           catch (Exception ex) {
          System.out.println("ERRORE DURANTE LA CONNESISONE \n");
            }
    }
    
}
