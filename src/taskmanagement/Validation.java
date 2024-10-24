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
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd-mm-yyyy");
                dateFormat.setLenient(false);
                try {
                    //trả về kiểu dữ liệu là date
                    Date dateInput = dateFormat.parse(input);
                    Date currentDate = new Date();
                    currentDate = dateFormat.parse(dateFormat.format(currentDate));

                    //so sánh
                    if (dateInput.before(currentDate)) {
                        System.out.println("Date input must be greater or equal current date");
                    } else {
                        return input;
                    }
                    //ParseException là gì ?
                } catch (ParseException e) {
                    System.out.println(error);
                }

            }
        }

    }

}

