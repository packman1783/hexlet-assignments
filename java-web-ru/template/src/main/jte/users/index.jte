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
            <h1>Users</h1>
            @if(page.getUsers().isEmpty())
                <p>No users found</p>
            @else
                <table class="table table-bordered table">
                    <thead>
                    <tr>
                        <td>ID</td>
                        <td>User name</td>
                    </tr>
                    </thead>
                    <tbody>
                    @for(var user : page.getUsers())
                        <tr>
                            <td>${user.getId()}</td>
                            <td><a href="/users/${user.getId()}">${user.getFirstName()} ${user.getLastName()}</a></td>
                        </tr>
                    @endfor
                    </tbody>
                </table>
            @endif
        </main>
    </body>
</html>
