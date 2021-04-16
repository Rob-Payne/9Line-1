package com.BE.RedLine.Controller;

import com.BE.RedLine.DAO.*;
import com.BE.RedLine.Model.Request;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController
//@RequestMapping("")
public class DispatcherController {
    final RequestRepo requestRepository;

    public DispatcherController(RequestRepo requestRepository) {
        this.requestRepository = requestRepository;
    }

    //get all
    @GetMapping("/requests")
    public Iterable<Request> getall(){
        return requestRepository.findAll();
    }
    //get one
    @GetMapping("/requests/{id}")
    public Optional<Request> getone(@PathVariable long id){
        return requestRepository.findById(id);
    }
    //patch one
    @PatchMapping("/requests/{id}") //takes a key value pair for each paramater to change
    public Request assign(@PathVariable long id, @RequestBody Map<String,String> input){
        Request request = requestRepository.findById(id).get();
        if(request == null){return null;}
        //for each key value pair
        for(String key : input.keySet()){
            //set the associated property
            switch (key.toLowerCase()){
                case "responder": request.setResponder(input.get(key)); break;
                case "completed": request.setCompleted(true);break;
            }
        }

        return requestRepository.save(request);
    }
}
