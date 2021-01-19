package com.javaex.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaex.dao.PhoneDao;
import com.javaex.vo.PersonVo;

@Controller
@RequestMapping(value = "/phone")
public class PhoneController {

	// 피드

	// 생성자

	// 메소드(get/set)

	// 일반 메소드
	// 리스트
	@RequestMapping(value = "/list", method = { RequestMethod.GET, RequestMethod.POST })
	public String list(Model model) {
		System.out.println("list");

		// dao.getList();
		PhoneDao pDao = new PhoneDao();
		List<PersonVo> pList = pDao.dbList();

		System.out.println(pList.toString());

		// modle → data 전송
		model.addAttribute("PersonList", pList);

		return "/WEB-INF/views/list.jsp";
	}

	// 등록폼
	@RequestMapping(value = "/writeForm", method = { RequestMethod.GET, RequestMethod.POST })
	public String writeForm() {
		System.out.println("writeForm");

		return "/WEB-INF/views/writeForm.jsp";
	}

	// http://localhost:8088/phonebook3/phone/write?name=[]&hp=[]&company=[]
	// 등록
	@RequestMapping(value = "/write", method = { RequestMethod.GET, RequestMethod.POST })
	public String write(@RequestParam("name") String name, @RequestParam("hp") String hp,
			@RequestParam("company") String company) {
		System.out.println("write");

		PersonVo pVo = new PersonVo(name, hp, company);
		System.out.println(pVo);

		PhoneDao pDao = new PhoneDao();
		pDao.dbIsrt(pVo);

		return "redirect:/phone/list";
	}
}
