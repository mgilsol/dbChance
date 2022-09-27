package com.db.challenge.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DefaultController implements ErrorController {

//	@RequestMapping("/error")
//	public void handleErrorWithRedirect(HttpServletResponse response) throws IOException {
//		response.sendRedirect("/swagger-ui.html");
//	}

}
