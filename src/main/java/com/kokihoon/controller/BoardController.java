package main.java.com.kokihoon.controller;

import java.util.List;
import java.util.Map;

import javax.activation.CommandMap;
import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import main.java.com.kokihoon.model.param.BoardVO;
import main.java.com.kokihoon.service.BoardService;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	@Autowired
    BoardService boardServcie;
    
    @RequestMapping(value="/list")
    public ModelAndView list() throws Exception {
        
    	List<BoardVO> list = boardServcie.listAll();
        ModelAndView mav = new ModelAndView("/board/list");
        
        mav.addObject("list", list);
        
        return mav;
        
    }
    
    @RequestMapping(value="/write", method=RequestMethod.GET)
    public String write() {
    	return "board/write";
    }
    
    @RequestMapping(value="/write", method=RequestMethod.POST)
    public String write(@ModelAttribute BoardVO vo) throws Exception {
    	boardServcie.create(vo);
    	
    	return "redirect:/board/list";
    }
    
    @RequestMapping(value="/read", method=RequestMethod.GET)
    public String read(@RequestParam("articleNo") int articleNo, Model model) throws Exception {
    	
    	BoardVO boardVO = boardServcie.read(articleNo);
    	System.out.println(boardVO);

    	model.addAttribute("boardVO", boardVO);
    	return "board/read";
    }
 	
}
