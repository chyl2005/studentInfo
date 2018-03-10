package com.github.stu.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.github.stu.model.Grade;
import com.github.stu.service.GradeService;

/**
 * Author:chyl2005
 * Date:17/2/3
 * Time:16:51
 * Desc:描述该类的作用
 */

@Controller
@RequestMapping("/grade")
public class GradeController {

    @Autowired
    private GradeService gradeService;



    @RequestMapping("/gradeListPage")
    public String gradeListPage(Model model) {
        model.addAttribute("mainPage", "class/classList");
        List<Grade> allGrades = this.gradeService.findAllGrades();
        model.addAttribute("gradeList", allGrades);
        return "main";
    }


    @RequestMapping("/gradeSavePage")
    public String gradeSavePage(Model model, Integer gradeId) {
        model.addAttribute("mainPage", "grade/gradeSave");
        Grade grade = this.gradeService.findById(gradeId);
        model.addAttribute("grade",grade);
        return "main";
    }


    @RequestMapping("/findById")
    @ResponseBody
    public Grade findById(Integer gradeId) {
        return gradeService.findById(gradeId);
    }

    @RequestMapping("/findAllGrades")
    @ResponseBody
    public List<Grade> findAllGrades() {
        return this.gradeService.findAllGrades();
    }

    @RequestMapping("/save")
    @ResponseBody
    public Grade saveEntity(Grade grade) {
        return gradeService.saveEntity(grade);
    }

    @RequestMapping("/update")
    @ResponseBody
    public Grade updateEntity(Grade grade) {
        return gradeService.updateEntity(grade);
    }

    @RequestMapping("/delete")
    @ResponseBody
    public Grade deleteEntity(Integer gradeId) {
        return gradeService.deleteEntity(gradeId);
    }

}
