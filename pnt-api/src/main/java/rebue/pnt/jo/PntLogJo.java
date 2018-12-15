/*
 * The MIT License
 *
 * Copyright 2018 zbz.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package rebue.pnt.jo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author zbz
 */
@Entity
@Table(name = "PNT_LOG", catalog = "pnt", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"ACCOUNT_ID", "LOG_TYPE_ID", "ORDER_ID", "ORDER_DETAIL_ID"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PntLog.findAll", query = "SELECT p FROM PntLog p"),
    @NamedQuery(name = "PntLog.findById", query = "SELECT p FROM PntLog p WHERE p.id = :id"),
    @NamedQuery(name = "PntLog.findByChangedPoints", query = "SELECT p FROM PntLog p WHERE p.changedPoints = :changedPoints"),
    @NamedQuery(name = "PntLog.findByChangedTitile", query = "SELECT p FROM PntLog p WHERE p.changedTitile = :changedTitile"),
    @NamedQuery(name = "PntLog.findByChangedDetail", query = "SELECT p FROM PntLog p WHERE p.changedDetail = :changedDetail"),
    @NamedQuery(name = "PntLog.findByOrderId", query = "SELECT p FROM PntLog p WHERE p.orderId = :orderId"),
    @NamedQuery(name = "PntLog.findByOrderDetailId", query = "SELECT p FROM PntLog p WHERE p.orderDetailId = :orderDetailId"),
    @NamedQuery(name = "PntLog.findByChangedTimestamp", query = "SELECT p FROM PntLog p WHERE p.changedTimestamp = :changedTimestamp")})
public class PntLogJo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(nullable = false)
    private Long id;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "CHANGED_POINTS", nullable = false, precision = 18, scale = 4)
    private BigDecimal changedPoints;
    @Basic(optional = false)
    @Column(name = "CHANGED_TITILE", nullable = false, length = 30)
    private String changedTitile;
    @Column(name = "CHANGED_DETAIL", length = 200)
    private String changedDetail;
    @Basic(optional = false)
    @Column(name = "ORDER_ID", nullable = false)
    private long orderId;
    @Column(name = "ORDER_DETAIL_ID")
    private BigInteger orderDetailId;
    @Basic(optional = false)
    @Column(name = "CHANGED_TIMESTAMP", nullable = false)
    private long changedTimestamp;
    @JoinColumn(name = "ACCOUNT_ID", referencedColumnName = "ID", nullable = false)
    @ManyToOne(optional = false)
    private PntAccountJo accountId;
    @JoinColumn(name = "LOG_TYPE_ID", referencedColumnName = "ID", nullable = false)
    @ManyToOne(optional = false)
    private PntLogTypeJo logTypeId;

    public PntLogJo() {
    }

    public PntLogJo(Long id) {
        this.id = id;
    }

    public PntLogJo(Long id, BigDecimal changedPoints, String changedTitile, long orderId, long changedTimestamp) {
        this.id = id;
        this.changedPoints = changedPoints;
        this.changedTitile = changedTitile;
        this.orderId = orderId;
        this.changedTimestamp = changedTimestamp;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getChangedPoints() {
        return changedPoints;
    }

    public void setChangedPoints(BigDecimal changedPoints) {
        this.changedPoints = changedPoints;
    }

    public String getChangedTitile() {
        return changedTitile;
    }

    public void setChangedTitile(String changedTitile) {
        this.changedTitile = changedTitile;
    }

    public String getChangedDetail() {
        return changedDetail;
    }

    public void setChangedDetail(String changedDetail) {
        this.changedDetail = changedDetail;
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public BigInteger getOrderDetailId() {
        return orderDetailId;
    }

    public void setOrderDetailId(BigInteger orderDetailId) {
        this.orderDetailId = orderDetailId;
    }

    public long getChangedTimestamp() {
        return changedTimestamp;
    }

    public void setChangedTimestamp(long changedTimestamp) {
        this.changedTimestamp = changedTimestamp;
    }

    public PntAccountJo getAccountId() {
        return accountId;
    }

    public void setAccountId(PntAccountJo accountId) {
        this.accountId = accountId;
    }

    public PntLogTypeJo getLogTypeId() {
        return logTypeId;
    }

    public void setLogTypeId(PntLogTypeJo logTypeId) {
        this.logTypeId = logTypeId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PntLogJo)) {
            return false;
        }
        PntLogJo other = (PntLogJo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "rebue.pnt.jo.PntLog[ id=" + id + " ]";
    }
    
}
