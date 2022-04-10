package com.gfa.backend_api.repositories;

import com.gfa.backend_api.models.Log;
import org.springframework.data.repository.CrudRepository;

public interface LogRepository extends CrudRepository<Log, Long> {
}
