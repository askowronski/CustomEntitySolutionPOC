package CustomEntityProject;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

@Entity("entity_definition")
public class EntityDefinition {

    @Id
    @JsonProperty("id")
    private String id;
    @JsonProperty("ownId")
    private Integer ownId;
    @JsonProperty("fieldAvailabilityKeys")
    private List<String> fieldAvailabilityKeys;
    @JsonProperty("entityType")
    private String entityType;
    @JsonProperty("parentEntityType")
    private String parentEntityType;
    @JsonProperty("isSystem")
    private Boolean isSystem;

    public EntityDefinition() {
    }

    public EntityDefinition(Integer ownId, List<String> fieldAvailabilityKeys,
            String entityType, String parentEntityType, Boolean isSystem) {
        this.ownId = ownId;
        this.fieldAvailabilityKeys = fieldAvailabilityKeys;
        this.entityType = entityType;
        this.parentEntityType = parentEntityType;
        this.isSystem = isSystem;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getOwnId() {
        return ownId;
    }

    public void setOwnId(Integer ownId) {
        this.ownId = ownId;
    }

    public List<String> getFieldAvailabilityKeys() {
        return fieldAvailabilityKeys;
    }

    public void setFieldAvailabilityKeys(List<String> fieldAvailabilityKeys) {
        this.fieldAvailabilityKeys = fieldAvailabilityKeys;
    }

    public String getEntityType() {
        return entityType;
    }

    public void setEntityType(String entityType) {
        this.entityType = entityType;
    }

    public String getParentEntityType() {
        return parentEntityType;
    }

    public void setParentEntityType(String parentEntityType) {
        this.parentEntityType = parentEntityType;
    }

    public Boolean getSystem() {
        return isSystem;
    }

    public void setSystem(Boolean system) {
        isSystem = system;
    }

    public String toJson() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            return mapper.writeValueAsString(this);
        } catch (JsonProcessingException e) {
            return e.getMessage();
        }
    }
}
