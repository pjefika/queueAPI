/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.net.gvt.efika.queueAPI.model.service;

import br.net.gvt.efika.queueAPI.controller.request.PendingTasksResponse;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author G0042204
 */
public class ConsumerQueueTaskServiceImplIT {

    public ConsumerQueueTaskServiceImplIT() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getPendingTasks method, of class ConsumerQueueTaskServiceImpl.
     */
    @Test
    public void testConsumePendingTasks() throws Exception {
        System.out.println("getPendingTasks");
        ConsumerQueueTaskServiceImpl instance = new ConsumerQueueTaskServiceImpl();
        PendingTasksResponse result = instance.consumePendingTasks("consumer");
        assertTrue(!result.getTasks().isEmpty());
    }

    /**
     * Test of updateTask method, of class ConsumerQueueTaskServiceImpl.
     */
    @Test
    public void testCompleteTask() throws Exception {
        System.out.println("completeTask");
        ConsumerQueueTaskServiceImpl instance = new ConsumerQueueTaskServiceImpl();
        instance.consumePendingTasks("consumer").getTasks().forEach((t) -> {
            try {
                instance.completeTask(t);
            } catch (Exception e) {
                fail(e.getMessage());
            }
        });
        assertTrue(instance.getPendingTasks().isEmpty());
    }

}
