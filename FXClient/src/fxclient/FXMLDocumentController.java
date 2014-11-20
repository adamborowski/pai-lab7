/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxclient;

import fxclient.wsclient.LabService;
import fxclient.wsclient.LabServiceService;
import fxclient.wsclient.ProjectDetailsAssembly;
import fxclient.wsclient.Task;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javax.xml.ws.WebServiceRef;

/**
 *
 * @author adam
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private Label label;

    @FXML
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");

        label.setText("Hello World!");
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            // TODO
            
            final LabService labServicePort = new LabServiceService(new URL("http://localhost:8080/LabServiceService/LabService?wsdl")).getLabServicePort();
            final ProjectDetailsAssembly projectAssembly = labServicePort.getProjectAssembly((long) 151);
            StringBuilder sb = new StringBuilder();
            sb.append(projectAssembly.getProjectData().getName());
            sb.append("\nprowadzi: ");
            sb.append(projectAssembly.getProjectManagerData().getName());
            sb.append("\nczynności: \n\t");
            for (Iterator<Object> it = projectAssembly.getListOfTasks().iterator(); it.hasNext();) {
                Task task = (Task) it.next();
                sb.append(task.getDescription());
                sb.append("\n\t");
            }
            label.setText(sb.toString());
        } catch (MalformedURLException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
