package com.opentext.dms.dto;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Data
public class SaveFileDto {

    MultipartFile file;

    Long metaDataId;

    List<MetaDataValuesDto> metaDataValues;
}
