package com.crio.learning_navigator.services;

import org.springframework.stereotype.Service;

@Service
public interface NumberService {
    String getNumberFact(int num);
}
