package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import json.quoto;

public class ActionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		String uri = request.getRequestURI();
		String action = uri.substring(uri.lastIndexOf("/"),uri.lastIndexOf("."));
		System.out.println("action:" + action);

		if("/quoto".equals(action)) {
			List<quoto> quotos = new ArrayList<quoto>();
			Random r = new Random();
			for(int i = 0;i<8;i++) {
				quoto q = new quoto();
				q.setCode("124124" + r.nextInt(10));
				q.setName("Ã×¹þÓÎ" + r.nextInt(10));
				q.setPrice(r.nextInt(100));
				quotos.add(q);
			}
			ObjectMapper om = new ObjectMapper();
			String jsonStr = om.writeValueAsString(quotos);
			System.out.println(jsonStr);
			out.println(jsonStr);
		}
	}

}
