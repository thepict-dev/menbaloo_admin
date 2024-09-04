package pict_admin.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;


import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;

import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.mail.PasswordAuthentication;
import pict_admin.service.PictService;
import pict_admin.service.PictVO;
import pict_admin.service.AdminService;
import pict_admin.service.AdminVO;
import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.apache.commons.codec.binary.Base64;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.util.CellRangeAddress;
import org.json.simple.parser.JSONParser;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import org.apache.commons.net.PrintCommandListener;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;


//import io.socket.emitter.Emitter;
//import io.socket.emitter.Emitter.Listener;
//import io.socket.client.IO;
//import io.socket.client.Socket;

import java.net.URL;
import java.net.URLEncoder;
import java.net.HttpURLConnection;

@Controller
public class pictController {
	PasswordAuthentication pa;
	
	@Resource(name = "pictService")
	private PictService pictService;
	
	@Resource(name = "adminService")
	private AdminService adminService;
	
	
	
	@RequestMapping(value = "/pict_main.do")
	public String pict_main(@ModelAttribute("searchVO") AdminVO adminVO, HttpServletRequest request, ModelMap model, HttpSession session, RedirectAttributes rttr) throws Exception {
		String sessions = (String)request.getSession().getAttribute("id");
		System.out.println(sessions);
		if(sessions == null || sessions == "null") {
			return "redirect:/pict_login.do";
		}
		else {
			String user_id = (String)request.getSession().getAttribute("id");
			if(request.getSession().getAttribute("id") != null) {
				adminVO.setAdminId((String)request.getSession().getAttribute("id"));
				adminVO = adminService.get_user_info(adminVO);
				model.addAttribute("adminVO", adminVO);
			}
		
			return "redirect:/user/user_list.do";
		
		}
	}
	
	@RequestMapping(value = "/pict_login.do")
	public String login_main(@ModelAttribute("searchVO") AdminVO adminVO, HttpServletRequest request, ModelMap model, HttpServletResponse response) throws Exception {
		String userAgent = request.getHeader("user-agent");
		String sessions = (String)request.getSession().getAttribute("id");
		boolean mobile1 = userAgent.matches( ".*(iPhone|iPod|Android|Windows CE|BlackBerry|Symbian|Windows Phone|webOS|Opera Mini|Opera Mobi|POLARIS|IEMobile|lgtelecom|nokia|SonyEricsson).*");
		boolean mobile2 = userAgent.matches(".*(LG|SAMSUNG|Samsung).*"); 
		if (mobile1 || mobile2) {
		    //여기 모바일일 경우
			System.out.println("피씨");
			model.addAttribute("message", "PC에서만 사용이 가능합니다.");
			model.addAttribute("retType", ":exit");
			return "pict/main/message";
		}
		
		
		if(sessions == null || sessions == "null") {
			return "pict/main/login";
		}
		else {
			//나중에 여기 계정별로 리다이렉트 분기처리
			return "redirect:/user/user_list.do";
			
		}
			
	}
	
	@RequestMapping(value = "/login.do")
	public String login(@ModelAttribute("adminVO") AdminVO adminVO, HttpServletRequest request,  ModelMap model) throws Exception {
		//처음 드러와서 세션에 정보있으면 메인으로 보내줘야함
		String inpuId = adminVO.getAdminId();
		String inputPw = adminVO.getAdminPw();
		
		adminVO = adminService.get_user_info(adminVO);

		if (adminVO != null && adminVO.getId() != null && !adminVO.getId().equals("")) {
			String user_id = adminVO.getId();
			String enpassword = encryptPassword(inputPw, inpuId);	//입력비밀번호
			
			if(enpassword.equals(adminVO.getPassword())) {
				request.getSession().setAttribute("id", adminVO.getId());
				request.getSession().setAttribute("name", adminVO.getName());
				request.getSession().setAttribute("depart", adminVO.getDepart());

				String ip = request.getRemoteAddr();
			    DateFormat format2 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			    String now = format2.format(Calendar.getInstance().getTime());
			    
			    adminVO.setLast_login_ip(ip);
			    adminVO.setLast_login_date(now);
			    adminService.insert_login_info(adminVO);
			    
			    adminVO.setAdminId(user_id);
			    adminVO = adminService.get_user_info(adminVO);
			    
				return "redirect:/pict_main.do";
				
			}
			else {
				model.addAttribute("message", "입력하신 정보가 일치하지 않습니다.");
				model.addAttribute("retType", ":location");
				model.addAttribute("retUrl", "/pict_login.do");
				return "pict/main/message";
			}
		}
		else {
			model.addAttribute("message", "입력하신 정보가 일치하지 않습니다.");
			model.addAttribute("retType", ":location");
			model.addAttribute("retUrl", "/pict_login.do");
			return "pict/main/message";
		}
	}
	
