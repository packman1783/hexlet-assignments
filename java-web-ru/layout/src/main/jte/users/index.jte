@import exercise.dto.users.UsersPage
@param UsersPage page

@template.layout.page(
    content = @`
    <div class="container">
        <div class="row">
            <div class="col-lg-8 mx-auto mt-5">
                <h2>Users List</h2>
                @if(page.getUsers().isEmpty())
                    <p>There are no users at the moment</p>
                @else
                    @for(var user : page.getUsers())
                        <div class="card my-3">
                            <div class="card-body">
                                <h4 class="card-title"><a href="/users/${user.getId()}">${user.getFirstName()} ${user.getLastName()}</a></h4>
                                <p class="card-text">${user.getEmail()}</p>
                            </div>
                        </div>
                    @endfor
                @endif
            </div>
        </div>
    </div>
    `
)
