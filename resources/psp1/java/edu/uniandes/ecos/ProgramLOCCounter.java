/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uniandes.ecos;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author ASUS-PC
 */
public class ProgramLOCCounter {
    
    public List<ClassInfo> CountClasses(String path){
        
        List<ClassInfo> listResults = new ArrayList<ClassInfo>();
        
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
                    
                    List<ClassInfo> listResultsDir = this.CountClasses(file.getAbsolutePath());
                    
                    if(!listResultsDir.isEmpty())
                        listResults.addAll(listResultsDir);
                    
                }else{                    
                    FileInputStream fileIS = new FileInputStream(file);
                    listResults.add(counter.countLOCClass(file.getAbsolutePath(), fileIS));
                }                  
             }
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
    return listResults;
    }
    
    
    
}
