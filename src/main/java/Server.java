/**
 *
 * @author frabi
 */
import java.net.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.text.SimpleDateFormat;
import java.util.Date;

// link google documenti https://docs.google.com/document/d/14p1swf3fdv6j_qFKLwvQyYl-6aWkqWIe9vS_GoHxQVc/edit

public class Server {
    
    public static void main(String[] args){
                

        try {
          
        BufferedWriter out;
        BufferedReader in;
          
       ServerSocket serverSocket = new ServerSocket(2000);
       
        System.out.println("SERVER AVVIATO CORRETTAMEMTE \n");
             // 
             
        Socket socket=serverSocket.accept();
         System.out.println("CONNESSO CON SUCCESSO \n");
         
         
         //connessione 
         serverSocket.close();
                              
             out= new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
             
            in= new BufferedReader( new InputStreamReader(socket.getInputStream()));
            
            String messaggioBen="prova";
         out.write(messaggioBen+"\r\n");
              //INVIO MESSAGGIO DI BENVENUTO
            out.flush();
            
                
            String stringaRicevuta;
            stringaRicevuta=in.readLine();
            System.out.println("LA RICHIESTA DEL CLIENT E': " +stringaRicevuta+"\n");
                      
                      
                      
            SimpleDateFormat date = new SimpleDateFormat("yyyy.MM.dd.HH:mm:ss");
            String timeStamp = date.format(new Date());
                   
         out.write(timeStamp+"\r\n");
              System.out.println("INVIO DATA E ORA \n");
            out.flush();
              
        
         socket.close();
           System.out.println("CONNESSIONE TERMINATA \n");
    }
        catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}