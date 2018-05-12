/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.net.gvt.efika.queueAPI.dao.queue;

import br.net.gvt.efika.mongo.dao.AbstractMongoDAO;
import br.net.gvt.efika.queueAPI.model.entity.ApiUsage;
import br.net.gvt.efika.queueAPI.model.enums.UsageStatus;
import br.net.gvt.efika.queueAPI.model.factory.FactoryApiUsage;
import java.util.Date;
import org.mongodb.morphia.query.UpdateOperations;

public class ApiUsageDAOImpl extends AbstractMongoDAO<ApiUsage> implements ApiUsageDAO {

    public ApiUsageDAOImpl() {
        super("10.200.35.67", "queueAPI", ApiUsage.class);
    }

    @Override
    public Long ammountByStatus(UsageStatus status) throws Exception {
        return getDatastore().createQuery(ApiUsage.class)
                .field("status").equal(status)
                .field("port").equal(FactoryApiUsage.create().getPort())
                .count();
    }

    @Override
    public ApiUsage update(ApiUsage t, UpdateOperations<ApiUsage> opers) throws Exception {
        getDatastore().update(t, opers);
        return t;
    }

    @Override
    public Long ammountByStatusFromDate(UsageStatus status, Date date) throws Exception {
        return getDatastore().createQuery(ApiUsage.class)
                .field("status").equal(status)
                .field("dateIn").greaterThan(date)
                .field("port").equal(FactoryApiUsage.create().getPort())
                .count();
    }

}
