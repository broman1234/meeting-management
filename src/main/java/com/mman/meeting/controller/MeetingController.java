package com.mman.meeting.controller;

import com.mman.meeting.model.Department;
import com.mman.meeting.model.Employee;
import com.mman.meeting.model.Meeting;
import com.mman.meeting.service.DepartmentService;
import com.mman.meeting.service.EmployeeService;
import com.mman.meeting.service.MeetingRoomService;
import com.mman.meeting.service.MeetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author 莫曼
 * @version 1.0
 */
@Controller
public class MeetingController {

    @Autowired
    MeetingRoomService meetingRoomService;

    @Autowired
    DepartmentService departmentService;

    @Autowired
    EmployeeService employeeService;

    @Autowired
    MeetingService meetingService;

    @RequestMapping("/bookmeeting")
    public String bookmeeting(Model model) {
        model.addAttribute("mrs", meetingRoomService.getAllMr());
        return "bookmeeting";
    }

    @RequestMapping("/alldeps")
    @ResponseBody
    public List<Department> getAllDeps() {
        return departmentService.getAllDeps();
    }

    @RequestMapping("/getempbydepid")
    @ResponseBody
    public List<Employee> getEmpsById(Integer depId) {
        return employeeService.getEmpsByDepId(depId);
    }

    @RequestMapping("/doAddMeeting")
    public String doAddMeeting(Meeting meeting, Integer[] mps, HttpSession session) {
        Employee currentuser = (Employee) session.getAttribute("currentuser");
        meeting.setReservationistid(currentuser.getEmployeeid());
        Integer result = meetingService.addMeeting(meeting,mps);
        if (result == 1) {
            return "redirect:/searchmeetings";
        }else{
            return "forward:/bookmeeting";
        }
    }
    @RequestMapping("/searchmeetings")
    public String searchmeetings() {
        return "searchmeetings";
    }
}
