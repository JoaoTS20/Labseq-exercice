package org.acme;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.parameters.Parameter;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;

import java.util.ArrayList;
import java.util.List;

@Path("/labseq")
public class LabSeqResource {

    @Inject
    LabSeqService labSeqService;

    @GET
    @Path("{n}")
    @Produces(MediaType.TEXT_PLAIN)
    @Operation(
            operationId = "getLabseqIndexValue",
            summary = "Get Labseq Value",
            description = "Get the value from Labseq with index n"
    )
    @APIResponse(
            description = "Labseq Sequence Value",
            content = @Content(mediaType = MediaType.TEXT_PLAIN)
    )
    public Response getLabseqIndexValue(@Parameter(description = "Index (non-negative integer number) of the sequence’s (single) value to return") @PathParam("n") Integer n) {
        if(n<0){
            return Response.status(Response.Status.BAD_REQUEST).build();
        }else{
            return Response.ok(String.format("%s",labSeqService.labseqMethod(n))).build();
        }
    }

    @GET
    @Path("")
    @Produces(MediaType.TEXT_PLAIN)
    @Operation(
            operationId = "getLabseqInitialValues",
            summary = "Get Labseq Initial Values",
            description = "Get the first 11 values from Labseq sequence"
    )
    @APIResponse(
            responseCode = "201",
            description = "Labseq Initial Sequence Values",
            content = @Content(mediaType = MediaType.TEXT_PLAIN)
    )
    public String getLabseqInitialValues() {
        List<Integer> labseqCalculatedValues= new ArrayList<>();
        for(int i=0; i<=10;i++){
            labseqCalculatedValues.add(labSeqService.labseqMethod(i));
        }
        return labseqCalculatedValues.toString();
    }
}
