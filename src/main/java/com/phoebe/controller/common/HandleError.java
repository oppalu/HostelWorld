package com.phoebe.controller.common;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by phoebegl on 2017/3/5.
 */
public class HandleError {

    public static void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, String s) {
        try {
            httpServletResponse.setContentType("text/html;charset=UTF-8");
            PrintWriter writer = httpServletResponse.getWriter();
            String error = "<script>alert('"+s+"');</script>";
            writer.write(error);
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
