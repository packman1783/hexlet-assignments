@import gg.jte.Content

@param Content content

<!doctype html>
<html lang="en">

    <head>
        <meta charset="utf-8"/>
        <meta name="viewport" content="width=device-width, initial-scale=1"/>

        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css"
              rel="stylesheet"
              integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0pWe"
              crossorigin="anonymous">

        <title>Hexlet Javalin Example</title>
    </head>

    <body>

    <header>
        <div class="custom-navbar">
            <div class="container">
                <a href="/">Main</a>
                <a href="/users">Users</a>
            </div>
        </div>
    </header>

        <div >
            ${content}
        </div>

        <footer class="footer mt-auto py-3">
            <div>
                <span class="text-muted">My GitHub page https://github.com/packman1783</span>
            </div>
        </footer>

    </body>
</html>
