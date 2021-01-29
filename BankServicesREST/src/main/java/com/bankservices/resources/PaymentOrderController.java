package com.bankservices.resources;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.websocket.server.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.bankservices.ejb.service.PaymentOrderServiceLocal;
import com.bankservices.entity.PaymentOrder;
import com.bankservices.wrapper.WrapperResponse;

@Path("/paymentOrder")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Stateless
public class PaymentOrderController {
	
	@EJB
	private PaymentOrderServiceLocal paymentService;

	@POST
	public Response save(PaymentOrder order) {
		paymentService.save(order);
		return Response.ok().entity(new WrapperResponse<>(true, "Orden creada con exito", null)).build();
	}
	
	@GET
	public Response getOrdersByOfficeIdAndCoin(@QueryParam("officeId") int officeId, @QueryParam("coin") String coin) {
		List<PaymentOrder> orders = paymentService.getOrdersByOfficeIdAndCoin(officeId, coin);
		if (orders.size() > 0) {
			 return Response.ok().entity(new WrapperResponse<>(true, "Ordenes encontradas", orders)).build();
		} else {
			return Response.status(Status.NOT_FOUND).entity(new WrapperResponse<>(false, "Ordenes no encontradas", orders)).build();
		}
	}
		
	@PUT
	public Response update(PaymentOrder order) {
		paymentService.update(order);
		return Response.ok().entity(new WrapperResponse<>(true, "Orden actualizada con exito", null)).build();
	}
	
	@DELETE
	@Path("/{id}")
	public Response delete(@PathParam("id") int id) {
		paymentService.delete(id);
		return Response.ok().entity(new WrapperResponse<>(true, "Orden eliminada con exito", null)).build();
	}
}
