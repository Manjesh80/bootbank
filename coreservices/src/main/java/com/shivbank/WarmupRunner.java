package com.shivbank;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;

/**
 * Created by aadhya on 2/8/2017.
 */

@Order(100)
public class WarmupRunner implements CommandLineRunner {
    protected final Log LOG = LogFactory.getLog(getClass());

    @Override
    public void run(String... args) throws Exception {
        LOG.info("Jai Ganesh Warm up");
    }
}
