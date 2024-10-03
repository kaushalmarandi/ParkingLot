import DTOS.IssueTicketRequestDto;
import DTOS.IssueTicketResponseDto;
import controllers.TicketController;
import models.Ticket;
import models.VehicleType;
import repositories.GateRepository;
import repositories.ParkingLotRepository;
import repositories.TicketRepository;
import repositories.VehicleRepository;
import services.TicketService;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //Create a ticket.
        IssueTicketRequestDto requestDto= new IssueTicketRequestDto();
        requestDto.setGateId(13L);
        requestDto.setVehicleNumber("KA123XL");
        requestDto.setVehicleType(VehicleType.SUV);
        requestDto.setVehicleOwnerName("Sam");


        GateRepository gateRepository= new GateRepository();
        ParkingLotRepository parkingLotRepository=new ParkingLotRepository();
        TicketRepository ticketRepository= new TicketRepository();
        VehicleRepository vehicleRepository=new VehicleRepository();

        TicketService ticketService = new TicketService(gateRepository,
                vehicleRepository,
                parkingLotRepository,
                ticketRepository);
        TicketController ticketController= new TicketController(ticketService);
        IssueTicketResponseDto responseDto= ticketController.issueTicket(requestDto);
        Ticket ticket=responseDto.getTicket();

    }
}