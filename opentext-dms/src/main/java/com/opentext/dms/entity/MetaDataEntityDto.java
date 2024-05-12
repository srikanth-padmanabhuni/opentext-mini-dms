package com.opentext.dms.entity;

import com.opentext.dms.dto.MetaDataDto;

import java.util.List;

public class MetaDataEntityDto {

    private List<MetaDataDto> metaData;

    public List<MetaDataDto> getMetaData() {
        return metaData;
    }

    public void setMetaData(List<MetaDataDto> metaData) {
        this.metaData = metaData;
    }
}
