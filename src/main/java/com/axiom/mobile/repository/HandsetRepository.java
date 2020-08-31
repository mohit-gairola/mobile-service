package com.axiom.mobile.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.axiom.mobile.model.Handset;

public interface HandsetRepository extends ElasticsearchRepository<Handset, String> {

}
