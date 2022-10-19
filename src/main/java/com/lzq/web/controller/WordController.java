package com.lzq.web.controller;

import com.github.pagehelper.PageInfo;
import com.lzq.domain.BookWord;
import com.lzq.domain.Bookshelf;
import com.lzq.domain.Word;
import com.lzq.service.IBookshelfService;
import com.lzq.service.IUserService;
import com.lzq.service.IWordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping(value = "/word")
public class WordController {
    @Autowired
    IWordService wordService;
    @Autowired
    IUserService userService;
    @Autowired
    IBookshelfService bookshelfService;

    /**
     * 单词总表
     * @param page
     * @param rows
     * @param word
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/list")
    public ModelAndView list(@RequestParam(required = false, defaultValue = "1") int page,
                             @RequestParam(required = false, defaultValue = "10") int rows,
                             Word word) throws Exception {
        ModelAndView mv = new ModelAndView("word/word_list");
        List<Word> wordList = wordService.queryAllWords(word, page, rows);
        mv.addObject("pageInfo", new PageInfo<Word>(wordList));
        mv.addObject("queryParam", word);
        mv.addObject("page", page);
        mv.addObject("rows", rows);
        return mv;
    }

    /**
     * 添加单词
     * @param word
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/add")
    public String add(Word word) throws Exception {
        // 保存到数据库
        wordService.insertWord(word);
        return "redirect:/admin/list";
    }

    /**
     * 跳转到更新单词页面
     * @param id
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/toUpdateWord")
    public ModelAndView toUpdateWord(@RequestParam("id") int id) throws Exception{
        ModelAndView mv = new ModelAndView("word/word_update");
        Word word = wordService.queryWordById(id);
        mv.addObject("word", word);
        return mv;
    }

    /**
     * 更新单词
     * @param word
     * @param id
     * @return
     * @throws Exception
     */
    @RequestMapping("updateWord")
    public ModelAndView updateWord(Word word ,@RequestParam("id") int id) throws Exception{
        ModelAndView mv = new ModelAndView("redirect:/word/list");
        wordService.updateWord(word);
        return mv;
    }

