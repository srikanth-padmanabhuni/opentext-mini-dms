package com.opentext.dms.dto;

import lombok.Data;

import java.util.List;

@Data
public class SaveMetaDataDto {

    Long id;

    List<MetaDataDto> metaData;
}
