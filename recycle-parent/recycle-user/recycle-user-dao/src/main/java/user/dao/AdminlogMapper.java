package user.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import user.pojo.Adminlog;
import user.pojo.AdminlogExample;

/**
 * 
 * @author JCX
 *
 */
public interface AdminlogMapper {
    int countByExample(AdminlogExample example);

    int deleteByExample(AdminlogExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Adminlog record);

    int insertSelective(Adminlog record);

    List<Adminlog> selectByExample(AdminlogExample example);

    Adminlog selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Adminlog record, @Param("example") AdminlogExample example);

    int updateByExample(@Param("record") Adminlog record, @Param("example") AdminlogExample example);

    int updateByPrimaryKeySelective(Adminlog record);

    int updateByPrimaryKey(Adminlog record);
}