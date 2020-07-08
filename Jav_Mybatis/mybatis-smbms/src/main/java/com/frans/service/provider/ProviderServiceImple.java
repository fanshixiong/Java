package com.frans.service.provider;

import com.frans.dao.bill.BillMapper;
import com.frans.dao.bill.BillMapperImpl;
import com.frans.dao.provider.ProviderMapper;
import com.frans.dao.provider.ProviderMapperImpl;
import com.frans.pojo.Provider;

import java.util.List;

public class ProviderServiceImple implements ProviderService{

    public ProviderMapper providerMapper;
    public BillMapper billMapper;
    public ProviderServiceImple(){
        providerMapper = new ProviderMapperImpl();
        billMapper = new BillMapperImpl();
    }
    @Override
    public boolean add(Provider provider) {
        boolean flag = false;
        try {
            if(providerMapper.add(provider) > 0)
                flag = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public List<Provider> getProviderList(String proName, String proCode) {
        List<Provider> providerList = null;
        System.out.println("query proName ---- > " + proName);
        System.out.println("query proCode ---- > " + proCode);
        try {
            providerList = providerMapper.getProviderList(proName,proCode);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return providerList;
    }

    @Override
    public int deleteProviderById(String delId) {
        int billCount = -1;
        try {
            billCount = billMapper.getBillCountByProviderId(delId);
            if(billCount == 0){
                providerMapper.deleteProviderById(delId);
            }
        } catch (Exception e) {
            e.printStackTrace();
            billCount = -1;
        }
        return billCount;
    }

    @Override
    public Provider getProviderById(String id) {
        Provider provider = null;
        try{
            provider = providerMapper.getProviderById(id);
        }catch (Exception e) {
            e.printStackTrace();
            provider = null;
        }
        return provider;
    }

    @Override
    public boolean modify(Provider provider) {
        boolean flag = false;
        try {
            if(providerMapper.modify(provider) > 0)
                flag = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }
}
