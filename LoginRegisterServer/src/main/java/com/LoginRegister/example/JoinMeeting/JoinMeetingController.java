package com.LoginRegister.example.JoinMeeting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.LoginRegister.example.Meeting.Meeting;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
@RestController
@RequestMapping("/api/join-meeting")
@CrossOrigin(origins = "http://localhost:4200")
public class JoinMeetingController {

    @Autowired
    private JoinMeetingService joinMeetingService;

    // Endpoint to join a meeting by title and password
    @PostMapping("/by-title")
    public ResponseEntity<Map<String, String>> joinByTitleAndPassword(@RequestParam String title, @RequestParam String password) {
        Optional<Meeting> meeting = joinMeetingService.joinMeetingByTitleAndPassword(title, password);

        Map<String, String> response = new HashMap<>();
        if (meeting.isPresent()) {
            response.put("message", "Joined meeting successfully!");
            return ResponseEntity.ok(response);
        } else {
            response.put("error", "Meeting not found or password is incorrect.");
            return ResponseEntity.status(404).body(response);
        }
    }

    // Endpoint to join a meeting by link
    @PostMapping("/by-link")
    public ResponseEntity<Map<String, String>> joinByLink(@RequestParam String link) {
        Optional<Meeting> meeting = joinMeetingService.joinMeetingByLink(link);

        Map<String, String> response = new HashMap<>();
        if (meeting.isPresent()) {
            response.put("message", "Joined meeting successfully via link!");
            return ResponseEntity.ok(response);
        } else {
            response.put("error", "Invalid meeting link.");
            return ResponseEntity.status(404).body(response);
        }
    }
}