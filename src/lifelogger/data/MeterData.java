package lifelogger.data;

import java.io.Serializable;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

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

	// @Type(type = "address")
//	private transient Address address;
    
	@Enumerated(EnumType.STRING)
	@Column(name = "meter_type")
	private MeterType type;
	
	private int value;

    public MeterData(){}
    
    public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

//	public Address getAddress() {
//		return address;
//	}
//
//	public void setAddress(Address address) {
//		this.address = address;
//	}

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

	public MeterData(Address address, MeterType type, int value) {
		// this.address = address;
        this.type = type;
        this.value = value;
    }

    @Override
    public String toString() {
        // return address.toString() + " / " + type + " / " + value;
    	return type + " / " + value;
    	// return "";
    }
}
