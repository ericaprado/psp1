/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uniandes.ecos;

import java.util.Iterator;
import java.util.List;

/**
 *
 * @author ASUS-PC
 */
public class ResultsPrinter {
    
    public static void printConsola(List<ClassInfo> list){
        
        for (Iterator<ClassInfo> iterator = list.iterator(); iterator.hasNext();) {
            ClassInfo classInfo = (ClassInfo)iterator.next();
            
            System.out.println("Clase:    " + classInfo.getPath());
            System.out.println("Número de Métodos:    " + classInfo.getMethods());
            System.out.println("Número de Líneas:    " + classInfo.getLinesOfCode());
            System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        }
        
    }
    
    public static String printWeb(List<ClassInfo> list, String programName){
        
        String resultHtml = "";
        
        for (Iterator<ClassInfo> iterator = list.iterator(); iterator.hasNext();) {
            ClassInfo classInfo = (ClassInfo)iterator.next();
            
            resultHtml = "<HTML>";
            resultHtml = resultHtml + "++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++";
            resultHtml = resultHtml + "CONTEO DE LINEAS PROGRAMA: " + programName;
            resultHtml = resultHtml + "</br>" + "Clase:    " + classInfo.getPath();
            resultHtml = resultHtml + "</br>" + "Número de Métodos:    " + classInfo.getMethods();
            resultHtml = resultHtml + "</br>" + "Número de Líneas:    " + classInfo.getLinesOfCode();
            resultHtml = resultHtml + "</br>" + "++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++";            
            resultHtml = resultHtml + "</HTML>";
        }
        
        return resultHtml;
    }
    
}
