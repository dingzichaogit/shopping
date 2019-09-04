package com.hyxy.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.hyxy.entity.Picture;
import com.hyxy.service.BannerService;
import com.hyxy.utils.upload2;

@Controller
@RequestMapping("bannercontroller")

public class Banner {
    @Autowired
    private BannerService BannerService;
    public static boolean Role(String role) {
		Subject subject=SecurityUtils.getSubject();
		System.out.println(subject.hasRole(role));
		if (subject.hasRole(role)) {
			return true;
		}else {
			return false;
		}
	}
    public static boolean Power(String power) {
    	Subject subject =SecurityUtils.getSubject();
    	
    	System.out.println(subject.isPermitted(power));
    	if (subject.isPermitted(power)) {
			return true;
		}else {
			return false;
		}
	}
	@RequestMapping("add")
	public String Add() {
		
		Subject subject=SecurityUtils.getSubject();
		
		if (Banner.Role("管理员")) {
			if (Banner.Power("banneradd")) {
				return "banner-add";
			}else {
				return "redirect:/logincontroller/skip";
			}
		} else {
			return "redirect:/logincontroller/skip";
		}
		
		
	}
	@RequestMapping("upload")
	@ResponseBody
	public List<Map<String, String>> Upload(HttpServletRequest request, String username ,@RequestParam(value="file",required=false)MultipartFile[] files) {
		List<Map<String, String>> lists = new ArrayList<>();
		// 调用图片上传工具类
		upload2 upload2=new upload2();
		List<Map<String, String>> list=upload2.uploadfile(request, files);	
		
		return list;
	}
	@RequestMapping("addp")
	@ResponseBody
	public Map<String, String> Addp(@RequestParam Map<String, Object> map) {
		 Map<String, String> map2=new HashMap<String, String>();
				BannerService.insert(map);
			    map2.put("message", "成功");  
		return map2;
	}
	@RequestMapping("select")
	
	public String select(Map<String, Object> map) {
		if (Banner.Role("管理员")) {
			if (Banner.Power("bannerselect")) {
				List<Picture> list=BannerService.select();
				map.put("banner", list);
				
					return "banner";
			} else {
				return "redirect:/logincontroller/skip";
			}
		} else {
			return "redirect:/logincontroller/skip";
		}
	}
	
	
	@RequestMapping(value = "update/{id}")
	public String UpDate(@PathVariable int id,Map<String, Object> map) {
		if (Banner.Role("管理员")) {
			if (Banner.Power("banneredit")) {
				List<Picture> list=BannerService.selectid(id);
				
				map.put("info", list);
				return "banner-edit";
			} else {
				return "redirect:/logincontroller/skip";
			}
		} else {
			return "redirect:/logincontroller/skip";
		}
		
	}
	
	@RequestMapping(value = "delete/{id}")
	public String Delete(@PathVariable int id) {
		if (Banner.Role("管理员")) {
			if (Banner.Power("bannerdelete")) {
				BannerService.delete(id);
				return "forward:/bannercontroller/select";
			} else {
				return "redirect:/logincontroller/skip";
			}
		} else {
			return "redirect:/logincontroller/skip";
		}
		
	}
	@RequestMapping("updates")
	public String UpDates(@RequestParam Map<String, Object> map) {
				BannerService.update(map);
				return "forward:/bannercontroller/select";
		
	}
}