	//관리자 관리
	@RequestMapping(value = "/user_list.do")
	public String user_list(@ModelAttribute("adminVO") AdminVO adminVO, ModelMap model, HttpServletRequest request) throws Exception {
		String session = (String)request.getSession().getAttribute("id");
		if(session == null || session == "null") {
			return "redirect:/pict_login.do";
		}
		
		model.addAttribute("search_text",adminVO.getSearch_text());
		
		
		List<?> userList = adminService.user_list(adminVO);
		model.addAttribute("resultList", userList);
		return "pict/main/user_list";
	}
	@RequestMapping(value = "/user_register.do")
	public String user_register(@ModelAttribute("adminVO") AdminVO adminVO, ModelMap model, HttpServletRequest request) throws Exception {
		String session = (String)request.getSession().getAttribute("id");
		if(session == null || session == "null") {
			return "redirect:/pict_login.do";
		}
		
		if(adminVO.getId() != null && !adminVO.equals("")) {
			//수정
			adminVO = adminService.user_select_one(adminVO);
			adminVO.setSaveType("update");
			
		}
		else {
			adminVO.setSaveType("insert");
		}
		
		model.addAttribute("adminVO", adminVO);
		return "pict/main/user_register";
	}
	@RequestMapping(value = "/user_reset.do")
	public String user_reset(@ModelAttribute("adminVO") AdminVO adminVO, ModelMap model, HttpServletRequest request) throws Exception {
		String session = (String)request.getSession().getAttribute("id");
		if(session == null || session == "null") {
			return "redirect:/pict_login.do";
		}
		
		String enpassword = encryptPassword(adminVO.getId()+"1!", adminVO.getId());	//입력비밀번호
		adminVO.setPassword(enpassword);
		adminService.user_reset(adminVO);
		
		model.addAttribute("message", "비밀번호가 초기화 되었습니다.");
		model.addAttribute("retType", ":location");
		model.addAttribute("retUrl", "/user_list.do");
		return "pict/main/message";
	}
	@RequestMapping(value = "/user_delete.do")
	public String user_delete(@ModelAttribute("adminVO") AdminVO adminVO, ModelMap model, HttpServletRequest request) throws Exception {
		String session = (String)request.getSession().getAttribute("id");
		if(session == null || session == "null") {
			return "redirect:/pict_login.do";
		}
		System.out.println(adminVO.getId());
		adminService.user_delete(adminVO);
		
		model.addAttribute("message", "삭제되었습니다.");
		model.addAttribute("retType", ":location");
		model.addAttribute("retUrl", "/user_list.do");
		return "pict/main/message";
	}
	@RequestMapping(value = "/user_save.do")
	public String user_save(@ModelAttribute("searchVO") PictVO pictVO, @ModelAttribute("adminVO") AdminVO adminVO,ModelMap model, HttpServletRequest request) throws Exception {
		String session = (String)request.getSession().getAttribute("id");
		if(session == null || session == "null") {
			return "redirect:/pict_login.do";
		}
		System.out.println("::::::::::::::"+adminVO.getPassword());
		String enpassword = encryptPassword(adminVO.getPassword(), adminVO.getId());	//입력비밀번호
		
		adminVO.setPassword(enpassword);
		String user_id = adminVO.getId();
		
		
		//중복 계정조회
		AdminVO vo = adminVO;
		vo.setAdminId(user_id);
		vo = adminService.get_user_info(vo);
		
		if(adminVO.getSaveType() != null && adminVO.getSaveType().equals("update")) {
			System.out.println("업데이트::::::::::::::::::::::");
			System.out.println(adminVO.toString());
			adminService.update_user(adminVO);	//user 정보 인설트
			model.addAttribute("message", "정상적으로 수정되었습니다.");
			model.addAttribute("retType", ":location");
			model.addAttribute("retUrl", "/user_list.do");
			return "pict/main/message";
		}
		
		else {
	        if(vo != null) {
	        	model.addAttribute("message", "동일한 아이디가 존재합니다.");
				model.addAttribute("retType", ":location");
				model.addAttribute("retUrl", "/user_register.do");
				return "pict/main/message";
	        }
	        System.out.println("인설트::::::::::::::::::::::");
	 
	        adminService.insert_user(adminVO);	//user 정보 인설트
            model.addAttribute("message", "계정발급이 완료되었습니다.");
    		model.addAttribute("retType", ":location");
    		model.addAttribute("retUrl", "/user_list.do");
    		return "pict/main/message";
		}
	}
	@RequestMapping(value = "/logout.do")
	public String logout(@ModelAttribute("searchVO") PictVO pictVO, HttpServletRequest request,  ModelMap model) throws Exception {
		request.getSession().setAttribute("id", null);
		request.getSession().setAttribute("name", null);
		request.getSession().setAttribute("depart", null);
		return "redirect:/pict_login.do";
		
	}
	
	
	

