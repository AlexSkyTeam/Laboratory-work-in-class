package org.example.app.controller;

import com.google.gson.Gson;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.example.app.dto.UserDTO;
import org.example.app.manager.UserManager;
import org.springframework.stereotype.Controller;

import java.io.IOException;
import java.util.List;
@Controller
@RequiredArgsConstructor
public class UserController {
    private final UserManager manager;
    private final Gson gson;

    public void getAll(final HttpServletRequest req, final HttpServletResponse res) throws ServletException, IOException {
        final List<UserDTO> responseDTO = manager.getAll();
        res.getWriter().write(gson.toJson(responseDTO));
    }

    public void getById(final HttpServletRequest req, final HttpServletResponse res) throws ServletException, IOException {
        final long id = Long.parseLong(req.getParameter("id"));
        final UserDTO responseDTO = manager.getById(id);
        res.getWriter().write(gson.toJson(responseDTO));
    }

    public void create(final HttpServletRequest req, final HttpServletResponse res) throws ServletException, IOException {
        final String login = req.getParameter("login");
        final UserDTO responseDTO = manager.create(login);
        res.getWriter().write(gson.toJson(responseDTO));
    }
}