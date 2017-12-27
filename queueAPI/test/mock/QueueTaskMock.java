/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mock;

import java.util.Date;
import model.domain.queue.enuns.TasksEnum;
import model.entity.QueueTask;

/**
 *
 * @author G0042204
 */
public class QueueTaskMock {
    
    public static QueueTask createDefaultQueueTask() {
        QueueTask task = new QueueTask();
        
        task.setDateQueueIn(new Date());
        task.setExecutor("G0042204");
        task.setTask(TasksEnum.FULLTEST);
        
        return task;
    }
    
}
