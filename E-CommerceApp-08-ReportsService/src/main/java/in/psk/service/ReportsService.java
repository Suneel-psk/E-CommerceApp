package in.psk.service;

import java.time.LocalDate;
import java.util.List;

import in.psk.dtos.OrdersDto;

public interface ReportsService {

	public List<OrdersDto> getOrders(String status,LocalDate startDate,LocalDate endDate);

}
