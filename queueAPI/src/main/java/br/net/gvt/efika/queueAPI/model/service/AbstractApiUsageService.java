/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.net.gvt.efika.queueAPI.model.service;

import br.net.gvt.efika.queueAPI.dao.factory.FactoryDAO;
import br.net.gvt.efika.queueAPI.dao.queue.ApiUsageDAO;
import br.net.gvt.efika.queueAPI.dao.queue.QueueTaskDAO;
import br.net.gvt.efika.queueAPI.model.entity.usage.ApiUsage;
import org.mongodb.morphia.query.UpdateOperations;

/**
 *
 * @author G0042204
 */
public abstract class AbstractApiUsageService {

    private ApiUsageDAO dao;

    public ApiUsageDAO getDao() {
        if (dao == null) {
            dao = FactoryDAO.createApiUsageDAO();
        }
        return dao;
    }

    protected UpdateOperations<ApiUsage> oper() {
        return getDao().createUpdateOperations();
    }

}
