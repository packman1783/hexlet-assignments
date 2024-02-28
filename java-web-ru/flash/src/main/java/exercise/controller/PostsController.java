package exercise.controller;

import java.util.Collections;
import exercise.dto.posts.PostsPage;
import exercise.dto.posts.PostPage;
import exercise.model.Post;
import exercise.repository.PostRepository;
import exercise.dto.posts.BuildPostPage;
import exercise.util.NamedRoutes;
import io.javalin.http.Context;
import io.javalin.validation.ValidationException;
import io.javalin.http.NotFoundResponse;

public class PostsController {

    public static void build(Context ctx) {
        var page = new BuildPostPage();
        ctx.render("posts/build.jte", Collections.singletonMap("page", page));
    }

    // BEGIN
    public static void index(Context ctx) {
        var posts = PostRepository.getEntities();
        String flash = ctx.consumeSessionAttribute("flash");

        var page = new PostsPage(posts);
        page.setFlash(flash);

        ctx.render("posts/index.jte", Collections.singletonMap("page", page));
    }

    public static void create(Context ctx) {
        var body = ctx.formParam("body");
        var name = ctx.formParam("name");

        try {
            ctx.formParamAsClass("name", String.class)
                    .check(value -> value.length() >= 2, "Название не должно быть короче двух символов")
                    .get();

            var post = new Post(name, body);
            PostRepository.save(post);

            ctx.sessionAttribute("flash", "Пост был успешно создан!");
            ctx.redirect(NamedRoutes.postsPath());

        } catch (ValidationException e) {
            var page = new BuildPostPage(name, body, e.getErrors());
            ctx.render("posts/build.jte", Collections.singletonMap("page", page));
        }
    }
    // END

    public static void show(Context ctx) {
        var id = ctx.pathParamAsClass("id", Long.class).get();
        var post = PostRepository.find(id)
            .orElseThrow(() -> new NotFoundResponse("Post not found"));

        var page = new PostPage(post);
        ctx.render("posts/show.jte", Collections.singletonMap("page", page));
    }
}
