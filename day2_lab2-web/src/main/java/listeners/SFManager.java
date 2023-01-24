package listeners;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import utils.HibernateUtils;

/**
 * Application Lifecycle Listener implementation class SFManager
 *
 */
@WebListener
public class SFManager implements ServletContextListener {

   
    public void contextDestroyed(ServletContextEvent sce)  { 
    	 System.out.println("----in ctx destroy----"); 
     	HibernateUtils.getGetFactory().close();
    }

	
    public void contextInitialized(ServletContextEvent sce)  { 
        System.out.println("----in ctx init----"); 
    	HibernateUtils.getGetFactory();
    }
	
}
