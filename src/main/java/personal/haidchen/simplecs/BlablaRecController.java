package personal.haidchen.simplecs;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class BlablaRecController {

    private final BlablaRecRepository blablaRepo;

    public BlablaRecController(BlablaRecRepository blablaRepo) {
        this.blablaRepo = blablaRepo;
    }

    @PostMapping("/blablas")
    public void saveBlablas(@RequestBody BlablaRec blablas) {
        System.out.println("Blabla Id : " + blablas.id());
        blablaRepo.save(blablas);
    }

    @GetMapping("/blablas/{id}")
    public BlablaRec getBlablas(@PathVariable String id) {
        return blablaRepo.findById(id).orElse(new BlablaRec("defaultId", List.of()));
    }
}
