package TDA.MsSecurity.model;

@Entity
@Table(name = "cliente")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String apellido;
    private String direccion;
    private String telefono;
    private String correoElectronico;

    // Constructores, getters y setters

    
}