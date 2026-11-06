/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.homeworktracker;

import java.time.LocalDate;
/**
 *
 * @author hczek
 */
public class Quiz extends Assignment {
    public Quiz(String assignmentName, String description, LocalDate dueDate, String priority) {
        super(assignmentName, description, dueDate, priority, "Quiz");
    }
}
