package com.BE.RedLine.Controller;

import com.BE.RedLine.DAO.*;
import com.BE.RedLine.Model.NineLine;
import com.BE.RedLine.Model.Request;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController
//@RequestMapping("")
public class RequesterController {
    final RequestRepo requestRepository;

    public RequesterController(RequestRepo requestRepository) {
        this.requestRepository = requestRepository;
    }

    //create one nineline
    @PostMapping("/nineline")
    public Request createNineLine(@RequestBody NineLine input){
        Request temp = new Request(input);
        return requestRepository.save(temp);
//        return requestRepository.save( input);
    }



}
