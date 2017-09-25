package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class login {
	@RequestMapping("/tologin.do")
	public String log(login_entity le) {
		System.out.println("le()");
		return "login";
	}
	
	@RequestMapping("/login.do")
		public ModelAndView log1(login_entity le) {
			System.out.println("username:" + le.getUsername() +" " +"pwd:" + le.getPwd());
			RedirectView rv = new RedirectView("tologin1.do");
			return new ModelAndView(rv);	
		}
	
	@RequestMapping("/tologin1.do")
	public String log2(login_entity le) {
		return "login1";
	}
}

