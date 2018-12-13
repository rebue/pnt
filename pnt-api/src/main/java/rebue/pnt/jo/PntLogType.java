package rebue.pnt.jo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the PNT_LOG_TYPE database table.
 * 
 */
@Entity
@Table(name="PNT_LOG_TYPE")
@NamedQuery(name="PntLogType.findAll", query="SELECT p FROM PntLogType p")
public class PntLogType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID")
	private String id;

	@Column(name="REMARK")
	private String remark;

	@Column(name="TYPE_NAME")
	private String typeName;

	//bi-directional many-to-one association to PntLog
	@OneToMany(mappedBy="pntLogType")
	private List<PntLog> pntLogs;

	public PntLogType() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getTypeName() {
		return this.typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public List<PntLog> getPntLogs() {
		return this.pntLogs;
	}

	public void setPntLogs(List<PntLog> pntLogs) {
		this.pntLogs = pntLogs;
	}

	public PntLog addPntLog(PntLog pntLog) {
		getPntLogs().add(pntLog);
		pntLog.setPntLogType(this);

		return pntLog;
	}

	public PntLog removePntLog(PntLog pntLog) {
		getPntLogs().remove(pntLog);
		pntLog.setPntLogType(null);

		return pntLog;
	}

}