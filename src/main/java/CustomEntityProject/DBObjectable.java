package CustomEntityProject;

import com.mongodb.DBObject;
import org.bson.Document;

public interface DBObjectable {

    Document toDbObject();

}
