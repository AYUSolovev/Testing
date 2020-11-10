package servlet;

import model.question.Question;
import org.springframework.beans.factory.annotation.Autowired;
import service.businessLayer.question.QuestionService;
import service.businessLayer.question.QuestionServiceImpl;
import singleton.Singleton;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "servletLoginUser", urlPatterns = "/question")
public class ServletQuestion extends HttpServlet {

    @Autowired
    private QuestionService question = new QuestionServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
        Singleton.getSingleton().setConnection("jdbc:h2:/C:/Users/tolya/Testing/DataBase/Testing");
        req.setCharacterEncoding("UTF-8");
        res.setCharacterEncoding("UTF-8");
        String numTest = req.getParameter("Test");
        Integer idTest = new Integer(numTest);
        List<Question> listQuestion = question.readQuestion(idTest);
        for (Question question:listQuestion
             ) {
            System.out.println(question.getId() + " " + question.getQuestion());
        }
    }

}
