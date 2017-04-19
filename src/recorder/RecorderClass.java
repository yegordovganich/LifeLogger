package recorder;

import data.MeterData;
import recorder.Recorder;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

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
        System.out.println("MeterData is added successfully.");
        System.out.println(data.toString());
    }
}
