package com.github.stu.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.github.stu.dao.AoData;
import com.github.stu.model.Class;
import com.github.stu.model.Grade;
import com.github.stu.service.ClassService;
import com.github.stu.service.GradeService;

/**
 * Author:chyl2005
 * Date:17/2/3
 * Time:15:47
 * Desc:描述该类的作用
 */
@Controller
@RequestMapping("/class")
public class ClassController {

    @Autowired
    private ClassService classService;

    @Autowired
    private GradeService gradeService;

    @RequestMapping("/classListPage")
    public String classListPage(Model model) {
        model.addAttribute("mainPage", "class/classList");
        AoData page = this.classService.findPage();
        model.addAttribute("classList", page.getDatas());
        return "main";
    }

    @RequestMapping("/clasSavePage")
    public String clasSavePage(Model model, Integer classId) {
        model.addAttribute("mainPage", "class/clasSave");
        Class aClass = this.classService.findById(classId);
        model.addAttribute("c",aClass);
        List<Grade> gradeList = gradeService.findAllGrades();
        model.addAttribute("gradeList",gradeList);
        return "main";
    }

    @RequestMapping("/findById")
    @ResponseBody
    public Class findById(@RequestParam Integer classId) {
        return this.classService.findById(classId);
    }


    @RequestMapping("/getClassListByGrdeId")
    @ResponseBody
    public List<Class> getClassListByGrdeId(@RequestParam Integer gradeId){
        return this.classService.getClassListByGrdeId(gradeId);
    }
    /**
     * 分页查询
     *
     * @return
     */
    @RequestMapping("/classList")
    @ResponseBody
    public AoData classList() {
        return this.classService.findPage();
    }

    @RequestMapping("/save")
    @ResponseBody
    public Class saveEntity(Class cls) {
        return this.classService.saveEntity(cls);

    }

    @RequestMapping("/update")
    @ResponseBody
    public Class updateEntity(Class cls) {
        return this.classService.updateEntity(cls);
    }

}
