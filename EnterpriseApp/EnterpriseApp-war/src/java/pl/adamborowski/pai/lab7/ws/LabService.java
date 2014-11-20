/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.adamborowski.pai.lab7.ws;

import javax.ejb.EJB;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.ejb.Stateless;
import pl.adamborowski.pai.lab7.toa.ProjectDetailsAssembler;
import pl.adamborowski.pai.lab7.toa.ProjectDetailsAssembly;

/**
 *
 * @author adam
 */
@WebService
@Stateless
public class LabService {

    @EJB
    private ProjectDetailsAssembler assembler;

    @WebMethod
    public ProjectDetailsAssembly getProjectAssembly(Long id) {
        return assembler.getData(id);
    }
}
