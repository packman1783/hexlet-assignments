@import exercise.dto.posts.PostsPage

@param PostsPage page

<!doctype html>
<html lang="en">

<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
          rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
          crossorigin="anonymous">

    <title>Homework CRUD</title>
</head>

    <body>

    !{int startIndex;}
    !{int pageNumber;}
    @if(page.getPageNumber() == null)
        !{startIndex = 0;}
        !{pageNumber = 1;}
    @else
        !{startIndex = (Integer.parseInt(page.getPageNumber()) - 1) * 5;}
        !{pageNumber = Integer.parseInt(page.getPageNumber());}
    @endif

        <nav aria-label="All posts" class="container mt-5">

            <table class="table">
                <tr>
                    <td>
                        <ul class="list-group">
                            @for(int i = startIndex; i < page.getPosts().size() && i < startIndex + 5; i++)
                                <li class="list-group-item">
                                    <a href="/posts/${page.getPosts().get(i).getId()}">${page.getPosts().get(i).getName()}</a>
                                </li>
                            @endfor
                        </ul>
                    </td>
                </tr>
            </table>

            <ul class="pagination justify-content-center">
                <li class="page-item"><a class="page-link" href="/posts?page=${Math.max(pageNumber - 1, 1)}">Previous</a></li>
                <li class="page-item"><a class="page-link" href="/posts?page=${Math.min(pageNumber + 1, page.getPosts().size())}">Next</a></li>
            </ul>

        </nav>
    </body>

</html>
