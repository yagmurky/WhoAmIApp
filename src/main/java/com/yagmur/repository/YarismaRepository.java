package com.yagmur.repository;

import com.yagmur.entity.Yarisma;

public class YarismaRepository extends RepositoryManager<Yarisma,Long> {

    public YarismaRepository() {
        super(new Yarisma());
    }
}
