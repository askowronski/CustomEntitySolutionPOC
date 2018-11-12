package CustomEntityProject.PersistenceManager;


import CustomEntityProject.MorphiaSessionFactory;
import org.mongodb.morphia.query.Query;

public class Restricition {

    private String restrictionString;


    public Restricition(String restrictionString) {
        this.restrictionString = restrictionString;
    }

    public String getRestrictionString() {
        return restrictionString;
    }

    public void setRestrictionString(String restrictionString) {
        this.restrictionString = restrictionString;
    }


    public Query parseRestrictionString(Class classType) {
        Query query = MorphiaSessionFactory.getDataStore().createQuery(classType);

    }

}
