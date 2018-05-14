/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.net.gvt.efika.queueAPI.model.entity.usage;

import br.net.gvt.efika.queueAPI.model.entity.usage.enums.Usage;
import br.net.gvt.efika.queueAPI.model.entity.usage.enums.UsageStatus;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import java.util.Date;
import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

/**
 *
 * @author G0042204
 */
@Entity("api_usage")
public class ApiUsage {

    @Id
    @JsonSerialize(using = ToStringSerializer.class)
    private ObjectId id;

    private UsageStatus status;

    private String user;

    private Usage usage;

    private Date dateIn;

    private Date dateOut;

    private Long port = 8080l;

    public ApiUsage() {
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public UsageStatus getStatus() {
        return status;
    }

    public void setStatus(UsageStatus status) {
        this.status = status;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public Usage getUsage() {
        return usage;
    }

    public void setUsage(Usage usage) {
        this.usage = usage;
    }

    public Date getDateIn() {
        return dateIn;
    }

    public void setDateIn(Date dateIn) {
        this.dateIn = dateIn;
    }

    public Date getDateOut() {
        return dateOut;
    }

    public void setDateOut(Date dateOut) {
        this.dateOut = dateOut;
    }

    public Long getPort() {
        return port;
    }

    public void setPort(Long port) {
        this.port = port;
    }

}