	//사용자 리스트
	@RequestMapping(value = "/user/user_list.do")
	public String user_list_f(@ModelAttribute("searchVO") PictVO pictVO, ModelMap model, HttpServletRequest request) throws Exception {
		String session = (String)request.getSession().getAttribute("id");
		if(session == null || session == "null") {
			return "redirect:/pict_login.do";
		}
		
		int limitNumber = 20;
		pictVO.setLimit(limitNumber);
		Integer pageNum = pictVO.getPageNumber();
		if(pageNum == 0) {
			pictVO.setPageNumber(1);
			pageNum = 1;
		}

		
		int startNum = (pageNum - 1) * limitNumber;
		pictVO.setStartNumber(startNum);
		Integer totalCnt = pictService.menbal_list_cnt(pictVO);
		int lastPageValue = (int)(Math.ceil( totalCnt * 1.0 / 20 )); 
		pictVO.setLastPage(lastPageValue);
		Integer s_page = pageNum - 4;
		Integer e_page = pageNum + 5;
		if (s_page <= 0) {
			s_page = 1;
			e_page = 10;
		} 
		if (e_page > lastPageValue){
			e_page = lastPageValue;
		}
		pictVO.setStartPage(s_page);
		pictVO.setEndPage(e_page);
		

		List<PictVO> reference_list = pictService.menbal_list(pictVO);

		model.addAttribute("resultList", reference_list);
		model.addAttribute("board_cnt", totalCnt);
		
		
		model.addAttribute("pictVO", pictVO);
		
		return "pict/user/user_list";
	}
	@RequestMapping(value = "/user/menbal_del.do", method = RequestMethod.POST)
	public String menbal_del(@ModelAttribute("searchVO") PictVO pictVO, ModelMap model, HttpServletRequest request) throws Exception {
		String session = (String)request.getSession().getAttribute("id");
		if(session == null || session == "null") {
			return "redirect:/pict_login.do";
		}
		pictService.menbal_del(pictVO);
		
		model.addAttribute("message", "정상적으로 삭제되었습니다.");
		model.addAttribute("retType", ":location");
		model.addAttribute("retUrl", "/user/user_list.do");
		return "pict/main/message";
		
	}
	@RequestMapping(value = "/user/excel_down.do")
	public void excel_down(@ModelAttribute("searchVO") PictVO pictVO, ModelMap model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		List<PictVO> attendance_list = pictService.menbal_list(pictVO);
		HSSFWorkbook objWorkBook = new HSSFWorkbook();
        HSSFSheet objSheet = null;
        HSSFRow objRow = null;
        HSSFCell objCell = null;       //셀 생성
        //제목 폰트
        HSSFFont font = objWorkBook.createFont();
        HSSFFont font_title = objWorkBook.createFont();
        font_title.setFontHeightInPoints((short)11);
        font.setFontHeightInPoints((short)9);
        font.setFontName("맑은고딕");
		int rowIndex = 0;
		
		HSSFCellStyle styleHd_title = objWorkBook.createCellStyle(); // 제목 스타일
		HSSFCellStyle styleHd = objWorkBook.createCellStyle();    //내용 스타일
		
		styleHd_title.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
		styleHd_title.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		
		// 각항목 테두리
		styleHd.setBorderRight(BorderStyle.THIN);
		styleHd.setBorderLeft(BorderStyle.THIN);
		styleHd.setBorderTop(BorderStyle.THIN);
		styleHd.setBorderBottom(BorderStyle.THIN);
		styleHd.setWrapText(true);//자동 줄바꿈

		styleHd_title.setBorderRight(BorderStyle.THIN);
		styleHd_title.setBorderLeft(BorderStyle.THIN);
		styleHd_title.setBorderTop(BorderStyle.THIN);
		styleHd_title.setBorderBottom(BorderStyle.THIN);
					
        objSheet = objWorkBook.createSheet("첫번째 시트");     //워크시트 생성
		
		
		//헤더
        objRow = objSheet.createRow(0);
        objRow.setHeight ((short) 0x150);
        
        objCell = objRow.createCell(0);
        objCell.setCellValue("순서");
        objCell.setCellStyle(styleHd_title);

        objCell = objRow.createCell(1);
        objCell.setCellValue("이름");
        objCell.setCellStyle(styleHd_title);
		
        objCell = objRow.createCell(2);
        objCell.setCellValue("연락처");
        objCell.setCellStyle(styleHd_title);
        
        objCell = objRow.createCell(3);
        objCell.setCellValue("성별");
        objCell.setCellStyle(styleHd_title);
        
        objCell = objRow.createCell(4);
        objCell.setCellValue("키");
        objCell.setCellStyle(styleHd_title);
        
        objCell = objRow.createCell(5);
        objCell.setCellValue("몸무게");
        objCell.setCellStyle(styleHd_title);
        
        objCell = objRow.createCell(6);
        objCell.setCellValue("등록일");
        objCell.setCellStyle(styleHd_title);
        
		//바디
		for(int i=0; i<attendance_list.size(); i++) {
			//순서
			objRow = objSheet.createRow(i+1);
	        objRow.setHeight ((short) 0x150);
	        objSheet.autoSizeColumn(i);
	        
	        //번호
	        objCell = objRow.createCell(0);
	        objCell.setCellValue(i+1);
	        objSheet.setColumnWidth(0, (short)0x700);
	        objCell.setCellStyle(styleHd);
	        
	        //이름
	        objCell = objRow.createCell(1);
	        objCell.setCellValue(attendance_list.get(i).getNickname());
	        objSheet.setColumnWidth(1, (short)0x1500);
	        objCell.setCellStyle(styleHd);

	        //연락처
	        objCell = objRow.createCell(2);
	        objCell.setCellValue(attendance_list.get(i).getPhone());
	        objSheet.setColumnWidth(2, (short)0x1500);
	        objCell.setCellStyle(styleHd);
	        
	        //성별
	        objCell = objRow.createCell(3);
	        objCell.setCellValue(attendance_list.get(i).getGender());
	        objSheet.setColumnWidth(3, (short)0x1000);
	        objCell.setCellStyle(styleHd);
	        
	        //키
	        objCell = objRow.createCell(4);
	        objCell.setCellValue(attendance_list.get(i).getHeight());
	        objSheet.setColumnWidth(4, (short)0x1000);
	        objCell.setCellStyle(styleHd);
	        
	        //몸무게
	        objCell = objRow.createCell(5);
	        objCell.setCellValue(attendance_list.get(i).getWeight());
	        objSheet.setColumnWidth(5, (short)0x1000);
	        objCell.setCellStyle(styleHd);
	        
	        //등록일
	        objCell = objRow.createCell(6);
	        objCell.setCellValue(attendance_list.get(i).getCreated_at());
	        objSheet.setColumnWidth(6, (short)0x2000);
	        objCell.setCellStyle(styleHd);
	       
		}
		
		String filename = "사용자 리스트";
		String header = request.getHeader("User-Agent");
		if(header.contains("Edge") || header.contains("MSIE")) {
			filename = URLEncoder.encode(filename, "UTF-8").replaceAll("//+", "%20");
		}
		else if(header.contains("Chrome") || header.contains("Opera") || header.contains("Firefox")) {
			filename = new String(filename.getBytes("UTF-8"), "ISO-8859-1");
		}
        
        response.setHeader("Content-Disposition", "ATTachment; Filename=" +filename +".xls");

        OutputStream fileOut  = response.getOutputStream();
        objWorkBook.write(fileOut);
        fileOut.close();

        response.getOutputStream().flush();
        response.getOutputStream().close();
	}
	

