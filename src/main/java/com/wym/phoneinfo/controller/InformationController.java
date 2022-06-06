package com.wym.phoneinfo.controller;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wym.phoneinfo.pojo.Informations;
import com.wym.phoneinfo.pojo.Replies;
import com.wym.phoneinfo.service.InformationsService;
import com.wym.phoneinfo.service.RepliesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class InformationController {
    @Autowired
    private InformationsService informationsService;

    @Resource
    private RepliesService repliesService;

    @RequestMapping(value="/index.action",method = RequestMethod.POST)
    @ResponseBody
    public Object toInformations(Integer pageNum){
        if(pageNum==null){
            pageNum=1;
        }
        PageHelper.startPage(pageNum,2,true);
        List<Informations> infoList=informationsService.findInformationList();
        PageInfo<Informations> pageInfo=new PageInfo<>(infoList);
        Map<String,Object> resultMap=new HashMap<>();
        resultMap.put("pageInfo",pageInfo);
        String json= JSON.toJSONStringWithDateFormat(resultMap,"yyyy-MM-dd HH:mm-ss");
        return json;
    }
    @RequestMapping(value="/addReplies.action",method = RequestMethod.POST)
    @ResponseBody
    public Object addReplies(Replies replies){
        Map<String,Object> resultMap=new HashMap<>();
        replies.setReplyTime(new Date());
        int num=repliesService.insertReplies(replies);
        if(num>0){
            informationsService.updateInfoReplyCount(replies.getInfoId(),new Date());
            resultMap.put("flag","success");
            resultMap.put("replies",replies);
        }else{
            resultMap.put("flag","fail");
        }
        String json= JSON.toJSONStringWithDateFormat(resultMap,"yyyy-MM-dd HH:mm-ss");
        return json;
    }


    @Transactional()
    @RequestMapping(value="/detail.action",method = RequestMethod.POST)
    @ResponseBody
    public Object toInfoandReplies(Long id){
        Informations info=informationsService.findinformationById(id);
        List<Replies> rlist=repliesService.findRepliesByInfoId(id);
        int num=informationsService.updateInfoCount(id);
        Map<String,Object> resultMap=new HashMap<>();
        resultMap.put("info",info);
        resultMap.put("rlist",rlist);
        String json= JSON.toJSONStringWithDateFormat(resultMap,"yyyy-MM-dd HH:mm-ss");
        return json;
    }
}
