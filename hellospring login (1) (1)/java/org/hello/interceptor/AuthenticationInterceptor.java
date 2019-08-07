package org.hello.interceptor;
import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;

import javax.servlet.http.HttpSession;

 

import org.springframework.web.servlet.ModelAndView;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

 

// �α���ó���� ����ϴ� ���ͼ���

public class AuthenticationInterceptor extends HandlerInterceptorAdapter{

 

    // preHandle() : ��Ʈ�ѷ����� ���� ����Ǵ� �޼���

    @Override

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)

            throws Exception {

        // session getSession을 이용해서 세션을 가져온다 

        HttpSession session = request.getSession();

        // object 타입에 login 세션을 가져온다 

        Object obj = session.getAttribute("login");

         

        if ( obj == null ){

            // 만약 obj가  null 이면 로그인페이지로 이동

            response.sendRedirect("/board/login");

            return false; // ���̻� ��Ʈ�ѷ� ��û���� ���� �ʵ��� false�� ��ȯ��

        }

         

        // preHandle�� return�� ��Ʈ�ѷ� ��û uri�� ���� �ǳ� �ȵǳĸ� �㰡�ϴ� �ǹ���

        // ���� true���ϸ� ��Ʈ�ѷ� uri�� ���� ��.

        return true;

    }

 

    // ��Ʈ�ѷ��� ����ǰ� ȭ���� �������� ������ ����Ǵ� �޼���

    @Override

    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,

            ModelAndView modelAndView) throws Exception {

        // TODO Auto-generated method stub

        super.postHandle(request, response, handler, modelAndView);

    }

     

}

