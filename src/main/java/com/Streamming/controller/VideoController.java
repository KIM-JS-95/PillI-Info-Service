package com.Streamming.controller;

import com.Streamming.Entity.Video;
import com.Streamming.Entity.VideoRepository;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.UrlResource;
import org.springframework.core.io.support.ResourceRegion;
import org.springframework.data.domain.Sort;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import static java.rmi.server.LogStream.log;

@Controller
@Slf4j
public class VideoController {
    Logger logger = LoggerFactory.getLogger(this.getClass());
    // private String url = "보여줄 비디오 url 경로";

    @Autowired
    private VideoRepository videoRepository;

    // like 크기 순으로 동영상 표시
    @GetMapping("/")
    public String home_list(Model model) throws IOException {


        List<Video> vods = videoRepository.findAll(Sort.by(Sort.Direction.DESC, "like"));
        Video vod = vods.get(0);
        log.info("로그: 비디오 크기 출력:" + vods.size());

        model.addAttribute("Vod", vod);
        model.addAttribute("VodList", vods);
        return "index";
    }


    @GetMapping("/search")
    public String search() {
        return "Search";
    }


    @GetMapping("/SearchPlayer")
    public String test() {
        return "SearchPlayer";
    }


    // 영상을 송출하는 것보다는 url을 넘겨주고 html에서 처리하는 것이
    // 타이틀 검색
    @GetMapping(value = "/video/search")
    public String search2(
            @RequestParam(value = "title") String name, Model model) throws IOException {


        List<Video> vod = videoRepository.findByTitleContaining(name);

        //String path = vod.getPath();
        //log.info("로그: 비디로 경로 출력:" + path);

        model.addAttribute("search", vod);
        return "SearchPlayer";
    }


    //타이틀 전체 출력 //이미지를 보여주고 링크를 태우는 방식으로 하는 것이 현명
//    @GetMapping(value = "/video")
//    public ResponseEntity<ResourceRegion> list(@RequestHeader HttpHeaders headers, Model model) throws IOException {
//        List<Video> vod = videoRepository.findAll();
//        ResourceRegion resourceRegion;
//
//
//
//                UrlResource video = new UrlResource("file:" + url);
//                final long chunkSize = 1000000L;
//                long contentLength = video.contentLength();
//
//                Optional<HttpRange> optional = headers.getRange().stream().findFirst();
//                HttpRange httpRange;
//
//
//                if (optional.isPresent()) {
//                    httpRange = optional.get();
//                    long start = httpRange.getRangeStart(contentLength);
//                    long end = httpRange.getRangeEnd(contentLength);
//                    long rangeLength = Long.min(chunkSize, end - start + 1);
//                    resourceRegion = new ResourceRegion(video, start, rangeLength);
//                } else {
//                    long rangeLength = Long.min(chunkSize, contentLength);
//                    resourceRegion = new ResourceRegion(video, 0, rangeLength);
//                }
//
//
//        return ResponseEntity
//                .status(HttpStatus.PARTIAL_CONTENT)
//                .contentType(MediaTypeFactory.getMediaType(video)
//                        .orElse(MediaType.APPLICATION_OCTET_STREAM))
//                .body(resourceRegion));
//    }


}
