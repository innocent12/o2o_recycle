package user.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import user.pojo.SellerAddress;
import user.pojo.SellerAddressExample;
/**
 * 
 * @author JCX
 *
 */
public interface SellerAddressMapper {
    int countByExample(SellerAddressExample example);

    int deleteByExample(SellerAddressExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SellerAddress record);

    int insertSelective(SellerAddress record);

    List<SellerAddress> selectByExample(SellerAddressExample example);

    SellerAddress selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SellerAddress record, @Param("example") SellerAddressExample example);

    int updateByExample(@Param("record") SellerAddress record, @Param("example") SellerAddressExample example);

    int updateByPrimaryKeySelective(SellerAddress record);

    int updateByPrimaryKey(SellerAddress record);
}