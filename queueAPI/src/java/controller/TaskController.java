/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import model.domain.queue.service.factory.FactoryService;
import model.entity.QueueTask;
import org.bson.types.ObjectId;

/**
 *
 * @author G0042204
 */
@Path("/task")
public class TaskController extends RestJaxAbstract {

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getTask(@PathParam("id") ObjectId id) {
        try {
            return ok(FactoryService.createQueueTaskService().getById(id));
        } catch (Exception e) {
            return serverError(e);
        }
    }

    @POST
    @Path("/process")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response process(QueueTask task) {
        try {
            return ok(FactoryService.createQueueTaskService().process(task));
        } catch (Exception e) {
            e.printStackTrace();
            return serverError(e);
        }
    }

    @POST
    @Path("/queue")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response queue(QueueTask task) {
        try {
            return ok(FactoryService.createQueueTaskService().queue(task));
        } catch (Exception e) {
            return serverError(e);
        }
    }

}
