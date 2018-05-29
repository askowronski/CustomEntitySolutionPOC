package CustomEntityProject.PersistenceManager;

import CustomEntityProject.MorphiaSessionFactory;
import java.util.List;
import java.util.Map;
import org.bson.types.ObjectId;
import org.mongodb.morphia.query.Query;

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

    public Object getEntityByFilter(String filter,String filterValue, Class classType) throws Exception {
        try {
            return MorphiaSessionFactory.getDataStore().createQuery(classType).filter(filter, filterValue).get();
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

    public Query beginQuery(Class classType) {
        return MorphiaSessionFactory.getDataStore().find(classType);
    }


    public Query addRestriction(Query query, String fieldRestricition, String value) {
        return query.filter(fieldRestricition,value);
    }

    public Query addRestrictionToSubField(Query query, String subFieldName, String fieldRestriction, String value) {
        return query.filter(subFieldName+fieldRestriction, value);
    }

    public Object addHasElement(Query query, String fieldName, Object obj) {
        return query.field(fieldName).hasThisOne(obj);
    }

}
