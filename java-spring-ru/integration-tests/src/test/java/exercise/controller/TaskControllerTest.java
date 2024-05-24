package exercise.controller;

import exercise.exception.ResourceNotFoundException;
import org.junit.jupiter.api.Test;
import static net.javacrumbs.jsonunit.assertj.JsonAssertions.assertThatJson;
import static org.assertj.core.api.Assertions.assertThat;
import org.instancio.Instancio;
import org.instancio.Select;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;

import java.util.HashMap;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.datafaker.Faker;
import exercise.repository.TaskRepository;
import exercise.model.Task;

// BEGIN
@SpringBootTest
@AutoConfigureMockMvc
// END
class ApplicationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private Faker faker;

    @Autowired
    private ObjectMapper om;

    @Autowired
    private TaskRepository taskRepository;


    @Test
    public void testWelcomePage() throws Exception {
        var result = mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andReturn();

        var body = result.getResponse().getContentAsString();
        assertThat(body).contains("Welcome to Spring!");
    }

    @Test
    public void testIndex() throws Exception {
        var result = mockMvc.perform(get("/tasks"))
                .andExpect(status().isOk())
                .andReturn();

        var body = result.getResponse().getContentAsString();
        assertThatJson(body).isArray();
    }


    // BEGIN
    private Task createTask() {
        Task task = Instancio.of(Task.class)
                .ignore(Select.field(Task::getId))
                .supply(Select.field(Task::getTitle), () -> faker.lorem().word())
                .supply(Select.field(Task::getDescription), () -> faker.lorem().paragraph())
                .create();

        return task;
    }

    @Test
    public void testShow() throws Exception {
        Task data = createTask();
        taskRepository.save(data);
        long id = data.getId();

        var result = mockMvc.perform(get("/tasks/" + id))
                .andExpect(status().isOk())
                .andReturn();

        var responseBody = result.getResponse().getContentAsString();

        assertThatJson(responseBody).and(
            a -> a.node("description").isEqualTo(data.getDescription()),
            a -> a.node("title").isEqualTo(data.getTitle())
        );
    }

    @Test
    public void testCreate() throws Exception {
        Task data = createTask();
        taskRepository.save(data);
        long id = data.getId();

        var request = post("/tasks")
                .contentType(MediaType.APPLICATION_JSON)
                .content(om.writeValueAsString(data));

        mockMvc.perform(request)
                .andExpect(status().isCreated());

        var task = taskRepository.findById(id).get();

        assertThat(task.getTitle()).isEqualTo(data.getTitle());
        assertThat(task.getDescription()).isEqualTo(data.getDescription());
    }

    @Test
    public void testUpdate() throws Exception {
        Task data = createTask();
        taskRepository.save(data);
        long id = data.getId();

        var taskData = new HashMap<>();
        taskData.put("title", "update title");
        taskData.put("description", "update description");

        var request = put("/tasks/" +  id)
                .contentType(MediaType.APPLICATION_JSON)
                .content(om.writeValueAsString(taskData));

        mockMvc.perform(request)
                .andExpect(status().isOk());

        var task = taskRepository.findById(id).get();

        assertThat(task.getTitle()).isEqualTo("update title");
        assertThat(task.getDescription()).isEqualTo("update description");
    }

    @Test
    public void testDelete() throws Exception {
        Task data = createTask();
        taskRepository.save(data);
        long id = data.getId();

        assertThat(taskRepository.findById(id)).isPresent();

        mockMvc.perform(delete("/tasks/" + id))
                .andExpect(status().isOk());

        assertThat(taskRepository.findById(id)).isEmpty();
    }
    // END
}
