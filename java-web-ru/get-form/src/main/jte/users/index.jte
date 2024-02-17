@import exercise.dto.users.UsersPage

@param UsersPage page

@template.layout.page(
    content = @`
    <form action="/users" method="get">
        <input type="search" name="term" value="${page.getTerm()}" />
        <input type="submit" value="Search" />
    </form>
    @if(!page.getUsers().isEmpty())
        @for(var user : page.getUsers())
            <div class="col-lg-8 mx-auto p-4 py-md-5">
                <h2>${user.getFirstName()}${" "}${user.getLastName()}</h2>
            </div>
        @endfor
    @endif
`
)