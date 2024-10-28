package com.neuedu.cj.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neuedu.cj.dao.UserDao;
import com.neuedu.cj.model.User;
import com.neuedu.cj.util.DateUtils;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/userServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String method=request.getParameter("method");
//		if("insert".equals(method)){
//			insert(request,response);
//			System.out.println("xx");
//		}else if("update".equals(method)){
//			update(request,response);
//		}
//			
//				else if("login".equals(method)){
//			login(request,response);
//		}else if("findAUserByDymamic".equals(method)){
//			findUsersByDymamic(request,response);
//		}
//		else 
		if("modify".equals(method)){
			modify(request,response);
		}
		else if("register".equals(method)){
			register(request,response);
		}else if("findAll".equals(method)){
		findAll(request,response);
		}else if("findAUserByDymamic".equals(method)){
			findUsersByDymamic(request,response);
		}else if("delete".equals(method)){
			delete(request,response);
		}else if("insert".equals(method)){
			insert(request,response);
		}else if("fenye".equals(method)){
			fenye(request,response);
		}
  }
	



	private void fenye(HttpServletRequest request, HttpServletResponse response) {
		
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}
//	protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		doGet(request, response);
//	}
	protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String param=request.getParameter("param");
		String cids[]=param.split(":");
		int[] intTemp=new int[cids.length];
		for(int i=0;i<cids.length;i++){
			intTemp[i]=Integer.parseInt(cids[i]);
		}
		UserDao dao=new UserDao();
		boolean b=dao.delete(intTemp);
		findAll(request,response);
	}
	protected void findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserDao userDao=new UserDao();
		List<User> userList=userDao.findAll();
		request.setAttribute("userList", userList);
		  request.getRequestDispatcher("/Admin/UserManageQuery.jsp").forward(request, response);
		}
	protected void modify(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//��ȡԭ����
		String ulpass=request.getParameter("ulpass");
		String newpass=request.getParameter("newpass");
		String newpass1=request.getParameter("newpass1");
		String ulname=request.getParameter("ulname");
		if(newpass.equals(newpass1)){
			User u=new User();
			u.setUlpass(newpass);
			u.setUlname(ulname);
			UserDao userDao=new UserDao();
			boolean b=userDao.moidify(u);
			if(b)System.out.println("����ɹ�");
		}
		else{
			 request.getRequestDispatcher("/User/Index.jsp").forward(request, response);
			 System.out.println("����ʧ��");
		}
		}
	protected void register(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("454521");
		String UlName=request.getParameter("ulname");
		String Ulpass=request.getParameter("ulpass");
		String RealName=request.getParameter("realName");
		String sex=request.getParameter("sex");
		String Provice=request.getParameter("provice");
		String City=request.getParameter("city");
		String CardType=request.getParameter("cardType");
		String CardNumber=request.getParameter("cardNumber");
		String Birthday=request.getParameter("birthday");
		String LvkeType=request.getParameter("lvkeType");
		String Info=request.getParameter("info");
		User user=new User();
		user.setUlname(UlName);
		user.setUlpass(Ulpass);
		user.setRealName(RealName);
		user.setSex(sex);
		user.setProvice(Provice);
		user.setCity(City);
        user.setCardType(CardType);
		user.setCardNumber(CardNumber);
		user.setBirthday(DateUtils.stringConvertToDate(Birthday));
		user.setLvkeType(LvkeType);
		user.setInfo(Info);
		UserDao userDao=new UserDao();
		Boolean flag=userDao.register(user);
		if(flag){
			
			System.out.println("ע�� success");
			
		}
		 request.getRequestDispatcher("/UserRegistration.jsp").forward(request, response);
		}
	protected void findUsersByDymamic(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//��ȡ��ѯ������
		
		String realName=request.getParameter("realName");
		String sex=request.getParameter("sex");
		String cardType=request.getParameter("cardType");
		String cardNumber=request.getParameter("cardNumber");
		String lvkeType=request.getParameter("lvkeType");
		User u=new User();
		u.setRealName(realName);
		u.setSex(sex);
		u.setCardType(cardType);
		u.setCardNumber(cardNumber);
		u.setLvkeType(lvkeType);
		
		UserDao userDao=new UserDao();
		List<User> userList=userDao.findUsersByDymamic(u);
		request.setAttribute("userList", userList);
		  request.getRequestDispatcher("/Admin/UserManageQuery.jsp").forward(request, response);
		}
//����
	protected void insert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ulname=request.getParameter("ulname");
		String ulpass=request.getParameter("ulpass");
		String realName=request.getParameter("realName");
		String sex=request.getParameter("sex");
		String provice=request.getParameter("provice");
		String city=request.getParameter("city");
		String cardType=request.getParameter("cardType");
		String cardNumber=request.getParameter("cardNumber");
		String birthday=request.getParameter("birthday");
		String lvkeType=request.getParameter("lvkeType");
		String info=request.getParameter("info");
		User user=new User();
		user.setUlname(ulname);
		user.setUlpass(ulpass);
		user.setRealName(realName);
		user.setSex(sex);
		user.setProvice(provice);
		user.setCity(city);
		user.setCardNumber(cardNumber);
		user.setCardType(cardType);
		user.setBirthday(DateUtils.stringConvertToDate(birthday));
		user.setLvkeType(lvkeType);
		user.setInfo(info);
		UserDao userDao=new UserDao();
		Boolean flag=userDao.insert(user);
		if(flag){
			
			System.out.println("insert success");
			
		}
		request.getRequestDispatcher("/userServlet?method=findAll").forward(request, response);
		}

}
