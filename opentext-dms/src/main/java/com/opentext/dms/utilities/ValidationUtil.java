package com.opentext.dms.utilities;

import com.opentext.dms.dto.MetaDataDto;
import com.opentext.dms.dto.MetaDataValuesDto;
import com.opentext.dms.dto.SaveFileDto;
import com.opentext.dms.dto.SaveMetaDataDto;
import com.opentext.dms.enums.MetaDataTypeEnum;
import com.opentext.dms.exceptions.InvalidMetaDataException;
import com.opentext.dms.exceptions.InvalidMetaDataValueException;
import com.opentext.dms.exceptions.InvalidSaveFileException;
import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import java.util.List;

public class ValidationUtil {

    public static void validateSaveMetaData(SaveMetaDataDto saveMetaDataDto) throws InvalidMetaDataException {
        if(ObjectUtils.isEmpty(saveMetaDataDto)) {
            throw new InvalidMetaDataException("Save Meta Data Request Cannot be Empty!!!");
        }

        if(ObjectUtils.isEmpty(saveMetaDataDto.getMetaData())) {
            throw new InvalidMetaDataException("Atleast One Meta Data Infgrmation is needed!!!");
        }

        for(MetaDataDto dto: saveMetaDataDto.getMetaData()) {
            ValidationUtil.validateMetaDataDto(dto);
        }
    }

    public static void validateMetaDataDto(MetaDataDto dto) throws InvalidMetaDataException {

        if(ObjectUtils.isEmpty(dto)) {
            throw new InvalidMetaDataException("Meta Data Cannot be Empty!!!");
        }

        if(StringUtils.isEmpty(dto.getTitle())) {
            throw new InvalidMetaDataException("Meta Data Title Cannot be Empty!!!");
        }

        if(StringUtils.isEmpty(dto.getType())) {
            throw new InvalidMetaDataException("Meta Data Type Cannot be Empty!!!");
        }

        if(!MetaDataTypeEnum.TEXT.toString().toLowerCase().equals(dto.getType())
                && !MetaDataTypeEnum.NUMBER.toString().toLowerCase().equals(dto.getType())) {
            throw new InvalidMetaDataException("Meta Data Type Should be either Text or Number!!!");
        }
    }

    public static void validateMetaDataValuesList(List<MetaDataValuesDto> dtos) throws InvalidMetaDataValueException {
        for(MetaDataValuesDto dto: dtos) {
            validateMetaDataValues(dto);
        }
    }

    public static void validateMetaDataValues(MetaDataValuesDto dto) throws InvalidMetaDataValueException {
        if(StringUtils.isEmpty(dto.getValue())) {
            throw new InvalidMetaDataValueException("Meta Data Field Value cannot be empty");
        }
    }

    public static void validateSaveFileDto(SaveFileDto saveFileDto) throws InvalidSaveFileException {
        if(ObjectUtils.isEmpty(saveFileDto)) {
            throw new InvalidSaveFileException("Save file request cannot be Empty!!!");
        }

        if(ObjectUtils.isEmpty(saveFileDto.getFile())) {
            throw new InvalidSaveFileException("File cannot be Empty!!!");
        }

        if(ObjectUtils.isEmpty(saveFileDto.getMetaDataValues())) {
            throw new InvalidSaveFileException("Meta Data Field Values are not available!!!");
        }

        if(ObjectUtils.isEmpty(saveFileDto.getMetaDataId())) {
            throw new InvalidSaveFileException("No Matching MetaData found for given metaData Id!!!");
        }
    }
}