	//피드 리스트
	//사용자 리스트
	@RequestMapping(value = "/feed/feed_list.do")
	public String feed_list(@ModelAttribute("searchVO") PictVO pictVO, ModelMap model, HttpServletRequest request) throws Exception {
		String session = (String)request.getSession().getAttribute("id");
		if(session == null || session == "null") {
			return "redirect:/pict_login.do";
		}
		
		int limitNumber = 20;
		pictVO.setLimit(limitNumber);
		Integer pageNum = pictVO.getPageNumber();
		if(pageNum == 0) {
			pictVO.setPageNumber(1);
			pageNum = 1;
		}

		
		int startNum = (pageNum - 1) * limitNumber;
		pictVO.setStartNumber(startNum);
		Integer totalCnt = pictService.feed_list_cnt(pictVO);
		int lastPageValue = (int)(Math.ceil( totalCnt * 1.0 / 20 )); 
		pictVO.setLastPage(lastPageValue);
		Integer s_page = pageNum - 4;
		Integer e_page = pageNum + 5;
		if (s_page <= 0) {
			s_page = 1;
			e_page = 10;
		} 
		if (e_page > lastPageValue){
			e_page = lastPageValue;
		}
		pictVO.setStartPage(s_page);
		pictVO.setEndPage(e_page);
		

		List<PictVO> reference_list = pictService.feed_list(pictVO);

		model.addAttribute("resultList", reference_list);
		model.addAttribute("board_cnt", totalCnt);
		
		
		model.addAttribute("pictVO", pictVO);
		
		return "pict/feed/feed_list";
	}
	@RequestMapping(value = "/feed/feed_del.do", method = RequestMethod.POST)
	public String feed_del(@ModelAttribute("searchVO") PictVO pictVO, ModelMap model, HttpServletRequest request) throws Exception {
		String session = (String)request.getSession().getAttribute("id");
		if(session == null || session == "null") {
			return "redirect:/pict_login.do";
		}
		pictService.feed_del(pictVO);
		
		model.addAttribute("message", "정상적으로 삭제되었습니다.");
		model.addAttribute("retType", ":location");
		model.addAttribute("retUrl", "/feed/feed_list.do");
		return "pict/main/message";
	}
	
