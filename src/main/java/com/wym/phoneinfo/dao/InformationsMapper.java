package com.wym.phoneinfo.dao;

import com.wym.phoneinfo.pojo.Informations;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface InformationsMapper {

    //查询全部
    List<Informations> findInformationList();
    //根据id查询
    Informations findinformationById(@Param("id") Long id);
    //根据id修改查看次数
    int updateInfoCount(@Param("id") Long id);
    //修改回复次数
    int updateInfoReplyCount(@Param("id") Long id, @Param("lastPostTime")Date lastPostTime);
}
