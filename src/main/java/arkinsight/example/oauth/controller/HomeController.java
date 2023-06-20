package arkinsight.example.oauth.controller;

import arkinsight.example.oauth.service.OAuth2AuthorizedClientService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/")
public class HomeController {

    @Autowired
    private OAuth2AuthorizedClientService service;

    @GetMapping("/welcome")
    public ResponseEntity<String> simpleRequest(HttpServletResponse response) {
        //String accessToken = service.getAccessToken();
        return ResponseEntity.status(response.getStatus()).body("Testing floww ");
    }

}
