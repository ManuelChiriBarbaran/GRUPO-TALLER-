package TDA.MsSecurity.services;

import org.springframework.beans.factory.annotation.Autowired;

import TDA.MsSecurity.model.Cliente;
import TDA.MsSecurity.repository.ClienteRepository;
@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    public List<Cliente> obtenerTodosClientes() {
        return clienteRepository.findAll();
    }

    public Cliente obtenerClientePorId(Long id) {
        return clienteRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Cliente no encontrado con id: " + id));
    }

    public Cliente crearCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public Cliente actualizarCliente(Long id, Cliente cliente) {
        Cliente clienteExistente = obtenerClientePorId(id);
        // Actualiza los atributos según sea necesario
        clienteExistente.setNombre(cliente.getNombre());
        clienteExistente.setApellido(cliente.getApellido());
        clienteExistente.setDireccion(cliente.getDireccion());
        clienteExistente.setTelefono(cliente.getTelefono());
        clienteExistente.setCorreoElectronico(cliente.getCorreoElectronico());
        return clienteRepository.save(clienteExistente);
    }

    public void eliminarCliente(Long id) {
        Cliente cliente = obtenerClientePorId(id);
        clienteRepository.delete(cliente);
    }
}
