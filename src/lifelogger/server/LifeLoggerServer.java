package lifelogger.server;

import lifelogger.recorder.Recorder;
import lifelogger.recorder.RecorderClass;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

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
    } 
}
