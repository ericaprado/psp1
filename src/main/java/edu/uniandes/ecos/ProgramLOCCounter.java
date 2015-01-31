/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uniandes.ecos;

import java.io.File;
import java.io.FileInputStream;


/**
 *
 * @author ASUS-PC
 */
public class ProgramLOCCounter {
    
    public void CountClasses(String path){
        
        try {
                       
            File dir = new File(path);
            File[] listFiles = dir.listFiles();
            ClassLOCCounter counter = new ClassLOCCounter();

             if (listFiles == null){
                 throw new Exception("No hay archivos en el directorio especificado");
             }
             
             for (int i = 0; i < listFiles.length; i++) {
                File file = listFiles[i];
                
                if (file.isDirectory()){
                    this.CountClasses(file.getAbsolutePath());
                }else{                    
                    FileInputStream fileIS = new FileInputStream(file);
                    printResults(counter.countLOCClass(file.getAbsolutePath(), fileIS));
                }                  
             }
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
    
    }
    
    private static void printResults (ClassInfo classInfo){
        
        System.out.println("Clase:    " + classInfo.getPath());
        System.out.println("Número de Métodos:    " + classInfo.getMethods());
        System.out.println("Número de Líneas:    " + classInfo.getLinesOfCode());
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
    }
    
}
