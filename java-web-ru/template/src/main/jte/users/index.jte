@import exercise.dto.users.UsersPage
@param UsersPage page

<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />

    <! -- Copy-paste from bootstrap -->

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
          rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
          crossorigin="anonymous">

</head>
<body>
    <main>
        @if(page.getUsers().isEmpty())
            <p>Пока не добавлено ни одного курса</p>
        @else
            @for(var user : page.getUsers())
                <div class="col-lg-8 mx-auto p-4 py-md-5">
                    <h2><a href="/users/${user.getId()}">${user.getFirstName()}${" "}${user.getLastName()}${" "}${user.getEmail()}</a></h2>
                </div>
            @endfor
        @endif
    </main>
</body>
</html>
