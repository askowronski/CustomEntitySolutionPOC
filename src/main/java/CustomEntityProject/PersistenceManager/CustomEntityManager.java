package CustomEntityProject.PersistenceManager;


import CustomEntityProject.CustomEntity;
import CustomEntityProject.EntityDefinition;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;
import java.util.stream.Collectors;
import org.bson.types.ObjectId;

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
