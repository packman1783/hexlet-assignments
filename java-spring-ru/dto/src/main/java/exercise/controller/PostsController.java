package exercise.controller;

import exercise.model.Comment;
import exercise.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import exercise.model.Post;
import exercise.repository.PostRepository;
import exercise.exception.ResourceNotFoundException;
import exercise.dto.PostDTO;
import exercise.dto.CommentDTO;

// BEGIN
@RestController
@RequestMapping("/posts")
public class PostsController {
    @Autowired
    private PostRepository postRepository;

    @Autowired
    private CommentRepository commentRepository;

    private CommentDTO toCommentDTO(Comment comment) {
        CommentDTO commentDTO = new CommentDTO();
        commentDTO.setId(comment.getId());
        commentDTO.setBody(comment.getBody());

        return commentDTO;
    }

    private PostDTO toPostDTO(Post post) {
        PostDTO postDTO = new PostDTO();        postDTO.setId(post.getId());
        postDTO.setTitle(post.getTitle());
        postDTO.setBody(post.getBody());

        List<Comment> comments = commentRepository.findByPostId(post.getId());
        List<CommentDTO> commentsDTO = comments.stream()
                .map(this::toCommentDTO)
                .toList();

        postDTO.setComments(commentsDTO);

        return postDTO;
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public PostDTO show(@PathVariable long id) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Post with id " + id + " not found"));

        PostDTO postDTO = toPostDTO(post);

        return postDTO;
    }

    @GetMapping("")
    public List<PostDTO> index() {
        List<Post> posts = postRepository.findAll();

        List<PostDTO> postsDTO = posts.stream()
                .map(this::toPostDTO)
                .toList();

        return postsDTO;
    }
}
// END
