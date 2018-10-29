package supervizor.api;

import org.springframework.stereotype.Controller;
import supervizor.domain.Issue;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@Path("issues")
@Produces({MediaType.APPLICATION_JSON})
@Consumes({MediaType.APPLICATION_JSON})
public class IssueController {
    private List<Issue> issues = new ArrayList<>();

    {
        issues.add(new Issue(
                1L,
                null,
                "Test title 1",
                "Test description 1",
                "new"
        ));

        issues.add(new Issue(
                2L,
                null,
                "Test title 2",
                "Test description 2",
                "new"
        ));
    }

    @GET
    @Path("/")
    public Response getAll() {
        return Response.ok().entity(issues).build();
    }

    @GET
    @Path("{id}")
    public Response getById(@PathParam("id") Long id) {
        Optional<Issue> result = issues.stream().filter(x -> x.getId().equals(id)).findFirst();

        if (!result.isPresent()) {
            throw new RuntimeException("No issues with id: " + id);
        }

        return Response.ok().entity(result.get()).build();
    }

    @POST
    @Path("{id}")
    public Response create(Issue issue) {
        return Response.ok().entity(issue.getId()).build();
    }

    @PUT
    @Path("{id}")
    public Response update(@PathParam("id") Long id, Issue issue) {
        return Response.ok().entity(id).build();
    }

    @DELETE
    @Path("{id}")
    public Response delete(@PathParam("id") Long id) {
        return Response.ok().entity(id).build();
    }
}
