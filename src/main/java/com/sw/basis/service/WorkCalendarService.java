package com.sw.basis.service;

import com.sw.basis.utils.Responses;

public interface WorkCalendarService {

    /**
     * 个人日历
     * @param userCode 用户编号
     *
     * @return
     **/
    Responses<String> personelCalendar(String userCode);
}
