package edu.uniandes.ecos;

import java.util.Iterator;
import java.util.LinkedList;


public class Operacion {
    
    public double calcularMedia (LinkedList numeros){
    
        Iterator it = numeros.iterator();
        
        double sumatoria = 0;
        
        while(it.hasNext()){            
            sumatoria += Double.parseDouble(it.next().toString());
        }
        
        return sumatoria/(numeros.size());
        
    }
    
    public double calcularDesviacionEstandar(LinkedList numeros, double media){
        
        Iterator it = numeros.iterator();
        
        double sumatoria = 0;
        
        while(it.hasNext()){
            sumatoria += Math.pow(((Double.parseDouble(it.next().toString())) - media ) , 2);            
        }
           
    return Math.sqrt(sumatoria/(numeros.size() - 1));
    }
    
}
