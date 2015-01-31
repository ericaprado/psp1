package edu.uniandes.ecos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Arrays;
import java.util.LinkedList;

public class MainClass {
    
    public static void main(String args[]){
        
        Operacion operacion = new Operacion();
        String ruta = "D://numeros.txt";
        LinkedList numeros = cargarNumeros(ruta);
        
        double media = operacion.calcularMedia(numeros);               
        System.out.println("MEDIA: " + media);        
        System.out.println("DESVIACION ESTANDAR  " + operacion.calcularDesviacionEstandar(numeros, media));        
    }
    
    public static LinkedList cargarNumeros(String ruta){
    
        try {
            File archivo = new File(ruta);
            FileReader fr = new FileReader(archivo);    
            BufferedReader br = new BufferedReader(fr);            
            String linea = br.readLine();            
            br.close();
            
            String[] arrayNumeros = linea.split(",");
            
            for (int i = 0; i < arrayNumeros.length; i++) {
                System.out.println(arrayNumeros[i]);
            }
            
            return new LinkedList(Arrays.asList(arrayNumeros));
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return null;        
    }
    
    
}
