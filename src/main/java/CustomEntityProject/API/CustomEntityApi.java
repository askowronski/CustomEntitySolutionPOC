package CustomEntityProject.API;


import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import CustomEntityProject.CustomEntity;
import CustomEntityProject.PersistenceManager.CustomEntityManager;
import CustomEntityProject.PersistenceManager.Restriction;
import CustomEntityProject.Value;
import java.util.ArrayList;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
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
    public ResponseEntity<String> getCustomEntities(@RequestParam(required = false) String restrictionExpression, @RequestParam(required = false) String operatorString,
            @RequestParam(required = false) String value ) {

        try {
            CustomEntityManager manager = new CustomEntityManager();
            Value valueToRestrictOn = new Value();
            valueToRestrictOn.setAvailabilityKey(restrictionExpression);
            valueToRestrictOn.setValue(value);
            return ResponseEntity.ok(CustomEntityManager.writeCustomEntitiesToJson(
                    StringUtils.isEmpty(restrictionExpression) ? manager.getAllCustomEntities() : manager.getCustomEntitiesWithValue(valueToRestrictOn)));
        } catch (Exception e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @CrossOrigin
    @RequestMapping(method = POST, path = "/Create1000Entities")
    public ResponseEntity<String> create1000entities() {

        try {
            CustomEntityManager manager = new CustomEntityManager();
            List<String> availabilityKeys = new ArrayList<>();
            String shf = "show_cfield";
            availabilityKeys.add(shf+22043);
            availabilityKeys.add(shf+22045);
            availabilityKeys.add(shf+22047);
            availabilityKeys.add(shf+22049);
            availabilityKeys.add(shf+22051);
            availabilityKeys.add(shf+22053);
            availabilityKeys.add(shf+22055);
            availabilityKeys.add(shf+22057);
            availabilityKeys.add(shf+22059);
            availabilityKeys.add(shf+22061);
            availabilityKeys.add(shf+22063);
            availabilityKeys.add(shf+22065);
            availabilityKeys.add(shf+22067);
            availabilityKeys.add(shf+22069);
            availabilityKeys.add(shf+"PartyBean.name");
            manager.create1000Entities(availabilityKeys);

            return ResponseEntity.ok("noice");
        } catch (Exception e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
