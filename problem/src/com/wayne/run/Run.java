package com.wayne.run;

import com.wayne.task.Task;
import com.wayne.task.TaskGroup;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class Run {
    public static void main(String[] args) {
        List<Task> taskList = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            taskList.add(new Task(i));
        }

        List<Thread> taskGroupList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            taskGroupList.add(new Thread(new TaskGroup(i, 10, taskList)));
        }

        for (Thread thread : taskGroupList) {
            thread.start();
        }
    }
}
