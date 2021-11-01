package agent;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/imageAgent")
@ApplicationScoped
public class ImageServlet extends HttpServlet {
    @Inject
    private AgentService agentService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       int id= Integer.parseInt(req.getParameter("id"));
        Agent agentbyId = agentService.getAgentbyId(id);
        resp.getOutputStream().write(agentbyId.getImage());
        resp.getOutputStream().close();

    }
}
