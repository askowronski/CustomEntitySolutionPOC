package CustomEntityProject;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.List;
import org.bson.Document;
import org.mongodb.morphia.annotations.Embedded;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

@Entity("custom_entity")
public class CustomEntity implements DBObjectable, HasValues {


    @Id
    @JsonProperty("id")
    private String id;
    @JsonProperty("values")
    @Embedded
    public List<Value> values;
    @JsonProperty("ownId")
    private Integer ownId;
    @JsonProperty("entityType")
    private String entityType;

    public CustomEntity() {
    }

    public Integer getOwnId() {
        return ownId;
    }

    public void setOwnId(Integer ownId) {
        this.ownId = ownId;
    }

    public CustomEntity(List<Value> values, String id, Integer ownId) {
        this.values = values;
        this.id = id;
        this.ownId = ownId;
    }

    public Document toDbObject() {
        List<Document> convertedValues = new ArrayList();

        for(Value value:values) {
            convertedValues.add(value.toDbObject());
        }

        return new Document("_id", id).append("values", convertedValues).append("ownId", ownId);
    }

    public List<Value> getValues() {
        return values == null ? new ArrayList<Value>() : values;
    }

    public void setValues(List<Value> values) {
        this.values = values;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEntityType() {
        return entityType;
    }

    public void setEntityType(String entityType) {
        this.entityType = entityType;
    }
}
