package wo.esys.controller;



import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import wo.common.entity.WoPage;
import wo.common.exception.WoResultCode;
import wo.common.util.WoUtil;
import wo.esys.po.Url;
import wo.esys.service.UrlService;


@Controller
@RequestMapping("/shortUrl")
public class UrlController {


	@Resource
	private UrlService urlService;
	
	

	/**
	 * 短链接随机生成
	 *
	 */
	
	@PostMapping("/create")
	@ResponseBody
	public WoResultCode create(String longUrl,String shortUrl){
			
		if(!WoUtil.isEmpty(shortUrl)) {
			
			if(urlService.create(longUrl,shortUrl)) {
				return new WoResultCode(200, "生成成功", shortUrl);
			}else {
				return new WoResultCode(200, "生成成功", shortUrl);
			}
			
		}else {
			shortUrl = urlService.create(longUrl);
			return new WoResultCode(200, "生成成功", shortUrl);
		}
		
	}
	
	/**
	 * 短链接统计分析，跳到页面
	 *
	 */
	
	@GetMapping("/Statistics")
	public String Statistics(){
		return "statistics";
	}
	
	/**
	 * 短链接统计分析，页面加载数据
	 *
	 */
	@RequestMapping("/list")
	@ResponseBody
	public WoResultCode Statistics(Integer page,Integer limit){
		WoPage<Url> list =  urlService.getPageData(page,limit);		
		return new WoResultCode(0, "获取成功", list.getResults(), list.getRows());
	}


}
