package com.jrevata.teclaborapp.repositories;

import com.jrevata.teclaborapp.models.Test;
import com.jrevata.teclaborapp.models.Usuario;
import com.orm.SugarRecord;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class TestRepository {

    public static List<Test> testList = new ArrayList<>();

    static{
        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            testList.add(new Test("106547", "Test 1", 3, 4, 2, 1, 2, 12, format.parse("2019-05-12")));
            testList.add(new Test("106547", "Test 2", 3, 4, 2, 1, 2, 18, format.parse("2019-05-13")));
            testList.add(new Test("106547", "Test 3", 3, 4, 2, 1, 2, 9, format.parse("2019-05-14")));
            testList.add(new Test("106547", "Test 4", 3, 4, 2, 1, 2, 1, format.parse("2019-05-15")));
        }catch (ParseException ex){

        }
    }

    public static List<Test> getList(){
        return testList;
    }

    public static void createTest(Test test){
        SugarRecord.save(test);
    }

    public static List<Test> listTests(){
        List<Test> tests = SugarRecord.listAll(Test.class);
        List<Test> tests1 = new ArrayList<>();

        for(Test test : tests){
            if(test.getUsuario().equals(UsuarioRepository.getUser().getUsuario()))
                tests1.add(test);
        }

        return tests1;
    }

    public static Test getTest(String nombre){

        List<Test> tests = SugarRecord.listAll(Test.class);


        for(Test test : tests){
            if(test.getUsuario().equals(UsuarioRepository.getUser().getUsuario()))
                if(test.getNombre().equals(nombre))
                    return test;
        }

        return null;

    }

}
