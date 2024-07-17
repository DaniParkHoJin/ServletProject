package join;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class JoinServlet
 */
@WebServlet("/join")
public class JoinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public JoinServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String name = request.getParameter("name_name");
		String birthday = request.getParameter("birthday");
		String id = request.getParameter("name_userid");
		String password = request.getParameter("name_password");
		String email = request.getParameter("name_email");
		String tel = request.getParameter("name_tel1") + request.getParameter("name_tel2")
				+ request.getParameter("name_tel3");
		String phone = request.getParameter("name_phone1") + request.getParameter("name_phone2") + request.getParameter("name_phone3");
		String zipcode = request.getParameter("name_zipcode");
		String address = request.getParameter("name_address1") + request.getParameter("name_address2") + request.getParameter("name_address3");
		String job = request.getParameter("name_job");
		String pathway = request.getParameter("pathway");
		
		System.out.println("name = " + name);
		System.out.println("birthday = " + birthday);
		System.out.println("id = " + id);
		System.out.println("password = " + password);
		System.out.println("email = " + tel);
		System.out.println("tel = " + tel);
		System.out.println("phone = " + phone);
		System.out.println("zipcode = " + zipcode);
		System.out.println("address = " + address);
		System.out.println("job = " + job);
		System.out.println("pathway = " + pathway);

	}

}
