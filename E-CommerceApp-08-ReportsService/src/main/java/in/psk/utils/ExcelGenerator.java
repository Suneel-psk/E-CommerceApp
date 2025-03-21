package in.psk.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;

import in.psk.dtos.OrdersDto;

@Component
public class ExcelGenerator {

	public static ByteArrayInputStream generateExcel(List<OrdersDto> ordersDto) throws IOException {
		Workbook workbook = new XSSFWorkbook();
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		Sheet sheet = workbook.createSheet("Orders");
		Row headerRow = sheet.createRow(0);
		String[] headers = { "OrderID", "UserID", "ProductID", "Quantity", "Price", "PaymentType", "OrderStatus",
				"OrderDate" };
		for (int i = 0; i < headers.length; i++) {
			headerRow.createCell(i).setCellValue(headers[i]);
		}
		int dataRowIndex = 1;
		for (OrdersDto order : ordersDto) {
			Row dataRow = sheet.createRow(dataRowIndex);
			dataRow.createCell(0).setCellValue(order.getOrderId());
			dataRow.createCell(1).setCellValue(order.getUserId());
			dataRow.createCell(2).setCellValue(order.getProductId());
			dataRow.createCell(3).setCellValue(order.getQuantity());
			dataRow.createCell(4).setCellValue(order.getPrice());
			dataRow.createCell(5).setCellValue(order.getPaymentType());
			dataRow.createCell(6).setCellValue(order.getOrderStatus());
			dataRow.createCell(7).setCellValue(order.getOrderDate());
			dataRowIndex++;
		}
		workbook.write(out);
		workbook.close();
		out.close();
		return new ByteArrayInputStream(out.toByteArray());

	}
}