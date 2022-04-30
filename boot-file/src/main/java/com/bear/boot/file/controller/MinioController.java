package com.bear.boot.file.controller;

import com.bear.boot.file.utils.MinioTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

/**
 * @program: IntelliJ IDEA
 * @description:
 * @author: bear
 * @create: 2022-04-15 13:25
 **/
@RestController
public class MinioController {
    @Resource
    private MinioTemplate minioTemplate;

    @PostMapping("/create/bucket")
    String create(String bucketName) {
        try {
            minioTemplate.makeBucket(bucketName);
        }catch (Exception e){
            e.printStackTrace();
            return "创建失败";
        }
        return "创建成功";
    }

    @PostMapping("/put/object")
    String putObject(MultipartFile uploadFile, @RequestParam String bucketName) {
        String originalFilename = uploadFile.getOriginalFilename();
        try {
            minioTemplate.putObject(bucketName, originalFilename, uploadFile.getInputStream());
        }catch (Exception e) {
            System.out.println(e);
            return "上传失败";
        }
        return "上传成功";
    }

    @PostMapping("/delete/object")
    String deleteObject(String fileName,String bucketName){
        try{
            minioTemplate.removeObject(bucketName,fileName);
        }catch (Exception e){
            e.printStackTrace();
            return "删除失败";
        }
        return "删除成功";
    }
}
