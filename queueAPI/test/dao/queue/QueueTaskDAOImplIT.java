/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.queue;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import model.domain.queue.Item;
import model.domain.queue.enuns.TaskState;
import model.domain.queue.enuns.TasksEnum;
import model.entity.QueueTask;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author G0042204
 */
public class QueueTaskDAOImplIT {

    public QueueTaskDAOImplIT() {
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

    @Test
    public void testSave() {
        try {
            QueueTaskDAOImpl dao = new QueueTaskDAOImpl();
            QueueTask t = new QueueTask();
            t.setDateQueueIn(new Date());
            t.addInputItem(new Item("instancia", "4130886762"));
            t.setState(TaskState.PENDING);
            t.setTask(TasksEnum.FULLTEST);
            dao.save(t);
        } catch (Exception e) {
            fail(e.getMessage());

        }
    }

    @Test
    public void testListByState() {
        try {
            QueueTaskDAOImpl dao = new QueueTaskDAOImpl();
            List<QueueTask> listByState = dao.listByState(TaskState.PENDING);
            assertTrue(!listByState.isEmpty());
        } catch (Exception e) {
            fail(e.getMessage());

        }
    }

}
