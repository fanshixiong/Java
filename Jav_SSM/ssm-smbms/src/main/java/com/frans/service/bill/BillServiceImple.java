package com.frans.service.bill;

import com.frans.mapper.BillMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("billService")
public class BillServiceImple implements BillService{

    @Autowired
    @Qualifier("billMapper")
    private BillMapper billMapper;
}
