/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.domain.queue.service;

import model.domain.queue.enuns.TaskState;
import model.entity.QueueTask;

public class QueueTaskServiceImpl extends AbstractQueueTaskService implements QueueTaskService {

    @Override
    public QueueTask process(QueueTask task) throws Exception {
        getDao().save(task);
        do {
            task = getDao().read(task.getId());
            System.out.println("Espera!");
            Thread.sleep(1000);
        } while (task.getState() != TaskState.EXECUTED);

        return task;
    }

}
