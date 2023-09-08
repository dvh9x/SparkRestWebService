package com.hido.SparkRestWebService;

import com.google.gson.Gson;
import com.hido.SparkRestWebService.Model.User;
import com.hido.SparkRestWebService.Response.CustomResponse;
import com.hido.SparkRestWebService.Response.StatusResponse;
import com.hido.SparkRestWebService.Service.IUserService;
import com.hido.SparkRestWebService.Service.UserServiceImpl;

import static spark.Spark.delete;
import static spark.Spark.get;
import static spark.Spark.options;
import static spark.Spark.post;
import static spark.Spark.put;

public class SparkRestService {
    public static void main(String[] args) {

        final IUserService userService = new UserServiceImpl();
        post("/users",(request, response) -> {

            response.type("application/json");
            User user = new Gson().fromJson(request.body(), User.class);
            userService.addUser(user);
            return new Gson().toJson(new CustomResponse(StatusResponse.SUCCESS));
        });
        get("/users",(request, response) -> {
            response.type("application/json");
            return new Gson().toJson(new CustomResponse(StatusResponse.SUCCESS, new Gson().toJsonTree(userService.getUsers())));
        });
        get("/users/:id", (request, response) -> {
            response.type("application/json");

            return new Gson().toJson(new CustomResponse(StatusResponse.SUCCESS, new Gson().toJsonTree(userService.getUser(request.params(":id")))));
        });
        put("/users/:id", (request, response) -> {
            response.type("application/json");

            User toEdit = new Gson().fromJson(request.body(), User.class);
            User editedUser = userService.editUser(toEdit);

            if (editedUser != null) {
                return new Gson().toJson(new CustomResponse(StatusResponse.SUCCESS, new Gson().toJsonTree(editedUser)));
            } else {
                return new Gson().toJson(new CustomResponse(StatusResponse.ERROR, new Gson().toJson("User not found or error in edit")));
            }
        });

        delete("/users/:id", (request, response) -> {
            response.type("application/json");

            userService.deleteUser(request.params(":id"));
            return new Gson().toJson(new CustomResponse(StatusResponse.SUCCESS, "User deleted"));
        });

        options("/users/:id", (request, response) -> {
            response.type("application/json");

            return new Gson().toJson(new CustomResponse(StatusResponse.SUCCESS, (userService.userExist(request.params(":id"))) ? "User exists" : "User does not exists"));
        });
    }
}
