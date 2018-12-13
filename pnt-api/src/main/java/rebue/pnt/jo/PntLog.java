package rebue.pnt.jo;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.math.BigInteger;


/**
 * The persistent class for the PNT_LOG database table.
 * 
 */
@Entity
@Table(name="PNT_LOG")
@NamedQuery(name="PntLog.findAll", query="SELECT p FROM PntLog p")
public class PntLog implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID")
	private String id;

	@Column(name="CHANGED_DETAIL")
	private String changedDetail;

	@Column(name="CHANGED_POINTS")
	private BigDecimal changedPoints;

	@Column(name="CHANGED_TIMESTAMP")
	private BigInteger changedTimestamp;

	@Column(name="CHANGED_TITILE")
	private String changedTitile;

	@Column(name="ORDER_DETAIL_ID")
	private BigInteger orderDetailId;

	@Column(name="ORDER_ID")
	private BigInteger orderId;

	//bi-directional many-to-one association to PntAccount
	@ManyToOne
	@JoinColumn(name="ACCOUNT_ID")
	private PntAccount pntAccount;

	//bi-directional many-to-one association to PntLogType
	@ManyToOne
	@JoinColumn(name="LOG_TYPE_ID")
	private PntLogType pntLogType;

	public PntLog() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getChangedDetail() {
		return this.changedDetail;
	}

	public void setChangedDetail(String changedDetail) {
		this.changedDetail = changedDetail;
	}

	public BigDecimal getChangedPoints() {
		return this.changedPoints;
	}

	public void setChangedPoints(BigDecimal changedPoints) {
		this.changedPoints = changedPoints;
	}

	public BigInteger getChangedTimestamp() {
		return this.changedTimestamp;
	}

	public void setChangedTimestamp(BigInteger changedTimestamp) {
		this.changedTimestamp = changedTimestamp;
	}

	public String getChangedTitile() {
		return this.changedTitile;
	}

	public void setChangedTitile(String changedTitile) {
		this.changedTitile = changedTitile;
	}

	public BigInteger getOrderDetailId() {
		return this.orderDetailId;
	}

	public void setOrderDetailId(BigInteger orderDetailId) {
		this.orderDetailId = orderDetailId;
	}

	public BigInteger getOrderId() {
		return this.orderId;
	}

	public void setOrderId(BigInteger orderId) {
		this.orderId = orderId;
	}

	public PntAccount getPntAccount() {
		return this.pntAccount;
	}

	public void setPntAccount(PntAccount pntAccount) {
		this.pntAccount = pntAccount;
	}

	public PntLogType getPntLogType() {
		return this.pntLogType;
	}

	public void setPntLogType(PntLogType pntLogType) {
		this.pntLogType = pntLogType;
	}

}