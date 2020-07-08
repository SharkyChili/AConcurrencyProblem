package com.wayne.task;

/**
 * @author wayne
 * @date 2020.07.08
 */
public class Task {
    private int i;

    public Task(int i){
        this.i=i;
    }

    public void met(TaskGroup group){
        System.out.println("任务组__" + group.getGroupId() + "__任务"+ i + "__执行中");
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }
}
