package control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Function;
import entity.pay;

@SuppressWarnings("serial")
public class DoUpdatePayServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public DoUpdatePayServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.print("    This is ");
		out.print(this.getClass());
		out.println(", using the GET method");
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//接收form表单数据，验证无误后，将数据保存到数据表中，
		//1、完成数据校验 
		request.setCharacterEncoding("utf-8");
        int id=Integer.parseInt( request.getParameter("id"));
		String leave=request.getParameter("leave");
		String belate=request.getParameter("belate");
		String absent=request.getParameter("absent");
		String basepay=request.getParameter("basepay");
		String bonus=request.getParameter("bonus");
		String depay=request.getParameter("depay");
		String rpay=request.getParameter("rpay");
		//2、数据保存
		//生成pay对象数据
		pay s=new pay();
		s.setId(id);
		s.setLeave(leave);
		s.setBelate(belate);
		s.setAbsent(absent);
		s.setBasepay(basepay);
		s.setBonus(bonus);
		s.setDepay(depay);
		s.setRpay(rpay);
		@SuppressWarnings("unused")
		boolean   r=Function.Update(s);
		response.sendRedirect("ListPay");
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
