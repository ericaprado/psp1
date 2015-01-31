package edu.uniandes.ecos;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        ProgramLOCCounter programCounter = new ProgramLOCCounter();
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("Contador de líneas Proyecto:  ");
        programCounter.CountClasses("C:\\Maven\\psp0\\src\\main\\java");
    }
}
