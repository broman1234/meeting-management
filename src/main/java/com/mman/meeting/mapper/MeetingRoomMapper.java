package com.mman.meeting.mapper;

import com.mman.meeting.model.MeetingRoom;

import java.util.List;

/**
 * @author 莫曼
 * @version 1.0
 */
public interface MeetingRoomMapper {
    List<MeetingRoom> getAllMr();

    MeetingRoom getMrById(Integer roomid);

    Integer updateRoom(MeetingRoom meetingRoom);

    Integer addMr(MeetingRoom meetingRoom);
}
