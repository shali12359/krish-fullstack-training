package com.example.demorentprocesstask.service;

import org.springframework.stereotype.Service;

@Service
public class RentProcessServiceImpl implements RentProcessService {
    @Override
    public boolean validateDL(String dlNum) {
        return dlNum.length() > 5;
    }
}
