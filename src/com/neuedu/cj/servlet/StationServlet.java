package com.neuedu.cj.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neuedu.cj.dao.StationDao;
import com.neuedu.cj.model.PageBean;
import com.neuedu.cj.model.Station;
import com.neuedu.cj.service.StationService;
import com.neuedu.cj.util.DateUtils;

/**
 * Servlet implementation class StationServlet
 */
@WebServlet("/stationServlet")
public class StationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StationServlet() {
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
	
		}else if("findStationsByDynamic".equals(method)){
			findStationsByDynamic(request,response);
		
		}else if("findStationBytId".equals(method)){
			findStationBytId(request,response);
	}else if("fenye".equals(method)){
		try {
			fenye(request,response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}}
	}
	//分页查询商品的Servlet
	private void fenye(HttpServletRequest request, HttpServletResponse response) throws Exception {
	int currPage = Integer.parseInt(request.getParameter("currPage"));
	//调用业务层处理数据：
	StationService stationService = new StationService();
	PageBean pageBean=stationService.finByPage(currPage);
	//将需要的数据保存到request中待到页面
	request.setAttribute("pageBean", pageBean);
	request.getRequestDispatcher("/Station/new.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}

	    protected void insert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    	
	    	String stationCode=request.getParameter("StationCode");
	    	String stationName=request.getParameter("StationName");
	    	String pinyinCode=request.getParameter("PinyinCode");
	    	String railwayBureau=request.getParameter("RailwayBureau");
	    	String stationgRade=request.getParameter("StationgRade");
	    	String  administrativeRegion=request.getParameter("AdministrativeRegion");
	    	String contactAddress=request.getParameter("ContactAddress");
	
	    	Station station=new Station();
	    	station.setStationCode(stationCode);
	    	station.setStationName(stationName);
	    	station.setPinyinCode(pinyinCode);
	    	station.setRailwayBureau(railwayBureau);
	    	station.setStationGrade(stationgRade);
	    	station.setAdministrativeRegion(administrativeRegion);
	    	station.setContactAddress(contactAddress);

	        StationDao stationDao=new StationDao();
	        
	        if(stationDao.insert(station)){
	        	
	        	
	        	System.out.println("StationServlet insert  success......................");
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
	    		// TODO Auto-generated method stub
	    		Integer sId=Integer.parseInt(request.getParameter("sId"));
	    		String stationCode=request.getParameter("stationCode");
	    		String stationName=request.getParameter("stationName");
	    		String pinyinCode=request.getParameter("pinyinCode");
	    		String railwayBureau=request.getParameter("railwayBureau");
	    		String stationGrade=request.getParameter("stationGrade");
	    		String administrativeRegion=request.getParameter("administrativeRegion");
	    		String contactAddress=request.getParameter("contactAddress");
	    		Station station=new Station();
	    		station.setsId(sId);
	    		station.setStationCode(stationCode);
	    		station.setStationName(stationName);
	    		station.setPinyinCode(pinyinCode);
	    		station.setRailwayBureau(railwayBureau);
	    		station.setStationGrade(stationGrade);
	    		station.setAdministrativeRegion(administrativeRegion);
	    		station.setContactAddress(contactAddress);
	        	StationDao s=new StationDao();
	        	if(s.update(station)){
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
	    	protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    		
	    		String param=request.getParameter("param");
	    		String cids[]=param.split(":");
	    		
	    		int[] intTemp = new int[cids.length];
	    		for (int i = 0; i <cids.length; i++)
	    		{
	    			intTemp[i] =Integer.parseInt(cids[i]);
	    		}
	    		
	    	   StationDao dao=new StationDao();
	    	   boolean b=dao.delete(intTemp);
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
	    	        StationDao stationDao=new StationDao();
	    	        List<Station> stationList=stationDao.findAll();
	    	        request.setAttribute("stationList",stationList );
	    	        request.getRequestDispatcher("/Station/Station_operation.jsp").forward(request, response);
	    	        
	    	}
	    	
	    	protected void findStationsByDynamic(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	            //��ȡ��ѯ������
	    		String StationCode=request.getParameter("StationCode");
	    		String StationName=request.getParameter("StationName");
	    		String StationgRade=request.getParameter("StationgRade");
	    		String RailwayBureau=request.getParameter("RailwayBureau");
	    		String AdministrativeRegion=request.getParameter("AdministrativeRegion");
	    		
	    		Station s=new Station();
	    		s.setStationCode(StationCode);
	    		s.setStationName(StationName);
	    		s.setStationGrade(StationgRade);
	    		s.setRailwayBureau(RailwayBureau);
	    		s.setAdministrativeRegion(AdministrativeRegion);
	    		
	    		
	    		StationDao stationDao=new StationDao();
	            List<Station> stationList=stationDao.findStationsByDynamic(s);
	            request.setAttribute("stationList",stationList);
	            request.getRequestDispatcher("/Station/Station_operation.jsp").forward(request, response);
	            
	    }
	    	
	    	protected void findStationBytId(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    		Integer sId=Integer.parseInt(request.getParameter("sId"));
	    		Station s=new Station();
	    		s.setsId(sId);
	    		StationDao station=new StationDao(); 
	    		s=station.findStationBytId(s);
	            request.setAttribute("s",s );
	    		System.out.println("lineServlet amindedit  success......................");
	            request.getRequestDispatcher("/Station/Station_update.jsp").forward(request, response);
	    		

	    	}
}
