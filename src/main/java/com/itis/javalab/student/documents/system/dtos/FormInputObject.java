package com.itis.javalab.student.documents.system.dtos;

import lombok.*;

import java.sql.Date;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class FormInputObject {
    private String name;
    private String patronymic;
    private String surname;
    private String passport;
    private String mail;

    private Date date;
    private String type;

    private String proved;

}
