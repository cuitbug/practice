package wo.esys.service.impl;

import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;


import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import wo.common.entity.WoPage;
import wo.esys.mapper.UrlMapper;
import wo.esys.po.Url;
import wo.esys.repository.UrlRepository;
import wo.esys.service.UrlService;
import wo.esys.util.UrlUtil;


@Service
@Transactional
public class UrlServiceImpl implements UrlService {
	
	@Resource
	private UrlRepository urlRepository;
	
	@Resource
	private UrlMapper urlMapper;


	@Override
	public String create(String longUrl) {
		
		Url url = urlRepository.findByLongUrl(longUrl);
		if(url==null) {
			String shortUrl = UrlUtil.convertUrl(longUrl);
			Url u = new Url();
			u.setLongUrl(longUrl);
			u.setShortUrl(shortUrl);
			urlRepository.save(u);
			return shortUrl;
		}else {
			return url.getShortUrl();
		}
	}

	/**
	 * 根据短链查出URL实体
	 * 
	 */
	@Override
	public Url getUrl(String shortUrl) {
		Url url = urlRepository.findByShortUrl(shortUrl);
		return url;
	}

	@Override
	public boolean create(String longUrl, String shortUrl) {
		
		Url url = urlRepository.findByShortUrl(shortUrl);
		if(url==null) {
			Url u = new Url();
			u.setLongUrl(longUrl);
			u.setShortUrl(shortUrl);
			u.setCount(0);
			urlRepository.save(u);
			return true;
		}else {
			return false;
		}
	}

	/**
	 * 短链访问计数
	 * 
	 */
	@Override
	public void updateCount(Url url) {
		url.setCount(url.getCount()+1);
		urlRepository.save(url);
	}

	
	/**
	 * 获取当前页URL数据
	 * 
	 */
	@Override
	public WoPage<Url> getPageData(Integer page,Integer rows) {
		PageHelper.startPage(page, rows);
		List<Url> list = (List<Url>) urlMapper.findAll();
		for (Url url : list) {
			url.setShortUrl("http://localhost:8080/"+url.getShortUrl());
		}
		Page<Url> pg = (Page<Url>)list;
		return new WoPage<>(pg.getResult(), pg.getTotal());
	}

}
