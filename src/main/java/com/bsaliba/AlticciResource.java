package com.bsaliba;

import org.jboss.logging.Logger;

import com.bsaliba.dto.AlticciResponseDTO;
import com.bsaliba.service.AlticciService;

import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;

@Path("/alticci")
public class AlticciResource {

    private static final Logger LOG = Logger.getLogger(AlticciResource.class);

    @Inject
    AlticciService alticciService;

    @GET
    @Path("/{number}")
    @Produces("application/json")
    public AlticciResponseDTO get(@Valid @Min(0) @PathParam("number") Long number) {
        var alticci = alticciService.alticci(number);
        LOG.infov("Alticci {0}: {1}", number, alticci);
        return AlticciResponseDTO.builder().number(alticci).build();
    }
}
