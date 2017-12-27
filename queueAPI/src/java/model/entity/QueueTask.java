/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.entity;

import java.util.Calendar;
import model.domain.queue.enuns.TaskState;
import model.domain.queue.enuns.TasksEnum;
import org.mongodb.morphia.annotations.Entity;

/**
 *
 * @author G0042204
 */
@Entity("queue_task")
public class QueueTask extends AbstractMongoEntity {

    private Calendar dateQueueIn;

    private Calendar dateQueueOut;

    private TaskState state;

    private TasksEnum task;

    private String input;

    private Object output = new Object();

    public QueueTask() {
    }

    public Calendar getDateQueueIn() {
        return dateQueueIn;
    }

    public void setDateQueueIn(Calendar dateQueueIn) {
        this.dateQueueIn = dateQueueIn;
    }

    public Calendar getDateQueueOut() {
        return dateQueueOut;
    }

    public void setDateQueueOut(Calendar dateQueueOut) {
        this.dateQueueOut = dateQueueOut;
    }

    public TaskState getState() {
        return state;
    }

    public void setState(TaskState state) {
        this.state = state;
    }

    public TasksEnum getTask() {
        return task;
    }

    public void setTask(TasksEnum task) {
        this.task = task;
    }

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public Object getOutput() {
        return output;
    }

    public void setOutput(Object output) {
        this.output = output;
    }

}
