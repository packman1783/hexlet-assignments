@import exercise.dto.users.UserPage

@param UserPage page

@template.layout.page(
    content = @`
    <div class="container">
        <div class="col-lg-8 mx-auto mt-5">
            <div class="card">
                <div class="card-body">
                    <h2 class="card-title">${page.getUser().getFirstName()} ${page.getUser().getLastName()}</h2>
                    <p class="card-text">ID: ${page.getUser().getId()}</p>
                    <p class="card-text">Email: ${page.getUser().getEmail()}</p>
                </div>
            </div>
        </div>
    </div>
    `
)
