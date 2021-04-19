package com.mavs.uta.service.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RestResource;

import com.mavs.uta.service.bean.TestCaseMetric;

@RestResource(exported = false)
public interface TestCaseRepository extends CrudRepository<TestCaseMetric, Long> {
	boolean existsByUsername(String username);

}
