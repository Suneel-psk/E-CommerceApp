package in.psk.rest;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.psk.dtos.OrdersDto;
import in.psk.dtos.ReportsDto;
import in.psk.service.ReportsService;
import in.psk.utils.ExcelGenerator;
import in.psk.utils.PdfGenerator;

@RestController
@RequestMapping("/orders")
public class ReportsRestController {
	@Autowired
	private ReportsService reportService;

	@PostMapping("/excel")
	public ResponseEntity<ByteArrayInputStream> generateExcel(@RequestBody ReportsDto reportDto) throws IOException {
		List<OrdersDto> orderDto = reportService.getOrders(reportDto.getOrderStatus(), reportDto.getStartDate(),
				reportDto.getEndDate());

		ByteArrayInputStream ordersData = ExcelGenerator.generateExcel(orderDto);
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
		headers.setContentDispositionFormData("attachment", "OrdersReport.xlsx");

		return new ResponseEntity<>(ordersData, headers, HttpStatus.OK);
	}

	@PostMapping("/pdf")
	public ResponseEntity<ByteArrayInputStream> generatePdf(@RequestBody ReportsDto reportDto) {
		List<OrdersDto> orderDto = reportService.getOrders(reportDto.getOrderStatus(), reportDto.getStartDate(),
				reportDto.getEndDate());
		ByteArrayInputStream bis = PdfGenerator.generatePdf(orderDto);
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Disposition", "attachment; filename=orders.pdf");
		return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF).body(bis);
	}
}
