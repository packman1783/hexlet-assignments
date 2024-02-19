@import exercise.dto.articles.BuildArticlePage

@param BuildArticlePage page

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


        <form action="/articles" method="post">

            <div>
                <label class="form-label m-2 w-50 text-start">
                    Title
                    <input type="text" class="form-control" required name="title" value="${page.getTitle()}">
                </label>
            </div>

            <div>
                <label class="form-label m-2 w-50 text-start">
                    Content
                    <textarea class="form-control" required name="content" rows="6">${page.getContent()}</textarea>

                </label>
            </div>

            <input type="submit" class="btn btn-outline-primary" value="Register">

        </form>

    </div>
`
)

