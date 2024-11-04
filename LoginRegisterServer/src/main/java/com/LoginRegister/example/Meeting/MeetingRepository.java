package com.LoginRegister.example.Meeting;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;



public interface MeetingRepository extends JpaRepository<Meeting, Long> {
    Optional<Meeting> findByUniqueLink(String uniqueLink);

	Optional<Meeting> findByTitleAndPassword(String title, String password);

	
}