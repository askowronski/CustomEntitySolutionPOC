package CustomEntityProject;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

public class MorphiaSessionFactory {

    private static Morphia morphia = new Morphia();

    private static Datastore dataStore = morphia.createDatastore(new com.mongodb.MongoClient("localhost:27017"), "TheCustomEntityDB");

    public static Datastore getDataStore() {
        return dataStore;
    }

}
