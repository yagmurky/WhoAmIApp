package com.yagmur.repository;

import com.yagmur.entity.Ipucu;

public class IpucuRepository extends RepositoryManager<Ipucu,Long> {
    public IpucuRepository(){
        super(new Ipucu());
    }
}
