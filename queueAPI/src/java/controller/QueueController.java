/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import model.domain.queue.service.factory.FactoryService;
import model.entity.QueueTask;

/**
 *
 * @author G0042204
 */
@Path("/fulltest")
public class QueueController extends RestJaxAbstract {

    @POST
    @Path("/queue")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response queue(QueueTask task) throws Exception {
        try {
            FactoryService.createQueueTaskService().process(task);
            return ok(task);
        } catch (Exception e) {
            return serverError(null);
        } finally {
        }
    }

}
