package wo.esys.init;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import wo.esys.po.Url;
import wo.esys.repository.UrlRepository;
import wo.esys.util.UrlUtil;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ShortUrlInit {
	
	@Resource
	private UrlRepository urlRepository;


	@Test
	@Rollback(value = false)
	@Transactional
	public void init() {
		
		//自定义
		Url u1 = new Url();
		u1.setCount(0);
		u1.setLongUrl("https://www.layui.com/doc/base/infrastructure.html");
		u1.setShortUrl("ttttt");
		urlRepository.save(u1);
		
		Url u2 = new Url();
		u2.setCount(0);
		u2.setLongUrl("https://cloud.tencent.com/act/seckill?from=10593");
		u2.setShortUrl("ssssss");
		urlRepository.save(u2);
	
		Url u3 = new Url();
		u3.setCount(0);
		u3.setLongUrl("	https://www.mi.com/?client_id=180100041086&masid=17489.0001");
		u3.setShortUrl("s456s");
		urlRepository.save(u3);
		
		
		
		
		//随机生成
		
		Url u4 = new Url();
		u4.setCount(0);
		u4.setLongUrl("https://sale.vmall.com/pseries.html?cid=10618");
		u4.setShortUrl(UrlUtil.convertUrl("https://sale.vmall.com/pseries.html?cid=10618"));
		urlRepository.save(u4);
		
		Url u5 = new Url();
		u5.setCount(0);
		u5.setLongUrl("https://www.nokia.com/phones/zh_int/?frontpage=home-cta");
		u5.setShortUrl(UrlUtil.convertUrl("https://www.nokia.com/phones/zh_int/?frontpage=home-cta"));
		urlRepository.save(u5);
		
		
		Url u6 = new Url();
		u6.setCount(0);
		u6.setLongUrl("http://support-cn.samsung.com/campaign/mobilephone/galaxys10/?cid=cn_ppc_baidubz_20190308_rpm_s10main1_shipintoubumiaoshu");
		u6.setShortUrl(UrlUtil.convertUrl("http://support-cn.samsung.com/campaign/mobilephone/galaxys10/?cid=cn_ppc_baidubz_20190308_rpm_s10main1_shipintoubumiaoshu"));
		urlRepository.save(u6);

	}



}







