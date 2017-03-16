package MyApp.util;

import java.io.InputStream;
import java.util.Properties;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;;

 
public class DBConnector {
 
    private static final SessionFactory sessionFactory;
 
    static {
        try {
           // sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        	InputStream inputStream = DBConnector.class.getClassLoader().getResourceAsStream( "/hibernate.properties" );
            Properties properties = new Properties();
                properties.load( inputStream );
                String hbcfg = properties.getProperty( "hiberNateCfgFileName" );
            sessionFactory =new Configuration().configure(hbcfg).buildSessionFactory();
           // System.out.println("Mapping Completed");
        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
 
    public static Session openSession() {
        return sessionFactory.openSession();
    }
}
