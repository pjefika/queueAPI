/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.in;

import br.net.gvt.efika.customer.EfikaCustomer;
import model.domain.queue.enuns.TasksEnum;

/**
 *
 * @author G0042204
 */
public class QueueTaskIn {

    private String executor;

    private String instancia;

    private TasksEnum task;

    public QueueTaskIn() {
    }

    public String getExecutor() {
        return executor;
    }

    public void setExecutor(String executor) {
        this.executor = executor;
    }

    public String getInstancia() {
        return instancia;
    }

    public void setInstancia(String instancia) {
        this.instancia = instancia;
    }

    public TasksEnum getTask() {
        return task;
    }

    public void setTask(TasksEnum task) {
        this.task = task;
    }

}
