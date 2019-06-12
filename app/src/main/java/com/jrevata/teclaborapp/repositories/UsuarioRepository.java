package com.jrevata.teclaborapp.repositories;

import com.jrevata.teclaborapp.models.Usuario;
import com.orm.SugarRecord;

public class UsuarioRepository {


    public static void createUser(Usuario user){
        SugarRecord.save(user);
    }

    public static Usuario getUser(){
        Usuario usuario = SugarRecord.listAll(Usuario.class).get(0);
        return usuario;
    }

    public static boolean verifyLogeo(){

        boolean verify = SugarRecord.listAll(Usuario.class).isEmpty();

        return verify;

    }

    public static void logout(){

        SugarRecord.deleteAll(Usuario.class);

    }
}
