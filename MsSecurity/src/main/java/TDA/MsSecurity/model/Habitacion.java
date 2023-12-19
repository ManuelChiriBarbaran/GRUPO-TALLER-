package TDA.MsSecurity.model;

@Entity
@Table(name = "habitacion")
public class Habitacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer numeroHabitacion;
    private String tipoHabitacion;
    private Double precio;
    private String estado;

    // Constructores, getters y setters
}