@import exercise.dto.users.UsersPage
@param UsersPage page

@template.layout.page(
    content = @`
        @if(page.getUsers().isEmpty())
            <p>There are no users at the moment</p>
        @else
            @for(var user : page.getUsers())
                <div class="col-lg-8 mx-auto p-4 py-md-5">
                    <h2><a href="/users/${user.getId()}">${user.getFirstName()}${" "}${user.getLastName()}${" "}
                    ${user.getEmail()}</a></h2>
                </div>
            @endfor
        @endif
    `
)
