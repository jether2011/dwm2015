/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.unisal.ws;

import br.unisal.dao.PessoaDao;
import br.unisal.model.Pessoa;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author JETHER
 */
@Path("pessoa")
public class PessoaResource {

    @Context
    private UriInfo context;
    private PessoaDao dao;

    /**
     * Creates a new instance of PessoaResource
     */
    public PessoaResource() {
    }

    /**
     * Retrieves representation of an instance of br.unisal.ws.PessoaResource
     * @return an instance list of br.unisal.model.Pessoa
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPessoas() {        
        GenericEntity<List<Pessoa>> pessoas = 
                new GenericEntity<List<Pessoa>>(getDao()
                        .getAll()){};       
        return Response
                .ok(pessoas)
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Headers", "Cache-Control, Pragma, Origin, Authorization, Content-Type, X-Requested-With")
                .header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT, OPTIONS, HEAD")
                .build();
    }
    
    /**
     * Retrieves representation of an instance of br.unisal.ws.PessoaResource
     * @param id
     * @return an instance of br.unisal.model.Pessoa
     */
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPessoa(@PathParam("id") Integer id) {
        Pessoa p = new Pessoa();
        p.setIdPessoa(id);
        return Response
                .ok(getDao().getById(p))
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Headers", "Cache-Control, Pragma, Origin, Authorization, Content-Type, X-Requested-With")
                .header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT, OPTIONS, HEAD")
                .build();
    }
    /*public Pessoa getPessoa(@PathParam("id") Integer id) {
        Pessoa p = new Pessoa();
        p.setIdPessoa(id);
        return getDao().getById(p);
    }*/
    
    /**
     * DELETE method for deleting an instance of PessoaResource     * 
     * @param id
     * @return message of deleted pessoa with error or not
     */
    @DELETE
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deletePessoa(@PathParam("id") Integer id) {
        Pessoa p = new Pessoa();
        p.setIdPessoa(id);        
        getDao().remove(p);
        String msg = "{\"msg\":\"Exclusão realizada com sucesso!\"}";
        return Response
                .ok(msg)
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Headers", "Cache-Control, Pragma, Origin, Authorization, Content-Type, X-Requested-With")
                .header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT, OPTIONS, HEAD")
                .build();
    }

    /**
     * PUT method for updating or creating an instance of PessoaResource
     * @param p representation for the resource
     * @param id
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updatePessoa(Pessoa p, 
            @PathParam("id")Integer id) {
        p.setIdPessoa(id);
        getDao().update(p);
        String msg = "{\"msg\":\"Atualização realizada com sucesso!\"}";
        return Response
                .ok(msg)
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Headers", "Cache-Control, Pragma, Origin, Authorization, Content-Type, X-Requested-With")
                .header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT, OPTIONS, HEAD")
                .build();
    }
    
    /**
     * POST method for creating an instance of PessoaResource
     * 
     * @param p
     * @return 
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createPessoa(Pessoa p) {        
        getDao().insert(p);
        String msg = "{\"msg\":\"Inserção realizada com sucesso!\"}";
        return Response
                .ok(msg)
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Headers", "Cache-Control, Pragma, Origin, Authorization, Content-Type, X-Requested-With")
                .header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT, OPTIONS, HEAD")
                .build();
    }

    public PessoaDao getDao() {
        if(dao == null){
            dao = new PessoaDao();
        }
        return dao;
    }
}
