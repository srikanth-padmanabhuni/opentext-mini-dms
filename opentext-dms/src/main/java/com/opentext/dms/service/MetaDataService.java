package com.opentext.dms.service;

import com.opentext.dms.dto.SaveMetaDataDto;
import com.opentext.dms.entity.MetaDataEntity;
import com.opentext.dms.exceptions.InvalidMetaDataException;
import com.opentext.dms.repository.MetaDataRepository;
import com.opentext.dms.utilities.MappingUtil;
import com.opentext.dms.utilities.ValidationUtil;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

@Service
public class MetaDataService {
    public Logger LOG = LoggerFactory.getLogger(MetaDataService.class);

    @Autowired
    private MetaDataRepository metaDataRepository;

    @Transactional
    public Long saveMetaData(SaveMetaDataDto saveMetaDataDto) throws InvalidMetaDataException {
        LOG.info("saveMetaData is called with dto: {}", saveMetaDataDto.toString());
        ValidationUtil.validateSaveMetaData(saveMetaDataDto);
        MetaDataEntity entity = MappingUtil.mapDtoToEntity(saveMetaDataDto);
        metaDataRepository.save(entity);
        if(ObjectUtils.isEmpty(entity)) {
            throw new InvalidMetaDataException("Error occurred while saving the meta data");
        }
        return entity.getId();
    }
}
