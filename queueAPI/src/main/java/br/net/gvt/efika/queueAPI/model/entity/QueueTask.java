/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.net.gvt.efika.queueAPI.model.entity;

import br.net.gvt.efika.queue.model.dto.task.QueueTaskDTO;
import org.mongodb.morphia.annotations.Entity;

/**
 *
 * @author G0042204
 */
@Entity("queue_task")
public class QueueTask extends QueueTaskDTO {

    public QueueTask() {
    }

}
