package wo.esys.repository;



import org.springframework.data.repository.PagingAndSortingRepository;


import wo.esys.po.Url;


public interface UrlRepository extends PagingAndSortingRepository<Url, String> {

	Url findByShortUrl(String shortUrl);

	Url findByLongUrl(String longUrl);

	

}
