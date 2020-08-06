package com.frans.mapper;

import com.frans.pojo.Provider;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface ProviderMapper {
    /**
     * 增加供应商
     * @param provider
     * @return
     * @throws Exception
     */
    @Insert("insert into smbms_provider " +
            "(proCode," +
            "proName," +
            "proDesc," +
            "proContact," +
            "proPhone," +
            "proAddress," +
            "proFax," +
            "createdBy," +
            "creationDate) " +
            "values(#{proCode}," +
            "#{proName}," +
            "#{proDesc}," +
            "#{proContact}," +
            "#{proPhone}," +
            "#{proAddress}," +
            "#{proFax}," +
            "#{createdBy}," +
            "#{creationDate}) ")
    public int add(Provider provider)throws Exception;


    /**
     * 通过供应商名称、编码获取供应商列表-模糊查询-providerList
     * @param proName
     * @return
     * @throws Exception
     */
    public List<Provider> getProviderList(@Param("proName") String proName, @Param("proCode") String proCode)throws Exception;

    /**
     * 通过proId删除Provider
     * @param delId
     * @return
     * @throws Exception
     */
    @Delete("delete " +
            "from smbms_provider " +
            "where id=#{delId}")
    public int deleteProviderById(@Param("delId") String delId)throws Exception;


    /**
     * 通过proId获取Provider
     * @param id
     * @return
     * @throws Exception
     */
    @Select("select * " +
            "from smbms_provider " +
            "where id=#{id}")
    public Provider getProviderById(@Param("id") String id)throws Exception;

    /**
     * 修改用户信息
     * @return
     * @throws Exception
     */

    @Update("update smbms_provider set proName=#{proName}," +
            "proDesc=#{proDesc}," +
            "proContact=#{proContact}, " +
            "proPhone=#{proPhone}," +
            "proAddress=#{proAddress}," +
            "proFax=#{proFax}," +
            "modifyBy=#{modifyBy}," +
            "modifyDate= #{modifyDate} " +
            "where id = #{id} ")
    public int modify(Provider provider)throws Exception;
}
