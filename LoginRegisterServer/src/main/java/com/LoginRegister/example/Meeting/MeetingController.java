package com.LoginRegister.example.Meeting;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;





@RestController
public class MeetingController {
    @Autowired
    private MeetingService meetingService;

    @PostMapping("/create-meeting")
    @CrossOrigin(origins = "http://localhost:4200/")
    public String createMeeting(@RequestBody Meeting meeting) {
        String uniqueLink = meetingService.generateUniqueLink(meeting);
        return uniqueLink;
    }

    @GetMapping("/{uniqueLink}")
	
    public String redirectToMeeting(@PathVariable String uniqueLink) {
        Optional<Meeting> meeting = meetingService.getMeetingByLink(uniqueLink);
        // Implement password verification and redirection logic here
        // ...
        return "redirect:/meeting-room"; // Replace with actual redirection logic
    }
}