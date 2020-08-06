package com.frans.mapper;

import com.frans.pojo.Bill;
import org.apache.ibatis.annotations.*;

import java.sql.Connection;
import java.util.List;

public interface BillMapper {
    /**
     * 增加订单
     * @param bill
     * @return
     * @throws Exception
     */
    @Insert("insert into smbms_bill\n" +
            "(billCode,productName,productDesc, productUnit,productCount,totalPrice,isPayment,providerId,createdBy,creationDate)\n" +
            "\t\tvalues(#{billCode}, #{productName}, #{productDesc}, #{productUnit}, #{productCount}, #{totalPrice}, #{isPayment}, #{providerId}, #{createdBy}, #{creationDate})")
    public int add(Bill bill)throws Exception;


    /**
     * 通过查询条件获取供应商列表-模糊查询-getBillList
     * @param bill
     * @return
     * @throws Exception
     */

    public List<Bill> getBillList(Bill bill)throws Exception;

    /**
     * 通过delId删除Bill
     * @param delId
     * @return
     * @throws Exception
     */
    @Delete("delete from smbms_bill where id=#{delId}")
    public int deleteBillById(@Param("delId") String delId)throws Exception;


    /**
     * 通过billId获取Bill
     * @param id
     * @return
     * @throws Exception
     */
    public Bill getBillById(@Param("id") String id)throws Exception;

    /**
     * 修改订单信息
     * @param bill
     * @return
     * @throws Exception
     */
    @Update("update smbms_bill\n" +
            "        set productName=#{productName}, productDesc=#{productDesc}, productUnit=#{productUnit}, productCount=#{productCount}, totalPrice=#{totalPrice},\n" +
            "\t\tisPayment=#{isPayment}, providerId=#{providerId}, modifyBy=#{modifyBy}, modifyDate=#{modifyDate} where id = #{id};\n" +
            "    ")
    public int modify(Bill bill)throws Exception;

    /**
     * 根据供应商ID查询订单数量
     * @param providerId
     * @return
     * @throws Exception
     */
    @Select("select count(1) as billCount\n" +
            "        from smbms_bill\n" +
            "        where providerId = #{providerId}")
    public int getBillCountByProviderId(@Param("providerId") String providerId)throws Exception;

}
