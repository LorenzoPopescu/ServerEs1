/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serveres1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.BindException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author loren
 */
public class Server {
    ServerSocket ss;
    Socket sc;
    BufferedWriter bw;
    BufferedReader br;
    CountDown cd;
    public Server(int porta){
        try {
            ss = new ServerSocket(porta);
            System.out.println("Server in ascolto...");
            ss.setSoTimeout(3000);
            cd = new CountDown(2000);
            cd.start();
        }catch (IOException ex) {
            System.err.println("errore nella creazione del server e nell'avvio del servizio");
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
    
    public void ascolto(){
        try {
            sc = ss.accept();
            System.out.println("Connessione stabilita");
            br = new BufferedReader(new InputStreamReader(sc.getInputStream()));
            
            bw = new BufferedWriter(new OutputStreamWriter(sc.getOutputStream()));
            
            } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void scrivi(String messaggio){
        try {
            bw.write(messaggio+"\n");
            bw.flush();
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public String leggi(){
        String messaggioRitorno = "";
        try {
            messaggioRitorno = br.readLine();
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
        return messaggioRitorno;
    }
}
