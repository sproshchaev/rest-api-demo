package com.prosoft.feign;

import com.prosoft.dto.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "postman", url = "https://7c0bf53e-8f0b-49a0-aebe-a44dcbe4e2aa.mock.pstmn.io")
public interface PostmanProxy {

    @PostMapping("/api/auth/plain")
    String getToken(@RequestBody User user);

}
