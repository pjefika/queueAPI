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
    public void testGetPendingTasks() throws Exception {
        System.out.println("getPendingTasks");
        ConsumerQueueTaskServiceImpl instance = new ConsumerQueueTaskServiceImpl();
        List<QueueTask> result = instance.getPendingTasks();
        assertTrue(!result.isEmpty());
    }

    /**
     * Test of updateTask method, of class ConsumerQueueTaskServiceImpl.
     */
    @Test
    public void testCompleteTask() throws Exception {
        System.out.println("completeTask");
        ConsumerQueueTaskServiceImpl instance = new ConsumerQueueTaskServiceImpl();
        instance.getPendingTasks().forEach((t) -> {
            t.setDateQueueOut(Calendar.getInstance().getTime());
            t.setState(TaskState.EXECUTED);
            try {
                instance.completeTask(t);
            } catch (Exception e) {
                fail(e.getMessage());
            }
        });
        assertTrue(instance.getPendingTasks().isEmpty());
    }

}
