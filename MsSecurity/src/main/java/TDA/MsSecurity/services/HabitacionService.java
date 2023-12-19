package TDA.MsSecurity.services;

@Service
public class HabitacionService {
    @Autowired
    private HabitacionRepository habitacionRepository;

    public List<Habitacion> obtenerTodasHabitaciones() {
        return habitacionRepository.findAll();
    }

    public Habitacion obtenerHabitacionPorId(Long id) {
        return habitacionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Habitación no encontrada con id: " + id));
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