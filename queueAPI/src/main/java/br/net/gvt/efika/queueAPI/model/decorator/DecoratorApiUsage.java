/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.net.gvt.efika.queueAPI.model.decorator;

import br.net.gvt.efika.queueAPI.model.entity.usage.ApiUsage;
import br.net.gvt.efika.queueAPI.model.enums.UsageStatus;
import java.util.Calendar;

/**
 *
 * @author G0041775
 */
public class DecoratorApiUsage {

    public static ApiUsage doneUsing(ApiUsage use) {
        use.setDateOut(Calendar.getInstance().getTime());
        use.setStatus(UsageStatus.DONE_USING);
        return use;
    }
}
