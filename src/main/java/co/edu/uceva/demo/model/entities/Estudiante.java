package co.edu.uceva.demo.model.entities;

import com.sun.istack.NotNull;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="estudiante")
public class Estudiante implements Serializable {
    private static final long serialVersionUID = 1;
    @Id
    @GenericGenerator(
            name="estudianteSequenceGenerator",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @Parameter(name = "sequence_name" , value = "ESTUDIANTE_SEQ"),
                    @Parameter(name = "initial_value" , value = "10"),
                    @Parameter(name = "increment_size" , value = "1")
            }
    )
    @GeneratedValue(generator = "estudianteSequenceGenerator")
    private Long id;

    public Date getCreadoEn() {
        return creadoEn;
    }

    public void setCreadoEn(Date creadoEn) {
        this.creadoEn = creadoEn;
    }

    @Temporal(TemporalType.DATE)
    private Date creadoEn;
    private String nombre;

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public long getCedula() {
        return cedula;
    }

    public void setCedula(long cedula) {
        this.cedula = cedula;
    }

    private String apellido;
    @NotNull
    private long cedula;

    public long getId() {return id;}

    public void setId(long id) {this.id = id;}


}
