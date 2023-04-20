package com.lab.task.Service;


import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Produces;
import javax.ws.rs.Path;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.GET;
import javax.ws.rs.POST;

import com.lab.task.DataBase.CalculationRepo;
import com.lab.task.Model.Calculation;


@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@RequestScoped
@Path("/")
 public class CalculationService {
    @Inject
    private CalculationRepo repo;

    public CalculationService() {
    }

    @Path("calc")
    @POST
    public Result calculate(Calculation calc) {
        int r;
        switch (calc.getOperation()) {
            
            case "-":
                r = calc.getNum_1() - calc.getNum_2();
                break;
            case "+":
                r = calc.getNum_1() + calc.getNum_2();
                break;    
            case "*":
                r= calc.getNum_1() * calc.getNum_2();
                break;
            case "/": {
                if (calc.getNum_2() == 0)
                    throw new IllegalArgumentException("Can't divide by zero");
                r = calc.getNum_1() / calc.getNum_2();
                break;
            }
            default:
                throw new IllegalArgumentException("Unsupported operation");
        }
        repo.insert(calc);
        return new Result(r);
    }

    @Path("calculations")
    @GET
    public List<Calculation> getAllCalculations() {
        return repo.selectAll();
    }

    @Path("/")
    @GET
    public String getHealth() {
        return "Up and running";
    }
}
