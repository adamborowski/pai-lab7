/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.adamborowski.pai.lab7.rs;

import javax.ejb.EJB;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import pl.adamborowski.pai.lab7.FixturesBean;

/**
 * REST Web Service
 *
 * @author adam
 */
@Path("fixtures")
public class FixturesService {

    @Context
    private UriInfo context;

    @EJB
    private FixturesBean fixturesService;

    /**
     * Retrieves representation of an instance of
     * pl.adamborowski.pai.lab7.rs.FixturesService
     *
     * @return an instance of java.lang.String
     */
    @GET
    @Produces("text/html")
    public String getHtml() {
        //TODO return proper representation object

        fixturesService.fill();
        return "Udało się załadować dane.";
    }
}
