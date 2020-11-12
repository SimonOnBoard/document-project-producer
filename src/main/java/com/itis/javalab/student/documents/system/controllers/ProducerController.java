package com.itis.javalab.student.documents.system.controllers;

import com.itis.javalab.student.documents.system.dtos.FormInputObject;
import com.itis.javalab.student.documents.system.services.interfaces.SenderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class ProducerController {
    private final SenderService senderService;

    @GetMapping("/form")
    public String getBasicForm(){
        return "form";
    }

    @PostMapping("/process")
    public ResponseEntity<String> sendDirectProducerMessage(FormInputObject form){
        return ResponseEntity.accepted().body(senderService.sendMessage(form));
    }
}
