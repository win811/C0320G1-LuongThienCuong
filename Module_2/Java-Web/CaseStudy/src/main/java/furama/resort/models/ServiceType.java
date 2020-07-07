package furama.resort.models;



import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "servicetypes")
public class ServiceType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "service_type_id")
    private long id;

    @NotBlank
    @Column(name = "service_type_name", length = 10)
    private String name;

    public ServiceType() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}