	//피드댓글
	@RequestMapping(value = "/feed/feed_reply_list.do")
	public String feed_reply_list(@ModelAttribute("searchVO") PictVO pictVO, ModelMap model, HttpServletRequest request) throws Exception {
		String session = (String)request.getSession().getAttribute("id");
		if(session == null || session == "null") {
			return "redirect:/pict_login.do";
		}
		

		List<PictVO> reference_list = pictService.feed_reply_list(pictVO);

		model.addAttribute("resultList", reference_list);
		model.addAttribute("board_cnt", reference_list.size());
		
		
		model.addAttribute("pictVO", pictVO);
		
		return "pict/feed/feed_reply_list";
	}
	@RequestMapping(value = "/feed/feed_reply_del.do", method = RequestMethod.POST)
	public String feed_reply_del(@ModelAttribute("searchVO") PictVO pictVO, ModelMap model, HttpServletRequest request) throws Exception {
		String session = (String)request.getSession().getAttribute("id");
		if(session == null || session == "null") {
			return "redirect:/pict_login.do";
		}
		String feed_id = pictVO.getFeed_id();
		pictService.feed_reply_del(pictVO);
		
		model.addAttribute("message", "정상적으로 삭제되었습니다.");
		model.addAttribute("retType", ":location");
		model.addAttribute("retUrl", "/feed/feed_reply_list.do?feed_id=" +feed_id);
		return "pict/main/message";
	}
	
	
	//코스이력 리스트
	@RequestMapping(value = "/history/history_list.do")
	public String history_list(@ModelAttribute("searchVO") PictVO pictVO, ModelMap model, HttpServletRequest request) throws Exception {
		String session = (String)request.getSession().getAttribute("id");
		if(session == null || session == "null") {
			return "redirect:/pict_login.do";
		}
		
		int limitNumber = 20;
		pictVO.setLimit(limitNumber);
		Integer pageNum = pictVO.getPageNumber();
		if(pageNum == 0) {
			pictVO.setPageNumber(1);
			pageNum = 1;
		}

		
		int startNum = (pageNum - 1) * limitNumber;
		pictVO.setStartNumber(startNum);
		Integer totalCnt = pictService.history_list_cnt(pictVO);
		int lastPageValue = (int)(Math.ceil( totalCnt * 1.0 / 20 )); 
		pictVO.setLastPage(lastPageValue);
		Integer s_page = pageNum - 4;
		Integer e_page = pageNum + 5;
		if (s_page <= 0) {
			s_page = 1;
			e_page = 10;
		} 
		if (e_page > lastPageValue){
			e_page = lastPageValue;
		}
		pictVO.setStartPage(s_page);
		pictVO.setEndPage(e_page);
		

		List<PictVO> reference_list = pictService.history_list(pictVO);

		model.addAttribute("resultList", reference_list);
		model.addAttribute("board_cnt", totalCnt);
		
		
		model.addAttribute("pictVO", pictVO);
		
		return "pict/history/history_list";
	}
	@RequestMapping(value = "/history/history_del.do", method = RequestMethod.POST)
	public String history_del(@ModelAttribute("searchVO") PictVO pictVO, ModelMap model, HttpServletRequest request) throws Exception {
		String session = (String)request.getSession().getAttribute("id");
		if(session == null || session == "null") {
			return "redirect:/pict_login.do";
		}
		pictService.history_del(pictVO);
		
		model.addAttribute("message", "정상적으로 삭제되었습니다.");
		model.addAttribute("retType", ":location");
		model.addAttribute("retUrl", "/history/history_list.do");
		return "pict/main/message";
	}
	
