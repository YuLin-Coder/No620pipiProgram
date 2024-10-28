package com.neuedu.cj.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.neuedu.cj.dao.ManagerDao;
import com.neuedu.cj.dao.UserDao;
import com.neuedu.cj.model.Manager;
import com.neuedu.cj.model.User;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String choice=request.getParameter("select");
		  if("1".equals(choice)){
			  String loginName=request.getParameter("loginName");
			  String password=request.getParameter("password");
		  Manager m=new Manager();
		  m.setMname(loginName);
		  m.setMpass(password);
		  //���õ��ò㡣
		  boolean b=new ManagerDao().login(m);
		//====�������ݿ�

		  //�����ж�
		  if(b){
			  //����½�û�����Ϣ�洢��Seeion��
//			  //��ȡsession����
//			  HttpSession session=request.getSession();
//			  session.setAttribute("manager", m);
//			 
			  response.sendRedirect(request.getContextPath()+"/Admin/Index.jsp");
		  }else{
			  response.sendRedirect(request.getContextPath()+"/Login.jsp");
		  }
				
				
				
			}
			
			else if("0".equals(choice)){
				String loginName=request.getParameter("loginName");
				  String password=request.getParameter("password");
				User n=new User();
			n.setUlname(loginName);  //�����û��˺������½��Ϣ
				n.setUlpass(password);
				 boolean b=new UserDao().login(n);
				 if(b){
					  HttpSession session=request.getSession();
					  session.setAttribute("user", n);
					  response.sendRedirect(request.getContextPath()+"/User/Index.jsp");
				  }else{
					  response.sendRedirect(request.getContextPath()+"/pipiProgram/Login.jsp");
				  }
				 }
		 
			}

		
	}


