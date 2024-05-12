package com.opentext.dms.controller;

import com.opentext.dms.dto.SaveFileDto;
import com.opentext.dms.service.FileService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/file")
public class FileController {

    public Logger LOG = LoggerFactory.getLogger(FileController.class);

    @Autowired
    private FileService fileService;



    @PostMapping(path = "/save")
    public ResponseEntity<?> saveFileWithMetaData(
            @RequestPart(value = "file", required = true) MultipartFile file,
            @RequestPart(value = "metaData", required = true) SaveFileDto saveFileDto) {
        LOG.info("saveFileWithMetaData is called");
        try {
            saveFileDto.setFile(file);
            Long id = fileService.saveFileWithData(saveFileDto);
            return ResponseEntity.ok().body("File Saved with Meta Data Successfully with Id : " + id);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
