package com.wym.phoneinfo.service;

import com.wym.phoneinfo.pojo.Informations;
import com.wym.phoneinfo.pojo.Replies;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface RepliesService {


    //根据资讯id查询回复
    List<Replies> findRepliesByInfoId(Long infoId);

    //添加回复
    int insertReplies(Replies replies);
}
