package basePackage.controller;


import basePackage.model.question.Question;
import basePackage.service.businessLayer.question.QuestionService;
import basePackage.service.businessLayer.question.QuestionServiceImpl;
import basePackage.singleton.Singleton;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.*;
import java.util.List;

@Path("/question")
@Consumes("application/json")
@Produces("application/json")
public class AdmUserController {

    @Autowired
    QuestionService qs;


    @GET
    @Path("/view")
    public Question findQuestion(@QueryParam("question") String question){
        Singleton.getSingleton().setConnection("jdbc:h2:/C:/Users/tolya/Testing/DataBase/Testing");
        Question quest;
        quest = qs.findQuestion(question);
        return quest;
    }


/*
    @GET
    @Path("/{id}")
    public void detailsQuestion(@QueryParam("id") String id){
        //qs.findQuestion(id);
    }

    @PUT
    @Path("")
    public void updateQuestion(){

    }

    @DELETE
    @Path("/{id}")
    public void deleteQuestion(){


    }

    @POST
    @Path("")
    public void createQuestion(){

    }
*/
}
