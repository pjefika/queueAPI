/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.net.gvt.efika.queueAPI.model.service;

import br.net.gvt.efika.queueAPI.model.entity.usage.decorator.DecoratorApiUsage;
import br.net.gvt.efika.queueAPI.model.entity.usage.ApiUsage;
import br.net.gvt.efika.queueAPI.model.entity.usage.ListUsage;
import br.net.gvt.efika.queueAPI.model.entity.usage.enums.UsageStatus;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
    public List<ListUsage> usingNow() throws Exception {
        List<ListUsage> l = new ArrayList<>();
        l.add(new ListUsage(8081l, getDao().ammountByStatusAndPort(UsageStatus.USING, 8081l)));
        l.add(new ListUsage(8082l, getDao().ammountByStatusAndPort(UsageStatus.USING, 8082l)));
        l.add(new ListUsage(8083l, getDao().ammountByStatusAndPort(UsageStatus.USING, 8083l)));
        l.add(new ListUsage(8084l, getDao().ammountByStatusAndPort(UsageStatus.USING, 8084l)));
        return l;
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
