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
import com.neuedu.cj.dao.TrainDao;
import com.neuedu.cj.model.Train;
import com.neuedu.cj.dao.MarshallingDao;
import com.neuedu.cj.model.Marshalling;
import com.neuedu.cj.util.DateUtils;


/**
 * Servlet implementation class UserSerlvet
 */
@WebServlet("/marshallingServlet")
public class MarshallingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MarshallingServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String method=request.getParameter("method");
		
		if("insert".equals(method)){
			insert(request,response);
			
			
		}else if("update".equals(method)){
			update(request,response);
			
		}else if("delete".equals(method)){
			
			delete(request,response);
		}else if("findAll".equals(method)){
			findAll(request,response);
			
		}else if("findMarshallingsByDynamic".equals(method)){
			findMarshallingsByDynamic(request,response);
			
		}else if("findmarshallingsById".equals(method)){
			findmarshallingsById(request,response);
			
		}else if("deletefindAll".equals(method)){
			deletefindAll(request,response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}
	/**
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void insert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String trafficCode=request.getParameter("trafficCode");
		String carriageNumber=request.getParameter("carriageNumber");
		String carSeatType=request.getParameter("carSeatType");
		String carSeatNumber=request.getParameter("carSeatNumber");
		String carType=request.getParameter("carType");
		Marshalling marshalling=new Marshalling();
		marshalling.setTrafficCode(trafficCode);
		marshalling.setCarriageNumber(carriageNumber);
		marshalling.setCarSeatType(carSeatType);
		marshalling.setCarSeatNumber(carSeatNumber);
		marshalling.setCarType(carType);


		MarshallingDao marshallingDao=new MarshallingDao();
    	if(marshallingDao.insert(marshalling)){
    		System.out.println("UserServlet insert  success......................");
    	}else{
    		System.out.println("UserServlet insert  false......................");
    	}
 	   findAll(request, response);
	}
	/**
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer trainMarshallingNumber=Integer.parseInt(request.getParameter("trainMarshallingNumber"));
		String trafficCode=request.getParameter("trafficCode");
		String carriageNumber=request.getParameter("carriageNumber");
		String carSeatType=request.getParameter("carSeatType");
		String carSeatNumber=request.getParameter("carSeatNumber");
		String carType=request.getParameter("carType");
		Marshalling marshalling=new Marshalling();
		marshalling.setTrafficCode(trafficCode);
		marshalling.setTrainMarshallingNumber(trainMarshallingNumber);
		marshalling.setCarriageNumber(carriageNumber);
		marshalling.setCarSeatType(carSeatType);
		marshalling.setCarSeatNumber(carSeatNumber);
		marshalling.setCarType(carType);
    	MarshallingDao marshallingDao=new MarshallingDao();
    	if(marshallingDao.update(marshalling)){
    		System.out.println("marshallingServlet update  success......................");
    	}else{
    		System.out.println("marshallingServlet update  false......................");
    	}
    	findAll(request, response);
	}
	
	/**
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	
	
	protected void findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MarshallingDao marshallingDao=new MarshallingDao();
    	List<Marshalling> marshallingList=marshallingDao.findAll();
    	request.setAttribute("marshallingList", marshallingList);
    	request.getRequestDispatcher("/Marshalling/MarshallingFind.jsp").forward(request, response);
	}
	

	protected void findMarshallingsByDynamic(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		System.out.println("UserServlet findUsersByDynamic  success......................");
		String trafficCode=request.getParameter("trafficCode");
		String carriageNumber=request.getParameter("carriageNumber");
		String carSeatType=request.getParameter("carSeatType");
		String carSeatNumber=request.getParameter("carSeatNumber");
		String carType=request.getParameter("carType");
		Marshalling mar=new Marshalling();
		mar.setTrafficCode(trafficCode);
		mar.setCarriageNumber(carriageNumber);
		mar.setCarSeatType(carSeatType);
		mar.setCarSeatNumber(carSeatNumber);
		mar.setCarType(carType);
		
		
		MarshallingDao marshallingDao=new MarshallingDao();
        List<Marshalling> marshallingList=marshallingDao.findMarshallingsByDynamic(mar);
        request.setAttribute("marshallingList",marshallingList );
		System.out.println("trainServlet findtrainsByDynamic  success......................");
        request.getRequestDispatcher("/Marshalling/MarshallingFind.jsp").forward(request, response);
    		
	}
	

	protected void findmarshallingsById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer trainMarshallingNumber=Integer.parseInt(request.getParameter("trainMarshallingNumber"));
		Marshalling marshalling=new Marshalling();
		marshalling.setTrainMarshallingNumber(trainMarshallingNumber);
		MarshallingDao marshallingDao=new MarshallingDao();
		marshalling=marshallingDao.findmarshallingsBytId(marshalling);
        request.setAttribute("marshalling",marshalling );
		System.out.println("marshallingServlet amindedit  success......................");
        request.getRequestDispatcher("/Marshalling/MarshallingUpdate.jsp").forward(request, response);
		

	}
	

	protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		String param=request.getParameter("param");
		String cids[]=param.split(":");
		
		int[] intTemp = new int[cids.length];
		for (int i = 0; i <cids.length; i++)
		{
			intTemp[i] =Integer.parseInt(cids[i]);
		}
		
		MarshallingDao dao=new MarshallingDao();
	   dao.delete(intTemp);
	   findAll(request, response);
       /*request.getRequestDispatcher("/Admin/trainServlet?method=deletefindAll").forward(request, response);*/

	}
	/**
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	
	protected void deletefindAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TrainDao TrainDao=new TrainDao();
    	List<Train> trainList=TrainDao.findAll();
    	request.setAttribute("trainList", trainList);
    	request.getRequestDispatcher("/Admin/TrainDelete.jsp").forward(request, response);
	}
	
}






