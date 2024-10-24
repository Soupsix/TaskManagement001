/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package taskmanagement;

import java.util.List;

/**
 *
 * @author admin
 */
public class View {

    Validation utility = new Validation();
    Manager manage = new Manager();
    List<Task> list = manage.getList();

    public boolean checkOverLabs(String date, String assignee, double from, double to) {
        for (Task task : list) {
            //Nếu mà date, assignee của task mà trùng thì tiến hành compare thời gian
            if (task.getDate().compareToIgnoreCase(date) == 0 && task.getAssignee().compareToIgnoreCase(assignee) == 0) {
                //TH1: from 2 < from1 && to2 > from1
                if (from < task.getFrom() && to > task.getFrom()) {
                    return true;
                }
                //TH2: from2 = from1
                if (from == task.getFrom()) {
                    return true;
                }
                //TH3: from2 > from1 && from 2 < to 1
                if (from > task.getFrom() && from < task.getTo()) {
                    return true;
                }
            }
        }
        return false;
    }

    //Check xem có bị trùng lặp thời gian không!
    public int addTask(String requirementName, int taskType, String date, double from,
            double to, String assignee, String reviewer, int id) {

        if (checkOverLabs(date, assignee, from, to)) {
            return -1;
        } else {
            id += 1;
            list.add(new Task(id, taskType, requirementName, date, from, to, assignee, reviewer));
            return id;
        }

    }

    public Task getTaskByID(int id) {
        for (Task task : list) {
            if (task.getId() == id) {
                return task;
            }
        }
        return null;
    }

}
