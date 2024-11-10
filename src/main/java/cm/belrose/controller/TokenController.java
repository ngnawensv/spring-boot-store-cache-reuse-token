package cm.belrose.controller;

import cm.belrose.service.TokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/token")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class TokenController {

    private final TokenService tokenService;

    /*
    ->This controller has a GET endpoint (/api/token) that returns the cached access token.
    ->If the token is not in the cache or has expired, TokenService.getAccessToken() generates and caches a new one.
    */
    @GetMapping
    public ResponseEntity<String> getAccessToken() {
        // This calls the token service to get (or cache) the access token
        String accessToken = tokenService.getAccessToken();
        return ResponseEntity.ok(accessToken);
    }
}