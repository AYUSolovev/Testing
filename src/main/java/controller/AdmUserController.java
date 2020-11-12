package controller;


import org.springframework.beans.factory.annotation.Autowired;
import service.businessLayer.question.QuestionService;
import service.businessLayer.question.QuestionServiceImpl;

import javax.ws.rs.*;

@Path("/question")
@Consumes("application/json")
@Produces("application/json")
public class AdmUserController {
/*
    @Autowired
    QuestionService qs;
*/
    @POST
    @Path("/view")
    public void findQuestion(){
        //System.out.print(textQuestion);
        //qs.findQuestion(textQuestion);

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
