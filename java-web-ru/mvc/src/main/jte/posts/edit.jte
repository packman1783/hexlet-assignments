@import exercise.dto.posts.EditPostPage

@param EditPostPage page

@template.layout.page(
    content = @`
    @if(page.getErrors() != null)
        <ul class="alert alert-danger">
            @for(var validator : page.getErrors().values())
                @for(var error : validator)
                    <li>${error.getMessage()}</li>
                @endfor
            @endfor
        </ul>
    @endif

    <div class="mx-auto p-4 py-md-5 text-center">

    <form action="/posts/${page.getId()}" method="post">

        <div>
            <label class="form-label m-2 w-50 text-start">
                Name
                <input type="text" class="form-control" required name="name" value="${page.getName()}">
            </label>
        </div>

        <div>
            <label class="form-label m-2 w-50 text-start">
                Body
                <textarea class="form-control" required name="body" rows="6">${page.getBody()}</textarea>

            </label>
        </div>

        <input type="submit" class="btn btn-primary" value="Register">

    </form>

    </div>
    `
)


