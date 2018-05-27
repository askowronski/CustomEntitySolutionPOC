package CustomEntityProject;

import java.util.ArrayList;
import java.util.List;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;
import org.mongodb.morphia.query.UpdateOperations;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class MongoApplication {

    public static void main(String[] args) {

        SpringApplication.run(MongoApplication.class ,args);




//        MongoClient client = MongoClients.create("mongodb://localhost:27017");
//        MongoDatabase database = client.getDatabase("TheCustomEntityDB");
//        Morphia morphia = new Morphia();
//        Datastore dataStore = morphia.createDatastore(new com.mongodb.MongoClient("localhost:27017"), "TheCustomEntityDB");
//
//
//
//        List<Value> values = new ArrayList();
//        for(int i = 2; i < 10; i++) {
//            values.add(new Value(Integer.toString(i), "avail_"+i, "value_"+i));
//        }
//
//        CustomEntity entity = new CustomEntity(values, "entity_7");
//
//        dataStore.save(entity);
//
//        List<CustomEntity> entities = dataStore.createQuery(CustomEntity.class).filter("values.availabilityKey = ", "avail_2").project("values.$",true).asList();
//        for (CustomEntity ent: entities) {
//            ent.getValues().get(0).setValue("Da New New CustomEntityProject.PersistencePackage.Value");
//            UpdateOperations ops = dataStore.createUpdateOperations(CustomEntity.class);
//        }
//
//        List<CustomEntity> entsAfter = dataStore.createQuery(CustomEntity.class).filter("values.availabilityKey = ", "avail_1").asList();

    }

}
