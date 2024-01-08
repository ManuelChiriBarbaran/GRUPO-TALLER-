package TDA.MsSecurity.repository;

import org.springframework.data.repository.CrudRepository;

import TDA.MsSecurity.model.Cliente;
public interface ClienteRepository extends CrudRepository<Cliente, Long> {
    // Puedes agregar métodos personalizados según tus necesidades
}