package com.wayne.task;

import com.wayne.test.AssertUtil;
import com.wayne.test.Data;

/**
 * @author wayne
 * @date 2020.07.08
 */
public class Task {
    private int id;

    public Task(int id){
        this.id=id;
    }

    public void met(TaskGroup group){
        System.out.println("任务组__" + group.getGroupId() + "__任务"+ getId() + "__执行中");

        AssertUtil.assertError(new Data(group.getGroupId(),this.getId()));
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
