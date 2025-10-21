package modelos;

import ayudas.Estados;
import ayudas.Roles;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nombre", length = 20, nullable = false, unique = false)
    private String nombre;
    @Column(name = "correo", length = 50, nullable = false, unique = true)
    private String correo;
    @Column(name = "contrasena", length = 10, nullable = false, unique = false)
    private String contrasena;

    @Column(name = "rol", nullable = false, unique = false)
    @Enumerated(EnumType.STRING)
    private Roles rol;
    @Column(name = "estado", nullable = false, unique = false)
    @Enumerated(EnumType.STRING)
    private Estados estado;

    //RELACIONANDOME CON 1 ESTUDIANTE
    @OneToOne(mappedBy = "usuario")
    @JsonBackReference(value="relacionusuarioestudiante")
    private Estudiante estudiante;

    public Usuario(){

    }
    public Usuario(Integer id, String nombre, String correo, String contrasena) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
        this.contrasena = contrasena;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
}

