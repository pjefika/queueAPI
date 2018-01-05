/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.request;

import java.util.ArrayList;
import java.util.List;
import model.entity.QueueTask;

/**
 *
 * @author G0042204
 */
public class PendingTasksResponse {

    private List<QueueTask> tasks;

    public PendingTasksResponse() {
        tasks = new ArrayList<>();
    }

    public List<QueueTask> getTasks() {
        return tasks;
    }

    public void setTasks(List<QueueTask> tasks) {
        this.tasks = tasks;
    }

}
