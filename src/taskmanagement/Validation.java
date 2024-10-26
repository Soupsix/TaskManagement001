/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package taskmanagement;

/**
 *
 * @author admin
 */
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Validation {

    public final String REGEX_STRING = "[a-zA-Z0-9 ]+";
    public final String REGEX_NAME = "[a-zA-Z ]+";

    public int getInteger(String message, String firstError, String secondError, String thirdError, double min,
            double max) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            // vòng lặp while sẽ dừng lại khi gặp điều kiện đúng
            try {
                System.out.print(message);
                String input = scanner.nextLine().trim();
                if (input.isEmpty()) {
                    System.out.println("Không được để trống!");
                } else {
                    int number = Integer.parseInt(input);
                    if (number < min) {
                        System.out.println(firstError);
                    } else if (number > max) {
                        System.err.println(secondError);
                    } else {
                        return number;
                    }
                }
            } catch (Exception e) {
                System.err.println(thirdError);
            }
        }
    }

    public String getString(String message, String error, String regex) {
        Scanner scanner = new Scanner(System.in);
        while (true) {

            System.out.print(message);
            String input = scanner.nextLine().trim(); // trim xóa dấu space
            if (input.isEmpty()) {
                System.out.println("Input's invalid, type it again!");
            } else {
                if (input.matches(regex)) {
                    return input;
                } else {
                    System.err.println(error);
                }
            }
        }

    }

    public float getFloat(String message, String firstError, String secondError, String thirdError, float min,
            float max) {
        Scanner scanner = new Scanner(System.in);

        // - Yêu cầu người dùng nhập vào một số nguyên
        while (true) {
            try {
                System.out.print(message);
                String input = scanner.nextLine().trim();
                if (input.isEmpty()) {
                    System.err.println("KhÔng được để trống");
                } else {
                    float number = Float.parseFloat(input);
                    // check number in range
                    if (number < min) {
                        System.out.println(firstError);
                    } else if (number > max) {
                        System.err.println(secondError);
                    } else {
                        return number;
                    }
                }
            } catch (Exception e) {
                System.err.println(thirdError);
            }
        }
    }

    public double getDouble(String message, String firstError, String secondError,
            String thirdError, double min, double max) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                System.out.print(message);
                String input = scanner.nextLine();
                double number = Double.parseDouble(input);

                // check range
                if (number > max) {
                    System.out.println(firstError);
                } else if (number < min) {
                    System.out.println(secondError);
                } else if (number % 0.5 != 0) {
                    System.out.println("Must be modulo 0.5");
                } else {
                    return number;
                }
            } catch (Exception e) {
                System.out.println(thirdError);
            }
        }
    }

    
    //Hàm tìm kiếm task có id trùng với id tìm kiếm
    public Task getTaskByID(List<Task> list, int id) {
        for (Task task : list) {
            if (task.getId() == id) {
                return task;
            }
        }
        return null;
    }

    //Hàm check over time nếu có bị trùng time với ca làm từ trước hay không
    public boolean checkOverLabs(List<Task> list, String date, String assignee, double from, double to) {
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

    public String getDate(String mess, String error) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print(mess);
            String input = sc.nextLine();
            //Check format
            if (input.matches("^\\d{1,2}[-]\\d{1,2}[-]\\d{4}$") == false) {
                System.out.println("Please date to correct format(dd-mm-yyyy)");
            } else {
                //check data exist
                //Khởi tạo đối tượng SimpleDateFormat để phân tích chuỗi input thành đối tượng Date
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd-mm-yyyy");
                dateFormat.setLenient(false);
                try {
                    //trả về kiểu dữ liệu là date
                    //Parse input từ kiểu String về date để so sánh với thời gian hiện tại trong máy
                    Date dateInput = dateFormat.parse(input);

                    //Format lại thời gian hiện tại bằng đối tượng dateFormat theo kiểu date dd-mm-yyyy và xóa ngày giờ của date
                    Date currentDate = new Date();
                    currentDate = dateFormat.parse(dateFormat.format(currentDate));

                    //so sánh thời gian nhập vào có bé hơn thời gian trong máy hay không!
                    if (dateInput.before(currentDate)) {
                        System.out.println("Date input must be greater or equal current date");
                    } else {
                        return input;
                    }

                } catch (ParseException e) {
                    System.out.println(error);
                }

            }
        }

    }

}
