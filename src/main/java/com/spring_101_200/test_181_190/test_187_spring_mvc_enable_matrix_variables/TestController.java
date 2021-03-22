package com.spring_101_200.test_181_190.test_187_spring_mvc_enable_matrix_variables;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

@Controller
@RequestMapping("/test")
public class TestController {
    @RequestMapping(value = "/a", method = RequestMethod.GET)
    public String a() {
        System.out.println("aaaaaaaaaaaaaaaaaa");
        return "user_list";
    }

    // GET /m1/owners/42;q=11;r=12/pets/21;q=22;s=23
    // (output {q=[11, 22], r=[12], s=[23]}:matrixVars , {q=[22], s=[23]}:petMatrixVars)

    //GET /m1/owners/q=11,12/pets/21;q=22;s=23
    //(output {q=[11, 12, 22], s=[23]}:matrixVars ,{q=[22], s=[23]}:petMatrixVars )

    // GET /m1/owners/***/pets/21;q=22;s=23
    //(output {q=[22], s=[23]}:matrixVars ,{q=[22], s=[23]}:petMatrixVars)
    @RequestMapping(value = "/m1/owners/{ownerId}/pets/{petId}", method = RequestMethod.GET)
    public String findPet(@MatrixVariable Map<String, String> matrixVars,
                          @MatrixVariable(pathVar = "petId") Map<String, String> petMatrixVars) {
        System.out.println(matrixVars + ":matrixVars");
        System.out.println(petMatrixVars + ":petMatrixVars");
        return "user_list";
    }

    // GET /m2/pets/42;q=11;r=22 (output petId:42 q:11)
    // GET /m2/pets/q=11 (output petId:q=11 q:11)
    @RequestMapping(value = "/m2/pets/{petId}", method = RequestMethod.GET)
    public String findPet2(@PathVariable String petId, @MatrixVariable int q) {
        System.out.println("petId:" + petId);
        System.out.println("q:" + q);
        return "user_list";
    }

    // GET /m3/owners/42;q=11/pets/21;q=22 (output q1:11 ,q2:22 )
    // GET /m3/owners/q=4/pets/q=21 (output q1:4 ,q2:21)
    @RequestMapping(value = "/m3/owners/{ownerId}/pets/{petId}", method = RequestMethod.GET)
    public String findPet3(@MatrixVariable(value = "q", pathVar = "ownerId") int q1,
                           @MatrixVariable(value = "q", pathVar = "petId") int q2) {
        System.out.println("q1:" + q1); // q1:4
        System.out.println("q2:" + q2); // q2:21
        return "user_list";
    }


}
