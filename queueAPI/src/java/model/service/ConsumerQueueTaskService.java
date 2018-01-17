/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.service;

import controller.request.PendingTasksResponse;
import java.util.List;
import model.entity.QueueTask;

/**
 *
 * @author G0042204
 */
public interface ConsumerQueueTaskService {

    public PendingTasksResponse consumePendingTasks(String consumer) throws Exception;

    public QueueTask completeTask(QueueTask queueTask) throws Exception;

    public QueueTask completeFulltest(QueueTask queueTask) throws Exception;

    public List<QueueTask> getPendingTasks() throws Exception;

}