    /**
     * 用户查看书中的单词列表
     * @param rows
     * @param bookId
     * @param word
     * @param session
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/userWords")
    public @ResponseBody ModelAndView userWords(@RequestParam(defaultValue = "10", required = false, value = "rows") int rows,
                                                @RequestParam("bookId") int bookId,
                                                Word word, HttpSession session) throws Exception {
        ModelAndView mv = new ModelAndView("word/user_word_list");
        int id = (Integer) session.getAttribute("userId");
        //查用户上次看到哪了
        Bookshelf bookshelf = bookshelfService.queryWordList(bookId, id);
        int page = bookshelf.getWordList();
        List<Word> wordList = wordService.queryWordList(word, page, rows, bookId);
        mv.addObject("pageInfo", new PageInfo<Word>(wordList));
        mv.addObject("queryParam", word);
        mv.addObject("page", page);
        mv.addObject("rows", rows);
        mv.addObject("bookId", bookId);
        return mv;
    }

    /**
     * 管理员查看的书中单词
     * @param rows
     * @param page
     * @param bookId
     * @param word
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/adminWords")
    public ModelAndView adminWords(@RequestParam(defaultValue = "10", required = false, value = "rows") int rows,
                                   @RequestParam(defaultValue = "1", required = false, value = "page") int page,
                                   @RequestParam("bookId") int bookId,
                                   Word word) throws Exception {
        ModelAndView mv = new ModelAndView("/word/admin_word_list");
        //书中单词列表查询
        List<Word> wordList = wordService.queryWordList(word, page, rows, bookId);
        mv.addObject("pageInfo", new PageInfo<Word>(wordList));
        mv.addObject("queryParam", word);
        mv.addObject("page", page);
        mv.addObject("rows", rows);
        mv.addObject("bookId", bookId);
        return mv;
    }

    /**
     * 管理员书中单词的搜索
     * @param rows
     * @param bookId
     * @param word
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/adminWordsQuery")
    public ModelAndView adminWordsQuery (@RequestParam(defaultValue = "10", required = false, value = "rows") int rows,
                                         @RequestParam(defaultValue = "1", required = false, value = "page") int page,
                                         @RequestParam("bookId") int bookId,
                                         @RequestParam("name") String name,
                                         Word word){
        ModelAndView mv = new ModelAndView("/word/admin_word_query_name");
        //name模糊查询
        List<Word> wordList = wordService.queryWordListByName(bookId, name ,page, rows);
        mv.addObject("pageInfo", new PageInfo<Word>(wordList));
        mv.addObject("queryParam", word);
        mv.addObject("page", page);
        mv.addObject("rows", rows);
        mv.addObject("bookId", bookId);
        mv.addObject("name", name);
        return mv;
    }

    /**
     * 用户的自测
     * @param rows
     * @param bookId
     * @param word
     * @param session
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/userWordTest")
    public @ResponseBody ModelAndView userWordTest(@RequestParam(defaultValue = "10", required = false, value = "rows") int rows,
                                                   @RequestParam("bookId") int bookId,
                                                   Word word, HttpSession session) throws Exception {
        ModelAndView mv = new ModelAndView("word/word_test");
        int id = (Integer) session.getAttribute("userId");
        //查用户上次看到哪了
        Bookshelf bookshelf = bookshelfService.queryWordList(bookId, id);
        int page = bookshelf.getWordList();
        List<Word> wordList = wordService.queryWordList(word, page, rows, bookId);
        mv.addObject("pageInfo", new PageInfo<Word>(wordList));
        mv.addObject("queryParam", word);
        mv.addObject("page", page);
        mv.addObject("rows", rows);
        mv.addObject("bookId", bookId);
        return mv;
    }


    /**
     * 跳转到添加单词页面
     * @param page
     * @param rows
     * @param name
     * @param bookId
     * @param word
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/toAddWords")
    public ModelAndView toAddWordsPage(@RequestParam(required = false, defaultValue = "1") int page,
                                       @RequestParam(required = false, defaultValue = "10") int rows,
                                       @RequestParam(required = false, value = "name", defaultValue = "") String name,
                                       @RequestParam("bookId") int bookId,
                                       Word word) throws Exception {
        ModelAndView mv = new ModelAndView("word/word_add_to_book");
        List<Word> wordList = wordService.queryWordByName(name, page, rows);
        mv.addObject("pageInfo", new PageInfo<Word>(wordList));
        mv.addObject("queryParam", word);
        mv.addObject("page", page);
        mv.addObject("rows", rows);
        mv.addObject("bookId", bookId);
        mv.addObject("name", name);
        return mv;
    }

    /**
     * 添加单词到书中
     * @param wordId
     * @param bookWord
     * @param bookId
     * @param word
     * @return
     */
    @RequestMapping("/addWord")
    public @ResponseBody String addWordToBook(@RequestParam("wordId") int wordId, BookWord bookWord,
                                              @RequestParam("bookId") int bookId, Word word) {
        String msg = "true";
        bookWord.setBookId(bookId);
        bookWord.setWordId(wordId);
        List<BookWord> bookWords = wordService.queryMidByBookIdWordId(bookId, wordId);
        if (null != bookWords && !bookWords.isEmpty()) {
            msg = "error";
        } else {
            wordService.add(bookWord);
        }

        return msg;
    }

    /**
     * 从书中删单词
     * @param bookId
     * @param wordId
     * @return
     */
    @RequestMapping("/deleteWord")
    public String deleteWordFromBook(@RequestParam("bookId") int bookId,
                                   @RequestParam("wordId") int wordId){
        String msg = "true";
        wordService.deleteWordFromBook(bookId, wordId);
        return msg;
    }


    /**
     * 跳转到添加单词页面
     * @return
     */
    @RequestMapping(value = "/toAdd")
    public String toAdd() {
        return "/word/word_add";
    }


