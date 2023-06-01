package com.hainam.petstore.resource.v1;

import com.hainam.petstore.dto.Account;
import com.hainam.petstore.dao.AccountDao;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriBuilder;

import java.net.URI;
import java.util.List;

/**
 * REST API resource for managing Account objects.
 */
@Path("v1/account")
public class AccountResource {

    private AccountDao dao = AccountDao.getInstance();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Account> getAccounts() {
        List<Account> accounts = dao.getAllAccounts();
        return accounts;
    }

    @GET
    @Path("/{accountId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAccountById(@PathParam("accountId") int accountId) {
        Account account = dao.getAccountById(accountId);
        if (account != null) {
            return Response.ok(account).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createAccount(Account account) {
        dao.createAccount(account);
        URI uri = UriBuilder.fromPath("v1/account/" + account.getAccountId()).build();
        return Response.created(uri).build();
    }

    @PUT
    @Path("/{accountId}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateAccount(@PathParam("accountId") int accountId, Account account) {
        Account existingAccount = dao.getAccountById(accountId);
        if (existingAccount != null) {
            account.setAccountId(accountId);
            dao.updateAccount(account);
            return Response.ok().build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @DELETE
    @Path("/{accountId}")
    public Response deleteAccount(@PathParam("accountId") int accountId) {
        Account existingAccount = dao.getAccountById(accountId);
        if (existingAccount != null) {
            dao.deleteAccount(accountId);
            return Response.ok().build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
}