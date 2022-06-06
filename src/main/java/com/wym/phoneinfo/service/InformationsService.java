package com.wym.phoneinfo.service;

import com.wym.phoneinfo.pojo.Informations;

import java.util.Date;
import java.util.List;

public interface InformationsService {

    //查询全部
    List<Informations> findInformationList();
    //根据id查询
    Informations findinformationById( Long id);
    //根据id修改查看次数
    int updateInfoCount( Long id);
    //修改回复次数
    int updateInfoReplyCount( Long id, Date lastPostTime);
}
