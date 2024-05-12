package com.opentext.dms.utilities;

import com.google.gson.Gson;
import com.opentext.dms.dto.MetaDataDto;
import com.opentext.dms.dto.MetaDataValuesDto;
import com.opentext.dms.dto.SaveFileDto;
import com.opentext.dms.dto.SaveMetaDataDto;
import com.opentext.dms.entity.*;
import org.springframework.util.ObjectUtils;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class MappingUtil {

    public static MetaDataEntity mapDtoToEntity(SaveMetaDataDto saveMetaDataDto) {
        Gson gson = new Gson();

        for(MetaDataDto dto: saveMetaDataDto.getMetaData()) {
            if(ObjectUtils.isEmpty(dto.getId())) {
                dto.setId(System.currentTimeMillis());
            }
        }

        MetaDataEntityDto entityDto = new MetaDataEntityDto();
        entityDto.setMetaData(saveMetaDataDto.getMetaData());

        MetaDataEntity entity = new MetaDataEntity();
        entity.setMetadata(gson.toJson(entityDto));

        return entity;
    }

    public static MetaDataValuesEntity mapDtoToEntity(List<MetaDataValuesDto> dtos, Long metaDataId) {
        Gson gson = new Gson();

        MetaDataValueEntityDto entityDto = new MetaDataValueEntityDto();
        entityDto.setMeteDataValues(dtos);

        MetaDataValuesEntity entity = new MetaDataValuesEntity();
        entity.setMetaDataId(metaDataId);
        entity.setMetaDataValues(gson.toJson(entityDto));

        return entity;
    }

    public static FileEntity mapDtoToEntity(SaveFileDto saveFileDto, Long metaDataValuesId) throws IOException {
        FileEntity entity = new FileEntity();
        entity.setMetaDataId(saveFileDto.getMetaDataId());
        entity.setMetaDataValueId(metaDataValuesId);
        entity.setFileInfo(saveFileDto.getFile().getBytes());
        entity.setFileName(saveFileDto.getFile().getName());
        return entity;
    }
}
