package com.yagmur.repository;

import com.yagmur.entity.Unlu;

public class UnluRepository extends RepositoryManager<Unlu,Long> {
    public UnluRepository() {
        super(new Unlu());
    }
}
