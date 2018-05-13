/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.net.gvt.efika.queueAPI.dao.queue;

import br.net.gvt.efika.mongo.dao.GenericDAO;
import br.net.gvt.efika.queueAPI.model.entity.usage.ApiUsage;
import br.net.gvt.efika.queueAPI.model.enums.UsageStatus;
import java.util.Date;

/**
 *
 * @author G0042204
 */
public interface ApiUsageDAO extends GenericDAO<ApiUsage> {

    public Long ammountByStatus(UsageStatus status) throws Exception;

    public Long ammountByStatusAndPort(UsageStatus status, Long port) throws Exception;

    public Long ammountByStatusFromDate(UsageStatus status, Date date) throws Exception;

}
