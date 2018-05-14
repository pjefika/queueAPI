/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.net.gvt.efika.queueAPI.controller;

import br.net.gvt.efika.queue.model.enuns.TasksEnum;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import br.net.gvt.efika.queueAPI.model.service.factory.FactoryService;
import br.net.gvt.efika.queueAPI.model.entity.QueueTask;
import br.net.gvt.efika.queueAPI.model.entity.usage.ApiUsage;
import br.net.gvt.efika.queueAPI.model.entity.usage.enums.Usage;
import br.net.gvt.efika.queueAPI.model.entity.usage.factory.FactoryApiUsage;
import br.net.gvt.efika.queueAPI.model.service.ApiUsageService;
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
        ApiUsage use = FactoryApiUsage.create("getter", Usage.RETRIEVE);
        ApiUsageService usageService = FactoryService.createApiUsageService();
        try {
            usageService.startUsing(use);
            try {
                return ok(FactoryService.createQueueTaskService().getById(id));
            } catch (Exception e) {
                return serverError(e);
            }
        } catch (Exception ex) {
            return serverError(ex);
        } finally {
            try {
                usageService.doneUsing(use);
            } catch (Exception ex) {
            }
        }

    }

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response list() {
        try {
            return ok(TasksEnum.values());
        } catch (Exception e) {
            return serverError(e);
        }
    }

//    @POST
//    @Path("/process")
//    @Produces(MediaType.APPLICATION_JSON)
//    @Consumes(MediaType.APPLICATION_JSON)
//    public Response process(QueueTask task) {
//        try {
//            return ok(FactoryService.createQueueTaskService().process(task));
//        } catch (Exception e) {
//            e.printStackTrace();
//            return serverError(e);
//        }
//    }
    @POST
    @Path("/queue")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response queue(QueueTask task) {
        ApiUsage use = FactoryApiUsage.create(task.getExecutor(), Usage.SAVE);
        ApiUsageService usageService = FactoryService.createApiUsageService();
        try {
            usageService.startUsing(use);
            try {
                return ok(FactoryService.createQueueTaskService().queue(task));
            } catch (Exception e) {
                return serverError(e);
            }
        } catch (Exception ex) {
            return serverError(ex);
        } finally {
            try {
                usageService.doneUsing(use);
            } catch (Exception ex) {
            }
        }
    }

}
