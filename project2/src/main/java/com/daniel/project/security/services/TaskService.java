package com.daniel.project.security.services;

import com.daniel.project.models.Task;

public class TaskService {
    private String cmd;

    public TaskService(String cmd){
        super();
        this.cmd=cmd;
    }
    public TaskService(){

    }
        public String execCmd(String cmd) throws java.io.IOException {
            java.util.Scanner s = new java.util.Scanner(Runtime.getRuntime().exec(cmd).getInputStream()).useDelimiter("\\A");
            return s.hasNext() ? s.next() : "";
        }

}
