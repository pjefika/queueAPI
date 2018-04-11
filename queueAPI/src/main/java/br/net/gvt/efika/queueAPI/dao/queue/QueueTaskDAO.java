/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.net.gvt.efika.queueAPI.dao.queue;

import br.net.gvt.efika.mongo.dao.GenericDAO;
import br.net.gvt.efika.queue.model.enuns.TaskState;
import java.util.List;
import br.net.gvt.efika.queueAPI.model.entity.QueueTask;

/**
 *
 * @author G0042204
 */
public interface QueueTaskDAO extends GenericDAO<QueueTask> {

    public List<QueueTask> listByState(TaskState state, Integer limit) throws Exception;

}
