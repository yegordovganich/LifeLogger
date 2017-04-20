package lifelogger.data;

import java.io.Serializable;

/**
 * Created by y.dovganich on 12.04.2017.
 */
public class Address implements Serializable {
	private static final long serialVersionUID = -4038575942328726270L;

	private String city = "Kiev";
    private String street = "Khreschatik";

    @Override
    public String toString() {
        return "Address: " + city + ", " + street;
    }
}
