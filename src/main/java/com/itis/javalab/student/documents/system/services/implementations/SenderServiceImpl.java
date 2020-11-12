package com.itis.javalab.student.documents.system.services.implementations;

import com.itis.javalab.student.documents.system.dtos.FormInputObject;
import com.itis.javalab.student.documents.system.models.PersonWithMail;
import com.itis.javalab.student.documents.system.services.interfaces.ExchangeSender;
import com.itis.javalab.student.documents.system.services.interfaces.SenderService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class SenderServiceImpl implements SenderService {
    public SenderServiceImpl(@Qualifier("exchangeSenderDirectImpl") ExchangeSender directExchangeSender,
                             @Qualifier("exchangeSenderTopicImpl") ExchangeSender topicExchangeSender,
                             String teachersTopicKey,
                             String studentsTopicKey) {
        this.directExchangeSender = directExchangeSender;
        this.topicExchangeSender = topicExchangeSender;
        this.teachersTopicKey = teachersTopicKey;
        this.studentsTopicKey = studentsTopicKey;
    }

    private final ExchangeSender directExchangeSender;
    private final ExchangeSender topicExchangeSender;

    private final String teachersTopicKey;
    private final String studentsTopicKey;

    @Override
    public String sendMessage(FormInputObject form) {
        PersonWithMail personWithMail = getPersonWithMail(form);
        if (form.getProved() == null) {
            directExchangeSender.sendMessages(form.getType(), personWithMail);
        } else {
            String key;
            switch (form.getType()) {
                case "teacher":
                    key = teachersTopicKey;
                    break;
                case "student":
                    key = studentsTopicKey;
                    break;
                default:
                    throw new IllegalArgumentException("This role does not exist");
            }
            topicExchangeSender.sendMessages(key, personWithMail);
        }
        return "All os ok";
    }

    private PersonWithMail getPersonWithMail(FormInputObject form) {
        return PersonWithMail.builder()
                .date(form.getDate())
                .mail(form.getMail())
                .name(form.getName())
                .surname(form.getSurname())
                .passport(form.getPassport())
                .patronymic(form.getPatronymic())
                .build();
    }
}
