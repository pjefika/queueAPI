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
@Path("/apiUsage")
public class ApiUsageController extends RestJaxAbstract {

    @GET
    @Path("/usingNow")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response usingNow() {
        try {
            return ok(FactoryService.createApiUsageService().usingNow());
        } catch (Exception e) {
            return serverError(e);
        }

    }

}
