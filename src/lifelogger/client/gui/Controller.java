package lifelogger.client.gui;

import lifelogger.data.Address;
import lifelogger.data.MeterData;
import lifelogger.data.MeterType;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextInputControl;
import lifelogger.recorder.Recorder;

import java.awt.*;
import java.net.URL;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML private TextInputControl counterValue;
    @FXML private Button sendButton;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        bindSendButtonAction();
    }

    private void bindSendButtonAction() {
        try {
            Registry localRegistry = LocateRegistry.getRegistry("localhost");
            Recorder recorder = (Recorder) localRegistry.lookup(Recorder.RECORDER_NAME);
            sendButton.setOnAction(__ -> sendMeterData(recorder, counterValue.getText()));
        } catch (RemoteException e) {
            System.out.println("Error when getting local registry.");
            e.printStackTrace();
        } catch (NotBoundException e) {
            System.out.println("Error when getting remote Recorder.");
            e.printStackTrace();
        }
    }

    private void sendMeterData(Recorder recorder, String value) {
        new Thread(() -> {
            // TODO: check input lifelogger.data
            EventQueue.invokeLater(() -> {
                try {
                    MeterData data = new MeterData(new Address(), MeterType.HOT_WATER, Integer.valueOf(value));
                    recorder.addData(data);
                } catch (RemoteException e) {
                    System.out.println("Error when sending MeterData.");
                    e.printStackTrace();
                }
            });
        }).start();
    }
}
