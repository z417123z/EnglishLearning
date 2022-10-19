package com.lzq.web.controller;


import com.github.pagehelper.PageInfo;
import com.lzq.domain.Memory;
import com.lzq.domain.Word;
import com.lzq.service.IMemoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/memory")
public class MemoryController {
    @Autowired
    IMemoryService memoryService;

    /**
     * 已加入单词列表
     *
     * @param page
     * @param rows
     * @param session
     * @param word
     * @return
     */
    @RequestMapping("/list")
    public ModelAndView list(@RequestParam(required = false, defaultValue = "1") int page,
                             @RequestParam(required = false, defaultValue = "20") int rows,
                             HttpSession session, Word word) {
        ModelAndView mv = new ModelAndView("/memory/forget_words_list");
        int userId = (Integer) session.getAttribute("userId");
        List<Word> wordList = memoryService.queryForgetWords(userId);
        mv.addObject("pageInfo", new PageInfo<Word>(wordList));
        mv.addObject("queryParam", word);
        mv.addObject("page", page);
        mv.addObject("rows", rows);
        return mv;
    }

    /**
     * 从列表中删除单词
     *
     * @param wordId
     * @param session
     * @return
     */
    @RequestMapping("/delete")
    public ModelAndView delete(@RequestParam("wordId") int wordId,
                               HttpSession session) {
        ModelAndView mv = new ModelAndView("redirect:/memory/list");
        int userId = (Integer) session.getAttribute("userId");
        memoryService.delete(userId, wordId);
        return mv;
    }

    @RequestMapping("/deleteFromTest")
    public ModelAndView deleteFromTest(@RequestParam("wordId") int wordId,
                                       HttpSession session) {
        ModelAndView mv = new ModelAndView("redirect:/memory/test");
        int userId = (Integer) session.getAttribute("userId");
        memoryService.delete(userId, wordId);
        return mv;
    }

    /**
     * 单词总表中添加单词
     *
     * @param wordId
     * @param session
     * @param memory
     * @return
     */
    @RequestMapping("/add")
    public @ResponseBody String add(@RequestParam("wordId") int wordId,
                                    HttpSession session, Memory memory) {
        int userId = (Integer) session.getAttribute("userId");
        memory.setWordId(wordId);
        memory.setUserId(userId);
        String msg = "true";
        List<Memory> memoryList = memoryService.queryByUserIdWordId(userId, wordId);
        if (null != memoryList && !memoryList.isEmpty()) {
            msg = "error";
        } else {
            memoryService.add(memory);
        }
        return msg;
    }


    /**
     * 我的单词的自测
     * @param page
     * @param rows
     * @param session
     * @param word
     * @return
     * @throws Exception
     */
    @RequestMapping("/test")
    public ModelAndView test(@RequestParam(required = false, defaultValue = "1") int page,
                             @RequestParam(required = false, defaultValue = "20") int rows,
                             HttpSession session, Word word) throws Exception {
        ModelAndView mv = new ModelAndView("/memory/forget_words_test");
        int userId = (Integer) session.getAttribute("userId");
        List<Word> wordList = memoryService.queryForgetWords(userId);
        mv.addObject("pageInfo", new PageInfo<Word>(wordList));
        mv.addObject("queryParam", word);
        mv.addObject("page", page);
        mv.addObject("rows", rows);
        return mv;
    }
}
