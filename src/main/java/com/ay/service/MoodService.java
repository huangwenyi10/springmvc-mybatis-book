package com.ay.service;

import com.ay.dto.MoodDTO;
import com.ay.model.Mood;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 描述：说说接口
 *
 * @author Ay
 * @date 2018/1/6.
 */
public interface MoodService {
    //传统查询
    List<MoodDTO> findAll();

    //传统点赞
    boolean praiseMood(String userId, String moodId);

    boolean update(@Param("mood") Mood mood);

    Mood findById(String id);

    boolean praiseMoodForRedis(String userId, String moodId);

    List<MoodDTO> findAllForRedis();
}
