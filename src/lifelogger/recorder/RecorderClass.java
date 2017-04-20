package lifelogger.recorder;

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
		entityManager.persist(data);
		entityManager.getTransaction().commit();
		entityManager.close();
	}
	
//	entityManager = entityManagerFactory.createEntityManager();
//	entityManager.getTransaction().begin();
//    List<Event> result = entityManager.createQuery( "from Event", Event.class ).getResultList();
//	for ( Event event : result ) {
//		System.out.println( "Event (" + event.getDate() + ") : " + event.getTitle() );
//	}
//    entityManager.getTransaction().commit();
//    entityManager.close();

    
}
