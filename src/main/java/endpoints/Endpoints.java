package endpoints;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Endpoints {

    @RequestMapping("/")
    String hello(){
        return "Hi..";
    }
}
