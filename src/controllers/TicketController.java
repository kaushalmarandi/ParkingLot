package controllers;

import DTOS.IssueTicketRequestDto;
import DTOS.IssueTicketResponseDto;
import DTOS.ResponseStatus;
import exceptions.GateNotFoundException;
import models.Ticket;
import services.TicketService;

public class TicketController {

    private TicketService ticketService;
    public TicketController(TicketService ticketService){
        this.ticketService=ticketService;
    }
    public IssueTicketResponseDto issueTicket(IssueTicketRequestDto requestDto){
        IssueTicketResponseDto responseDto= new IssueTicketResponseDto();

        try {
           Ticket ticket = ticketService.issueTicket(
                   requestDto.getGateId(),
                   requestDto.getVehicleNumber(),
                   requestDto.getVehicleOwnerName(),
                   requestDto.getVehicleType()
           );

           responseDto.setTicket(ticket);
           responseDto.setResponseStatus(ResponseStatus.SUCCESS);

        } catch (GateNotFoundException e) {
           e.getMessage();
           responseDto.setResponseStatus(ResponseStatus.FAILURE);
        }
        return responseDto;
    }
}
