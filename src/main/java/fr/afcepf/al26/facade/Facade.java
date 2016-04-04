package fr.afcepf.al26.facade;

import fr.afcepf.al26.iservice.IProduitService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by alexandrequere on 1/04/2016.
 */
public class Facade {
    private static Facade singleInstance;
    private ApplicationContext context;
    private IProduitService produitService;
    public static synchronized Facade getInstance(){
        if (singleInstance==null){
            singleInstance = new Facade();
        }
        return singleInstance;
    }

    public Facade() {
        context = new ClassPathXmlApplicationContext("classpath:spring-context.xml");
        produitService = context.getBean(IProduitService.class);
    }

    public IProduitService getProduitService() {
        return produitService;
    }
}
