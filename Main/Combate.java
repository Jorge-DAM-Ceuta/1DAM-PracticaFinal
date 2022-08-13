package PracticaT7;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

public class Combate extends Personaje{
    
    private static HashSet <Equipamiento> tesoros;
    
    
    public Combate (){
        tesoros = new HashSet<>();
        
        try{
            FileReader fr = new FileReader ("/home/jorge/Descargas/Tesoros/Tesoros/armas.csv");
            BufferedReader br = new BufferedReader(fr);
            String linea = "";
            String equipo [] = new String [5]; 
            
            br.readLine();
            
            while((linea=br.readLine())!=null){
                ArrayList<Integer> stats = new ArrayList<>();
                String [] estadisticas = new String[4];
                equipo = linea.split(",");
                estadisticas=equipo[3].split("-");
                
                for(int i=0; i<estadisticas.length; i++){
                    stats.add(Integer.parseInt(estadisticas[i]));
                }
                
                Arma a = new Arma (stats, equipo[0], equipo[1], Integer.parseInt(equipo[4]), "Una mano", equipo[2]);
                tesoros.add(a);
            }
            
            br.close();
            fr.close();
        
        }catch(IOException error){
            System.out.println(error);
        }
        
        
        try{
            FileReader fr = new FileReader ("/home/jorge/Descargas/Tesoros/Tesoros/armadura.csv");
            BufferedReader br = new BufferedReader(fr);
            String linea = "";
            String equipo [] = new String [6]; 
            
            br.readLine();
            
            while((linea=br.readLine())!=null){
                ArrayList<Integer> stats = new ArrayList<>();
                String [] estadisticas = new String[3];
                equipo = linea.split(",");
                estadisticas = equipo[3].split("-");
                
                for(int i=0; i<estadisticas.length; i++){
                    stats.add(Integer.parseInt(estadisticas[i]));
                }
                
                Armadura a = new Armadura (stats, equipo[0], equipo[1], Integer.parseInt(equipo[5]), equipo[2], equipo[3]);
                tesoros.add(a);
            }
            
            br.close();
            fr.close();
        
        }catch(IOException error){
            System.out.println(error);
        }
        
        try{
            FileReader fr = new FileReader ("/home/jorge/Descargas/Tesoros/Tesoros/artefactos.csv");
            BufferedReader br = new BufferedReader(fr);
            String linea = "";
            String equipo [] = new String [5]; 
            
            br.readLine();
            
            while((linea=br.readLine())!=null){
                ArrayList<Integer> stats = new ArrayList<>();
                String [] estadisticas = new String[7];
                equipo = linea.split(",");
                estadisticas = equipo[3].split("-");
                
                for(int i=0; i<estadisticas.length; i++){
                    stats.add(Integer.parseInt(estadisticas[i]));
                }
                
                Artefacto a = new Artefacto (stats, equipo[0], equipo[1], Integer.parseInt(equipo[3]), equipo[2]);
                tesoros.add(a);
            }
            
            br.close();
            fr.close();
        
        }catch(IOException error){
            System.out.println(error);
        }
    }
    
    
    public Equipamiento combatir(Personaje a, Personaje b){
        Iterator<Equipamiento> itr = tesoros.iterator();
        
        if(a.getAgilidadTotal()>b.getAgilidadTotal()){
                do{
                    System.out.println(a.defender());
                    System.out.println(b.defender());
                    System.out.println(a.luchar());
                    
                    if(a.getAgilidadTotal()>(b.getAgilidadTotal()*2)){
                        b.setVida(b.getVida()-(a.getDanoTotal()*2-b.getBlindajeTotal()));                        
                    }else{
                        b.setVida(b.getVida()-(a.getDanoTotal()-b.getBlindajeTotal()));
                    }
                    
                    System.out.println(a.getNombre() + " le quita " + (a.getDanoTotal()-b.getBlindajeTotal()) + " de Vida a " + b.getNombre() + "\n");
                    System.out.println(b.defender());
                    System.out.println(b.luchar());
                    
                    if(b.getAgilidadTotal()>(a.getAgilidadTotal()*2)){
                        a.setVida(a.getVida()-(b.getDanoTotal()*2-a.getBlindajeTotal()));                        
                    }else{
                        a.setVida(a.getVida()-(b.getDanoTotal()-a.getBlindajeTotal()));
                    }
                    
                    System.out.println(b.getNombre() + " le quita " + (b.getDanoTotal()-a.getBlindajeTotal()) + " de Vida a " + a.getNombre() + "\n");
                    a.setVida(a.getVida()-(b.getDanoTotal()-a.getBlindajeTotal()));
                    
                    if(a.getVida()<=0 && b.getVida()>0){
                        System.out.println(b.getNombre() + " ha ganado el combate!");
                        return itr.next();
                    }if(b.getVida()<=0 && a.getVida()>0){
                        System.out.println(a.getNombre() + " ha ganado el combate!");
                        return itr.next();
                    }
            
                }while(a.getVida()<=0 || b.getVida()<=0);
        }
        
        if(b.getAgilidadTotal()>a.getAgilidadTotal()){
                do{
                    System.out.println(b.defender());
                    System.out.println(a.defender());
                    System.out.println(b.luchar());
                    
                    if(b.getAgilidadTotal()>(a.getAgilidadTotal()*2)){
                        a.setVida(a.getVida()-(b.getDanoTotal()*2-a.getBlindajeTotal()));                        
                    }else{
                        a.setVida(a.getVida()-(b.getDanoTotal()-a.getBlindajeTotal()));
                    }
                    
                    System.out.println(b.getNombre() + " le quita " + (b.getDanoTotal()-a.getBlindajeTotal()) + " de Vida a " + a.getNombre() + "\n");
                    a.setVida(a.getVida()-b.getDanoTotal());
                    System.out.println(a.defender());
                    System.out.println(a.luchar());
                    
                    if(a.getAgilidadTotal()>(b.getAgilidadTotal()*2)){
                        b.setVida(b.getVida()-(a.getDanoTotal()*2-b.getBlindajeTotal()));                        
                    }else{
                        b.setVida(b.getVida()-(a.getDanoTotal()-b.getBlindajeTotal()));
                    }
                    
                    System.out.println(a.getNombre() + " le quita " + (a.getDanoTotal()-b.getBlindajeTotal()) + " de Vida a " + b.getNombre() + "\n");
                    b.setVida(b.getVida()-(a.getDanoTotal()-b.getBlindajeTotal()));
                    
                    if(a.getVida()<=0 && b.getVida()>0){
                        System.out.println(b.getNombre() + " ha ganado el combate!");
                        return itr.next();
                    }if(b.getVida()<=0 && a.getVida()>0){
                        System.out.println(a.getNombre() + " ha ganado el combate!");
                        return itr.next();
                    }
                    
                }while(a.getVida()<=0 || b.getVida()<=0);
        }
        
        return null;
    }
    
    public Equipamiento combatirGrupo(LinkedList<Personaje> bando1, LinkedList<Personaje> bando2){
        
        LinkedList <Personaje> caidosBando1 = new LinkedList();
        LinkedList <Personaje> caidosBando2 = new LinkedList();
        
        int intercambio=0;
        for(int i = 0; i<bando1.size()-1; i++){
            if(bando1.get(i).getAgilidad() > bando1.get(i+1).getAgilidad()){
                intercambio=bando1.get(i+1).getAgilidad();
                
            }
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

    @Override
    public String toString() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
