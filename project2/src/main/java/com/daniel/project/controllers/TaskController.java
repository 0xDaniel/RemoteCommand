package com.daniel.project.controllers;

import com.daniel.project.repository.TaskRepository;
import com.daniel.project.request.TaskRequest;
import com.daniel.project.models.Task;
import com.daniel.project.response.MessageResponse;
//import com.sun.org.apache.xpath.internal.operations.String;
import org.bson.json.JsonObject;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import com.daniel.project.security.services.TaskService;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;


@CrossOrigin(origins = "*", maxAge = 4800)
@RestController
@RequestMapping("/api/task")
public class TaskController {


    @Autowired
    TaskRepository taskRepository;
    TaskService taskDo = new TaskService();
    ArrayList<String> arr =new ArrayList<String>();
    JSONObject jo = new JSONObject();

    @GetMapping("/list")
    @PreAuthorize("hasRole('EMPLOYEE') ")
    public ResponseEntity<?> GetTask(@RequestBody TaskRequest taskRequest) {

        taskRepository.findAll().forEach(s->{
            arr.add(s.getEmployeename()+"|"+s.getTask());
            try {
                jo.put("emplyeename", s.getEmployeename());
                jo.put("task", s.getTask());
            } catch (JSONException e) {
                throw new RuntimeException(e);
            }
        });
       return ResponseEntity.ok(new MessageResponse(jo.toString()));
    }
    @GetMapping("/exec")
    @PreAuthorize("hasRole('ADMIN') ")
    public ResponseEntity<?> ExecuteTask(@RequestBody TaskRequest taskRequest) throws IOException {
        Task task= new Task(taskRequest.getEmployeename(),taskRequest.getTask(),taskRequest.getStatus());
        taskDo.execCmd(taskRequest.getTask());
        taskRepository.save(task);
        return ResponseEntity.ok(new MessageResponse("Task registered successfully!"));
    }


}
