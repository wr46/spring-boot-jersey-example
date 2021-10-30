package com.github.wr46.springbootjerseyexample.resources;

import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.github.wr46.springbootjerseyexample.dtos.TaskDTO;
import com.github.wr46.springbootjerseyexample.entities.Task;
import com.github.wr46.springbootjerseyexample.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@Path("/tasks")
public class TaskResource {

    @Autowired
    private TaskService taskService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getTasks() {
        return Response.ok(taskService.getTasks()).build();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getTask(@PathParam("id") Long id) {
        if (id == null) {
            return Response.ok(taskService.getTasks()).build();
        }
        final Optional<TaskDTO> task = taskService.getTask(id);
        if (task.isEmpty()) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(task).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createTask(@Valid TaskDTO task) {
        return Response.ok(taskService.createTask(task)).build();
    }
}
