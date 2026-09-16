package pe.edu.uni.demopersistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ControllerRepuesto {
    @Autowired
    RepositoryRepuesto repoRepuesto;

    @PostMapping("/repuesto/nuevo")
    public Repuesto registrar(@RequestBody Repuesto nuevo) {
        Repuesto r = repoRepuesto.save(nuevo);
        return r;
    }

    @GetMapping("/repuesto/id/{id}")
    public Repuesto consultarPorId(@PathVariable(name = "id") int id) {
        return repoRepuesto.findById(id).get();
    }
}