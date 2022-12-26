package com.swgoh.service;

import com.swgoh.entity.Caracter;

public interface CaracterService {
    void generateCaracterList(int allyCode);
    Caracter getCaracter(String defId);
}
