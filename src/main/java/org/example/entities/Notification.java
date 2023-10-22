package org.example.entities;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Notification {
    private String senderName;
    private String reciverName;
    private String message;
    private String date;
    private Status status;
}
