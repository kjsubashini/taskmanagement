package com.example.taskmanagement.service;

import org.springframework.stereotype.Service;

@Service
// spring boot service class to send notification when task is created
public class NotificationService {
    // service method to send notification when task is created

        public void sendTaskCreatedNotification(String taskName) {
            // logic to send notification
            System.out.println("Notification: Task '" + taskName + "' has been created.");
        }
}
