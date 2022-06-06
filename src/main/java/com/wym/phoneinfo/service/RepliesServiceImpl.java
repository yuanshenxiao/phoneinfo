package com.wym.phoneinfo.service;

import com.wym.phoneinfo.dao.RepliesMapper;
import com.wym.phoneinfo.pojo.Replies;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class RepliesServiceImpl implements RepliesService {

    @Resource
    private RepliesMapper repliesMapper;


    @Override
    public List<Replies> findRepliesByInfoId(Long infoId) {
        return repliesMapper.findRepliesByInfoId(infoId);
    }

    @Override
    public int insertReplies(Replies replies) {
        return repliesMapper.insertReplies(replies);
    }
}
