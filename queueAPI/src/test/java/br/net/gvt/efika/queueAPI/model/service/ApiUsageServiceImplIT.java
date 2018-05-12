/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.net.gvt.efika.queueAPI.model.service;

import br.net.gvt.efika.queueAPI.model.entity.ApiUsage;
import br.net.gvt.efika.queueAPI.model.enums.Usage;
import br.net.gvt.efika.queueAPI.model.factory.FactoryApiUsage;
import br.net.gvt.efika.util.json.JacksonMapper;
import java.util.Date;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author G0041775
 */
public class ApiUsageServiceImplIT {

    public ApiUsageServiceImplIT() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of startUsing method, of class ApiUsageServiceImpl.
     */
    @Test
    public void testStartUsing() throws Exception {
        System.out.println("startUsing");
        ApiUsage use = FactoryApiUsage.create("teste", Usage.SAVE);
        ApiUsageServiceImpl instance = new ApiUsageServiceImpl();

        ApiUsage result = instance.startUsing(use);

        System.out.println(new JacksonMapper(ApiUsage.class).serialize(result));

    }

    /**
     * Test of doneUsing method, of class ApiUsageServiceImpl.
     */
    @Test
    public void testDoneUsing() throws Exception {
        System.out.println("doneUsing");
        ApiUsage use = FactoryApiUsage.create("teste", Usage.SAVE);
        ApiUsageServiceImpl instance = new ApiUsageServiceImpl();

        ApiUsage result = instance.doneUsing(instance.startUsing(use));
//        System.out.println(new JacksonMapper(ApiUsage.class).serialize(result));
    }

    /**
     * Test of usingNow method, of class ApiUsageServiceImpl.
     */
    @Test
    public void testUsingNow() throws Exception {
        System.out.println("usingNow");
        ApiUsageServiceImpl instance = new ApiUsageServiceImpl();

        Long result = instance.usingNow();
        System.out.println("Result->" + result);
    }

    /**
     * Test of usedSoFar method, of class ApiUsageServiceImpl.
     */
    @Test
    public void testUsedSoFar() throws Exception {
        System.out.println("usedSoFar");
        ApiUsageServiceImpl instance = new ApiUsageServiceImpl();

        Long result = instance.usedSoFar();
        System.out.println("Result->" + result);
    }

    /**
     * Test of usesFrom method, of class ApiUsageServiceImpl.
     */
    @Test
    public void testUsesFrom() throws Exception {
        System.out.println("usesFrom");
        Date date = new Date(1526180400000l);
        ApiUsageServiceImpl instance = new ApiUsageServiceImpl();
        Long result = instance.usesFrom(date);
        System.out.println("Result->" + result);

    }

}
