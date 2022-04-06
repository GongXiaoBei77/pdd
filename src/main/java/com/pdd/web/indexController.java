package com.pdd.web;

import com.pdd.model.Pdd;
import com.pdd.model.ResponseResult;
import com.pdd.service.PddService;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * @author GongXiaoBei
 */
@Controller
public class indexController {
	@Autowired
	private PddService pddService;
	
	@GetMapping({"", "/index"})
	public String index(Model model) {
		List<Pdd> pddList = pddService.findAll();
		model.addAttribute("pddList", pddList);
		return "/index";
	}
	
	@GetMapping("/select")
	@ResponseBody
	public ResponseResult selectByTypeN(String typeN) {
		ResponseResult result = new ResponseResult();
		List<Pdd> byTypeN = pddService.findByTypeN(typeN);
		result.setCode(2000);
		result.setMsg("查询成功");
		result.setData(byTypeN);
		return result;
	}
	
	@PostMapping("/remove")
	@ResponseBody
	public ResponseResult remove(int[] ids) {
		ResponseResult result = new ResponseResult();
		int i = pddService.removeById(ids);
		if (i < 1) {
			result.setCode(4000);
			result.setMsg("删除失败");
			result.setData(i);
			return result;
		}
		result.setCode(2000);
		result.setMsg("删除成功");
		result.setData(i);
		return result;
	}
	
	@RequestMapping("/download")
	public void downloadPoster(HttpServletRequest req, HttpServletResponse resp)
			throws
			IOException {
		//生成文件名
		String time = String.valueOf(System.currentTimeMillis());
		String filename = time + ".xls";
		resp.setCharacterEncoding("UTF-8");
		//设置响应头，告知浏览器以附件方式下载该响应体
		resp.setHeader("content-type", "application/octet-stream");
		resp.setHeader("content-disposition", "attachement;filename=" + URLEncoder.encode(filename, "UTF-8"));
		//创建工作簿
		HSSFWorkbook workbook = new HSSFWorkbook();
		//创建工作单
		HSSFSheet sheet = workbook.createSheet("市场活动");
		HSSFRow titlerRow = sheet.createRow(0);
		titlerRow.createCell(0).setCellValue("商品ID");
		titlerRow.createCell(1).setCellValue("商品名");
		titlerRow.createCell(2).setCellValue("导航图链接");
		titlerRow.createCell(3).setCellValue("导航图日期");
		titlerRow.createCell(4).setCellValue("详细图链接");
		titlerRow.createCell(5).setCellValue("详细图日期");
		titlerRow.createCell(6).setCellValue("商铺ID");
		titlerRow.createCell(7).setCellValue("价格");
		titlerRow.createCell(8).setCellValue("销量");
		titlerRow.createCell(9).setCellValue("类别");
		List<Pdd> all = pddService.findAll();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		int lastRow = 1;
		for (Pdd pdd : all) {
			titlerRow = sheet.createRow(lastRow);
			titlerRow.createCell(0).setCellValue(String.valueOf(pdd.getGoodsId()));
			titlerRow.createCell(1).setCellValue(pdd.getGoodsName());
			titlerRow.createCell(2).setCellValue(pdd.getHdThumbUrl());
			titlerRow.createCell(3).setCellValue(sdf.format(pdd.getHdThumbDate()));
			titlerRow.createCell(4).setCellValue(pdd.getHdUrl());
			titlerRow.createCell(5).setCellValue(sdf.format(pdd.getHdDate()));
			titlerRow.createCell(6).setCellValue(String.valueOf(pdd.getMallId()));
			titlerRow.createCell(7).setCellValue(pdd.getPriceInfo());
			titlerRow.createCell(8).setCellValue(pdd.getSales());
			titlerRow.createCell(9).setCellValue(pdd.getTypen());
			lastRow++;
		}
		//保存到输出流
		workbook.write(resp.getOutputStream());
		resp.getOutputStream().flush();
		
	}
	
}
