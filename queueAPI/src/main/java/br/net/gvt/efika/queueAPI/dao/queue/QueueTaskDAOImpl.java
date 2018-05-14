/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.net.gvt.efika.queueAPI.dao.queue;

import br.net.gvt.efika.mongo.dao.AbstractMongoDAO;
import br.net.gvt.efika.queue.model.enuns.TaskState;
import java.util.List;
import br.net.gvt.efika.queueAPI.model.entity.QueueTask;
import org.mongodb.morphia.query.UpdateOperations;

/**
 *
 * @author G0042204
 */
public class QueueTaskDAOImpl extends AbstractMongoDAO<QueueTask> implements QueueTaskDAO {

    public QueueTaskDAOImpl() {
        //10.40.197.137
        //10.200.35.67
        super("10.200.35.67", "queueAPI", QueueTask.class);
    }

    @Override
    public List<QueueTask> listByState(TaskState state, Integer limit) throws Exception {
        return getDatastore().createQuery(QueueTask.class).field("state").equal(state).limit(limit).asList();
    }

    @Override
    public QueueTask update(QueueTask t, UpdateOperations<QueueTask> opers) throws Exception {
        getDatastore().update(t, opers);
        return t;
    }

}
