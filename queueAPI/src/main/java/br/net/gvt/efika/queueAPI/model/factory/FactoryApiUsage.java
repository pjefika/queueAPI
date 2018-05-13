/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.net.gvt.efika.queueAPI.model.factory;

import br.net.gvt.efika.queueAPI.model.entity.usage.ApiUsage;
import br.net.gvt.efika.queueAPI.model.enums.Usage;
import java.util.Calendar;

/**
 *
 * @author G0041775
 */
public class FactoryApiUsage {

    public static ApiUsage create(String user, Usage usage) {
        ApiUsage use = create();
        use.setDateIn(Calendar.getInstance().getTime());
        use.setUsage(usage);
        use.setUser(user);
        return use;
    }

    public static ApiUsage create() {
        return new ApiUsage();
    }
}
