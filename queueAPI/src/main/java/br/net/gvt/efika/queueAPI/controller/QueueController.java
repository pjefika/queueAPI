/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.net.gvt.efika.queueAPI.controller;

import br.net.gvt.efika.queueAPI.controller.request.ConsumerQueueTaskRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import br.net.gvt.efika.queueAPI.model.service.factory.FactoryService;
import br.net.gvt.efika.queueAPI.model.entity.QueueTask;

/**
 *
 * @author G0042204
 */
@Path("/queue")
public class QueueController extends RestJaxAbstract {

    @POST
    @Path("/consumePendingTasks")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response consumePendingTasks(ConsumerQueueTaskRequest request) {
        try {
            return ok(FactoryService.createConsumerQueueTaskService().consumePendingTasks(request.getConsumer()));
        } catch (Exception e) {
            return serverError(e);
        }
    }

    @GET
    @Path("/getPendingTasks")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getPendingTasks() {
        try {
            return ok(FactoryService.createConsumerQueueTaskService().getPendingTasks());
        } catch (Exception e) {
            return serverError(e);
        }
    }

    @POST
    @Path("/completeTask")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)

    public Response completeTask(QueueTask task) {
        try {
            return ok(FactoryService.createConsumerQueueTaskService().completeTask(task));
        } catch (Exception e) {
            e.printStackTrace();
            return serverError(e);
        }
    }

    @POST
    @Path("/completeTask/fulltest")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response completeFulltest(QueueTask task) {
        try {
            return ok(FactoryService.createConsumerQueueTaskService().completeTask(task));
        } catch (Exception e) {
            e.printStackTrace();
            return serverError(e);
        }
    }

}