	//행사관리
	@RequestMapping(value = "/event/event_list.do")
	public String event_list(@ModelAttribute("searchVO") PictVO pictVO, ModelMap model, HttpServletRequest request) throws Exception {
		String session = (String)request.getSession().getAttribute("id");
		if(session == null || session == "null") {
			return "redirect:/pict_login.do";
		}
		pictVO.setUser_id(session);

		int limitNumber = 10;
		pictVO.setLimit(limitNumber);
		
		Integer pageNum = pictVO.getPageNumber();
		
		if(pageNum == 0) {
			pictVO.setPageNumber(1);
			pageNum = 1;
		}

		int startNum = (pageNum - 1) * limitNumber;
		pictVO.setStartNumber(startNum);
		
		Integer totalCnt = pictService.event_list_cnt(pictVO);
		
		int lastPageValue = (int)(Math.ceil( totalCnt * 1.0 / 10 )); 
		pictVO.setLastPage(lastPageValue);
		
		Integer s_page = pageNum - 4;
		Integer e_page = pageNum + 5;
		if (s_page <= 0) {
			s_page = 1;
			e_page = 10;
		} 
		if (e_page > lastPageValue){
			e_page = lastPageValue;
		}
		
		pictVO.setStartPage(s_page);
		pictVO.setEndPage(e_page);
		
		List<PictVO> event_list = pictService.event_list(pictVO);
		model.addAttribute("resultList", event_list);
		model.addAttribute("totalCnt", totalCnt);

		model.addAttribute("pictVO", pictVO);
		
		return "pict/event/event_list";
	}
	@RequestMapping(value = "/event/event_register.do")
	public String event_register(@ModelAttribute("searchVO") PictVO pictVO, ModelMap model, HttpServletRequest request) throws Exception {
		String session = (String)request.getSession().getAttribute("id");
		if(session == null || session == "null") {
			return "redirect:/pict_login.do";
		}
		pictVO.setUser_id(session);
		
		
		if(pictVO.getIdx() != 0) {
			//수정
			pictVO = pictService.event_list_one(pictVO);
			pictVO.setSaveType("update");
		}
		else {
			pictVO.setSaveType("insert");
			//인설트
		}
		model.addAttribute("pictVO", pictVO);
			
		return "pict/event/event_register";
	}
	@RequestMapping(value = "/event/event_save.do", method = RequestMethod.POST)
	public String event_save(@ModelAttribute("pictVO") PictVO pictVO, ModelMap model, MultipartHttpServletRequest request,
			@RequestParam("attach_file") MultipartFile attach_file) throws Exception {
		String session = (String)request.getSession().getAttribute("id");
		if(session == null || session == "null") {
			return "redirect:/pict_login.do";
		}
		if(attach_file.getSize() != 0) {	//애드벌룬
			String uploadPath = fileUpload(request, attach_file, (String)request.getSession().getAttribute("id"));
			String filepath = "/user1/upload_file/menbaloo/";
			String filename = uploadPath.split("#####")[1];
			pictVO.setImage(filepath+filename);
		}
		//pictVO.setType(pictVO.getType().replaceAll(",", ""));
		if(pictVO.getSaveType() != null && pictVO.getSaveType().equals("update")) {
			pictService.event_update(pictVO);
			model.addAttribute("message", "정상적으로 수정되었습니다.");
			model.addAttribute("retType", ":location");
			model.addAttribute("retUrl", "/event/event_list.do");
			return "pict/main/message";
		}
		else {
			pictService.event_insert(pictVO);
			model.addAttribute("message", "정상적으로 저장되었습니다.");
			model.addAttribute("retType", ":location");
			model.addAttribute("retUrl", "/event/event_list.do");
			return "pict/main/message";	
		}
		
	}	
	@RequestMapping(value = "/event/event_delete.do", method = RequestMethod.POST)
	public String event_delete(@ModelAttribute("searchVO") PictVO pictVO, ModelMap model, HttpServletRequest request) throws Exception {
		String session = (String)request.getSession().getAttribute("id");
		if(session == null || session == "null") {
			return "redirect:/pict_login.do";
		}
		pictService.event_delete(pictVO);
		
		model.addAttribute("message", "정상적으로 삭제되었습니다.");
		model.addAttribute("retType", ":location");
		model.addAttribute("retUrl", "/event/event_list.do");
		return "pict/main/message";
		
	}	
	
