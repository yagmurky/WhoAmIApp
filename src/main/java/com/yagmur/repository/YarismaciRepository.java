package com.yagmur.repository;

import com.yagmur.entity.Yarismaci;

public class YarismaciRepository extends RepositoryManager<Yarismaci, Long> {
    public YarismaciRepository() {
        super(new Yarismaci());
    }

}
