package com.opentext.dms.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "MetaData")
public class MetaDataEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "text")
    private String metadata;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMetadata() {
        return metadata;
    }

    public void setMetadata(String metadata) {
        this.metadata = metadata;
    }


    @Override
    public String toString() {
        return "MetaDataEntity{" +
                "id=" + id +
                ", metadata='" + metadata + '\'' +
                '}';
    }
}