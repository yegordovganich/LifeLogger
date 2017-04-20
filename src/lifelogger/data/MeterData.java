package lifelogger.data;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * Created by y.dovganich on 12.04.2017.
 */

@Entity
@Table(name = "METER_DATA")
public class MeterData implements Serializable {
	private static final long serialVersionUID = 7454338882150271407L;
	
	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "uncrement")
    private int id;
//    private Address address;
//    private MeterTypes type;
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
//
//	public MeterTypes getType() {
//		return type;
//	}
//
//	public void setType(MeterTypes type) {
//		this.type = type;
//	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public MeterData(Address address, MeterTypes type, int value) {
//        this.address = address;
//        this.type = type;
        this.value = value;
    }

    @Override
    public String toString() {
        // return address.toString() + " / " + type + " / " + value;
    	return "" + value;
    }
}
