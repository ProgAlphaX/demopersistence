package pe.edu.uni.demopersistence;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceRepuesto {
    RepositoryRepuesto repoRepuesto;

    public ServiceRepuesto(RepositoryRepuesto repoRepuesto) {
        this.repoRepuesto = repoRepuesto;
    }

    public Repuesto registrar(RequestRepuesto request) {
        Repuesto r = new Repuesto();
        r.setMarca(request.marca());
        r.setNombre(request.nombre());
        r.setPrecio(request.precio());
        repoRepuesto.save(r);
        return r;
    }

    public ResponseRepuesto consultarPorId(int id) {
        Repuesto repuesto = repoRepuesto.findById(id).get();
        ResponseRepuesto r = new ResponseRepuesto(repuesto.getId(), repuesto.getNombre(), repuesto.getPrecio());
        return r;
    }

    public List<ResponseRepuesto> consultarPorNombreExacto(String nombre) {
        List<Repuesto> lst = repoRepuesto.findByNombreIgnoreCase(nombre);
        List<ResponseRepuesto> lstResponse = lst.stream()
                .map(r -> new ResponseRepuesto(r.getId(), r.getNombre(), r.getPrecio())).toList();
        return lstResponse;
    }

    public List<ResponseRepuestoMarca> consultarPorMarcaSubcadena(String marca) {
        List<Repuesto> lst = repoRepuesto.findByMarcaContainingIgnoreCase(marca);
        List<ResponseRepuestoMarca> lstResponse = lst.stream()
                .map(r->new ResponseRepuestoMarca(r.getId(), r.getNombre(), r.getMarca())).toList();
        return lstResponse;
    }

    public List<ResponseRepuestoMarca> consultarPorNombreMarcaSubcadena(String nombre, String marca) {
        List<Repuesto> lst = repoRepuesto.findByNombreContainingIgnoreCaseOrMarcaContainingIgnoreCase(nombre, marca);
        List<ResponseRepuestoMarca> lstResponse = lst.stream()
                .map(r -> new ResponseRepuestoMarca(r.getId(), r.getNombre(), r.getMarca())).toList();
        return lstResponse;
    }
}