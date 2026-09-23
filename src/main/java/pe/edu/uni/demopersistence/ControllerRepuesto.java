package pe.edu.uni.demopersistence;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ControllerRepuesto {
    ServiceRepuesto serviceRepuesto;

    public ControllerRepuesto(ServiceRepuesto serviceRepuesto) {
        this.serviceRepuesto = serviceRepuesto;
    }

    @PostMapping("/repuesto/nuevo")
    public Repuesto registrar(@RequestBody RequestRepuesto nuevo) {
        Repuesto r = serviceRepuesto.registrar(nuevo);
        return r;
    }

    @GetMapping("/repuesto/id/{id}")
    public ResponseRepuesto consultarPorId(@PathVariable(name = "id") int id) {
        return serviceRepuesto.consultarPorId(id);
    }

    @GetMapping("/repuesto/nombre/{nombre}")
    public List<ResponseRepuesto> consultarPorNombre(@PathVariable(name = "nombre") String nombre) {
        return serviceRepuesto.consultarPorNombreExacto(nombre);
    }

    @GetMapping("/repuesto/marca/{marca}")
    public List<ResponseRepuestoMarca> consultarPorMarca(@PathVariable(name = "marca") String marca) {
        return serviceRepuesto.consultarPorMarcaSubcadena(marca);
    }

    @GetMapping("/repuesto/nombremarca/{nombremarca}")
    public List<ResponseRepuestoMarca> consultarPorNombreMarca(@PathVariable(name = "nombremarca") String nombremarca) {
        return serviceRepuesto.consultarPorNombreMarcaSubcadena(nombremarca, nombremarca);
    }
}