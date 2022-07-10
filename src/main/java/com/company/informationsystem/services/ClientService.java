package com.company.informationsystem.services;

import org.springframework.stereotype.Service;

@Service
public class ClientService {

    public boolean isCorrectEmail(String email){
        return email.matches("^([\\w-\\.]+){1,64}@([\\w&&[^_]]+){2,255}.[a-z]{2,}$");
    }
}
