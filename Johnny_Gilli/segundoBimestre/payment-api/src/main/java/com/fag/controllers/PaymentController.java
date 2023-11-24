package com.fag.controllers;

import java.util.UUID;

import org.eclipse.microprofile.rest.client.inject.RestClient;

import com.fag.dto.ConsultaBoletoDTO;
import com.fag.dto.ConsultaResponseDTO;
import com.fag.dto.PaymentResponseDTO;
import com.fag.dto.TokenDTO;
import com.fag.model.Payment;
import com.fag.model.Token;
import com.fag.services.RestClientCelcoin;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Form;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/api")
public class PaymentController {

    @Inject
    @RestClient
    RestClientCelcoin restClient;

    @GET
    @Path("/token")
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Response hello() {
        TokenDTO dto = getToken();
        Token entity = new Token();

        entity.setToken(dto.getAccessToken());
        entity.persist();

        return Response.ok().build();
    }

    public TokenDTO getToken(){

        Form form = new Form();

        form.param("client_id","41b44ab9a56440.teste.celcoinapi.v5");
        form.param("client_secret","e9d15cde33024c1494de7480e69b7a18c09d7cd25a8446839b3be82a56a044a3");
        form.param("grant_type","client_credentials");

        TokenDTO token = restClient.getToken(form);

        return token;
    }

    @POST
    @Path("/consult")
    @Produces(MediaType.APPLICATION_JSON)
    public Response consult(ConsultaBoletoDTO dto) {
        ConsultaResponseDTO response = restClient.consult("Bearer " + getToken().getAccessToken(), dto);

        return Response.ok(response).build();
    }

    @POST
    @Path("/payment")
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Response payment(ConsultaBoletoDTO dto) {
        PaymentResponseDTO response = restClient.payment("Bearer " + getToken().getAccessToken(), dto);
        Payment entity = new Payment();

        entity.setId(UUID.randomUUID());
        entity.setAmount(dto.getBill().getValue());
        entity.setDigitable(dto.getData().getDigitable());
        entity.setReceipt(response.getReceipt().getReceiptformatted());

        entity.persist();

        return Response.ok(response).build();
    }
}
