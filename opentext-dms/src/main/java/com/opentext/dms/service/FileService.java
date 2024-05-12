package com.opentext.dms.service;

import com.opentext.dms.dto.SaveFileDto;
import com.opentext.dms.entity.FileEntity;
import com.opentext.dms.entity.MetaDataEntity;
import com.opentext.dms.exceptions.InvalidMetaDataValueException;
import com.opentext.dms.exceptions.InvalidSaveFileException;
import com.opentext.dms.repository.FileRepository;
import com.opentext.dms.repository.MetaDataRepository;
import com.opentext.dms.utilities.MappingUtil;
import com.opentext.dms.utilities.ValidationUtil;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.io.IOException;
import java.util.Optional;

@Service
public class FileService {

    public Logger LOG = LoggerFactory.getLogger(FileService.class);

    @Autowired
    private MetaDataValuesService metaDataValuesService;

    @Autowired
    private MetaDataRepository metaDataRepository;

    @Autowired
    private FileRepository fileRepository;

    @Transactional
    public Long saveFileWithData(SaveFileDto saveFileDto) throws InvalidSaveFileException, InvalidMetaDataValueException, IOException {
        LOG.info("saveFileWithData is called");
        ValidationUtil.validateSaveFileDto(saveFileDto);
        validateMetaDataId(saveFileDto.getMetaDataId());
        Long metaDataValuesId = metaDataValuesService.saveMetaDataValues(saveFileDto.getMetaDataValues(), saveFileDto.getMetaDataId());
        FileEntity entity = MappingUtil.mapDtoToEntity(saveFileDto, metaDataValuesId);
        if(ObjectUtils.isEmpty(entity)) {
            throw new InvalidSaveFileException("Error occurred while saving the file with meta data to DB");
        }
        fileRepository.save(entity);
        return entity.getId();
    }

    public void validateMetaDataId(Long metaDataId) throws InvalidSaveFileException {
        LOG.info("validateMetaDataId is called metaDataId: {}", metaDataId);
        Optional<MetaDataEntity> optionalEntity = metaDataRepository.findById(metaDataId);
        if(optionalEntity.isEmpty()) {
            throw new InvalidSaveFileException("Meta Data not found for given metaData Id: " + metaDataId);
        }
    }

}
