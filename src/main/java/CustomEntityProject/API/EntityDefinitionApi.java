package CustomEntityProject.API;

import CustomEntityProject.EntityDefinition;
import CustomEntityProject.PersistenceManager.EntityDefinitionManager;
import java.util.List;
import org.bson.types.ObjectId;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import static org.springframework.web.bind.annotation.RequestMethod.DELETE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;


@CrossOrigin()
@RestController
public class EntityDefinitionApi {


    @CrossOrigin
    @RequestMapping(method = POST, path = "/CreateEntityDefinition")
    public ResponseEntity<String> createEntityDefinition(
            @RequestParam(value = "ownId", required = false) Integer ownId,
            @RequestParam(value = "availabilityKeys", required = false) List<String> fieldAvailabilityKeys,
            @RequestParam(value = "entityType", required = true) String entityType,
            @RequestParam(value = "parentEntityType", required = false) String parentEntityType,
            @RequestParam(value = "isSystem", required = true) Boolean isSystem,
            @RequestParam(value = "id", required = false) String id) {

        try {
            EntityDefinitionManager manager = new EntityDefinitionManager();
            EntityDefinition def = manager.createEntityDefinition(ownId, fieldAvailabilityKeys, entityType, parentEntityType, isSystem);
            return ResponseEntity.ok(def.toJson());
        } catch (Exception e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @CrossOrigin
    @RequestMapping(method = POST, path = "/CreateEntityDefinitionBody")
    public ResponseEntity<String> createEntityDefinition(@RequestBody EntityDefinition def) {
        try {
            EntityDefinitionManager manager = new EntityDefinitionManager();
            if (def == null) {
                throw new Exception("Not able to create entity definition.");
            }
            manager.createEntityDefinition(def);
            return ResponseEntity.ok(def.toJson());
        } catch (Exception e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @CrossOrigin
    @RequestMapping(method = GET, path = "/GetEntityDefinition")
    public ResponseEntity<String> getEntityDefinitionById(
            @RequestParam(value = "id", required = true) String id) {

        try {
            EntityDefinitionManager manager = new EntityDefinitionManager();
            EntityDefinition def = manager.getEntityDefinition(id);
            if (def == null) {
                throw new Exception("No Entity Definition found with id "+ id);
            }
            return ResponseEntity.ok(def.toJson());
        } catch (Exception e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @CrossOrigin
    @RequestMapping(method = GET, path = "/GetEntityDefinitionByType")
    public ResponseEntity<String> getEntityDefinitionByType(
            @RequestParam(value = "entityType", required = true) String entityType) {

        try {
            EntityDefinitionManager manager = new EntityDefinitionManager();
            EntityDefinition def = manager.getEntityDefinitionByType(entityType);
            if (def == null) {
                throw new Exception("No Entity Definition found with type "+ entityType);
            }
            return ResponseEntity.ok(def.toJson());
        } catch (Exception e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @CrossOrigin
    @RequestMapping(method = GET, path = "/GetEntityDefinitions")
    public ResponseEntity<String> getAllEntityDefinitions() {

        try {
            EntityDefinitionManager manager = new EntityDefinitionManager();
            List<EntityDefinition> defs = manager.getAllEntityDefinitions();
            return ResponseEntity.ok(EntityDefinitionManager.writeEntityDefinitionsToJson(defs));
        } catch (Exception e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

}
