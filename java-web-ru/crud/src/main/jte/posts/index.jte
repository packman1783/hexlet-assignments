@import exercise.dto.posts.PostPage

@param PostPage page

<!doctype html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1" />

        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
              rel="stylesheet"
              integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
              crossorigin="anonymous">

        <title>Homework CRUD</title>
    </head>

    <body>
        <main class="container mt-5">
            <div class="card">
                <div class="card-body">
                    <h5 class="card-title">${page.getPost().getName()}</h5>
                    <p class="card-text">${page.getPost().getBody()}</p>
                </div>
            </div>
        </main>

        <nav class="container mt-3">
            <a href="/posts" class="btn btn-primary">Return to Main</a>
        </nav>
    </body>

</html>





