package wo.esys.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import wo.esys.po.Url;

@Mapper
public interface UrlMapper {
	List<Url> findAll();

}
