package CustomEntityProject;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Date;
import org.bson.Document;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

@Entity("value")
public class Value implements DBObjectable {

    @Id
    @JsonProperty("id")
    private String id;
    @JsonProperty("availabilityKey")
    private String availabilityKey;
    @JsonProperty("value")
    private String value;
    @JsonProperty("createdDate")
    private Date createdDate;
    @JsonProperty("effectiveDate")
    private Date effectiveDate;

    public Value() {
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(Date effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public Value(String id, String availabilityKey, String value) {
        this.id = id;
        this.availabilityKey = availabilityKey;
        this.value = value;
    }

    public String getAvailabilityKey() {
        return availabilityKey;
    }

    public void setAvailabilityKey(String availabilityKey) {
        this.availabilityKey = availabilityKey;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Document toDbObject() {
        return new Document("_id", id).append("availabilityKey", availabilityKey)
                .append("value", value);
    }
}
