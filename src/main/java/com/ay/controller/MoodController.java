package com.ay.controller;

import com.ay.dto.MoodDTO;
import com.ay.service.MoodService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Random;

/**
 * 描述：说说控制层
 *
 * @author Ay
 * @date 2018/1/6.
 */
@Controller
@RequestMapping("/mood")
public class MoodController {

    @Resource
    private MoodService moodService;

    @GetMapping(value = "/findAll")
    public String findAll(Model model) {
        List<MoodDTO> moodDTOList = moodService.findAll();
        model.addAttribute("moods", moodDTOList);
        return "mood";
    }

    @GetMapping(value = "/{moodId}/praise")
    public String praise(Model model, @PathVariable(value = "moodId") String moodId,
                         @RequestParam(value = "userId") String userId) {
        boolean isPraise = moodService.praiseMood(userId, moodId);

        List<MoodDTO> moodDTOList = moodService.findAll();
        model.addAttribute("moods", moodDTOList);
        model.addAttribute("isPraise", isPraise);
        return "mood";
    }

    @GetMapping(value = "/{moodId}/praiseForRedis")
    public String praiseForRedis(Model model, @PathVariable(value = "moodId") String moodId,
                                 @RequestParam(value = "userId") String userId) {
        //方便使用，随机生成用户id
        Random random = new Random();
        userId = random.nextInt(100) + "";

        boolean isPraise = moodService.praiseMoodForRedis(userId, moodId);
        //查询所有的说说数据
        List<MoodDTO> moodDTOList = moodService.findAllForRedis();
        model.addAttribute("moods", moodDTOList);
        model.addAttribute("isPraise", isPraise);
        return "mood";
    }
}
