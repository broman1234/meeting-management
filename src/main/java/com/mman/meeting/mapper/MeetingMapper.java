package com.mman.meeting.mapper;

import com.mman.meeting.model.Meeting;
import org.apache.ibatis.annotations.Param;

/**
 * @author 莫曼
 * @version 1.0
 */

public interface MeetingMapper {
    Integer addMeeting(Meeting meeting);

    void addParticipants(@Param("meetingid") Integer meetingid, @Param("mps") Integer[] mps);
}