    /**
     * 按单词名称查询
     * @param page
     * @param rows
     * @param name
     * @param word
     * @return
     */
    @RequestMapping(value = "/queryName")
    public ModelAndView queryName(@RequestParam(required = false, defaultValue = "1") int page,
                                  @RequestParam(required = false, defaultValue = "10") int rows,
                                  @RequestParam(value = "name") String name,
                                  Word word) {
        ModelAndView result = new ModelAndView("word/word_query");
        List<Word> wordList = wordService.queryWordByName(name, page, rows);
        result.addObject("pageInfo", new PageInfo<Word>(wordList));
        result.addObject("queryParam", word);
        result.addObject("page", page);
        result.addObject("rows", rows);
        result.addObject("name", name);
        return result;
    }

    /**
     * 用户的单词总表
     * @param page
     * @param rows
     * @param word
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/userAllWords")
    public ModelAndView userAllWords(@RequestParam(required = false, defaultValue = "1") int page,
                                     @RequestParam(required = false, defaultValue = "10") int rows,
                                     Word word, HttpSession session) throws Exception {
        ModelAndView mv = new ModelAndView("/word/user_allwords_list");
        int userId = (Integer) session.getAttribute("userId");
        List<Word> wordList = wordService.queryAllWords(word, page, rows);
        mv.addObject("pageInfo", new PageInfo<Word>(wordList));
        mv.addObject("queryParam", word);
        mv.addObject("page", page);
        mv.addObject("rows", rows);
        return mv;
    }

    /**
     * 用户查询单词总表
     * @param page
     * @param rows
     * @param name
     * @param word
     * @return
     */
    @RequestMapping(value = "/userQueryName")
    public ModelAndView userQueryName(@RequestParam(required = false, defaultValue = "1") int page,
                                      @RequestParam(required = false, defaultValue = "10") int rows,
                                      @RequestParam(value = "name") String name,
                                      Word word) {
        ModelAndView result = new ModelAndView("/word/user_allwords_query");
        List<Word> wordList = wordService.queryWordByName(name, page, rows);
        result.addObject("pageInfo", new PageInfo<Word>(wordList));
        result.addObject("queryParam", word);
        result.addObject("page", page);
        result.addObject("rows", rows);
        result.addObject("name", name);
        return result;
    }

    /**
     * 用户书中单词的翻页
     * @param page
     * @param rows
     * @param bookId
     * @param word
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/wordPage")
    public ModelAndView userWordPage(@RequestParam(required = false, defaultValue = "1") int page,
                                     @RequestParam(required = false, defaultValue = "10") int rows,
                                     @RequestParam("bookId") int bookId,
                                     Word word) throws Exception {
        ModelAndView mv = new ModelAndView("word/user_word_list_page");
        List<Word> wordList = wordService.queryWordList(word, page, rows, bookId);
        mv.addObject("pageInfo", new PageInfo<Word>(wordList));
        mv.addObject("queryParam", word);
        mv.addObject("page", page);
        mv.addObject("rows", rows);
        mv.addObject("bookId", bookId);
        return mv;
    }

    /**
     * 用户自测的翻页页面
     * @param page
     * @param rows
     * @param bookId
     * @param session
     * @param word
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/wordTestPage")
    public ModelAndView userTestPage(@RequestParam(required = false, defaultValue = "1") int page,
                                     @RequestParam(required = false, defaultValue = "10") int rows,
                                     @RequestParam("bookId") int bookId, HttpSession session,
                                     Word word) throws Exception {
        ModelAndView mv = new ModelAndView("word/word_test_page");
        int userId = (Integer) session.getAttribute("userId");
        //更新用户上次看到的地方
        bookshelfService.updateWordList(userId, bookId, page);
        List<Word> wordList = wordService.queryWordList(word, page, rows, bookId);
        mv.addObject("pageInfo", new PageInfo<Word>(wordList));
        mv.addObject("queryParam", word);
        mv.addObject("page", page);
        mv.addObject("rows", rows);
        mv.addObject("bookId", bookId);
        return mv;
    }
}
