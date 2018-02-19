/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.net.gvt.efika.queueAPI.model.service;

import br.net.gvt.efika.queueAPI.model.entity.QueueTask;
import org.bson.types.ObjectId;

/**
 *
 * @author G0042204
 */
public interface QueueTaskService {

    public QueueTask process(QueueTask task) throws Exception;

    public QueueTask queue(QueueTask task) throws Exception;

    public QueueTask getById(ObjectId task) throws Exception;

}
