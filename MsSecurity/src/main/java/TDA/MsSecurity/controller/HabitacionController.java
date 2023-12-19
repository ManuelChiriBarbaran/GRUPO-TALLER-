package TDA.MsSecurity.controller;
@RestController
@RequestMapping("/habitaciones")
public class HabitacionController {
    @Autowired
    private HabitacionService habitacionService;

    @GetMapping
    public List<Habitacion> obtenerHabitaciones() {
        return habitacionService.obtenerTodasHabitaciones();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Habitacion> obtenerHabitacionPorId(@PathVariable Long id) {
        Habitacion habitacion = habitacionService.obtenerHabitacionPorId(id);
        return ResponseEntity.ok(habitacion);
    }

    @PostMapping
    public ResponseEntity<Habitacion> crearHabitacion(@RequestBody Habitacion habitacion) {
        Habitacion nuevaHabitacion = habitacionService.crearHabitacion(habitacion);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevaHabitacion);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Habitacion> actualizarHabitacion(@PathVariable Long id, @RequestBody Habitacion habitacion) {
        Habitacion habitacionActualizada = habitacionService.actualizarHabitacion(id, habitacion);
        return ResponseEntity.ok(habitacionActualizada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarHabitacion(@PathVariable Long id) {
        habitacionService.eliminarHabitacion(id);
        return ResponseEntity.noContent().build();
    }
}