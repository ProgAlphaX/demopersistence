package pe.edu.uni.demopersistence;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface RepositoryRepuesto extends JpaRepository<Repuesto, Integer> {
    public List<Repuesto> findByNombreIgnoreCase(String nombre);
    public List<Repuesto> findByMarcaContainingIgnoreCase(String marca);
    public List<Repuesto> findByNombreContainingIgnoreCaseOrMarcaContainingIgnoreCase(String nombre, String marca);
}