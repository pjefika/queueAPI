/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.net.gvt.efika.queueAPI.model.service;

import br.net.gvt.efika.queueAPI.model.entity.usage.ApiUsage;
import br.net.gvt.efika.queueAPI.model.entity.usage.ListUsage;
import java.util.Date;
import java.util.List;

/**
 *
 * @author G0042204
 */
public interface ApiUsageService {

    public ApiUsage startUsing(ApiUsage use) throws Exception;

    public ApiUsage doneUsing(ApiUsage use) throws Exception;

    public List<ListUsage> usingNow() throws Exception;

    public Long usedSoFar() throws Exception;

    public Long usesFrom(Date date) throws Exception;

}
