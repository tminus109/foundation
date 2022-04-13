package com.gfa.orientation_exam_example.repositories;

import com.gfa.orientation_exam_example.models.UrlAlias;
import org.springframework.data.repository.CrudRepository;

public interface UrlAliasRepository extends CrudRepository<UrlAlias, Long> {
    UrlAlias findByAliasIgnoreCase(String alias);
}
