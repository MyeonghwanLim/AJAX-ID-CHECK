package test;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Check
 */
@WebServlet("/check.do")
public class Check extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Check() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("로그1 ["+request.getParameter("mid")+"]");
		// 로그에 [] 사용이유는 null 값이들어오면 아무것도 보이지않게 구분하기 위해서 사용한다.
		// 판단할떄는 / 를앞에붙이고 요청할 떄는 붙이지 않는다.
		
		TestDAO dao =new TestDAO();
		TestVO vo = new TestVO();
		vo.setMid(request.getParameter("mid"));
		int result = dao.check(vo);
		
		response.setContentType("application/x-json; chsrest=UTF-8");
		response.getWriter().write(result+"");
	}

}
