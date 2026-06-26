package com.example.supplify.repository;

import com.example.supplify.entity.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotifiactionRepository extends JpaRepository<Notification, Long> {
}
