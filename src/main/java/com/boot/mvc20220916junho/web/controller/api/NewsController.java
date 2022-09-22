package com.boot.mvc20220916junho.web.controller.api;

import com.boot.mvc20220916junho.web.dto.AddNewReqDto;
import com.boot.mvc20220916junho.web.dto.CMRespDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
public class NewsController {

    @PostMapping("/api/news")
    public ResponseEntity<?> addNews(AddNewReqDto addNewReqDto) {

        log.info("{}", addNewReqDto);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("title", addNewReqDto.getTitle());
        map.put("broadcastingName", addNewReqDto.getBroadcastingName());
        map.put("content", addNewReqDto.getContent());

        List<String> fileNameList = new ArrayList<String>();
        addNewReqDto.getFiles().forEach((file) -> {
            fileNameList.add(file.getOriginalFilename());
        });
        map.put("fileNames", fileNameList);

        return ResponseEntity.ok(new CMRespDto<>(1, "뉴스 등록 완료", map));
    }
}
