package nongsan.webmvc.controller.admin; 
 
import java.io.IOException; 
import java.util.List; 
 
import javax.servlet.RequestDispatcher; 
import javax.servlet.ServletException; 
import javax.servlet.annotation.WebServlet; 
import javax.servlet.http.HttpServlet; 
import javax.servlet.http.HttpServletRequest; 
import javax.servlet.http.HttpServletResponse; 
 
import nongsan.webmvc.service.AdminService; 
import nongsan.webmvc.service.impl.AdminServicesImpl; 
import nongsan.webmvc.model.Admin; 
 
/** 
 * Servlet implementation class AdminAddController 
 */ 
//@WebServlet(urlPatterns = { "" }) 
public class AdminAddController extends HttpServlet { 
	/** 
	 *  
	 */ 
	private static final long serialVersionUID = 1L; 
	AdminService adminService = new AdminServicesImpl(); 
 
	@Override 
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException { 
		RequestDispatcher dispatcher = req.getRequestDispatcher("/view/admin/addadmin.jsp"); 
		dispatcher.forward(req, resp); 
	} 
 
	@Override 
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {	 
		String admin_id = req.getParameter("admin-id"); 
		String admin_username = req.getParameter("admin-username"); 
		String admin_password = req.getParameter("admin-password"); 
		String admin_name = req.getParameter("admin-name"); 
		Admin admin = new Admin(); 
		admin.setId(admin_id); 
		admin.setUsername(admin_username); 
		admin.setPassword(admin_password); 
		admin.setName(admin_name); 
		adminService.insert(admin); 
		resp.sendRedirect(req.getContextPath() + "/admin/admin/list"); 
//		resp.sendRedirect(req.getContextPath() + "/view/admin/admin.jsp"); 
	} 
 
} 