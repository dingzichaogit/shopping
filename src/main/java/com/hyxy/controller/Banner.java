package com.hyxy.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
	@RequestMapping("skip")
	public String Skip() {
		return "banner";
	}
	@RequestMapping("add")
	public String Add() {
		return "banner-add";
		
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
		System.out.println(map.get("id"));
		System.out.println(map.get("path"));
		System.out.println(map.get("url"));
		System.out.println(map.get("orders"));
		System.out.println(map.get("starts"));
		System.out.println(map.get("title"));
	   BannerService.insert(map);
	   Map<String, String> map2=new HashMap<String, String>();
	    map2.put("message", "成功");
		
	
		return map2;
		
	}
	@RequestMapping("select")
	
	public String select(Map<String, Object> map) {
		
	List<Picture> list=BannerService.select();
	map.put("banner", list);
	
		return "banner";
		
	}
	
	
	@RequestMapping(value = "update/{id}")
	public String UpDate(@PathVariable int id,Map<String, Object> map) {
		
		List<Picture> list=BannerService.selectid(id);
		for (Picture picture : list) {
			System.out.println(picture.getTitle());
			System.out.println(picture.getUrl());
		}
		
		map.put("info", list);
		return "banner-edit";
	}
	
	@RequestMapping(value = "delete/{id}")
	public String Delete(@PathVariable int id) {
		
		BannerService.delete(id);
		return "forward:/bannercontroller/select";
	}
	@RequestMapping("updates")
	public String UpDates(@RequestParam Map<String, Object> map) {
		
		BannerService.update(map);
		
		return "forward:/bannercontroller/select";
	}
}
