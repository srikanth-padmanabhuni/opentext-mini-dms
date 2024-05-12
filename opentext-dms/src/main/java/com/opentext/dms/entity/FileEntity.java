package com.opentext.dms.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "File")
public class FileEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "fileName")
    private String fileName;

    @Lob
    @Column(name = "fileInfo")
    private byte[] fileInfo;

    @Column(name = "metaDataId")
    private Long metaDataId;

    @Column(name = "metaDataValueId")
    private Long metaDataValueId;

    @ManyToOne
    @JoinColumn(name = "metaDataId", referencedColumnName = "id", insertable = false, updatable = false)
    private MetaDataEntity metaData;

    @ManyToOne
    @JoinColumn(name = "metaDataValueId", referencedColumnName = "id", insertable = false, updatable = false)
    private MetaDataValuesEntity metaDataValues;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public byte[] getFileInfo() {
        return fileInfo;
    }

    public void setFileInfo(byte[] fileInfo) {
        this.fileInfo = fileInfo;
    }

    public Long getMetaDataId() {
        return metaDataId;
    }

    public void setMetaDataId(Long metaDataId) {
        this.metaDataId = metaDataId;
    }

    public Long getMetaDataValueId() {
        return metaDataValueId;
    }

    public void setMetaDataValueId(Long metaDataValueId) {
        this.metaDataValueId = metaDataValueId;
    }

    public MetaDataEntity getMetaData() {
        return metaData;
    }

    public void setMetaData(MetaDataEntity metaData) {
        this.metaData = metaData;
    }

    public MetaDataValuesEntity getMetaDataValues() {
        return metaDataValues;
    }

    public void setMetaDataValues(MetaDataValuesEntity metaDataValues) {
        this.metaDataValues = metaDataValues;
    }

    @Override
    public String toString() {
        return "FileEntity{" +
                "id=" + id +
                ", fileName='" + fileName + '\'' +
                ", fileInfo='" + fileInfo + '\'' +
                ", metaDataId=" + metaDataId +
                ", metaDataValueId=" + metaDataValueId +
                ", metaData=" + metaData +
                ", metaDataValues=" + metaDataValues +
                '}';
    }
}
