package io.oniasfilho.ufmtdrive.controller;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface FileController {
    public List<String> listUploadedFiles();
    public void handleFileUpload(MultipartFile file);
}
