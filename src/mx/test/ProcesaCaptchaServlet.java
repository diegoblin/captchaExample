package mx.test;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.octo.captcha.service.CaptchaServiceException;

public class ProcesaCaptchaServlet extends HttpServlet {
    
	protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
    	Boolean isResponseCorrect =Boolean.FALSE;
        //remenber that we need an id to validate!
        String captchaId = httpServletRequest.getSession().getId();
        //retrieve the response
        String response = httpServletRequest.getParameter("j_captcha_response");
        // Call the Service method
         try {
             isResponseCorrect = CaptchaServiceSingleton.getInstance().validateResponseForID(captchaId,
                     response);
         } catch (CaptchaServiceException e) {
              //should not happen, may be thrown if the id is not valid
         }

         //do something according to the result!
    }
	
	protected void doPost(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
    	Boolean isResponseCorrect =Boolean.FALSE;
        //remenber that we need an id to validate!
        String captchaId = httpServletRequest.getSession().getId();
        //retrieve the response
        String response = httpServletRequest.getParameter("j_captcha_response");
        // Call the Service method
         try {
             isResponseCorrect = CaptchaServiceSingleton.getInstance().validateResponseForID(captchaId,response);
             System.out.println("isResponseCorrect: " + isResponseCorrect);
         } catch (CaptchaServiceException e) {
              //should not happen, may be thrown if the id is not valid
         }

         //do something according to the result!
    }

}
