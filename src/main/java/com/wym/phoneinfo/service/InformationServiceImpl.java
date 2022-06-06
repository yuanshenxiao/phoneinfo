package com.wym.phoneinfo.service;

import com.wym.phoneinfo.dao.InformationsMapper;
import com.wym.phoneinfo.pojo.Informations;
import com.wym.phoneinfo.utils.RedisUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
@Service
public class InformationServiceImpl implements InformationsService{

    @Resource
    private InformationsMapper informationsMapper;

    @Resource
    private RedisUtil redisUtil;

    @Override
    public List<Informations> findInformationList() {
        return informationsMapper.findInformationList();
    }

    @Override
    public Informations findinformationById(Long id) {
        Informations info=null;
        if(redisUtil.getRedisTemplate("info:"+id)!=null){
            System.out.println("从缓存中获取");
            info=(Informations)redisUtil.getRedisTemplate("info:"+id);
        }else{
            System.out.println("从数据库中获取");
            info=informationsMapper.findinformationById(id);
            redisUtil.setRedisTemplate("info:"+id,info);
        }
        return info;
    }

    @Override
    public int updateInfoCount(Long id) {
        return informationsMapper.updateInfoCount(id);
    }

    @Override
    public int updateInfoReplyCount(Long id, Date lastPostTime) {
        return informationsMapper.updateInfoReplyCount(id,lastPostTime);
    }
}
