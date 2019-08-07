package org.hello.controller;
import java.util.List;

import javax.annotation.Resource;
import javax.inject.Inject;
import org.hello.interceptor.*;
import javax.servlet.http.HttpServletRequest;

import org.hello.domain.BoardVO;
import org.hello.domain.Criteria;
import org.hello.domain.PageMaker;
import org.hello.domain.ReplyVO;
import org.hello.domain.SearchCriteria;
import org.hello.domain.UserVO;
import org.hello.service.BoardService;
import org.hello.service.ReplyService;
import org.hello.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/board/") //url占쏙옙청占쏙옙  /board/占쏙옙 占쏙옙占쏙옙占싹댐옙 占쏙옙占쏙옙 占쏙옙占썩서 처占쏙옙占싼댐옙. ex) board/abc , board/123 board/create
public class BoardController {
    @Inject
    private BoardService service;
    @Inject
    private ReplyService RepService;
   
    // create view �떎�뻾 
    @RequestMapping(value="/create",method=RequestMethod.GET)
    public void createGET(BoardVO board, Model model) throws Exception{
        System.out.println(" /board/create 입니다. GET방식");
        
    }
    // 寃뚯떆湲� �옉�꽦 post諛⑹떇
    @RequestMapping(value = "/create",method=RequestMethod.POST )
    public String createPOST(BoardVO board,Model model) throws Exception{
        System.out.println("/board/create POST방식입니다.");
        
        service.create(board);
        model.addAttribute("result","성공");
        return "redirect:/board/listAll";
    }

    

    // 寃뚯떆湲� �긽�꽭蹂닿린 諛⑸쾿1,2
    @RequestMapping(value = "/detail", method=RequestMethod.GET)
    public void detail(@RequestParam("b_no") int b_no, Model model, @ModelAttribute("scri") SearchCriteria scri) throws Exception{
        System.out.println(b_no+"踰� �럹�씠吏� �엯�땲�떎/ requestparam 諛⑹떇");
        model.addAttribute("detail", service.read(b_no));
        model.addAttribute("scri", scri);
        List<ReplyVO> repList = RepService.readReply(b_no);
        model.addAttribute("repList", repList);
    } // request濡� 遺��꽣 荑쇰━ b_no�뙆�씪誘명꽣瑜� 諛쏆븘�삤寃� �맖 
    
    @RequestMapping(value = "/{b_no}", method=RequestMethod.GET)
    public String detail2(@PathVariable("b_no") int b_no, Model model) throws Exception{
        System.out.println(b_no+"踰� �럹�씠吏� �엯�땲�떎/ pathvariable 諛⑹떇");
        model.addAttribute("detail", service.read(b_no));
        return "/board/detail";
    } //RequestMapping�쓽 url�뿉�꽌 {}紐낆떆�맂 蹂��닔瑜� 諛쏆븘�삩�떎
    // <a href='/board/detail/${boardVo.b_no}
    // 2媛쒖씠�긽 �뙆�씪誘명꽣 泥섎━ 媛��뒫 
    //�닔�젙 �뤌�쑝濡� �씠�룞
    @RequestMapping(value="/update/{b_no}", method=RequestMethod.GET)
    public String updateGet(@PathVariable("b_no") int b_no,Model model) throws Exception{
    	model.addAttribute("detail", service.read(b_no));
    	return "/board/update";
    }
    //�닔�젙�븯湲�
    @RequestMapping(value="/update/{b_no}", method= RequestMethod.POST)
    public String update(@PathVariable("b_no") int b_no,BoardVO vo) throws Exception{
    	System.out.println(b_no+"踰� 湲��씠 �닔�젙�릺�뿀�뒿�땲�떎");
    	service.update(vo);
    	return "redirect:/board/"+b_no;     // return�쓣 �벐吏��븡�뒗 �씠�쑀�뒗 return �궗�슜�떆 �뜲�씠�꽣媛� �븞蹂댁씤�떎, redirect �궗�슜�븳�떎 怨좊줈 
    }
    //�궘�젣�븯湲� 
    @RequestMapping(value="/delete/{b_no}")
    public String delete(@PathVariable("b_no") int b_no,BoardVO vo) throws Exception{
    	System.out.println(b_no+"踰� 湲��씠 �궘�젣�릺�뿀�뒿�땲�떎");
    	service.delete(b_no);
    	return "redirect:/board/listAll";
    }
    // ajax �뀒�뒪�듃 
    @RequestMapping(value = "/commentInsert" )
    @ResponseBody
    public String comment(@RequestParam String comment,@RequestParam String b_writer,HttpServletRequest httpRequest) throws Exception{
    	String writer = (httpRequest.getParameter("b_writer"));
    	System.out.println("ajax �뀒�뒪�듃 �엯�땲�떎");
    	System.out.println("getParameter諛⑹떇�쑝濡� 諛쏆� writer�� "+writer); // getParameter 諛⑹떇
    	System.out.println("@ReqeustParam諛⑹떇�쑝濡� 諛쏆� writer��" + b_writer); // requestParam諛⑹떇
    	
       BoardVO vo = new BoardVO();
       vo.setB_detail(comment);
       vo.setB_writer(b_writer);
       service.create(vo);
        return "redirect:/board/listAll";
    }
    @RequestMapping(value="/listAll", method=RequestMethod.GET)
    public void listAll(@ModelAttribute("cri") Criteria cri, Model model) throws Exception {
    	System.out.println("get list page");
    	List<BoardVO> list = service.listAll(cri);
    	model.addAttribute("boardList", list);
    	PageMaker pageMaker = new PageMaker();
    	pageMaker.setCri(cri);
    	pageMaker.setTotalCount(service.listCount());
    	model.addAttribute("pageMaker", pageMaker);
    }
    @RequestMapping(value = "/listSearch", method=RequestMethod.GET)
    public void listSearch(@ModelAttribute("scri") SearchCriteria scri, Model model) throws Exception {
    	System.out.println("get list search");
    	List<BoardVO> list = service.listSearch(scri);
    	model.addAttribute("boardlist", list);
    	PageMaker pageMaker = new PageMaker();
    	pageMaker.setCri(scri);
    	pageMaker.setTotalCount(service.countSearch(scri));
    	model.addAttribute("pageMaker", pageMaker);
    }
    @RequestMapping(value="/replyWrite", method=RequestMethod.POST)
    public String replyWrite(ReplyVO vo, SearchCriteria scri, RedirectAttributes rttr) throws Exception {
    	System.out.println("reply write");
    	RepService.writeReply(vo);
    	rttr.addAttribute("b_no", vo.getB_no());
    	rttr.addAttribute("page", scri.getPage());
    	rttr.addAttribute("perPageNum", scri.getPerPageNum());
    	rttr.addAttribute("searchType", scri.getSearchType());
    	rttr.addAttribute("keyword", scri.getKeyword());
    	return "redirect:/board/listAll";
    }
   
   
}

