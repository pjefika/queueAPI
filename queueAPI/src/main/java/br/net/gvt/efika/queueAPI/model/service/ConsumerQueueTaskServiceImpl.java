/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.net.gvt.efika.queueAPI.model.service;

import br.net.gvt.efika.queue.model.enuns.TaskState;
import br.net.gvt.efika.queueAPI.controller.request.PendingTasksResponse;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import br.net.gvt.efika.queueAPI.model.entity.QueueTask;



public class ConsumerQueueTaskServiceImpl extends AbstractQueueTaskService implements ConsumerQueueTaskService {

    private static final Logger LOG = Logger.getLogger(ConsumerQueueTaskServiceImpl.class.getName());

    @Override
    public PendingTasksResponse consumePendingTasks(String consumer) throws Exception {
        PendingTasksResponse ret = new PendingTasksResponse();
        List<QueueTask> pending = this.getPendingTasks();
        pending.forEach((t) -> {
            t.setState(TaskState.RUNNING);
            t.setDateConsumed(new Date());
            t.setConsumer(consumer);
            try {
                getDao().update(t, oper()
                        .set("state", t.getState())
                        .set("consumer", t.getConsumer())
                        .set("dateConsumed", t.getDateConsumed()));
            } catch (Exception e) {
                LOG.log(Level.WARNING, "Falha ao alterar: {0}", t.getId());
            }
            ret.getTasks().add(t);
        });
        return ret;
    }

    @Override
    public QueueTask completeTask(QueueTask t) throws Exception {
        t.setDateQueueOut(new Date());
        t.setState(TaskState.EXECUTED);
        getDao().update(t, oper()
                .set("state", t.getState())
                .set("input", t.getInput())
                .set("output", t.getOutput())
                .set("dateQueueOut", t.getDateQueueOut())
        );
        return t;
    }

    @Override
    public List<QueueTask> getPendingTasks() throws Exception {
        return getDao().listByState(TaskState.PENDING);
    }

    @Override
    public QueueTask completeFulltest(QueueTask queueTask) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
