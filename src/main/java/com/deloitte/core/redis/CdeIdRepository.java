package com.deloitte.core.redis;

import com.deloitte.core.entity.CdeId;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CdeIdRepository extends CrudRepository<CdeId, String> {
}
