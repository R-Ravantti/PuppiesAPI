import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/puppies")
public class ControllerAPI {

    private final ServiceAPI service;
    public ControllerAPI(ServiceAPI service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<DogDTO>> getAllPuppies() {
        return ResponseEntity.ok(service.getPuppies());
    }

    @GetMapping(path = "{id}")
    public ResponseEntity<DogDTO> getPuppy(@PathVariable String id) {
        return ResponseEntity.ok(service.getPuppy(id));
    }

    @PostMapping
    public ResponseEntity<DogDTO> addPuppy(@RequestBody DogDTO dto, HttpServletRequest req) {
        URI location = URI.create((req.getRequestURL() + "/" + dto.id())
                .replace("puppies//", "puppies/"));
        return ResponseEntity.created(location).body(service.addPuppy(dto));
    }

    @PutMapping(path = "{id}")
    public ResponseEntity<DogDTO> updatePuppy(@PathVariable String id, @RequestBody DogDTO dto) {
        return ResponseEntity.accepted().body(service.updatePuppy(dto));
    }

    @DeleteMapping(path = "{id}")
    public ResponseEntity<DogDTO> deletePuppy(@PathVariable String id) {
        service.deletePuppy(id);
        return ResponseEntity.noContent().build();
    }
}
