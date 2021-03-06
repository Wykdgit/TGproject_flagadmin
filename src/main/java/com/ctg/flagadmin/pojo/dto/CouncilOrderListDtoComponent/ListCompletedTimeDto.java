package com.ctg.flagadmin.pojo.dto.CouncilOrderListDtoComponent;

import java.util.Date;

public class ListCompletedTimeDto {
    private Date startTime;
    private Date endTime;

    public ListCompletedTimeDto(Date startTime, Date endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public ListCompletedTimeDto() {

    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }
}
