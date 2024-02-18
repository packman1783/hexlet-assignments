@import exercise.dto.users.UsersPage

@param UsersPage page

@template.layout.page(
    content = @`
    <form action="/users" method="post" class="w-50 m-auto">
        <div class="mb-3">
            <label for="firstName" class="form-label">Name</label>
            <input type="text" class="form-control" id="firstName" name="firstName" />
        </div>
        <div class="mb-3">
            <label for="lastName" class="form-label">Surname</label>
            <input type="text" class="form-control" id="lastName" name="lastName" />
        </div>
        <div class="mb-3">
            <label for="email" class="form-label">Email</label>
            <input type="email" class="form-control" id="email" required name="email" />
        </div>
        <div class="mb-3">
            <label for="password" class="form-label">Password</label>
            <input type="password" class="form-control" id="password" required name="password" />
        </div>
        <button type="submit" class="btn btn-primary">Register</button>
    </form>
`
);
