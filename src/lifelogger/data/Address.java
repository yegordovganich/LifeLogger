package lifelogger.data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by y.dovganich on 12.04.2017.
 */

@Entity
@Table(name = "address")
public class Address implements Serializable {
    private static final long serialVersionUID = -4038575942328726270L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String address;

    public Address(){}
}
