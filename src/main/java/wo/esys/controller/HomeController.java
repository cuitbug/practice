package wo.esys.controller;


import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import wo.esys.po.Url;
import wo.esys.service.UrlService;


@Controller
public class HomeController {

	@Resource
	private UrlService urlService;
	
	@GetMapping("/")
	public String index(){
		return "index";
    }
	
	@GetMapping("/test")
	public String newFile(){
		return "test";
    }
	
	/**
	 * 短链接访问
	 * localhost:8080/7nUFJn
	 */
	@RequestMapping("/{shortUrl:[0-9a-zA-Z]{4,8}}")
	public String accessUrl(@PathVariable("shortUrl") String shortUrl) {
	    Url url = urlService.getUrl(shortUrl);
		if (url == null) {
			return "index";
		} else {
			urlService.updateCount(url);
			return "redirect:" + url.getLongUrl();
		}
	}


}
