package com.kintore.contoroller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController {

    //@Autowired
    //private UserMapper userMapper;

    @RequestMapping("/")
    public String index() {
        //String userName = userMapper.findByState(1);
        return "test";
    }
}