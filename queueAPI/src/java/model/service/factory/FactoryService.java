/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.service.factory;

import model.service.ConsumerQueueTaskService;
import model.service.ConsumerQueueTaskServiceImpl;
import model.service.QueueTaskService;
import model.service.QueueTaskServiceImpl;

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
