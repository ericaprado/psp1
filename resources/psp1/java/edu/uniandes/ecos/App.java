package edu.uniandes.ecos;

import java.util.List;
import javax.servlet.http.HttpServlet;
import org.eclipse.jetty.servlet.*;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import org.eclipse.jetty.server.Server;

/**
 * Hello world!
 *
 */
public class App extends HttpServlet 
{
     public static void main(String[] args) throws Exception {
    
        Server server = new Server(8080);
        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.setContextPath("/");
        server.setHandler(context);
        context.addServlet(new ServletHolder(new App()),"/*");
        server.start();
        server.join();
    }
     
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ProgramLOCCounter programCounter = new ProgramLOCCounter();
        String result = "";
                
        List<ClassInfo> classInfoList1 = programCounter.CountClasses("resources/psp0");        
        result = ResultsPrinter.printWeb(classInfoList1, "PSP0");
        
        List<ClassInfo> classInfoList2 = programCounter.CountClasses("resources/psp1");        
        result += ResultsPrinter.printWeb(classInfoList2, "PSP1");
        
        resp.getWriter().write(result);  

    }
     
}
