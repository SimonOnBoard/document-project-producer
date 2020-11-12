package com.itis.javalab.student.documents.system.services.interfaces;

import com.itis.javalab.student.documents.system.dtos.FormInputObject;

public interface SenderService {
    String sendMessage(FormInputObject form);
}
