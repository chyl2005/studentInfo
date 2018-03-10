package com.github.stu.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.github.stu.dao.AoData;
import com.github.stu.model.DataDic;
import com.github.stu.model.DataDicType;
import com.github.stu.service.DataDicService;
import com.github.stu.service.DataDicTypeService;

/**
 * Author:chyl2005
 * Date:17/2/3
 * Time:17:12
 * Desc:描述该类的作用
 */

@Controller
@RequestMapping("/dataDic")
public class DataDicController {

    @Autowired
    private DataDicService dataDicService;

    @Autowired
    private DataDicTypeService dataDicTypeService;

    @RequestMapping("/dataDicListPage")
    public String dataDicListPage(Model model) {
        model.addAttribute("mainPage", "class/classList");
        List<DataDic> dataDics = this.dataDicService.findAllDataDics();
        model.addAttribute("dataDics", dataDics);
        return "main";
    }

    @RequestMapping("/dataDicSavePage")
    public String dataDicSavePage(Model model, Integer ddId) {
        model.addAttribute("mainPage", "class/clasSave");
        DataDic dataDic = this.dataDicService.findById(ddId);
        model.addAttribute("dataDic", dataDic);
        List<DataDicType> dataDicTypes = dataDicTypeService.findAllDataDicTypes();
        model.addAttribute("dataDicTypeList", dataDicTypes);
        return "main";
    }

    @RequestMapping("/list")
    @ResponseBody
    public AoData list(String ddTypeName){
        return  dataDicService.list(ddTypeName);
    }




    @RequestMapping("/getSexList")
    @ResponseBody
    public List<DataDic> getSexList() {
        return this.dataDicService.getSexList();
    }

    @RequestMapping("/getNationList")
    @ResponseBody
    public List<DataDic> getNationList() {
        return this.dataDicService.getNationList();
    }

    @RequestMapping("/findById")
    @ResponseBody
    public DataDic findById(Integer gradeId) {
        return dataDicService.findById(gradeId);
    }

    @RequestMapping("/dataDicList")
    @ResponseBody
    public List<DataDic> dataDicList() {
        return this.dataDicService.findAllDataDics();
    }

    @RequestMapping("/save")
    @ResponseBody
    public DataDic saveEntity(DataDic dataDic) {
        return dataDicService.saveEntity(dataDic);
    }

    @RequestMapping("/update")
    @ResponseBody
    public DataDic updateEntity(DataDic dataDic) {
        return dataDicService.updateEntity(dataDic);
    }

    @RequestMapping("/delete")
    @ResponseBody
    public DataDic deleteEntity(Integer ddId) {
        return dataDicService.deleteEntity(ddId);
    }

}
