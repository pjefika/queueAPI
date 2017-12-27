/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import controller.request.ConsumerQuestTaskRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import model.domain.queue.service.factory.FactoryService;

/**
 *
 * @author G0042204
 */
@Path("/queue")
public class QueueController extends RestJaxAbstract {

    @POST
    @Path("/process")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response process(ConsumerQuestTaskRequest request) {
        try {
            return ok(FactoryService.createConsumerQueueTaskService().getPendingTasks(request.getConsumer()));
        } catch (Exception e) {
            return serverError(e);
        }
    }

}
