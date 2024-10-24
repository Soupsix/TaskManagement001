/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package taskmanagement;

/**
 *
 * @author admin
 */

public class Task {
    private int id;
    private int taskTypeID;
    private String requirementName;
    private String date;
    private double from, to;
    private String assignee;
    private String reviewer;

    public Task() {
    }

    public Task(int id, int taskTypeID, String requirementName, String date, double from, double to, String assignee,
            String reviewer) {
        this.id = id;
        this.taskTypeID = taskTypeID;
        this.requirementName = requirementName;
        this.date = date;
        this.from = from;
        this.to = to;
        this.assignee = assignee;
        this.reviewer = reviewer;
    }

       // Hàm đổi từ code, test, design, review
       public String getTaskType() {

        switch (taskTypeID) {
            case 1:
                return "Code";
                
            case 2:
                return "Test";
                
            case 3:
                return "Design";
                
            case 4:
                return "Review";
                

        }
        return null;
    }

    @Override
    public String toString() {
        // xóa from to đi và thời gian làm sẽ = to - from
        return String.format("%-10s %-15s %-10s %-15s %-5s %-5s %-15s %-15s\n",
                id, getTaskType(), requirementName, date, from, to, assignee, reviewer);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTaskTypeID() {
        return taskTypeID;
    }

    public void setTaskTypeID(int taskTypeID) {
        this.taskTypeID = taskTypeID;
    }

    public String getRequirementName() {
        return requirementName;
    }

    public void setRequirementName(String requirementName) {
        this.requirementName = requirementName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getFrom() {
        return from;
    }

    public void setFrom(double from) {
        this.from = from;
    }

    public double getTo() {
        return to;
    }

    public void setTo(double to) {
        this.to = to;
    }

    public String getAssignee() {
        return assignee;
    }

    public void setAssignee(String assignee) {
        this.assignee = assignee;
    }

    public String getReviewer() {
        return reviewer;
    }

    public void setReviewer(String reviewer) {
        this.reviewer = reviewer;
    }

}

