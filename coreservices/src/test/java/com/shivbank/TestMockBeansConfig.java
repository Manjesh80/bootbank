package com.shivbank;

import com.shivbank.repository.PublisherRepository;
import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * Author: mg153v (Manjesh Gowda). Creation Date: 2/9/2017.
 */
@Configuration
@UsedForTesting
public class TestMockBeansConfig {
    @Bean
    @Primary
    public PublisherRepository createMockPublisherRepository() {
        return Mockito.mock(PublisherRepository.class);
    }
}