/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.domain.queue.service;

import java.util.Calendar;
import java.util.List;
import model.domain.queue.enuns.TaskState;
import model.entity.QueueTask;

public class ConsumerQueueTaskServiceImpl extends AbstractQueueTaskService implements ConsumerQueueTaskService {

    @Override
    public List<QueueTask> getPendingTasks() throws Exception {
        return getDao().listByState(TaskState.PENDING);
    }

    @Override
    public void completeTask(QueueTask queueTask) throws Exception {
        queueTask.setDateQueueOut(Calendar.getInstance().getTime());
        getDao().update(queueTask);
    }

}
