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
import com.neuedu.cj.util.DateUtils;


/**
 * Servlet implementation class UserSerlvet
 */
@WebServlet("/trainServlet")
public class TrainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TrainServlet() {
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
			
		}else if("findtrainsByDynamic".equals(method)){
			findtrainsByDynamic(request,response);
			
		}else if("findtrainsById".equals(method)){
			findtrainsById(request,response);
			
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
	
		String traffic=request.getParameter("traffic");
		String departureStation=request.getParameter("departureStation");
		String terminalStation=request.getParameter("terminalStation");
		String startingTime=request.getParameter("startingTime");
		String endTime=request.getParameter("endTime");
		String duration=request.getParameter("duration");
		String mileage=request.getParameter("mileage");
		String noSeat=request.getParameter("noSeat");
		String vehicleType=request.getParameter("vehicleType");
		String trainType=request.getParameter("trainType");
		Train train=new Train();
		train.setTraffic(traffic);
		train.setDepartureStation(departureStation);
		train.setTerminalStation(terminalStation);
		train.setStartingTime(DateUtils.stringConvertToDate(startingTime));
		train.setEndTime(DateUtils.stringConvertToDate(endTime));
		train.setDuration(duration);
		train.setMileage(mileage);
		train.setNoSeat(noSeat);
		train.setVehicleType(vehicleType);
		train.setTrainType(trainType);

		TrainDao trainDao=new TrainDao();
    	if(trainDao.insert(train)){
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
		Integer tId=Integer.parseInt(request.getParameter("tId"));
		String traffic=request.getParameter("traffic");
		String departureStation=request.getParameter("departureStation");
		String terminalStation=request.getParameter("terminalStation");
		String startingTime=request.getParameter("startingTime");
		String endTime=request.getParameter("endTime");
		String duration=request.getParameter("duration");
		String mileage=request.getParameter("mileage");
		String noSeat=request.getParameter("noSeat");
		String vehicleType=request.getParameter("vehicleType");
		String trainType=request.getParameter("trainType");
		Train train=new Train();
		train.settId(tId);
		train.setTraffic(traffic);
		train.setDepartureStation(departureStation);
		train.setTerminalStation(terminalStation);
		train.setStartingTime(DateUtils.stringConvertToDate(startingTime));
		train.setEndTime(DateUtils.stringConvertToDate(endTime));
		train.setDuration(duration);
		train.setMileage(mileage);
		train.setNoSeat(noSeat);
		train.setVehicleType(vehicleType);
		train.setTrainType(trainType);

		TrainDao trainDao=new TrainDao();
    	if(trainDao.update(train)){
    		System.out.println("strainServlet update  success......................");
    	}else{
    		System.out.println("strainServlet update  false......................");
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
		TrainDao TrainDao=new TrainDao();
    	List<Train> trainList=TrainDao.findAll();
    	request.setAttribute("trainList", trainList);
    	request.getRequestDispatcher("/Train/TrainFind.jsp").forward(request, response);
	}
	

	protected void findtrainsByDynamic(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		System.out.println("UserServlet findUsersByDynamic  success......................");
		String traffic=request.getParameter("traffic");
		String departureStation=request.getParameter("departureStation");
		String terminalStation=request.getParameter("terminalStation");
		String vehicleType=request.getParameter("vehicleType");
		String trainType=request.getParameter("trainType");
		
		Train tra=new Train();
		tra.setTraffic(traffic);
		tra.setDepartureStation(departureStation);
		tra.setTerminalStation(terminalStation);
		tra.setVehicleType(vehicleType);
		tra.setTrainType(trainType);
		
		
		TrainDao trainDao=new TrainDao();
        List<Train> trainList=trainDao.findtrainsByDynamic(tra);
        request.setAttribute("trainList",trainList );
		System.out.println("trainServlet findtrainsByDynamic  success......................");
        request.getRequestDispatcher("/Train/TrainFind.jsp").forward(request, response);
    		
	}
	

	protected void findtrainsById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer tId=Integer.parseInt(request.getParameter("tId"));
		Train train=new Train();
		train.settId(tId);
		TrainDao trainDao=new TrainDao();
		train=trainDao.findtrainsBytId(train);
        request.setAttribute("train",train );
		System.out.println("trainServlet amindedit  success......................");
        request.getRequestDispatcher("/Train/TrainUpdate.jsp").forward(request, response);
		

	}
	

	protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		String param=request.getParameter("param");
		String cids[]=param.split(":");
		
		int[] intTemp = new int[cids.length];
		for (int i = 0; i <cids.length; i++)
		{
			intTemp[i] =Integer.parseInt(cids[i]);
		}
		
	   TrainDao dao=new TrainDao();
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






