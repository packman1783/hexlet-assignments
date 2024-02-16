@import exercise.dto.users.UserPage

@param UserPage page

@template.layout.page(
    content = @`
        <div class="col-lg-8 mx-auto p-4 py-md-5">
            <h2>${page.getUser().getId()}${") "}${page.getUser().getFirstName()}${" "}${page.getUser().getLastName()}
            ${" ("}${page.getUser().getEmail()}${")"}</h2>
        </div>
    `
)
