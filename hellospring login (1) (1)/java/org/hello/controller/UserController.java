package org.hello.controller;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hello.domain.UserVO;
import org.hello.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
@RequestMapping("/board/") //url占쏙옙청占쏙옙  /board/占쏙옙 占쏙옙占쏙옙占싹댐옙 占쏙옙占쏙옙 占쏙옙占썩서 처占쏙옙占싼댐옙. ex) board/abc , board/123 board/create
public class UserController {
    
    @Inject
    private UserService service;
    
    
    @RequestMapping(value="/signup",method=RequestMethod.GET)
    public void signup() throws Exception{
        System.out.println(" 회占쏙옙占쏙옙占쏙옙 占쏙옙 占쌉니댐옙");
        
    }
  
    @RequestMapping(value = "/signup",method=RequestMethod.POST )
    public String createPOST(UserVO user) throws Exception{
        
        service.createUserencrpyt(user);
       
        return "redirect:/board/login";


    }
    
    @RequestMapping(value="/user",method=RequestMethod.GET)
    public void userGET(Model model,UserVO vo) throws Exception{
        System.out.println(" /board/userpage �엯�땲�떎");

        
    }
    

 // 占싸깍옙占쏙옙 占쏙옙占쏙옙 占쏙옙占쏙옙 占싸븝옙

    @RequestMapping(value="/login",method=RequestMethod.GET)
    public void loginGET(UserVO board, Model model) throws Exception{
        System.out.println(" /board/login 占쌉니댐옙. GET占쏙옙占�");
        
    }
   

    // 占싸깍옙占쏙옙 처占쏙옙占싹댐옙 占싸븝옙

    @RequestMapping(value="/loginProcess",method=RequestMethod.POST)

    public String loginProcess(HttpSession session,UserVO dto,HttpServletRequest httpRequest) throws Exception{

        String returnURL = "";
       
        		

        if ( session.getAttribute("login") != null ){

            //留뚯빟 �씠誘� login�씠�씪�뒗 �꽭�뀡�씠 議댁옱�븳�떎硫�

            session.removeAttribute("login"); // �꽭�뀡�젣嫄� 

        }


        // 濡쒓렇�씤 �씤利앹쓣 �넻�빐�꽌 UserVO�쓽 媛앹껜�뿉 媛믪쓣 �꽔�뒗�떎.

        UserVO vo = service.login(dto);
      
        String id = (httpRequest.getParameter("id"));
        String pw = (httpRequest.getParameter("pw"));

        if ( vo != null ){ // vo媛� null�씠 �븘�땲硫� 

            session.setAttribute("login", vo); // login�씠�씪�뒗 �꽭�뀡�쓣 留뚮뱾怨� vo 媛믪쓣 �꽔�뒗�떎 

           
            System.out.println("�엯�젰�맂 �븘�씠�뵒�뒗 : "+id+"�엯�젰�맂 鍮꾨�踰덊샇�뒗"+pw+"�엯�땲�떎");
            returnURL = "redirect:/board/listAll"; // 洹몃━怨� redirect listAll �떎�떆 

        }else { // 占싸깍옙占싸울옙 占쏙옙占쏙옙占쏙옙 占쏙옙占�
        	
             System.out.println("�엯�젰�맂 �븘�씠�뵒�뒗 : "+id+"�엯�젰�맂 鍮꾨�踰덊샇�뒗"+pw+"�엯�땲�떎");
            returnURL = "redirect:/board/login"; // 留뚯빟 vo 媛� null�씪�떆 login �럹�씠吏�濡� �씠�룞 

        }

         

        return returnURL; // 占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙占쏙옙 returnURL 占쏙옙 占쏙옙환占쌔쇽옙 占싱듸옙占쏙옙킴

    }
    

    // 占싸그아울옙 占싹댐옙 占싸븝옙

    @RequestMapping(value="/logout")

    public String logout(HttpSession session) {

        session.invalidate(); // 占쏙옙占쏙옙 占쏙옙체占쏙옙 占쏙옙占쏙옙占쏙옙占쏙옙

//      session.removeAttribute("login"); // 占싹놂옙占쏙옙 占싹뤄옙占쏙옙 占싱뤄옙占쏙옙 占쌔듸옙 占쏙옙.

        return "redirect:/board/login"; // 占싸그아울옙 占쏙옙 占쌉시깍옙 占쏙옙占쏙옙占쏙옙占� 占싱듸옙占싹듸옙占쏙옙...占쏙옙

    }
    //회원 확인
    @ResponseBody
    @RequestMapping(value = "/idCheck", method = RequestMethod.POST)
    public boolean postIdCheck(HttpServletRequest req) throws Exception {
    	System.out.println("post idCheck");
    	String id = req.getParameter("id");
    	UserVO idCheck = service.idCheck(id);
    	boolean result = false;
    	if(idCheck != null) {
    		result = true;
    	}
    	return result;
    }
   @RequestMapping(value = "/user", method = RequestMethod.POST)
   public String postUser(HttpSession session, UserVO vo) throws Exception {
	   System.out.println("post user");
	   service.user(vo);
	   session.invalidate();
	   return "redirect:/board/login";
   }
   @RequestMapping(value = "/withdrawal", method = RequestMethod.GET)
   public void getWithdrawal() throws Exception {
    System.out.println("get withdrawal");
    
   }
   @RequestMapping(value = "/withdrawal", method = RequestMethod.POST)
   public String postWithdrawal(HttpSession session, UserVO vo, RedirectAttributes rttr) throws Exception {
	   System.out.println("post withdrawal");
	   UserVO login = (UserVO)session.getAttribute("login");
	   String oldid = login.getId();
	   String newid= login.getId();
	   if(!(oldid.equals(newid))) {
		   rttr.addFlashAttribute("msg",false);
		   return "redirect:/board/withdrawal";
	   }
	   service.withdrawal(login);
	   session.invalidate();
	   return "redirect:/";
	   
   }
 

} // end of controller

