package com.opentext.dms.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "MetaDataValues")
public class MetaDataValuesEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "metaDataId")
    private Long metaDataId;

    @Column(columnDefinition = "text")
    private String metaDataValues;

    @ManyToOne
    @JoinColumn(name = "metaDataId", referencedColumnName = "id", insertable = false, updatable = false)
    private MetaDataEntity metaData;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMetaDataId() {
        return metaDataId;
    }

    public void setMetaDataId(Long metaDataId) {
        this.metaDataId = metaDataId;
    }

    public String getMetaDataValues() {
        return metaDataValues;
    }

    public void setMetaDataValues(String metaDataValues) {
        this.metaDataValues = metaDataValues;
    }

    public MetaDataEntity getMetaData() {
        return metaData;
    }

    public void setMetaData(MetaDataEntity metaData) {
        this.metaData = metaData;
    }

    @Override
    public String toString() {
        return "MetaDataValues{" +
                "id=" + id +
                ", metaDataId=" + metaDataId +
                ", metaDataValues='" + metaDataValues + '\'' +
                ", metaData=" + metaData +
                '}';
    }
}
