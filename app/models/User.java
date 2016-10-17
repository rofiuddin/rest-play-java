package models;

import org.hibernate.validator.constraints.Length;
import play.data.validation.Constraints;
import javax.persistence.*;


/**
 * Created by rofi on 8/24/16.
 */
@Entity
@Table(name="users", schema = "kunderaexamples@cassandra_pu")
public class User {
    @Constraints.Required(message = "name is required")
    @Length(min = 3, max = 50)
    @Column(name = "name")
    private String name;

    @Id @GeneratedValue(strategy=GenerationType.TABLE)
    private Integer id;

    /**
     * Set all empty values to null
     */
    public void emptyToNull() {
        if (name != null && name.isEmpty()) name = null;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        } if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        User aux = (User) obj;

        if (id != null && aux.id != null)
            return (id == aux.id);
        else
            return (name.equals(aux.name));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id);
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }
}