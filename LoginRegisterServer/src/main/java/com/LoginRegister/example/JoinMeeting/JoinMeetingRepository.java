package com.LoginRegister.example.JoinMeeting;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface JoinMeetingRepository extends JpaRepository<JoinMeeting, Long> {
    Optional<JoinMeeting> findByTitleAndPassword(String title, String password);
    Optional<JoinMeeting> findByLink(String link);
}