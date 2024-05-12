package com.opentext.dms.entity;

import com.opentext.dms.dto.MetaDataValuesDto;

import java.util.List;

public class MetaDataValueEntityDto {
    private List<MetaDataValuesDto> meteDataValues;

    public List<MetaDataValuesDto> getMeteDataValues() {
        return meteDataValues;
    }

    public void setMeteDataValues(List<MetaDataValuesDto> meteDataValues) {
        this.meteDataValues = meteDataValues;
    }
}
