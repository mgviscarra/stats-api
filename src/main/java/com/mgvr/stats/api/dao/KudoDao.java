package com.mgvr.stats.api.dao;

import com.mgvr.stats.api.model.kudo.model.Kudo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class KudoDao {
    @Autowired
    private MongoTemplate mongoTemplate;

    public int getNumberOfKudosByUser(String destino){
        Query query = new Query();
        query.addCriteria(Criteria.where("destino").is(destino));
        List<Kudo> kudo = mongoTemplate.find(query, Kudo.class);
        return kudo.size();

    }
}
