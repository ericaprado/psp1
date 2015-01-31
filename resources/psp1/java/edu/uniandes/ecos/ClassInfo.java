/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uniandes.ecos;

/**
 *
 * @author ASUS-PC
 */
public class ClassInfo {
    
    String path = "";    
    int methods = 0;
    int linesOfCode = 0;

    
    public String getPath() {
        return path;
    }

    public int getMethods() {
        return methods;
    }

    public int getLinesOfCode() {
        return linesOfCode;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public void setMethods(int methods) {
        this.methods = methods;
    }

    public void setLinesOfCode(int linesOfCode) {
        this.linesOfCode = linesOfCode;
    }
    
}