	//코스관리
	@RequestMapping(value = "/course/course_list.do")
	public String course_list(@ModelAttribute("searchVO") PictVO pictVO, ModelMap model, HttpServletRequest request) throws Exception {
		String session = (String)request.getSession().getAttribute("id");
		if(session == null || session == "null") {
			return "redirect:/pict_login.do";
		}
		pictVO.setUser_id(session);

		int limitNumber = 10;
		pictVO.setLimit(limitNumber);
		
		Integer pageNum = pictVO.getPageNumber();
		
		if(pageNum == 0) {
			pictVO.setPageNumber(1);
			pageNum = 1;
		}

		int startNum = (pageNum - 1) * limitNumber;
		pictVO.setStartNumber(startNum);
		
		Integer totalCnt = pictService.course_list_cnt(pictVO);
		
		int lastPageValue = (int)(Math.ceil( totalCnt * 1.0 / 10 )); 
		pictVO.setLastPage(lastPageValue);
		
		Integer s_page = pageNum - 4;
		Integer e_page = pageNum + 5;
		if (s_page <= 0) {
			s_page = 1;
			e_page = 10;
		} 
		if (e_page > lastPageValue){
			e_page = lastPageValue;
		}
		
		pictVO.setStartPage(s_page);
		pictVO.setEndPage(e_page);
		
		List<PictVO> course_list = pictService.course_list(pictVO);
		model.addAttribute("resultList", course_list);
		model.addAttribute("totalCnt", totalCnt);

		model.addAttribute("pictVO", pictVO);
		
		return "pict/course/course_list";
	}
	@RequestMapping(value = "/course/course_register.do")
	public String course_register(@ModelAttribute("searchVO") PictVO pictVO, ModelMap model, HttpServletRequest request) throws Exception {
		String session = (String)request.getSession().getAttribute("id");
		if(session == null || session == "null") {
			return "redirect:/pict_login.do";
		}
		pictVO.setUser_id(session);
		
		
		if(pictVO.getIdx() != 0) {
			//수정
			pictVO = pictService.course_list_one(pictVO);
			pictVO.setSaveType("update");
		}
		else {
			pictVO.setSaveType("insert");
			//인설트
		}
		model.addAttribute("pictVO", pictVO);
			
		return "pict/course/course_register";
	}
	@RequestMapping(value = "/course/course_save.do", method = RequestMethod.POST)
	public String course_save(@ModelAttribute("pictVO") PictVO pictVO, ModelMap model, MultipartHttpServletRequest request,
			@RequestParam("attach_file") MultipartFile attach_file) throws Exception {
		String session = (String)request.getSession().getAttribute("id");
		if(session == null || session == "null") {
			return "redirect:/pict_login.do";
		}
		if(attach_file.getSize() != 0) {	//애드벌룬
			String uploadPath = fileUpload(request, attach_file, (String)request.getSession().getAttribute("id"));
			String filepath = "/user1/upload_file/menbaloo/";
			String filename = uploadPath.split("#####")[1];
			pictVO.setImage(filepath+filename);
		}
		//pictVO.setType(pictVO.getType().replaceAll(",", ""));
		if(pictVO.getSaveType() != null && pictVO.getSaveType().equals("update")) {
			pictService.course_update(pictVO);
			model.addAttribute("message", "정상적으로 수정되었습니다.");
			model.addAttribute("retType", ":location");
			model.addAttribute("retUrl", "/course/course_list.do");
			return "pict/main/message";
		}
		else {
			pictService.course_insert(pictVO);
			model.addAttribute("message", "정상적으로 저장되었습니다.");
			model.addAttribute("retType", ":location");
			model.addAttribute("retUrl", "/course/course_list.do");
			return "pict/main/message";	
		}
		
	}	
	@RequestMapping(value = "/course/course_delete.do", method = RequestMethod.POST)
	public String course_delete(@ModelAttribute("searchVO") PictVO pictVO, ModelMap model, HttpServletRequest request) throws Exception {
		String session = (String)request.getSession().getAttribute("id");
		if(session == null || session == "null") {
			return "redirect:/pict_login.do";
		}
		pictService.course_delete(pictVO);
		
		model.addAttribute("message", "정상적으로 삭제되었습니다.");
		model.addAttribute("retType", ":location");
		model.addAttribute("retUrl", "/course/course_list.do");
		return "pict/main/message";
		
	}	
	
	
	
