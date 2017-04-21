package lifelogger.server;

import lifelogger.data.Address;
import lifelogger.data.MeterData;
import lifelogger.data.MeterType;
import lifelogger.recorder.Recorder;
import lifelogger.recorder.RecorderClass;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import javax.persistence.EntityManager;

/**
 * Created by y.dovganich on 12.04.2017.
 */
public class LifeLoggerServer {
    public static void main(String[] args) {
        try {
            RecorderClass recorder = new RecorderClass();
            Registry localRegistry = LocateRegistry.createRegistry(Registry.REGISTRY_PORT);
            localRegistry.rebind(Recorder.RECORDER_NAME, recorder);
            System.out.println("LifeLogger lifelogger.server is running.");
        } catch (RemoteException e) {
            System.out.println("Error when creating Recorder.");
            e.printStackTrace();
        }
        
		MeterData data = new MeterData(new Address(), MeterType.HOT_WATER, 6686);
        EntityManager entityManager = JPAFactory.getEntityManagerFactory().createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(data);
		entityManager.getTransaction().commit();
		entityManager.close();

    }
}
