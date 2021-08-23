package com.rizalpurnama.invoice.service;

import com.rizalpurnama.invoice.dao.RunningNumberDao;
import com.rizalpurnama.invoice.entity.RunningNumber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service @Transactional
public class RunningNumberService {

    @Autowired
    RunningNumberDao runningNumberDao;

    public Long getNumber(String prefix){

        RunningNumber rn = runningNumberDao.findByPrefix(prefix);
        if (rn == null){
            rn = new RunningNumber();
            rn.setPrefix(prefix);
        }

        rn.setLastNumber(rn.getLastNumber() + 1);
        runningNumberDao.save(rn);

        return rn.getLastNumber();
    }

}
