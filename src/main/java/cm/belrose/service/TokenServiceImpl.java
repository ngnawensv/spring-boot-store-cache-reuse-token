package cm.belrose.service;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class TokenServiceImpl implements TokenService{

    // This method retrieves the access token and caches it.
    /*
    @Cacheable tells Spring to cache the result of getAccessToken using the key "accessToken".
    When the method is called, it first checks the cache. If the token is present, it returns the cached value.
    Otherwise, it generates a new token (using a random UUID here as a placeholder) and stores it in the cache.
    */
    @Cacheable(value = "accessTokenCache", key = "'accessToken'", unless = "#result == null")
    @Override
    public String getAccessToken() {
        // In a real-world application, you would call an external service to get the token.
        // For demonstration, we're generating a random UUID as the token.
        return UUID.randomUUID().toString();
    }
}
