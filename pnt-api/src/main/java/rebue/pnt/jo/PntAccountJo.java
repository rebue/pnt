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
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author zbz
 */
@Entity
@Table(name = "PNT_ACCOUNT", catalog = "pnt", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PntAccount.findAll", query = "SELECT p FROM PntAccount p"),
    @NamedQuery(name = "PntAccount.findById", query = "SELECT p FROM PntAccount p WHERE p.id = :id"),
    @NamedQuery(name = "PntAccount.findByPoints", query = "SELECT p FROM PntAccount p WHERE p.points = :points"),
    @NamedQuery(name = "PntAccount.findByIsLocked", query = "SELECT p FROM PntAccount p WHERE p.isLocked = :isLocked")})
public class PntAccountJo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(nullable = false)
    private Long id;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(nullable = false, precision = 18, scale = 4)
    private BigDecimal points;
    @Basic(optional = false)
    @Column(name = "IS_LOCKED", nullable = false)
    private boolean isLocked;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "accountId")
    private List<PntLogJo> pntLogList;

    public PntAccountJo() {
    }

    public PntAccountJo(Long id) {
        this.id = id;
    }

    public PntAccountJo(Long id, BigDecimal points, boolean isLocked) {
        this.id = id;
        this.points = points;
        this.isLocked = isLocked;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getPoints() {
        return points;
    }

    public void setPoints(BigDecimal points) {
        this.points = points;
    }

    public boolean getIsLocked() {
        return isLocked;
    }

    public void setIsLocked(boolean isLocked) {
        this.isLocked = isLocked;
    }

    @XmlTransient
    public List<PntLogJo> getPntLogList() {
        return pntLogList;
    }

    public void setPntLogList(List<PntLogJo> pntLogList) {
        this.pntLogList = pntLogList;
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
        if (!(object instanceof PntAccountJo)) {
            return false;
        }
        PntAccountJo other = (PntAccountJo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "rebue.pnt.jo.PntAccount[ id=" + id + " ]";
    }
    
}
