@import exercise.dto.users.UsersPage

@param UsersPage page

@template.layout.page(
content = @`
    <form action="/users" method="get" class="mb-3 row justify-content-center">
        <div class="col-lg-6">
            <input type="search" name="term" value="${page.getTerm()}" class="form-control" placeholder="Search..." />
        </div>
        <div class="col-lg-1">
            <button type="submit" class="btn btn-primary">Search</button>
        </div>
    </form>

    @if(!page.getUsers().isEmpty())
        <div class="row justify-content-start">
            <div class="col-lg-6 mb-4">
                @for(var user : page.getUsers())
                    <div class="card">
                        <div class="card-body">
                            <h5 class="card-title">${user.getFirstName()} ${user.getLastName()}</h5>
                        </div>
                    </div>
                @endfor
            </div>
        </div>
    @else
        <p class="col-lg-6-center">No users found</p>
    @endif
`
)