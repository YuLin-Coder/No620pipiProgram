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
import com.neuedu.cj.dao.LineDao;
import com.neuedu.cj.model.Line;
import com.neuedu.cj.util.DateUtils;


/**
 * Servlet implementation class UserSerlvet
 */
@WebServlet("/lineServlet")
public class LineServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LineServlet() {
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
			
		}else if("findlinesByDynamic".equals(method)){
			findlinesByDynamic(request,response);
			
		}else if("findlinesById".equals(method)){
			findlinesById(request,response);
			
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
		String stationName=request.getParameter("stationName");
		String departureTime=request.getParameter("departureTime");
		String arrivalTime=request.getParameter("arrivalTime");
		String mileage=request.getParameter("mileage");
		String residenceTime=request.getParameter("residenceTime");
		String spendTime=request.getParameter("spendTime");
		String stationCode=request.getParameter("stationCode");
		Line line=new Line();
		line.setTrafficCode(trafficCode);
		line.setStationName(stationName);
		line.setDepartureTime(DateUtils.stringConvertToDate(departureTime));
		line.setArrivalTime(DateUtils.stringConvertToDate(arrivalTime));
		line.setMileage(mileage);
		line.setResidenceTime(residenceTime);
		line.setSpendTime(spendTime);
		line.setStationCode(stationCode);


		LineDao lineDao=new LineDao();
    	if(lineDao.insert(line)){
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
		
		Integer lineNumber=Integer.parseInt(request.getParameter("lineNumber"));
		String trafficCode=request.getParameter("trafficCode");
		String stationName=request.getParameter("stationName");
		String departureTime=request.getParameter("departureTime");
		String arrivalTime=request.getParameter("arrivalTime");
		String mileage=request.getParameter("mileage");
		String residenceTime=request.getParameter("residenceTime");
		String spendTime=request.getParameter("spendTime");
		String stationCode=request.getParameter("stationCode");
		Line line=new Line();
		line.setLineNumber(lineNumber);
		line.setTrafficCode(trafficCode);
		line.setStationName(stationName);
		line.setDepartureTime(DateUtils.stringConvertToDate(departureTime));
		line.setArrivalTime(DateUtils.stringConvertToDate(arrivalTime));
		line.setMileage(mileage);
		line.setResidenceTime(residenceTime);
		line.setSpendTime(spendTime);
		line.setStationCode(stationCode);
    	LineDao lineDao=new LineDao();
    	if(lineDao.update(line)){
    		System.out.println("lineServlet update  success......................");
    	}else{
    		System.out.println("lineServlet update  false......................");
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
		LineDao lineDao=new LineDao();
    	List<Line> lineList=lineDao.findAll();
    	request.setAttribute("lineList", lineList);
    	request.getRequestDispatcher("/Line/LineFind.jsp").forward(request, response);
	}
	

	protected void findlinesByDynamic(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		System.out.println("UserServlet findUsersByDynamic  success......................");
		String trafficCode=request.getParameter("trafficCode");
		String stationName=request.getParameter("stationName");
		String stationCode=request.getParameter("stationCode");

		
		Line lin=new Line();
		lin.setTrafficCode(trafficCode);
		lin.setStationName(stationName);
		lin.setStationCode(stationCode);
		


		
		LineDao lineDao=new LineDao();
        List<Line> lineList=lineDao.findlinesByDynamic(lin);
        request.setAttribute("lineList",lineList );
		System.out.println("lineServlet findlinesByDynamic  success......................");
        request.getRequestDispatcher("/Line/LineFind.jsp").forward(request, response);
    		
	}
	

	protected void findlinesById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer lineNumber=Integer.parseInt(request.getParameter("lineNumber"));
		Line line=new Line();
		line.setLineNumber(lineNumber);
		LineDao lineDao=new LineDao(); 
		line=lineDao.findlinesBytId(line);
        request.setAttribute("line",line );
		System.out.println("lineServlet amindedit  success......................");
        request.getRequestDispatcher("/Line/LineUpdate.jsp").forward(request, response);
		

	}
	

	protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		String param=request.getParameter("param");
		String cids[]=param.split(":");
		
		int[] intTemp = new int[cids.length];
		for (int i = 0; i <cids.length; i++)
		{
			intTemp[i] =Integer.parseInt(cids[i]);
		}
		
	   LineDao dao=new LineDao();
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
    	request.getRequestDispatcher("/Line/TrainDelete.jsp").forward(request, response);
	}
	
}






