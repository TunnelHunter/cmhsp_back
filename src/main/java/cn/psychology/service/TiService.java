package cn.psychology.service;


import cn.psychology.dao.TiRepository;
import cn.psychology.entity.Ti;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

@Service
public class TiService implements TiRepository {
    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    private TiRepository tiRepository;


    @Override
    public <S extends Ti> S save(S entity) {
        return null;
    }

    @Override
    public Ti findOne(String s) {
        return null;
    }

    @Override
    public boolean exists(String s) {
        return false;
    }

    @Override
    public Iterable<Ti> findAll(Iterable<String> strings) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void delete(String s) {

    }

    @Override
    public void delete(Ti entity) {

    }

    @Override
    public void delete(Iterable<? extends Ti> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public <S extends Ti> S findOne(Example<S> example) {
        return null;
    }

    @Override
    public <S extends Ti> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Ti> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Ti> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends Ti> List<S> save(Iterable<S> entites) {
        return null;
    }


    public List<Ti> findAll() {
        return tiRepository.findAll();
    }

    @Override
    public List<Ti> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<Ti> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Ti> S insert(S entity) {
        return null;
    }

    @Override
    public <S extends Ti> List<S> insert(Iterable<S> entities) {
        return null;
    }

    @Override
    public <S extends Ti> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends Ti> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public Ti findByExamination(String examination) {
        Query query = new Query(Criteria.where("examination").is(examination));
        Ti ti = mongoTemplate.findOne(query, Ti.class);
        return ti;
    }

    public void saveTi(Ti ti) {
        mongoTemplate.save(ti);
    }

}
