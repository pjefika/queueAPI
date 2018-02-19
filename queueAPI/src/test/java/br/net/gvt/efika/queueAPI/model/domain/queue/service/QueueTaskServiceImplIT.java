/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.net.gvt.efika.queueAPI.model.domain.queue.service;

import br.net.gvt.efika.queue.model.enuns.TaskState;
import br.net.gvt.efika.queueAPI.mock.QueueTaskMock;
import br.net.gvt.efika.queueAPI.model.entity.QueueTask;
import br.net.gvt.efika.queueAPI.model.service.QueueTaskServiceImpl;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author G0042204
 */
public class QueueTaskServiceImplIT {

    public QueueTaskServiceImplIT() {
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
     * Test of process method, of class QueueTaskServiceImpl.
     */
    @Test
    public void testProcess() throws Exception {
        System.out.println("process");
        QueueTask task = QueueTaskMock.createDefaultQueueTask();
        QueueTaskServiceImpl instance = new QueueTaskServiceImpl();
        QueueTask result = instance.process(task);
        assertTrue(result.getState() == TaskState.EXECUTED);

    }

}
