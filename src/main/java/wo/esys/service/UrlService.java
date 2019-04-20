package wo.esys.service;


import wo.common.entity.WoPage;
import wo.esys.po.Url;

public interface UrlService {

	String create(String longUrl);

	Url getUrl(String shortUrl);

	boolean create(String longUrl, String sUrl);

	void updateCount(Url url);

	WoPage<Url> getPageData(Integer page, Integer limit);

	

}
