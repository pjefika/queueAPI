/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.net.gvt.efika.queueAPI.model.entity.usage;

/**
 *
 * @author G0041775
 */
public class ListUsage {

    private Long port;

    private Long ammount;

    public ListUsage() {
    }

    public ListUsage(Long port, Long ammount) {
        this.port = port;
        this.ammount = ammount;
    }

    public Long getPort() {
        return port;
    }

    public void setPort(Long port) {
        this.port = port;
    }

    public Long getAmmount() {
        return ammount;
    }

    public void setAmmount(Long ammount) {
        this.ammount = ammount;
    }

}
