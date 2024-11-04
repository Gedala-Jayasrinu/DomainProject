package com.LoginRegister.example.JoinMeeting;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.LoginRegister.example.Meeting.Meeting;
import com.LoginRegister.example.Meeting.MeetingRepository;
import java.util.Optional;

@Service
public class JoinMeetingService {

    @Autowired
    private JoinMeetingRepository joinMeetingRepository;
    
    @Autowired
    private MeetingRepository meetingRepository; // Repository to access Meeting data

    // Method to join a meeting by title and password
    public Optional<Meeting> joinMeetingByTitleAndPassword(String title, String password) {
        return meetingRepository.findByTitleAndPassword(title, password);
    }

    // Method to join a meeting by link
    public Optional<Meeting> joinMeetingByLink(String link) {
        // Assuming that the meetingRepository has a method to find by link
        Optional<Meeting> meeting = meetingRepository.findByUniqueLink(link);

        if (meeting.isPresent()) {
            // You could add additional validation here if needed
            return meeting; // Return the found meeting
        } else {
            return Optional.empty(); // Meeting not found
        }
    }
}