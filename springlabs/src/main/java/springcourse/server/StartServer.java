/**
 * 
 */
package springcourse.server;


import java.io.IOException;
import java.net.URL;
import java.net.URLClassLoader;

import org.apache.jasper.servlet.JspServlet;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.DefaultServlet;
import org.eclipse.jetty.servlet.ServletHolder;
import org.eclipse.jetty.webapp.WebAppContext;
/**
 * @author Oded Nissan
 *
 */
public class StartServer {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String projPath = "./";
		Server server = new Server(8080);

		try {
			projPath = new java.io.File( "." ).getCanonicalPath();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
       
        WebAppContext context = new WebAppContext();
        context.setAttribute("javax.servlet.context.tempdir","c:/tmp");
        context.setDescriptor(projPath +"src/main/webapp/WEB-INF/web.xml");
        context.setResourceBase(projPath + "/src/main/webapp");
        context.setContextPath("/");
        context.setParentLoaderPriority(true);

        server.setHandler(context);
        System.out.println("Server started ....");
        
        
        
        
        try {
			server.start();
			server.join();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}   
     
	}

}
