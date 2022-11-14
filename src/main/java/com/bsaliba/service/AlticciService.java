package com.bsaliba.service;

import org.jboss.logging.Logger;

import io.quarkus.cache.CacheResult;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class AlticciService {

    private static final Logger LOG = Logger.getLogger(AlticciService.class);

    @CacheResult(cacheName = "alticci-cache") 
    public Long alticci(Long n) {
        LOG.infov("Calculating alticci for {0}", n);

        if (n == 0) {
            return 0L;
        } else if (n == 1 || n == 2) {
            return 1L;
        }

        return alticci(n - 3) + alticci(n - 2);
    }
}
