package fr.afcepf.al26.programme;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by alexandrequere on 5/04/2016.
 */
@ApplicationPath("/rest")
public class MonApplication extends Application {
    private Set<Object> singletons = new HashSet<>();

    public MonApplication() {
        singletons.add(new RiaConnect());
    }

    @Override
    public Set<Object> getSingletons() {
        return singletons;
    }
}
