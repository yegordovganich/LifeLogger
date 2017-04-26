package lifelogger.recorder;

import lifelogger.data.Address;
import lifelogger.data.MeterData;
import lifelogger.server.JPAFactory;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import javax.persistence.EntityManager;

/**
 * Created by y.dovganich on 12.04.2017.
 */
public class RecorderClass extends UnicastRemoteObject implements Recorder {
	private static final long serialVersionUID = -5771020516807946216L;

	public RecorderClass() throws RemoteException {
        super();
    }

    @Override
    public synchronized void addData(MeterData data) throws RemoteException {
        saveMeterData(data);
    	
    	System.out.println("MeterData is added successfully.");
        System.out.println(data.toString());
    }
    
	public static void saveMeterData(MeterData data) {
		EntityManager entityManager = JPAFactory.getEntityManagerFactory().createEntityManager();
		entityManager.getTransaction().begin();

		// stub for address
		Address address = entityManager.find(Address.class, 1);
		data.setAddress(address);

		entityManager.persist(data);

		entityManager.getTransaction().commit();
		entityManager.close();
	}
    
}
