package main.java.com.kokihoon.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.activation.CommandMap;
import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import main.java.com.kokihoon.common.Criteria;
import main.java.com.kokihoon.common.PageMaker;
import main.java.com.kokihoon.model.param.BoardVO;
import main.java.com.kokihoon.service.BoardService;

@Controller
@RequestMapping("/board")
public class BoardController {

	private static final Logger logger =LoggerFactory.getLogger(BoardController.class);
	
	@Autowired
    BoardService boardService;
    
    @RequestMapping(value="/list")
    public String list(Criteria cri, Model model,
    		@RequestParam(defaultValue="title") String searchOption,
    		@RequestParam(defaultValue="") String keyword) throws Exception {
        
    	logger.info(cri.toString());
    	
    	List<BoardVO> list = boardService.listAll(cri);
    	System.out.println(list);
        PageMaker pageMaker = new PageMaker(cri);
        pageMaker.setCri(cri);
        
        int totalCount = boardService.countArticle(cri);
        pageMaker.setTotalCount(totalCount);
        
        model.addAttribute("list", list);
        model.addAttribute("pageMaker", pageMaker);
        
        return "board/list";
        
    }
    
    @RequestMapping(value="/write", method=RequestMethod.GET)
    public String write() {
    	return "board/write";
    }
    
    @RequestMapping(value="/write", method=RequestMethod.POST)
    public String write(@ModelAttribute BoardVO vo) throws Exception {
    	boardService.create(vo);
    	
    	return "redirect:/board/list";
    }
    
    @RequestMapping(value="/read", method=RequestMethod.GET)
    public String read(@RequestParam("articleNo") int articleNo, Model model) throws Exception {
    	System.out.println(articleNo);
    	BoardVO boardVO = boardService.read(articleNo);
    	System.out.println(boardVO.getArticleNo());
    	System.out.println(boardVO.getTitle());

    	model.addAttribute("boardVO", boardVO);
    	return "board/read";
    }
    
    @RequestMapping(value="/update", method=RequestMethod.GET)
    public String update(@RequestParam("articleNo") int articleNo, Model model) throws Exception{
    	System.out.println(articleNo);
    	BoardVO boardVO = boardService.read(articleNo);
    	System.out.println(boardVO);
    	model.addAttribute("boardVO", boardVO);
    	
    	return "board/update";
    }
    
    @RequestMapping(value="/update", method=RequestMethod.POST)
    public String update(BoardVO vo) throws Exception {
    	boardService.update(vo);
    	
    	return "redirect:/board/list";
    }
 	

    @RequestMapping(value="/delete", method=RequestMethod.GET) 
    public String delete(@RequestParam int articleNo) throws Exception {
    	boardService.delete(articleNo);
    	
    	return "redirect:/board/list";
    }
}
