/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.request;

/**
 *
 * @author G0042204
 */
public class ConsumerQuestTaskRequest {

    private String consumer;

    private Integer amount;

    public ConsumerQuestTaskRequest() {
        amount = 5;
    }

    public String getConsumer() {
        return consumer;
    }

    public void setConsumer(String consumer) {
        this.consumer = consumer;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

}
