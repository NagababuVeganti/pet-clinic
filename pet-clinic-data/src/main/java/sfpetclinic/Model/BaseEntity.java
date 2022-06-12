package sfpetclinic.Model;

import javax.persistence.Id;
import java.io.Serializable;

public class BaseEntity implements Serializable {
    @Id
    private Long Id;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }
}
