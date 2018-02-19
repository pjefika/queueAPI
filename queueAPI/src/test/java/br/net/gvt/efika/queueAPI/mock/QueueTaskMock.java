/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.net.gvt.efika.queueAPI.mock;

import br.net.gvt.efika.queue.model.enuns.TasksEnum;
import br.net.gvt.efika.queueAPI.model.entity.QueueTask;
import java.util.Date;

/**
 *
 * @author G0042204
 */
public class QueueTaskMock {
    
    public static QueueTask createDefaultQueueTask() {
        QueueTask task = new QueueTask();
        
        task.setDateQueueIn(new Date());
        task.setExecutor("G0042204");
        task.setTask(TasksEnum.CERTIFICATION);
        
        return task;
    }
    
}
