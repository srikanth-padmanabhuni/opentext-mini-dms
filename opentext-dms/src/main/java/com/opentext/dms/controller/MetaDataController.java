package com.opentext.dms.controller;

import com.opentext.dms.dto.SaveMetaDataDto;
import com.opentext.dms.service.MetaDataService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/metadata")
public class MetaDataController {

    public Logger LOG = LoggerFactory.getLogger(MetaDataController.class);

    @Autowired
    private MetaDataService metaDataService;

    @PostMapping(path = "/save")
    public ResponseEntity<?> saveMetaData(@RequestBody SaveMetaDataDto saveMetaDataDto) {
        LOG.info("saveMetaData is called");
        try {
            Long id = metaDataService.saveMetaData(saveMetaDataDto);
            return ResponseEntity.ok().body("Meta Data Saved Successfully with Id : " + id);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
