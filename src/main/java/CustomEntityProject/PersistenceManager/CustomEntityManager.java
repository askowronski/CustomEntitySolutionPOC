package CustomEntityProject.PersistenceManager;


import CustomEntityProject.CustomEntity;
import CustomEntityProject.Value;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.bson.types.ObjectId;
import org.mongodb.morphia.query.Query;

public class CustomEntityManager {

    private MongoDbPersistenceManager persistenceManager =  new MongoDbPersistenceManager();


    public CustomEntity createCustomEntity(CustomEntity entity) throws Exception {
        try {
            persistenceManager.saveOrUpdateEntity(entity);
            return entity;
        } catch(Exception e) {
            throw e;
        }
    }

    public void create1000Entities(List<String> availabilityKeys) throws Exception {

        for (int i = 0; i<1000;i++) {
            List<Value> values = new ArrayList<>();
            CustomEntity entity = new CustomEntity();
            entity.setEntityType("custom_123");
            entity.setOwnId(85);
            entity.setId(((i+1000)+""));

            int j = 0;

            for (String key:availabilityKeys) {
                Integer id = 10+j;
                j++;
                String value;
                if (key.equals("show_cfieldPartyBean.name")) {
                    value = "Andrew"+i;
                } else {
                    value="value"+id+i;
                }
                values.add(new Value(null,key,value));
            }
            entity.setValues(values);
            try {
                this.createCustomEntity(entity);
            } catch (Exception e) {
                throw e;
            }
        }


    }

    public CustomEntity getCustomEntityById(String id) throws Exception {
        try {
            return (CustomEntity) persistenceManager.getEntityByObjectId(new ObjectId(id), CustomEntity.class);
        } catch(Exception e) {
            throw e;
        }
    }

    public List<CustomEntity> getAllCustomEntities() throws Exception {

        try {
            return  persistenceManager.getEntities(CustomEntity.class).stream().map(e -> ((CustomEntity)e)).collect(
                    Collectors.toList());
        } catch(Exception e) {
            throw e;
        }
    }

    public List<CustomEntity> getCustomEntitiesWithFilter(Restriction restriction) throws Exception {
        Query query = persistenceManager.beginQuery(CustomEntity.class);
        return persistenceManager
                .addRestriction(query, restriction.getRestrictionString(), restriction.getValue())
                .asList();
    }

    public List<CustomEntity> getCustomEntitiesWithValue(Value value) throws Exception {
        Query<CustomEntity> query = persistenceManager.beginQuery(CustomEntity.class);
        return query.field("values").hasThisOne(value).asList();
    }

    public static String writeCustomEntitiesToJson(List<CustomEntity> defs) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.writeValueAsString(defs);
        } catch (JsonProcessingException e) {
            return e.getMessage();
        }
    }

    public static String writeCustomEntityToJson(CustomEntity entity) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.writeValueAsString(entity);
        } catch (JsonProcessingException e) {
            return e.getMessage();
        }
    }



}
