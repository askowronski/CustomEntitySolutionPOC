package CustomEntityProject.API;


import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import CustomEntityProject.CustomEntity;
import CustomEntityProject.EntityDefinition;
import CustomEntityProject.PersistenceManager.CustomEntityManager;
import CustomEntityProject.PersistenceManager.EntityDefinitionManager;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin()
@RestController
public class CustomEntityApi {

    @CrossOrigin
    @RequestMapping(method = POST, path = "/CreateCustomEntity")
    public ResponseEntity<String> createCustomEntity(
            @RequestBody CustomEntity entity) {

        try {
            CustomEntityManager manager = new CustomEntityManager();
            if (entity == null) {
                throw new Exception("Not able to create entity definition.");
            }
            manager.createCustomEntity(entity);
            return ResponseEntity.ok(CustomEntityManager.writeCustomEntityToJson(entity));
        } catch (Exception e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @CrossOrigin
    @RequestMapping(method = GET, path = "/GetCustomEntity")
    public ResponseEntity<String> getCustomEntityById(
            @RequestParam(value = "id") String id) {

        try {
            CustomEntityManager manager = new CustomEntityManager();
            CustomEntity entity = manager.getCustomEntityById(id);
            if (entity == null) {
                throw new Exception("Not able to create entity definition.");
            }
            return ResponseEntity.ok(CustomEntityManager.writeCustomEntityToJson(entity));
        } catch (Exception e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @CrossOrigin
    @RequestMapping(method = GET, path = "/GetCustomEntities")
    public ResponseEntity<String> getCustomEntities() {

        try {
            CustomEntityManager manager = new CustomEntityManager();
            List<CustomEntity> entities = manager.getAllCustomEntities();
            return ResponseEntity.ok(CustomEntityManager.writeCustomEntitiesToJson(entities));
        } catch (Exception e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
