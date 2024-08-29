package com.FinalExam.ClbManagement.service;

import com.FinalExam.ClbManagement.dto.request.NotificationRequest;
import com.FinalExam.ClbManagement.entity.notification;
import com.FinalExam.ClbManagement.repository.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class NotificationService {
    @Autowired
    private NotificationRepository notificationRepository;

    public notification createNotification(NotificationRequest request) {
        notification noti = new notification();

        noti.setClub_id(request.getClub_id());
        noti.setTitle(request.getTitle());
        noti.setDescription(request.getDescription());
        noti.setDetails(request.getDetails());

        notificationRepository.save(noti);
        return noti;
    }

    public notification updateNotification(int id, NotificationRequest request) {
        notification noti = notificationRepository.findById(id).orElseThrow(() -> new RuntimeException("not found"));
        if (noti != null) {
            noti.setClub_id(request.getClub_id());
            noti.setTitle(request.getTitle());
            noti.setDescription(request.getDescription());
            noti.setDetails(request.getDetails());
        }
        return noti;
    }

    public boolean deleteNotification(int id) {
        Optional<notification> optionalNotification = notificationRepository.findById(id);

        if (optionalNotification.isPresent()) {
            notificationRepository.delete(optionalNotification.get());
            return true;
        } else {
            throw new RuntimeException("Notification not found with id: " + id);
        }
    }


    public List<notification> getNotificationsByClubId(int clubId) {
        return notificationRepository.findByClubId(clubId);
    }
}
