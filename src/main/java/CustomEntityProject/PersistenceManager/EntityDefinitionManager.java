package CustomEntityProject.PersistenceManager;


import CustomEntityProject.EntityDefinition;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;
import java.util.stream.Collectors;
import org.bson.types.ObjectId;

public class EntityDefinitionManager {

    private MongoDbPersistenceManager persistenceManager =  new MongoDbPersistenceManager();


    public EntityDefinition createEntityDefinition(
             Integer ownId,
             List<String>fieldAvailabilityKeys,
             String entityType,
             String parentEntityType,
             Boolean isSystem) throws Exception {

        EntityDefinition entityDef = new EntityDefinition(ownId, fieldAvailabilityKeys, entityType, parentEntityType, isSystem);


        try {
            persistenceManager.saveOrUpdateEntity(entityDef);
            return entityDef;
        } catch(Exception e) {
            throw e;
        }
    }

    public EntityDefinition createEntityDefinition(
            EntityDefinition def) throws Exception {

        try {
            persistenceManager.saveOrUpdateEntity(def);
            return def;
        } catch(Exception e) {
            throw e;
        }
    }

    public EntityDefinition createEntityDefinition(
            Integer ownId,
            List<String>fieldAvailabilityKeys,
            String entityType,
            String parentEntityType,
            Boolean isSystem,
            String id) throws Exception {

        EntityDefinition entityDef = new EntityDefinition(ownId, fieldAvailabilityKeys, entityType, parentEntityType, isSystem);
        entityDef.setId(id);


        try {
            persistenceManager.saveOrUpdateEntity(entityDef);
            return entityDef;
        } catch(Exception e) {
            throw e;
        }
    }

    public EntityDefinition getEntityDefinition(
            String id) throws Exception {


        try {
            return (EntityDefinition) persistenceManager.getEntityByObjectId(new ObjectId(id), EntityDefinition.class);
        } catch(Exception e) {
            throw e;
        }
    }

    public List<EntityDefinition> getAllEntityDefinitions() throws Exception {

        try {
            return  persistenceManager.getEntities(EntityDefinition.class).stream().map(e -> ((EntityDefinition)e)).collect(
                    Collectors.toList());
        } catch(Exception e) {
            throw e;
        }
    }

    public EntityDefinition updateEntityDefinition(String id,
            List<String>fieldAvailabilityKeys,
            String entityType,
            String parentEntityType,
            Boolean isSystem) throws Exception {

        try {
            EntityDefinition def = (EntityDefinition) persistenceManager.getEntityByKey(id, EntityDefinition.class);
            def.setFieldAvailabilityKeys(fieldAvailabilityKeys);
            def.setEntityType(entityType);
            def.setParentEntityType(parentEntityType);
            def.setSystem(isSystem);
            persistenceManager.saveOrUpdateEntity(def);
            return def;
        } catch(Exception e) {
            throw e;
        }
    }

    public boolean deleteEntityDefinition(Integer id) throws Exception {

        try {
            EntityDefinition def = (EntityDefinition) persistenceManager.getEntityByKey(id.toString(), EntityDefinition.class);
            persistenceManager.removeEntity(def);
            return true;
        } catch(Exception e) {
            throw e;
        }
    }

    public static String writeEntityDefinitionsToJson(List<EntityDefinition> defs) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.writeValueAsString(defs);
        } catch (JsonProcessingException e) {
            return e.getMessage();
        }
    }

}
