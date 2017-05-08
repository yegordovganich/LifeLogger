package lifelogger.data;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by y.dovganich on 12.04.2017.
 */

@Entity
@Table(name = "meter_data")
public class MeterData implements Serializable {
	private static final long serialVersionUID = 7454338882150271407L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

	@ManyToOne/*(cascade = CascadeType.ALL)*/
	@JoinColumn(name = "address_id")
	private Address address;
    
	@Enumerated(EnumType.STRING)
	@Column(name = "meter_type")
	private MeterType type;
	
	private int value;

	private LocalDateTime timestamp;

    public MeterData(){}

	public MeterData(Address address, MeterType type, int value, LocalDateTime timestamp) {
		this.address = address;
		this.type = type;
		this.value = value;
		this.timestamp = timestamp;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}

	public MeterType getType() {
    	return type;
    }
	public void setType(MeterType type) {
    	this.type = type;
    }

	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}


	@Override
    public String toString() {
        return address.toString() + " / " + type + " / " + value;
    }
}
