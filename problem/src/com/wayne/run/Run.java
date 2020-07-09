package com.wayne.run;

import com.wayne.task.Task;
import com.wayne.task.TaskGroup;
import com.wayne.test.AssertUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class Run {
    public static void main(String[] args) {
        Integer taskCount = 30;
        if(taskCount>32){throw new RuntimeException("task should be not bigger than 32 in this case");}

        Integer taskGroupCapacity = 10;
        if(taskGroupCapacity>taskCount){throw new RuntimeException("there are not enough task to select");}
        AssertUtil.setTaskGroupCapacity(taskGroupCapacity);

        Integer taskGroupCount = 10;

        List<Task> taskList = new ArrayList<>();
        for (int i = 0; i < taskCount; i++) {
            taskList.add(new Task(i));
        }

        List<Thread> taskGroupList = new ArrayList<>();
        for (int i = 0; i < taskGroupCount; i++) {
            taskGroupList.add(new Thread(new TaskGroup(i, taskGroupCapacity, taskList)));
        }

        for (Thread thread : taskGroupList) {
            thread.start();
        }
    }
}
