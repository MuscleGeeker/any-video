package me.musclegeeker.api;

import me.musclegeeker.bean.response.Episode;
import me.musclegeeker.bean.response.Video;
import me.musclegeeker.parse.Parser;
import me.musclegeeker.parse.ParserManager;
import me.musclegeeker.parse.video.Tencent;
import me.musclegeeker.tools.UrlUtils;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@AllArgsConstructor
public class VideoAPI {

    private final ParserManager parseManager;

    /**
     * 解析视频
     */
    @GetMapping("/api/video")
    public Video play(HttpServletRequest request) {
        String url = request.getParameter("v");
        url = url.replaceAll("\\?(spm|from).*", "");
        return (Video) parseManager.parse(url);
    }

    /**
     * 解析视频相关集数
     */
    @GetMapping("/api/episode")
    public List episodes(HttpServletRequest request) {
        String url = request.getParameter("v");
        url = url.replaceAll("\\?(spm|from).*", "");
        String key = UrlUtils.getTopDomain(url);
        Parser videoParse = parseManager.getParser(key);
        return videoParse.parseEpisodes(url);
    }

    /**
     * 解析腾讯视频片段
     */
    @GetMapping("/api/qq/{file}/{index}")
    public Episode qqVideo(@PathVariable("file") String fileName, @PathVariable("index") Integer index) {
        return ((Tencent) parseManager.getParser("v.qq.com")).parsePart(fileName, index);
    }

}
