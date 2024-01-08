
package TDA.MsSecurity.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import TDA.MsSecurity.model.Habitacion;
import TDA.MsSecurity.repository.HabitacionRepository;

@Service
public class HabitacionService {
    @Autowired
    private HabitacionRepository habitacionRepository;

    public List<Habitacion> obtenerTodasHabitaciones() {
        return (List<Habitacion>) habitacionRepository.findAll();
    }

    public Habitacion obtenerHabitacionPorId(Long id) {
        return habitacionRepository.findById(id)
                .orElseThrow();
    }

    public Habitacion crearHabitacion(Habitacion habitacion) {
        return habitacionRepository.save(habitacion);
    }

    public Habitacion actualizarHabitacion(Long id, Habitacion habitacion) {
        Habitacion habitacionExistente = obtenerHabitacionPorId(id);
        // Actualiza los atributos según sea necesario
        habitacionExistente.setNumeroHabitacion(habitacion.getNumeroHabitacion());
        habitacionExistente.setTipoHabitacion(habitacion.getTipoHabitacion());
        habitacionExistente.setPrecio(habitacion.getPrecio());
        habitacionExistente.setEstado(habitacion.getEstado());
        return habitacionRepository.save(habitacionExistente);
    }

    public void eliminarHabitacion(Long id) {
        Habitacion habitacion = obtenerHabitacionPorId(id);
        habitacionRepository.delete(habitacion);
    }
}