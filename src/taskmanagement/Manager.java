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

    public ArrayList<Task> getList() {
        return list;
    }

    public void data() {
        list.add(new Task(1, 2, "Lao công", "21-10-2024", 3, 5, "Toan", "Truong"));
        list.add(new Task(2, 2, "Lao công", "22-10-2024", 8, 10, "Toan", "Truong"));
        list.add(new Task(3, 2, "Lao công", "23-10-2024", 12, 14, "Toan", "Truong"));
        list.add(new Task(4, 2, "Lao công", "26-10-2024", 15, 16, "Toan", "Truong"));
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

        requirementName = validation.getString("Requrement name: ", "Wrong", validation.REGEX_NAME);
        taskType = validation.getInteger("Task type: ", "Please input in range 1 - 4", "Please input in range 1 - 4", "Please input in range 1 - 4", 1, 4);
        date = validation.getDate("Enter date: ", "Date doesn't exist!");
        from = validation.getDouble("Enter from: ", "Wrong", "Wrong", "Wrong", 8, 17);
        to = validation.getDouble("Enter to: ", "Wrong", "Wrong", "Wrong", from + 0.5, 17.5);
        assignee = validation.getString("Assignee: ", "Wrong", validation.REGEX_NAME);
        reviewer = validation.getString("reviewer: ", "Wrong", validation.REGEX_NAME);

        //Check xem có bị Duplicate về thời gian không!
        int result = addTask(requirementName, taskType, date, from, to, assignee, reviewer, id);
        if (result == -1) {
            System.err.println("Duplicate time");
        } else {
            System.out.println("Added Successfuly!");
        }
    }

    //Delete Task 
    void deleteTask() {
        int id = validation.getInteger("Enter id: ", "Wrong", "Wrong", "Wrong", 0, Integer.MAX_VALUE);
        Task task = validation.getTaskByID(list, id);
        //Hàm tìm kiếm task, nếu tìm ra thì sẽ trả về đây

        if (task == null) {
            System.out.println("Not found!!");
        } else {
//            1. Remove trực tiếp trong List
            list.remove(task);
            System.err.println("Removed successfully!");
//            2. Remove qua hàm!
//              validation.delete(task);
        }

    }

    //Check xem có bị trùng lặp thời gian không!
    public int addTask(String requirementName, int taskType, String date, double from,
            double to, String assignee, String reviewer, int id) {

        //Nếu như có trùng lặp ca làm việc thì trả về -1
        if (validation.checkOverLabs(list, date, assignee, from, to)) {
            return -1;
        } else {
            //id tăng lên 1
            id += 1;
            list.add(new Task(id, taskType, requirementName, date, from, to, assignee, reviewer));
            return id;
        }
    }

}
