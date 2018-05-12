/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.net.gvt.efika.queueAPI.model.service;

import br.net.gvt.efika.queueAPI.model.decorator.DecoratorApiUsage;
import br.net.gvt.efika.queueAPI.model.entity.ApiUsage;
import br.net.gvt.efika.queueAPI.model.enums.UsageStatus;
import java.util.Date;

public class ApiUsageServiceImpl extends AbstractApiUsageService implements ApiUsageService {

    @Override
    public ApiUsage startUsing(ApiUsage use) throws Exception {
        use.setStatus(UsageStatus.USING);
        return getDao().save(use);
    }

    @Override
    public ApiUsage doneUsing(ApiUsage use) throws Exception {
        ApiUsage used = DecoratorApiUsage.doneUsing(use);
        return getDao().update(use, oper()
                .set("dateOut", used.getDateOut())
                .set("status", used.getStatus())
        );
    }

    @Override
    public Long usingNow() throws Exception {
        return getDao().ammountByStatus(UsageStatus.USING);
    }

    @Override
    public Long usedSoFar() throws Exception {
        return getDao().ammountByStatus(UsageStatus.DONE_USING);
    }

    @Override
    public Long usesFrom(Date date) throws Exception {
        return getDao().ammountByStatusFromDate(UsageStatus.DONE_USING, date);
    }

}
