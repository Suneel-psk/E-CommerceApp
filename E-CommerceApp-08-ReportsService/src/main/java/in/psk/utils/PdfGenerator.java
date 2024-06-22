package in.psk.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.List;

import org.springframework.stereotype.Component;

import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

import in.psk.dtos.OrdersDto;

@Component
public class PdfGenerator {
	public static ByteArrayInputStream generatePdf(List<OrdersDto> ordersDto) {
		Document document = new Document();
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		PdfWriter.getInstance(document, out);
		PdfPTable table = new PdfPTable(8);
		table.setWidthPercentage(100);
		table.setSpacingBefore(10);
		table.setSpacingAfter(10);
		Font headFont = new Font(Font.HELVETICA, 12, Font.BOLD);
		String headers[] = { "Order ID", "Order Date", "Payment Type", "Price", "Product ID", "Quantity", "Status",
				"User ID" };
		for (String header : headers) {
			table.addCell(new Phrase(header, headFont));
		}
		for (OrdersDto orderDto : ordersDto) {
			table.addCell(String.valueOf(orderDto.getOrderId()));
			table.addCell(String.valueOf(orderDto.getOrderDate()));
			table.addCell(String.valueOf(orderDto.getPaymentType()));
			table.addCell(String.valueOf(orderDto.getPrice()));
			table.addCell(String.valueOf(orderDto.getProductId()));
			table.addCell(String.valueOf(orderDto.getQuantity()));
			table.addCell(String.valueOf(orderDto.getOrderStatus()));
			table.addCell(String.valueOf(orderDto.getUserId()));
		}
		document.add(table);
		document.close();
		return new ByteArrayInputStream(out.toByteArray());
	}
}
