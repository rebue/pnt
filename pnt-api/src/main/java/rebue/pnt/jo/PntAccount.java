package rebue.pnt.jo;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the PNT_ACCOUNT database table.
 * 
 */
@Entity
@Table(name="PNT_ACCOUNT")
@NamedQuery(name="PntAccount.findAll", query="SELECT p FROM PntAccount p")
public class PntAccount implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID")
	private String id;

	@Column(name="IS_LOCKED")
	private byte isLocked;

	@Column(name="POINTS")
	private BigDecimal points;

	//bi-directional many-to-one association to PntLog
	@OneToMany(mappedBy="pntAccount")
	private List<PntLog> pntLogs;

	public PntAccount() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public byte getIsLocked() {
		return this.isLocked;
	}

	public void setIsLocked(byte isLocked) {
		this.isLocked = isLocked;
	}

	public BigDecimal getPoints() {
		return this.points;
	}

	public void setPoints(BigDecimal points) {
		this.points = points;
	}

	public List<PntLog> getPntLogs() {
		return this.pntLogs;
	}

	public void setPntLogs(List<PntLog> pntLogs) {
		this.pntLogs = pntLogs;
	}

	public PntLog addPntLog(PntLog pntLog) {
		getPntLogs().add(pntLog);
		pntLog.setPntAccount(this);

		return pntLog;
	}

	public PntLog removePntLog(PntLog pntLog) {
		getPntLogs().remove(pntLog);
		pntLog.setPntAccount(null);

		return pntLog;
	}

}