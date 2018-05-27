package CustomEntityProject.PersistenceManager;

import CustomEntityProject.MorphiaSessionFactory;
import java.util.List;
import org.bson.types.ObjectId;

public class MongoDbPersistenceManager {

    public Object saveOrUpdateEntity(Object entity) throws Exception {
        try {
            MorphiaSessionFactory.getDataStore().save(entity);
            return entity;
        } catch (Exception e) {
            throw e;
        }
    }

    public Object removeEntity(Object entity) throws Exception {
        try {
            MorphiaSessionFactory.getDataStore().delete(entity);
            return entity;
        } catch (Exception e) {
            throw e;
        }
    }

    public Object getEntityByKey(String key, Class classType) throws Exception {
        try {
            return MorphiaSessionFactory.getDataStore().createQuery(classType).filter("_id", key).get();
        } catch (Exception e) {
            throw e;
        }
    }

    public Object getEntityByObjectId(ObjectId key, Class classType) throws Exception {
        try {
            return MorphiaSessionFactory.getDataStore().createQuery(classType).filter("_id", key).get();
        } catch (Exception e) {
            throw e;
        }
    }

    public List<Object> getEntities(Class classType) throws Exception {
        try {
            return MorphiaSessionFactory.getDataStore().createQuery(classType).asList();
        } catch (Exception e) {
            throw e;
        }
    }

}
