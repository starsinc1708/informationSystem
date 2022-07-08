package com.company.informationsystem.services;

import org.springframework.stereotype.Service;

@Service
public class ClientService {

    public boolean isCorrectEmail(String email){
        return email.matches("[0-9]*[A-Za-z]+\\.*\\@[A-Za-z]+\\.[A-Za-z]+");
    }
}
