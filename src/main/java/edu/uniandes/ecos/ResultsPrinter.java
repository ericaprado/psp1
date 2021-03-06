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
            System.out.println("N�mero de M�todos:    " + classInfo.getMethods());
            System.out.println("N�mero de L�neas:    " + classInfo.getLinesOfCode());
            System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        }
        
    }
    
    public static String printWeb(List<ClassInfo> list, String programName){
        
        String resultHtml = "";
        int totalLines = 0;
               
            
        for (Iterator<ClassInfo> iterator = list.iterator(); iterator.hasNext();) {
            ClassInfo classInfo = (ClassInfo)iterator.next();
            
            resultHtml += "</br>--------------------------------------------------------------------";
            resultHtml += "</br>" + "Clase:    " + classInfo.getPath();
            resultHtml += "</br>" + "N�mero de M�todos:    " + classInfo.getMethods();
            resultHtml += "</br>" + "N�mero de L�neas:    " + classInfo.getLinesOfCode();
                     
            resultHtml += "</HTML>";
            
            totalLines += classInfo.getLinesOfCode();
        }
        resultHtml += "</br>++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++";
        
        String infoProgram = "";
        infoProgram += "<HTML>";
        infoProgram +=  "</br>++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++";
        infoProgram +=  "</br>CONTEO DE LINEAS PROGRAMA: " + programName;
        infoProgram +=  "</br>TOTAL LINEAS PROGRAMA: " + totalLines;
        
        return infoProgram + resultHtml;
    }
    
}
