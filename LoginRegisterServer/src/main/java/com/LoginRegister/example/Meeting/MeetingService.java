package com.LoginRegister.example.Meeting;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import java.util.Optional;
import java.util.UUID;

@Service
public class MeetingService {
    @Autowired
    private MeetingRepository meetingRepository;

    public String generateUniqueLink(Meeting meeting) {
        String uniqueLink = UUID.randomUUID().toString();
        meeting.setUniqueLink(uniqueLink);
        meetingRepository.save(meeting);
        return uniqueLink;
    }

    public Optional<Meeting> getMeetingByLink(String uniqueLink) {
        return meetingRepository.findByUniqueLink(uniqueLink);
    }
}