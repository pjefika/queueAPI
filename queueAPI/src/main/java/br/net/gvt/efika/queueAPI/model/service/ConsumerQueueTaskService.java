/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.net.gvt.efika.queueAPI.model.service;

import br.net.gvt.efika.queueAPI.controller.request.ConsumerQueueTaskRequest;
import br.net.gvt.efika.queueAPI.controller.request.PendingTasksResponse;
import java.util.List;
import br.net.gvt.efika.queueAPI.model.entity.QueueTask;

/**
 *
 * @author G0042204
 */
public interface ConsumerQueueTaskService {

    public PendingTasksResponse consumePendingTasks(ConsumerQueueTaskRequest consumer) throws Exception;

    public QueueTask completeTask(QueueTask queueTask) throws Exception;

    public QueueTask completeFulltest(QueueTask queueTask) throws Exception;

    public List<QueueTask> getPendingTasks(Integer limit) throws Exception;

}
