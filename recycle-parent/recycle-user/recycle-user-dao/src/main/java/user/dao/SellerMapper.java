package user.dao;


import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import user.pojo.Seller;
import user.pojo.SellerExample;
import user.vo.NormalSellerInfo;
import user.vo.SellerDetailedInfo;

/**
 * 
 * @author JCX
 *
 */
public interface SellerMapper {
    int countByExample(SellerExample example);

    int deleteByExample(SellerExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Seller record);

    int insertSelective(Seller record);

    List<Seller> findByPage(HashMap<String,Object> map);
    
    List<Seller> selectByExample(SellerExample example);

    Seller selectByAccountAndPasswd(String account, String password);
    
    Seller selectByOpenid(String openid);
    
    Seller selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Seller record, @Param("example") SellerExample example);

    int updateByExample(@Param("record") Seller record, @Param("example") SellerExample example);

    int updateByPrimaryKeySelective(Seller record);

    int updateByPrimaryKey(Seller record);
    
    //
    List<NormalSellerInfo> selectNormalInfoByAccount(String sellerAccount);
    
    //得到居民卖家详细信息
    SellerDetailedInfo selectDetailedInfoByAccount(String sellerAccount);
}