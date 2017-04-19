package recorder;

import data.MeterData;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Created by y.dovganich on 12.04.2017.
 */
public interface Recorder extends Remote {
    String RECORDER_NAME = "Recorder";

    void addData(MeterData data) throws RemoteException;
}
