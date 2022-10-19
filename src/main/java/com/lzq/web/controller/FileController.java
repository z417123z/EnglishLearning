package com.lzq.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;

@Controller
@RequestMapping("/file")
public class FileController {
    @RequestMapping("upload")
    public ModelAndView upload(HttpServletRequest request) {
        //进行转换
        MultipartHttpServletRequest mhsr = (MultipartHttpServletRequest) request;
        //获得请求上传的文件
        MultipartFile file = mhsr.getFile("file");
        //设置视图为JSON视图
        ModelAndView mv = new ModelAndView();
        mv.setView(new MappingJackson2JsonView());
        //获取原始文件名
        String fileName = file.getOriginalFilename();
        //目标文件
        File dest = new File(fileName);
        try {
            file.transferTo(dest);
            //保存成功
            mv.addObject("success", true);
            mv.addObject("msg", "上传文件成功");
        } catch (IllegalStateException | IOException e) {
            //保存失败
            mv.addObject("success", false);
            mv.addObject("msg", "上传文件失败");
            e.printStackTrace();
        }
        return mv;
    }


    //使用MultipartFile
    @RequestMapping("/uploadMultipartFile")
    public ModelAndView uploadMultipartFile(MultipartFile file, HttpSession session) {
        ModelAndView mv = new ModelAndView();
        mv.setView(new MappingJackson2JsonView());
        //获取原始文件名
        String fileName = file.getOriginalFilename();
        file.getContentType();
        //目标文件
        String leftPath = session.getServletContext().getRealPath("/resources/upload");
        System.out.println(leftPath);
        File dest = new File(leftPath, fileName);
        session.setAttribute("fileName", fileName);

        try {
            file.transferTo(dest);
            //保存成功
            mv.addObject("success", true);
            mv.addObject("msg", "上传文件成功");
        } catch (IllegalStateException | IOException e) {
            //保存失败
            mv.addObject("success", false);
            mv.addObject("msg", "上传文件失败");
            e.printStackTrace();
        }
        return mv;
    }

    @RequestMapping("firstUploadController")
    public String doFirst(MultipartFile uploadFile, HttpSession session) throws IllegalStateException, IOException {
        String filename = uploadFile.getOriginalFilename();

        String leftPath = session.getServletContext().getRealPath("/resources/upload");
        System.out.println(leftPath);
        File file = new File(leftPath, filename);

        uploadFile.transferTo(file);
        return "index";

    }

    //使用Part
    /*@RequestMapping("/uploadPart")
    public ModelAndView uploadPart(Part file) {
        ModelAndView mv = new ModelAndView();
        mv.setView(new MappingJackson2JsonView());
        //获取原始文件名
        String fileName = file.SubmittedFileName();
        File dest = new File(fileName);

        try {
            file.write("");
            //保存成功
            mv.addObject("success", true);
            mv.addObject("msg", "上传文件成功");
        } catch (IllegalStateException | IOException e) {
            //保存失败
            mv.addObject("success", false);
            mv.addObject("msg", "上传文件失败");
            e.printStackTrace();
        }
        return mv;
    }*/
}
