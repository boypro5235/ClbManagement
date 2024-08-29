package com.FinalExam.ClbManagement.controller;

import com.FinalExam.ClbManagement.dto.request.NotificationRequest;
import com.FinalExam.ClbManagement.entity.notification;
import com.FinalExam.ClbManagement.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notifications")
public class NotificationController {

    @Autowired
    private NotificationService notificationService;

    // Tạo mới một thông báo
    @PostMapping("/create")
    public ResponseEntity<notification> createNotification(@RequestBody NotificationRequest request) {
        notification noti = notificationService.createNotification(request);
        return ResponseEntity.ok(noti);
    }

    // Cập nhật thông báo
    @PutMapping("/update/{id}")
    public ResponseEntity<notification> updateNotification(@PathVariable int id, @RequestBody NotificationRequest request) {
        notification updatedNoti = notificationService.updateNotification(id, request);
        return ResponseEntity.ok(updatedNoti);
    }

    // Xóa thông báo
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteNotification(@PathVariable int id) {
        boolean isDeleted = notificationService.deleteNotification(id);
        if (isDeleted) {
            return ResponseEntity.ok("Notification deleted successfully");
        } else {
            return ResponseEntity.status(404).body("Notification not found");
        }
    }

    // Lấy thông báo theo ID
    @GetMapping("/{clubId}")
    public ResponseEntity<List<notification>> getNotificationsByClubId(@PathVariable int clubId) {
        List<notification> notifications = notificationService.getNotificationsByClubId(clubId);
        return ResponseEntity.ok(notifications);
    }
}
