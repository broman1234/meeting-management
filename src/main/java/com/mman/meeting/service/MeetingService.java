package com.mman.meeting.service;

import com.mman.meeting.mapper.MeetingMapper;
import com.mman.meeting.model.Meeting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author 莫曼
 * @version 1.0
 */
@Service
public class MeetingService {
    @Autowired
    MeetingMapper meetingMapper;
    public Integer addMeeting(Meeting meeting, Integer[] mps) {
        meeting.setReservationtime(new Date());
        Integer result = meetingMapper.addMeeting(meeting);
        meetingMapper.addParticipants(meeting.getMeetingid(), mps);
        return result;
    }
}
