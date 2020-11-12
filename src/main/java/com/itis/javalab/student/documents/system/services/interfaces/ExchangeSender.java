package com.itis.javalab.student.documents.system.services.interfaces;

import com.itis.javalab.student.documents.system.models.PersonWithMail;

public interface ExchangeSender {
    void sendMessages(String key, PersonWithMail person);
}
