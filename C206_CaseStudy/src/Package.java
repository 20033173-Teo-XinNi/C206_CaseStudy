
public class Package {

	private String pCode;
	private String pDesc;
	private String pStartDate;
	private String pEndDate;
	private int pAmount;

	public Package(String pCode, String pDesc, String pStartDate, String pEndDate, int pAmount) {
		this.pCode = pCode;
		this.pDesc = pDesc;
		this.pStartDate = pStartDate;
		this.pEndDate = pEndDate;
		this.pAmount = pAmount;
	}

	public String getpCode() {
		return pCode;
	}

	public void setpCode(String pCode) {
		this.pCode = pCode;
	}

	public String getpDesc() {
		return pDesc;
	}

	public void setpDesc(String pDesc) {
		this.pDesc = pDesc;
	}

	public String getpStartDate() {
		return pStartDate;
	}

	public void setpStartDate(String pStartDate) {
		this.pStartDate = pStartDate;
	}

	public String getpEndDate() {
		return pEndDate;
	}

	public void setpEndDate(String pEndDate) {
		this.pEndDate = pEndDate;
	}

	public int getpAmount() {
		return pAmount;
	}

	public void setpAmount(int pAmount) {
		this.pAmount = pAmount;
	}
	public String doStringPackage() {
		return String.format("%-10s %-30s %-10s %-10s %-10d\n", getpCode(), getpDesc(), getpStartDate(),
				        getpEndDate(), getpAmount());
	}
}
