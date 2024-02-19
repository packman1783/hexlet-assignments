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
            <nav class="navbar navbar-expand-lg navbar-light bg-light">
                <div class="container">
                    <a class="navbar-brand" href="/">Main</a>

                    <div class="collapse navbar-collapse" id="navbarNav">
                        <ul class="navbar-nav">
                            <li class="nav-item">
                                <a class="nav-link" href="/users">Users</a>
                            </li>
                        </ul>
                    </div>

                </div>
            </nav>
        </header>

        <div class="container mx-auto p-4 py-md-5">
            ${content}
        </div>

        <footer class="footer mt-auto py-3 bg-light">
            <div class="">
                <span class="text-muted">https://github.com/packman1783</span>
            </div>
        </footer>

    </body>
</html>
