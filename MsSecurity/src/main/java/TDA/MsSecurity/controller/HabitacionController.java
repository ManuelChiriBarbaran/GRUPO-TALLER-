package TDA.MsSecurity.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import TDA.MsSecurity.model.Habitacion;
import TDA.MsSecurity.services.HabitacionService;
@RestController
@RequestMapping("/habitaciones")

public class HabitacionController {

    @Autowired
    HabitacionService habitacionService;
    
    /**
     * @return
     */
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