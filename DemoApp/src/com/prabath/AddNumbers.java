package com.prabath;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddNumbers extends HttpServlet {
	public void service(HttpServletRequest req, HttpServletResponse res) throws IOException {
		double num1 = Double.parseDouble(req.getParameter("num1"));
		double num2 = Double.parseDouble(req.getParameter("num2"));
		String opt = req.getParameter("opt");
		double answer = 0;
		PrintWriter writer = res.getWriter();
		
		if (opt.equals("+") || opt.equals("-") || opt.equals("*") || opt.equals("/")) {
			switch (opt) {
			case "+":
				answer = num1 + num2;
				break;
			case "-":
				answer = num1 - num2;
				break;	
			case "/":
				answer = num1 / num2;
				break;
			case "*":
				answer = num1 * num2;
				break;
			}
			
			writer.println("Answer is: " + answer);
		}
		else {
			writer.println("Invalid Operator..!");
		}
	}
}
