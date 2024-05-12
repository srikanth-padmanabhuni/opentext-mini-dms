package com.opentext.dms.repository;

import com.opentext.dms.entity.MetaDataValuesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MetaDataValuesRepository extends JpaRepository<MetaDataValuesEntity, Long> {
}
