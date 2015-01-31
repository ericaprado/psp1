/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uniandes.ecos;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author ASUS-PC
 */
public class ClassLOCCounter {
    
    private List specifiedAccessMethod; 

    public ClassLOCCounter() {
        this.specifiedAccessMethod = new ArrayList();
        this.specifiedAccessMethod.add("public");
        this.specifiedAccessMethod.add("privated");
        this.specifiedAccessMethod.add("protected");        
    }
    
    
    public ClassInfo countLOCClass(String path, FileInputStream file){
        ClassInfo classInfo = new ClassInfo();        
        classInfo.path = path;
        int lineCounter = 0;
        int methodCounter = 0;
        
        String line = "";
        
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(file));
            line = reader.readLine();
            
            while(line != null){
                
                if(isLine(line))
                    lineCounter++;
                
                if(isMethod(line))
                    methodCounter++;
                
                line=reader.readLine();
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        classInfo.methods = methodCounter;
        classInfo.linesOfCode = lineCounter;
        
        return classInfo;
    } 
    
    
    private boolean isMethod(String lineOfCode){
    
        String specifier = "";
        
        for (Iterator iterator = specifiedAccessMethod.iterator(); iterator.hasNext();) {
            
            specifier = iterator.next().toString();
            
            if(lineOfCode.trim().startsWith(specifier) && lineOfCode.contains("class"))
                return false;
            if(lineOfCode.trim().startsWith(specifier) && lineOfCode.contains("(") && lineOfCode.contains(")"))
                return true;
            
        }
        
        return false;
    }
    
    private boolean isLine(String lineOfCode){
    
        if(lineOfCode.trim().equals(""))
            return false;
        
        if(lineOfCode.trim().equals("{") || lineOfCode.trim().equals("}"))
            return false;
        
        if(lineOfCode.trim().startsWith("//"))
            return false;
        
        return true;
    }
    
    
}
