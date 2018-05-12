/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.net.gvt.efika.queueAPI.model.service;

import br.net.gvt.efika.queueAPI.model.entity.ApiUsage;
import java.util.Date;

/**
 *
 * @author G0042204
 */
public interface ApiUsageService {

    public ApiUsage startUsing(ApiUsage use) throws Exception;

    public ApiUsage doneUsing(ApiUsage use) throws Exception;

    public Long usingNow() throws Exception;

    public Long usedSoFar() throws Exception;

    public Long usesFrom(Date date) throws Exception;

}
