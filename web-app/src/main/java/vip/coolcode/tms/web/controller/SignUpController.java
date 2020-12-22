package vip.coolcode.tms.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
import vip.coolcode.account.dto.GenericAccountResponse;

import java.util.HashMap;
import java.util.Map;

@Controller
public class SignUpController {

    @Autowired
    RestTemplateBuilder rtb;

    @PostMapping("/signup")
    @ResponseBody
    public GenericAccountResponse signUp(String name,String email,String phoneNumber) {
        //调用Account服务
        RestTemplate restTemplate = rtb.build();
        String uri = "http://localhost:9000/api/v1/account/create";
        Map<String,String> map = new HashMap<>();
        map.put("name",name);
        map.put("email",email);
        map.put("phoneNumber", phoneNumber);

        GenericAccountResponse gar =
                restTemplate.postForObject(uri,map,GenericAccountResponse.class);
        return gar;
    }
}
