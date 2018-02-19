/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.net.gvt.efika.queueAPI.model.service.factory;

import br.net.gvt.efika.queueAPI.model.service.ConsumerQueueTaskService;
import br.net.gvt.efika.queueAPI.model.service.ConsumerQueueTaskServiceImpl;
import br.net.gvt.efika.queueAPI.model.service.QueueTaskService;
import br.net.gvt.efika.queueAPI.model.service.QueueTaskServiceImpl;

/**
 *
 * @author G0042204
 */
public class FactoryService {

    public static ConsumerQueueTaskService createConsumerQueueTaskService() {
        return new ConsumerQueueTaskServiceImpl();
    }

    public static QueueTaskService createQueueTaskService() {
        return new QueueTaskServiceImpl();
    }

}
