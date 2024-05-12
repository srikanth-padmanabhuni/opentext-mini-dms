package com.opentext.dms.service;

import com.opentext.dms.dto.MetaDataValuesDto;
import com.opentext.dms.entity.MetaDataValuesEntity;
import com.opentext.dms.exceptions.InvalidMetaDataException;
import com.opentext.dms.exceptions.InvalidMetaDataValueException;
import com.opentext.dms.repository.MetaDataValuesRepository;
import com.opentext.dms.utilities.MappingUtil;
import com.opentext.dms.utilities.ValidationUtil;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;

@Service
public class MetaDataValuesService {
    public Logger LOG = LoggerFactory.getLogger(MetaDataService.class);

    @Autowired
    private MetaDataValuesRepository metaDataValuesRepository;

    @Transactional
    public Long saveMetaDataValues(List<MetaDataValuesDto> metaDataValuesDto, Long metaDataId) throws InvalidMetaDataValueException {
        LOG.info("saveMetaDataValues is called with dto: {} | metaDataId: {}", metaDataValuesDto.toString(), metaDataId);
        if(ObjectUtils.isEmpty(metaDataId)) {
            throw new InvalidMetaDataValueException("Missing meta data id");
        }
        ValidationUtil.validateMetaDataValuesList(metaDataValuesDto);
        MetaDataValuesEntity entity = MappingUtil.mapDtoToEntity(metaDataValuesDto, metaDataId);
        metaDataValuesRepository.save(entity);
        if(ObjectUtils.isEmpty(entity)) {
            throw new InvalidMetaDataValueException("Error occurred while saving the meta data field values");
        }
        return entity.getId();
    }
}
