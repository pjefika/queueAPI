/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.queue;

import dao.AbstractMongoDAO;
import java.util.List;
import model.entity.QueueTask;
import model.enuns.TaskState;
import org.mongodb.morphia.query.UpdateOperations;

/**
 *
 * @author G0042204
 */
public class QueueTaskDAOImpl extends AbstractMongoDAO<QueueTask> implements QueueTaskDAO {

    public QueueTaskDAOImpl() {
        //10.40.197.137
        //10.200.35.67
        super("127.0.0.1", "queueAPI", QueueTask.class);
    }
    

    @Override
    public List<QueueTask> listByState(TaskState state) throws Exception {
        return getDatastore().createQuery(QueueTask.class).field("state").equal(state).asList();
    }

    @Override
    public QueueTask update(QueueTask t, UpdateOperations<QueueTask> opers) throws Exception {
        getDatastore().update(t, opers);
        return t;
    }

}
