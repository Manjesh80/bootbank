package com.shivbank.coreservicestarter.dbcount;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;

/**
 * Author: mg153v (Manjesh Gowda). Creation Date: 2/9/2017.
 */
@Configuration
public class DbCountAutoConfiguration {
    protected final Log logger = LogFactory.getLog(getClass());

    @Bean
    @ConditionalOnMissingBean
    public DbCountRunner dbCountRunner(Collection<CrudRepository> repositories) {

        return new DbCountRunner(repositories);
    }
}