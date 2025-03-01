package com.ult1ma;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CommandLineHandler {
    public static void run(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            System.out.println("Enter a command: (see /help for available commands)");
            try {
                String command = reader.readLine();
                if (command.equals("/exit")) {
                    System.out.println("Goodbye!");
                    break;
                }
                else if (command.contains("/add")) {
                    TaskService.createTask(command.substring(4));

                }
                else if (command.contains("/delete")) {
                    TaskService.deleteTask(Integer.parseInt(command.split(" ")[1]));
                }

                else if (command.contains("/update")) {
                    TaskService.updateTask(Integer.parseInt(command.split(" ")[1]), command.substring(command.indexOf(" ", command.indexOf(" ") + 1) + 1));
                }
                else if (command.contains("/help")) {
                    System.out.println("Available commands: /add, /delete, /update, /list-all, /exit \n" +
                            "/mark-done, /mark-todo, /mark-inprogress, /list-todo, /list-inprogress, /list-done");
                }

                else if (command.contains("/list-all")) {
                    TaskService.printAllTasks();
                }
                else if (command.contains("/mark-done")) {
                    TaskService.updateTaskStatus(Integer.parseInt(command.split(" ")[1]), TaskStatus.done);
                }
                else if (command.contains("/mark-todo")) {
                    TaskService.updateTaskStatus(Integer.parseInt(command.split(" ")[1]), TaskStatus.todo);
                }
                else if (command.contains("/mark-inprogress")) {
                    TaskService.updateTaskStatus(Integer.parseInt(command.split(" ")[1]), TaskStatus.inprogress);
                } else if (command.contains("/list-todo")) {
                    TaskService.printTasksByStatus(TaskStatus.todo);
                } else if (command.contains("/list-inprogress")) {
                    TaskService.printTasksByStatus(TaskStatus.inprogress);
                } else if (command.contains("/list-done")) {
                    TaskService.printTasksByStatus(TaskStatus.done);

//                } else if (command.contains("/clear-all")) {
//                    TaskService.deleteAllTasks();

                } else {
                    System.out.println("Invalid command. Type /help to see available commands.");
                }


            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
