package dcs.project.barangay.mappers;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import dcs.project.barangay.bean.BarangayOfficialBean;

@Mapper
public interface BarangayOfficialMappers {
	
	@Select("select * from [dbo].[BarangayOfficials] where UserName =#{userName}")
	BarangayOfficialBean findUser(@Param("userName") String userName);
}
