package exercise.controller;

import java.util.Collections;
import exercise.dto.MainPage;
import exercise.dto.LoginPage;
import exercise.repository.UsersRepository;
import static exercise.util.Security.encrypt;

import exercise.util.NamedRoutes;
import exercise.util.Security;
import io.javalin.http.Context;

public class SessionsController {

    // BEGIN
    public static void index(Context ctx) {
        var user = ctx.sessionAttribute("user");
        var page = new MainPage(user);
        ctx.render("index.jte", Collections.singletonMap("page", page));
    }

    public static void build(Context ctx) {
        var page = new LoginPage("", "");
        ctx.render("build.jte", Collections.singletonMap("page", page));
    }

    public static void create(Context ctx) {
        var name = ctx.formParam("name");
        var user = UsersRepository.findByName(name);

        var password = ctx.formParam("password");

        if (user != null && user.getPassword().equals(encrypt(password))) {
            ctx.sessionAttribute("user", name);
            ctx.redirect(NamedRoutes.rootPath());
        } else {
            var error = "Wrong username or password";
            var page = new LoginPage(name, error);
            ctx.render("build.jte", Collections.singletonMap("page", page));
        }
    }

    public static void destroy(Context ctx) {
        ctx.sessionAttribute("user", null);
        ctx.redirect(NamedRoutes.rootPath());
    }
    // END
}
