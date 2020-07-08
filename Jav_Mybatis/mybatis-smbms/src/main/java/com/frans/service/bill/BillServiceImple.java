package com.frans.service.bill;

import com.frans.dao.bill.BillMapper;
import com.frans.dao.bill.BillMapperImpl;
import com.frans.pojo.Bill;

import java.util.List;

public class BillServiceImple implements BillService{
    private BillMapper billMapper;
    public BillServiceImple(){
        billMapper = new BillMapperImpl();
    }
    @Override
    public boolean add(Bill bill) {
        boolean flag = false;
        try {
            if(billMapper.add(bill) > 0)
                flag = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public List<Bill> getBillList(Bill bill) {
        List<Bill> billList = null;
        System.out.println("query productName ---- > " + bill.getProductName());
        System.out.println("query providerId ---- > " + bill.getProviderId());
        System.out.println("query isPayment ---- > " + bill.getIsPayment());

        try {
            billList = billMapper.getBillList(bill);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return billList;
    }

    @Override
    public boolean deleteBillById(String delId) {
        boolean flag = false;
        try {
            if(billMapper.deleteBillById(delId) > 0)
                flag = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public Bill getBillById(String id) {
        Bill bill = null;
        try{
            bill = billMapper.getBillById(id);
        }catch (Exception e) {
            e.printStackTrace();
            bill = null;
        }
        return bill;
    }

    @Override
    public boolean modify(Bill bill) {
        boolean flag = false;
        try {
            if(billMapper.modify(bill) > 0)
                flag = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }
}
