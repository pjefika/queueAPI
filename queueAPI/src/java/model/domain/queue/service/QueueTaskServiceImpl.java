/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.domain.queue.service;

import java.util.Date;
import model.domain.queue.enuns.TaskState;
import model.entity.QueueTask;
import org.bson.types.ObjectId;

public class QueueTaskServiceImpl extends AbstractQueueTaskService implements QueueTaskService {

    @Override
    public QueueTask process(QueueTask task) throws Exception {
        getDao().save(this.prepare(task));
        do {
            task = getById(task.getId());
            Thread.sleep(1000);
        } while (task.getState() != TaskState.EXECUTED);

        return task;
    }

    @Override
    public QueueTask getById(ObjectId id) throws Exception {
        QueueTask read = getDao().read(id);
        if (read == null) {
            throw new Exception("Task não encontrada!");
        }
        return read;
    }

    @Override
    public QueueTask queue(QueueTask task) throws Exception {
        getDao().save(this.prepare(task));
        return task;
    }

    protected QueueTask prepare(QueueTask task) {
        task.setDateQueueIn(new Date());
        task.setState(TaskState.PENDING);
        return task;
    }

}
