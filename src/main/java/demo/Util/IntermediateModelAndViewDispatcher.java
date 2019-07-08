package demo.Util;

import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//页面中转控制器,重用一部分代码
public class IntermediateModelAndViewDispatcher {
    public ModelAndView goPage(HttpServletRequest request, HttpServletResponse response, ModelAndView mv, String nextURL, String message) {
        request.setAttribute("nextURL", nextURL);
        request.setAttribute("intermediateTimer", 3);
        request.setAttribute("message", message);
        mv.addObject("request", request);
        mv.addObject("response", response);
        mv.setViewName("General/intermediatePage");
        return mv;
    }

}
