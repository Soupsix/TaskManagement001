/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package taskmanagement;

/**
 *
 * @author admin
 */

import java.util.ArrayList;

public class Manager {
    ArrayList<Task> list = new ArrayList<>();
    Validation validation = new Validation();
    View view = new View();
    public ArrayList<Task> getList() {
        return list;
    }

    public void data() {
        list.add(new Task(1, 2, "Lao công", "21-10-2024", 3, 5, "Toan", "Truong"));
        list.add(new Task(2, 2, "Lao công", "22-10-2024", 8, 10, "Toan", "Truong"));
        list.add(new Task(3, 2, "Lao công", "23-10-2024", 12, 14, "Toan", "Truong"));
        list.add(new Task(4, 2, "Lao công", "24-10-2024", 15, 18, "Toan", "Truong"));
    }

    public void getDataTask() {
        for (Task o : list) {
            System.out.println(o);
        }
    }

    public void input(int id) {
        // Nhập thông tin và Add vào trong List
        String requirementName, date, assignee, reviewer;
        int taskType;
        double from, to;

        requirementName = validation.getString("requrement name: ", "Wrong", validation.REGEX_STRING);
        taskType = validation.getInteger("Task type: ", "Wrong", "Wrong", "Wrong", 1, 4);
        date = validation.getDate("Enter date: ", "Date doesn't exist!");
        from = validation.getDouble("Enter from: ", "Wrong", "Wrong", "Wrong", 8, 17);
        to = validation.getDouble("Enter to: ", "Wrong", "Wrong", "Wrong", from + 0.5, 17.5);
        assignee = validation.getString("Assignee: ", "Wrong", validation.REGEX_NAME);
        reviewer = validation.getString("reviewer: ", "Wrong", validation.REGEX_NAME);
        

        //Check xem có bị Duplicate về thời gian không!
        int result = view.addTask(requirementName, taskType, date, from, to, assignee, reviewer, id);
        if(result == -1) {
            System.err.println("Duplicate time");
        } else {
            System.out.println("Added Successfuly!");
        }
    }

    

}
