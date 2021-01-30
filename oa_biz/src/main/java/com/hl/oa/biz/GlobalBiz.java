package com.hl.oa.biz;

import com.hl.oa.entity.Employee;

public interface GlobalBiz {
    Employee login(String sn,String password);
    void changePassword(Employee employee);
}
