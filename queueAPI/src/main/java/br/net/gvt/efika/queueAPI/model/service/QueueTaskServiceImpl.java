/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.net.gvt.efika.queueAPI.model.service;

import br.net.gvt.efika.queue.model.dto.output.CadastroResponse;
import br.net.gvt.efika.queue.model.enuns.TaskResultState;
import br.net.gvt.efika.queue.model.enuns.TaskState;
import java.util.Date;
import br.net.gvt.efika.queueAPI.model.entity.QueueTask;
import br.net.gvt.efika.queueAPI.model.service.exception.TaskTimeoutException;
import org.bson.types.ObjectId;

public class QueueTaskServiceImpl extends AbstractQueueTaskService implements QueueTaskService {

    @Override
    public QueueTask process(QueueTask task) throws Exception {
        getDao().save(this.prepare(task));
        try {
            int sleeps = 0;
            do {
                sleeps++;
                task = getById(task.getId());
                Thread.sleep(5000);
                if (sleeps > 50) {
                    throw new TaskTimeoutException();
                }
            } while (task.getState() != TaskState.EXECUTED);
            
        } catch (TaskTimeoutException e) {

            CadastroResponse resp = new CadastroResponse();
            resp.setState(TaskResultState.EXCEPTION);
            resp.setExceptionMessage(e.getMessage());
            
            
            task.setOutput(resp);
            task.setConsumer("queueAPI");
                    
            getDao().update(task, oper()
                    .set("state", TaskState.EXECUTED)
                    .set("consumer", task.getConsumer())
                    .set("output", task.getOutput())
                    .set("dateConsumed", new Date()));

        }

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
