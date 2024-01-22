package com.yagmur.service;

import com.yagmur.entity.Unlu;
import com.yagmur.repository.UnluRepository;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class UnluService {

    public static List<Unlu> randomUnluGetir(){
        List<Unlu> unluList = new UnluRepository().findAll();
        Collections.shuffle(unluList);
        return unluList;
    }
}
