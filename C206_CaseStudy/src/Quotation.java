
public class Quotation {
private String requestID;
private String quotationID;
private String renoCategory;
private String description;
private String designerName;
private String date;
private String amount;

public Quotation(String requestID, String quotationID, String renoCategory, String description, String designerName,
		String date, String amount) {
	super();
	this.requestID = requestID;
	this.quotationID = quotationID;
	this.renoCategory = renoCategory;
	this.description = description;
	this.designerName = designerName;
	this.date = date;
	this.amount = amount;
}

public String getRequestID() {
	return requestID;
}

public String getQuotationID() {
	return quotationID;
}

public String getRenoCategory() {
	return renoCategory;
}

public String getDescription() {
	return description;
}

public String getDesignerName() {
	return designerName;
}

public String getDate() {
	return date;
}

public String getAmount() {
	return amount;
}


}
