package com.mman.meeting.service;

import com.mman.meeting.mapper.MeetingRoomMapper;
import com.mman.meeting.model.MeetingRoom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 莫曼
 * @version 1.0
 */
@Service
public class MeetingRoomService {

    @Autowired
    MeetingRoomMapper meetingRoomMapper;

    public List<MeetingRoom> getAllMr() {
        return meetingRoomMapper.getAllMr();
    }

    public MeetingRoom getMrById(Integer roomid) {
        return meetingRoomMapper.getMrById(roomid);
    }

    public Integer updateRoom(MeetingRoom meetingRoom) {
        return meetingRoomMapper.updateRoom(meetingRoom);
    }

    public Integer addMr(MeetingRoom meetingRoom) {
        return meetingRoomMapper.addMr(meetingRoom);
    }
}
