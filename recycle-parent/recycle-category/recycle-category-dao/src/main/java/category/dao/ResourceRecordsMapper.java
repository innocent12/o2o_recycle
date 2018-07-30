package category.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import category.pojo.ResourceRecords;
import category.pojo.ResourceRecordsExample;

public interface ResourceRecordsMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table resource_records
     *
     * @mbg.generated Thu Mar 15 10:40:36 CST 2018
     */
    long countByExample(ResourceRecordsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table resource_records
     *
     * @mbg.generated Thu Mar 15 10:40:36 CST 2018
     */
    int deleteByExample(ResourceRecordsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table resource_records
     *
     * @mbg.generated Thu Mar 15 10:40:36 CST 2018
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table resource_records
     *
     * @mbg.generated Thu Mar 15 10:40:36 CST 2018
     */
    int insert(ResourceRecords record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table resource_records
     *
     * @mbg.generated Thu Mar 15 10:40:36 CST 2018
     */
    int insertSelective(ResourceRecords record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table resource_records
     *
     * @mbg.generated Thu Mar 15 10:40:36 CST 2018
     */
    List<ResourceRecords> selectByExample(ResourceRecordsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table resource_records
     *
     * @mbg.generated Thu Mar 15 10:40:36 CST 2018
     */
    ResourceRecords selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table resource_records
     *
     * @mbg.generated Thu Mar 15 10:40:36 CST 2018
     */
    int updateByExampleSelective(@Param("record") ResourceRecords record, @Param("example") ResourceRecordsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table resource_records
     *
     * @mbg.generated Thu Mar 15 10:40:36 CST 2018
     */
    int updateByExample(@Param("record") ResourceRecords record, @Param("example") ResourceRecordsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table resource_records
     *
     * @mbg.generated Thu Mar 15 10:40:36 CST 2018
     */
    int updateByPrimaryKeySelective(ResourceRecords record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table resource_records
     *
     * @mbg.generated Thu Mar 15 10:40:36 CST 2018
     */
    int updateByPrimaryKey(ResourceRecords record);
}