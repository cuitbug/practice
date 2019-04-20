package wo.esys.po;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "sUrl_url")
public class Url {

	/**
	 * 主键id
	 */
	@Id
	@GeneratedValue
	private int id;



	@Column
	private String shortUrl;

	/**
	 * 指向url
	 */
	@Column
	private String longUrl;

	/**
	 * 访问计数
	 */
	@Column
	private int count;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getShortUrl() {
		return shortUrl;
	}

	public void setShortUrl(String shortUrl) {
		this.shortUrl = shortUrl;
	}

	public String getLongUrl() {
		return longUrl;
	}

	public void setLongUrl(String longUrl) {
		this.longUrl = longUrl;
	}
	
	


}
