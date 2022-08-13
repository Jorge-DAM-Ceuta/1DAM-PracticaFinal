/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PracticaT7;

import java.util.LinkedList;

/**
 *
 * @author jorge
 */
public class papapapa {
 
    
    public Equipamiento combatirGrupo(LinkedList<Personaje> bando1, LinkedList<Personaje> bando2){
        
        LinkedList <Personaje> listadoDeOstias = new LinkedList ();
        LinkedList <Personaje> reservaBando1 = new LinkedList (bando1);
        LinkedList <Personaje> reservaBando2 = new LinkedList (bando2);
        
        
        for(){
        
        }
        
        if(bando1.peek().getAgilidadTotal()>bando2.peek().getAgilidadTotal()){
                do{
                    System.out.println(bando1.peek().defender());
                    System.out.println(bando2.peek().defender());
                    System.out.println(bando1.peek().luchar());
                    
                    if(bando1.peek().getAgilidadTotal()>(bando2.peek().getAgilidadTotal()*2)){
                        bando2.peek().setVida(bando2.peek().getVida()-(bando1.peek().getDanoTotal()*2-bando2.peek().getBlindajeTotal()));                        
                    }else{
                        bando2.peek().setVida(bando2.peek().getVida()-(bando1.peek().getDanoTotal()-bando2.peek().getBlindajeTotal()));
                    }
                    
                    System.out.println(bando1.peek().getNombre() + " le quita " + (bando1.peek().getDanoTotal()-bando2.peek().getBlindajeTotal()) + " de Vida a " + bando2.peek().getNombre() + "\n");
                    System.out.println(bando2.peek().defender());
                    System.out.println(bando2.peek().luchar());
                    
                    if(bando2.peek().getAgilidadTotal()>(bando1.peek().getAgilidadTotal()*2)){
                        bando1.peek().setVida(bando1.peek().getVida()-(bando2.peek().getDanoTotal()*2-bando1.peek().getBlindajeTotal()));                        
                    }else{
                        bando1.peek().setVida(bando1.peek().getVida()-(bando2.peek().getDanoTotal()-bando1.peek().getBlindajeTotal()));
                    }
                    
                    System.out.println(bando2.peek().getNombre() + " le quita " + (bando2.peek().getDanoTotal()-bando1.peek().getBlindajeTotal()) + " de Vida a " + bando1.peek().getNombre() + "\n");
                    bando1.peek().setVida(bando1.peek().getVida()-(bando2.peek().getDanoTotal()-bando1.peek().getBlindajeTotal()));
                    
                    if(bando1.peek().getVida()<=0 && bando2.peek().getVida()>0){
                        System.out.println(bando2.peek().getNombre() + " ha ganado el combate!");
                        caidosBando1.add(bando1.pop());
                        
                    }if(bando2.peek().getVida()<=0 && bando1.peek().getVida()>0){
                        System.out.println(bando1.peek().getNombre() + " ha ganado el combate!");
                        caidosBando2.add(bando2.pop());
                    }
            
                }while(bando1.peek().getVida()<=0 || bando2.peek().getVida()<=0);
        }
        
        if(bando2.peek().getAgilidadTotal()>bando1.peek().getAgilidadTotal()){
                do{
                    System.out.println(bando2.peek().defender());
                    System.out.println(bando1.peek().defender());
                    System.out.println(bando2.peek().luchar());
                    
                    if(bando2.peek().getAgilidadTotal()>(bando1.peek().getAgilidadTotal()*2)){
                        bando1.peek().setVida(bando1.peek().getVida()-(bando2.peek().getDanoTotal()*2-bando1.peek().getBlindajeTotal()));                        
                    }else{
                        bando1.peek().setVida(bando1.peek().getVida()-(bando2.peek().getDanoTotal()-bando1.peek().getBlindajeTotal()));
                    }
                    
                    System.out.println(bando2.peek().getNombre() + " le quita " + (bando2.peek().getDanoTotal()-bando1.peek().getBlindajeTotal()) + " de Vida a " + bando1.peek().getNombre() + "\n");
                    bando1.peek().setVida(bando1.peek().getVida()-bando2.peek().getDanoTotal());
                    System.out.println(bando1.peek().defender());
                    System.out.println(bando1.peek().luchar());
                    
                    if(bando1.peek().getAgilidadTotal()>(bando2.peek().getAgilidadTotal()*2)){
                        bando2.peek().setVida(bando2.peek().getVida()-(bando1.peek().getDanoTotal()*2-bando2.peek().getBlindajeTotal()));                        
                    }else{
                        bando2.peek().setVida(bando2.peek().getVida()-(bando1.peek().getDanoTotal()-bando2.peek().getBlindajeTotal()));
                    }
                    
                    System.out.println(bando1.peek().getNombre() + " le quita " + (bando1.peek().getDanoTotal()-bando2.peek().getBlindajeTotal()) + " de Vida a " + bando2.peek().getNombre() + "\n");
                    bando2.peek().setVida(bando2.peek().getVida()-(bando1.peek().getDanoTotal()-bando2.peek().getBlindajeTotal()));
                    
                    if(bando1.peek().getVida()<=0 && bando2.peek().getVida()>0){
                        System.out.println(bando2.peek().getNombre() + " ha ganado el combate!");
                        return tesoros.pop();
                    }if(bando2.peek().getVida()<=0 && bando1.peek().getVida()>0){
                        System.out.println(bando1.peek().getNombre() + " ha ganado el combate!");
                        return tesoros.pop();
                    }
                    
                }while(bando1.peek().getVida()<=0 || bando2.peek().getVida()<=0);
        }
        
        return null;
    }
}