    //메소드
	public static String encryptPassword(String password, String id) throws Exception {
		if (password == null) return "";
		if (id == null) return ""; // KISA 보안약점 조치 (2018-12-11, 신용호)
		byte[] hashValue = null; // 해쉬값
	
		MessageDigest md = MessageDigest.getInstance("SHA-256");
		md.reset();
		md.update(id.getBytes());
		hashValue = md.digest(password.getBytes());
	
		return new String(Base64.encodeBase64(hashValue));
    }
	public String fileUpload(MultipartHttpServletRequest request, MultipartFile uploadFile, String target) {
    	String path = "";
    	String fileName = "";
    	OutputStream out = null;
    	PrintWriter printWriter = null;
    	long fileSize = uploadFile.getSize();
    	try {
    		fileName = uploadFile.getOriginalFilename();
    		byte[] bytes = uploadFile.getBytes();
    		
			path = getSaveLocation(request, uploadFile);
    		
    		
    		File file = new File(path);
    		if(fileName != null && !fileName.equals("")) {
    			if(file.exists()) {
    				file = new File(path + fileName);
    			}
    		}
    		out = new FileOutputStream(file);
    		out.write(bytes);
    		
    		
    	}
    	catch(Exception e) {
    		e.printStackTrace();
    	}
    	
    	return path + "#####" + fileName;
    }
    private String getSaveLocation(MultipartHttpServletRequest request, MultipartFile uploadFile) {
    	String uploadPath = "/user1/upload_file/menbaloo/";
    	return uploadPath;
    }
    private static String getTagValue(String tag, Element eElement) {
	    NodeList nlList = eElement.getElementsByTagName(tag).item(0).getChildNodes();
	    Node nValue = (Node) nlList.item(0);
	    if(nValue == null) 
	        return null;
	    return nValue.getNodeValue();
	}
    
    
    
}
