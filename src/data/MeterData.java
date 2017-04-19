package data;

import java.io.Serializable;

/**
 * Created by y.dovganich on 12.04.2017.
 */

public class MeterData implements Serializable {
    private static final long serialVersionUID = 1L;

    private Address address;
    private MeterTypes type;
    private int value;

    public MeterData(Address address, MeterTypes type, int value) {
        this.address = address;
        this.type = type;
        this.value = value;
    }

    @Override
    public String toString() {
        return address.toString() + " / " + type + " / " + value;
    }
}
