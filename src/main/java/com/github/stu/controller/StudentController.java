package com.github.stu.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.github.stu.dao.AoData;
import com.github.stu.model.DataDic;
import com.github.stu.model.Student;
import com.github.stu.service.DataDicService;
import com.github.stu.service.StudentService;
import com.github.stu.vo.StudentQueryParam;

/**
 * Author:chyl2005
 * Date:17/2/3
 * Time:19:40
 * Desc:描述该类的作用
 */

@Controller
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;
    @Autowired
    private DataDicService dataDicService;

    @RequestMapping("/showPage")
    public String showPage(Integer studentId,Model model) {
        Student student = this.studentService.findById(studentId);
        model.addAttribute("student",student);
        model.addAttribute("mainPage", "student/studentShow");
        return "main";
    }


    @RequestMapping("/savePage")
    public String savePage(Integer studentId,Model model) {
        Student student = this.studentService.findById(studentId);
        List<DataDic> nationDataDicList = dataDicService.getNationList();
        List<DataDic> sexDataDicList = dataDicService.getSexList();
        List<DataDic> zzmmDataDicList = dataDicService.getZzmmDataDicList();
        model.addAttribute("sexDataDicList",sexDataDicList);
        model.addAttribute("nationDataDicList",nationDataDicList);
        model.addAttribute("zzmmDataDicList",zzmmDataDicList);
        model.addAttribute("student",student);
        model.addAttribute("mainPage", "student/studentSave");
        return "main";
    }

    @RequestMapping("/list")
    @ResponseBody
    public AoData list(StudentQueryParam query) {
        return this.studentService.findStudentPage(query);
    }

    @RequestMapping("/findById")
    @ResponseBody
    public Student findById(Integer studentId) {
        Student student = this.studentService.findById(studentId);
        return student;
    }

    @RequestMapping("/save")
    @ResponseBody
    public Student saveEntity(Student student) {
        this.studentService.saveEntity(student);
        return student;
    }

    @RequestMapping("/update")
    @ResponseBody
    public Student updateEntity(Student student) {
        this.studentService.updateEntity(student);
        return student;
    }

    @RequestMapping("/delete")
    @ResponseBody
    public Student deleteEntity(Integer studentId) {
        Student student = this.studentService.deleteEntity(studentId);
        return student;
    }

}
