/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.net.gvt.efika.queueAPI.model.service.exception;

/**
 *
 * @author G0042204
 */
public class TaskTimeoutException extends Exception {

    public TaskTimeoutException() {
        super("Tarefa demorou demais para ser executada!");
    }

}
