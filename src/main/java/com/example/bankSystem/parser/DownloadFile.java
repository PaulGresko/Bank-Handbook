package com.example.bankSystem.parser;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class DownloadFile {

    public static File download() throws IOException {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<byte[]> response = restTemplate.getForEntity("http://www.cbr.ru/s/newbik", byte[].class);

        String tempFileName = "temp_" + System.currentTimeMillis() + ".zip";

        File tempFile = File.createTempFile(tempFileName, null);
        try (OutputStream outputStream = new FileOutputStream(tempFile)) {
            outputStream.write(response.getBody());
        }

        return tempFile;
    }

    public static File unzipFile(File zipFile) throws IOException {

        String tempDirectoryName = "temp_" + System.currentTimeMillis();


        File tempDirectory = Files.createTempDirectory(tempDirectoryName).toFile();

        try (ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream(zipFile))) {
            ZipEntry entry = zipInputStream.getNextEntry();
            while (entry != null) {
                if (!entry.isDirectory() && entry.getName().endsWith(".xml")) {
                    File extractedXmlFile = new File(tempDirectory, entry.getName());
                    Files.copy(zipInputStream, extractedXmlFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
                    return extractedXmlFile;
                }
                entry = zipInputStream.getNextEntry();
            }
        }

        return null;
    }

}
