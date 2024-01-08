package TDA.MsSecurity.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import TDA.MsSecurity.model.Habitacion;
@Repository

public interface HabitacionRepository extends CrudRepository<Habitacion, Long> {
    // No se requiere código adicional, ya que CrudRepository proporciona métodos CRUD básicos
}