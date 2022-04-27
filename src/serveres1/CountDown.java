/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serveres1;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author loren
 */
public class CountDown extends Thread{
    int n;
    public CountDown(int n) {
        this.n = n;
    }
    
    @Override
    public void run(){
        for(int i = n; i>=0; i--){
            System.out.println("Tempo trascorso: "+i);
            try {
                sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(CountDown.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        System.out.println("Sessione terminata");
    }
}
